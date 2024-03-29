/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormCadastroMateriaPrima.java
 *
 * Created on 24/09/2009, 14:25:31
 */

package br.com.bijufactory.ui;

import br.com.bijufactory.materia_prima.controller.MateriaPrimaController;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FormCadastroMateriaPrima extends javax.swing.JFrame {
    MateriaPrimaController materiaPrimaController;

    /** Creates new form FormCadastroMateriaPrima */
    public FormCadastroMateriaPrima() {
        initComponents();
        materiaPrimaController = new MateriaPrimaController();
        this.limpaComponetes();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbSCodigo = new javax.swing.JLabel();
        txSCodigo = new javax.swing.JTextField();
        lbSDescricao = new javax.swing.JLabel();
        txSDescricao = new javax.swing.JTextField();
        btNovo = new javax.swing.JToggleButton();
        btExcluir = new javax.swing.JToggleButton();
        btSalvar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Matéria Prima");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da Matéria Prima"));

        lbSCodigo.setText("Codigo:");

        txSCodigo.setBackground(new java.awt.Color(255, 255, 153));
        txSCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSCodigoActionPerformed(evt);
            }
        });

        lbSDescricao.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSCodigo)
                    .addComponent(lbSDescricao))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(txSCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSCodigo)
                    .addComponent(txSCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSDescricao)
                    .addComponent(txSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bijufactory/resources/img_adicionar0.gif"))); // NOI18N
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bijufactory/resources/ico_excluir.gif"))); // NOI18N
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bijufactory/resources/salvar.png"))); // NOI18N
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void habilitaComponentes(boolean status){
        this.txSCodigo.setEnabled(status);
        this.txSDescricao.setEnabled(status);

        this.btSalvar.setEnabled(status);
        this.btExcluir.setEnabled(status);
    }

    private void limpaComponetes(){
        this.txSDescricao.setText("");
        materiaPrimaController.inicializaObjetos();
        this.habilitaComponentes(true);
        this.txSCodigo.grabFocus();
    }

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        this.habilitaComponentes(true);
        this.limpaComponetes();
        materiaPrimaController.inicializaObjetos();
}//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Object opcoes[] = {"Sim","Não"};
        //JDialog.setDefaultLookAndFeelDecorated(true);
        int op = JOptionPane.showOptionDialog(null, "Confirma a exclusão da matéria prima?", "Excluindo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE , null, opcoes, null);
        if(op == JOptionPane.YES_OPTION ){
            materiaPrimaController.removerMateriaPrima();
            this.limpaComponetes();
        }
}//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Object opcoes[] = {"Sim","Não"};
        //JDialog.setDefaultLookAndFeelDecorated(true);
        int op = JOptionPane.showOptionDialog(null, "Confirma a gravação da matéria prima?", "Gravando", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE , null, opcoes, null);
        if(op == JOptionPane.YES_OPTION ){
            materiaPrimaController.getBjMateriaPrima().setSCodigo(this.getTxSCodigo().getText());
            materiaPrimaController.getBjMateriaPrima().setSDescricao(this.getTxSDescricao().getText());

            materiaPrimaController.salvar();
        }
}//GEN-LAST:event_btSalvarActionPerformed

    private void txSCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSCodigoActionPerformed
        materiaPrimaController.inicializaObjetos();
        this.limpaComponetes();
        this.habilitaComponentes(true);
        materiaPrimaController.consultarMateriaPrima(this.txSCodigo.getText());
        this.txSDescricao.setText(materiaPrimaController.getBjMateriaPrima().getSDescricao());
    }//GEN-LAST:event_txSCodigoActionPerformed
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastroMateriaPrima().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btExcluir;
    private javax.swing.JToggleButton btNovo;
    private javax.swing.JToggleButton btSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbSCodigo;
    private javax.swing.JLabel lbSDescricao;
    private javax.swing.JTextField txSCodigo;
    private javax.swing.JTextField txSDescricao;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txSCodigo
     */
    public javax.swing.JTextField getTxSCodigo() {
        return txSCodigo;
    }

    /**
     * @param txSCodigo the txSCodigo to set
     */
    public void setTxSCodigo(javax.swing.JTextField txSCodigo) {
        this.txSCodigo = txSCodigo;
    }

    /**
     * @return the txSDescricao
     */
    public javax.swing.JTextField getTxSDescricao() {
        return txSDescricao;
    }

    /**
     * @param txSDescricao the txSDescricao to set
     */
    public void setTxSDescricao(javax.swing.JTextField txSDescricao) {
        this.txSDescricao = txSDescricao;
    }

}
