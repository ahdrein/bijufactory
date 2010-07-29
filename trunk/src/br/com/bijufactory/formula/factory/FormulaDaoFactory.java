/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.formula.factory;

/**
 *
 * @author HP
 */
import br.com.bijufactory.formula.model.BjFormula;
import br.com.bijufactory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import br.gov.inca.publico.modelo.*;

//import br.gov.inca.publico.util.HibernateUtil;

public class FormulaDaoFactory {
    private final Session session;

    private Transaction transaction;

    private static Logger log = Logger.getLogger(FormulaDaoFactory.class);

    public FormulaDaoFactory() {
        session = HibernateUtil.getSession();
    }

    public void beginTransaction() {
        this.transaction = session.beginTransaction();
    }

    public void commit() {
        this.transaction.commit();
        this.transaction = null;
    }

    public boolean hasTransaction() {
        return this.transaction != null;
    }

    public void rollback() {
        this.transaction.rollback();
        this.transaction = null;
    }

    public void close() {
        this.session.close();
    }

    public FormulaDao<BjFormula> getDao() {
        return new FormulaDao<BjFormula>(this.session, BjFormula.class);
    }

    //public ProdutoDao<Categoria> getCategoriaDao() {
    //    return new ProdutoDao<Categoria>(this.session, Categoria.class);
    //}
}
