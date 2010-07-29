/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.pessoa.factory;

/**
 *
 * @author HP
 */
import br.com.bijufactory.pessoa.model.BjPessoa;
import br.com.bijufactory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import br.gov.inca.publico.modelo.*;

//import br.gov.inca.publico.util.HibernateUtil;

public class PessoaDaoFactory {
    private final Session session;

    private Transaction transaction;

    private static Logger log = Logger.getLogger(PessoaDaoFactory.class);

    public PessoaDaoFactory() {
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

    public PessoaDao<BjPessoa> getDao() {
        return new PessoaDao<BjPessoa>(this.session, BjPessoa.class);
    }


}
