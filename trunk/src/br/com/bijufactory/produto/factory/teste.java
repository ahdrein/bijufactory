/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.produto.factory;

/**
 *
 * @author HP
 */
import br.com.bijufactory.produto.model.BjProduto;
import org.apache.log4j.PropertyConfigurator;

public class teste {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //SessionFactory sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        // TODO Auto-generated method stub
        //Configuration conf =  new AnnotationConfiguration();
        //conf.configure();
        //SchemaExport se =  new SchemaExport(conf);
        //se.create(true, true);

        //SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

        /*AnnotationConfiguration conf =  new AnnotationConfiguration();
        conf.addAnnotatedClass(BjProducts.class);
        conf.configure();*/
        //SchemaExport se =  new SchemaExport(conf);
        //se.create(true, true);

        //HibernateUtil sf = new HibernateUtil();
        PropertyConfigurator.configure("log4j.properties");
        ProdutoDaoFactory factory = new ProdutoDaoFactory();
        ProdutoDao<BjProduto> daobjProdutos = factory.getDao();
        BjProduto bjProdutos = new BjProduto();
        bjProdutos.setSCodigo("COD2");
        bjProdutos.setSDescricao("Produto numero 1");
        bjProdutos.setNIndiceAuAg("1");
        bjProdutos.setNPeso(Double.parseDouble("1.35"));
        bjProdutos.setNVlrCusto(Double.parseDouble("1087.4"));
        daobjProdutos.inserirAtualizar(bjProdutos);

    }

}
