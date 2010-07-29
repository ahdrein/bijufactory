/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.util.*;
import javax.swing.JPanel;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.*;
public class MostraRelatorio extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel jContentPane = null;
private JButton btAbreRel = null;

public MostraRelatorio( ) throws HeadlessException {
    super( );
    initialize( );
    try {
        this.abreRelatorio();
    } catch (JRException ex) {
        Logger.getLogger(MostraRelatorio.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(MostraRelatorio.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public MostraRelatorio(GraphicsConfiguration gc) {
    super(gc);
    initialize( );
}
public MostraRelatorio(String title) throws HeadlessException {
    super(title);
    initialize( );
}
public MostraRelatorio(String title, GraphicsConfiguration gc) {
    super(title, gc);
    //initialize( );
    try {
        this.abreRelatorio();
    } catch (JRException ex) {
        Logger.getLogger(MostraRelatorio.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(MostraRelatorio.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private Connection getConnection( )
{
    Connection con=null;
    try{
    String driver="org.postgresql.Driver";
    String url= "jdbc:postgresql://localhost:5432/BijuFactory";
    String user="postgres";
    String password="admin";
    Class.forName(driver);
    con = DriverManager.getConnection( url, user, password );
    }
    catch(ClassNotFoundException cnf){mostrarErro("Erro ao se conectar");}
    catch(SQLException sqlex){mostrarErro("Erro ao se conectar");}
    return con;
}

private void abreRelatorio( ) throws JRException, Exception
{
    Connection con = getConnection( );
    Map parameters = new HashMap( );
    String path = "src/br/com/bijufactory/relatorios/Relatorio_Produtos.jasper";
    File file = new File(path);
    file = file.getAbsoluteFile( );
    String repStr2 = file.getPath( );
    try{
        JasperFillManager.fillReportToFile( repStr2, parameters, con );
        JasperPrint jasperPrint = JasperFillManager.fillReport(repStr2,parameters,con);
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setVisible(true);
    }catch(JRException jex){
        mostrarErro("JasperException: "+jex.getMessage( ));
    }catch(Exception ex){
        mostrarErro(""+ex.getStackTrace( ));
    }
}
private JButton getBtAbreRel( ) {
    if (btAbreRel == null) {
        btAbreRel = new JButton();
        btAbreRel.setBounds(new java.awt.Rectangle(78,58,123,40));
        btAbreRel.setText("Abre Relatório");
        btAbreRel.addActionListener(new java.awt.event.ActionListener( ) {
        public void actionPerformed(java.awt.event.ActionEvent e){
            try{
                abreRelatorio( );
            }
            catch(JRException jre){
                mostrarErro("JasperException: "+jre.getMessage( ));
            }catch(Exception ex){
                mostrarErro(""+ex.getStackTrace( ));
            }
        }
        });
    }
    return btAbreRel;
}

public static void main(String[] args) {
    new MostraRelatorio( ).setVisible(true);
}

private void initialize() {
    this.setSize(300, 200);
    this.setContentPane(getJContentPane( ));
    this.setTitle("Relatório");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    java.awt.Dimension frameSize = this.getSize( );
    if (frameSize.height > screenSize.height) {
        frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
        frameSize.width = screenSize.width;
    }
    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
}

private JPanel getJContentPane( ) {
    if (jContentPane == null) {
        jContentPane = new JPanel( );
        jContentPane.setLayout(null);
        jContentPane.add(getBtAbreRel( ), null);
    }
    return jContentPane;
}
private void mostrarErro(String msg) {
    JOptionPane.showMessageDialog(  null,
                                    msg,
                                    "Erro encontrado",
                                    JOptionPane.ERROR_MESSAGE);
    }
}