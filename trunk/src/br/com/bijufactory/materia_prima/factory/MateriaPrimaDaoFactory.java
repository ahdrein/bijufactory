/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.materia_prima.factory;

/**
 *
 * @author HP
 */
import br.com.bijufactory.materia_prima.model.BjMateriaPrima;
import br.com.bijufactory.produto.factory.*;
import br.com.bijufactory.produto.model.BjProduto;
import br.com.bijufactory.util.HibernateUtil;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import br.gov.inca.publico.modelo.*;

//import br.gov.inca.publico.util.HibernateUtil;

public class MateriaPrimaDaoFactory {
    private final Session session;

    private Transaction transaction;

    private static Logger log = Logger.getLogger(MateriaPrimaDaoFactory.class);

    public MateriaPrimaDaoFactory() {
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

    public MateriaPrimaDao<BjMateriaPrima> getDao() {
        return new MateriaPrimaDao<BjMateriaPrima>(this.session, BjMateriaPrima.class);
    }


}
