/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.cotacao.factory;

/**
 *
 * @author HP
 */
import br.com.bijufactory.cotacao.model.BjCotacao;
import br.com.bijufactory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import br.gov.inca.publico.modelo.*;

//import br.gov.inca.publico.util.HibernateUtil;

public class CotacaoDaoFactory {
    private final Session session;

    private Transaction transaction;

    private static Logger log = Logger.getLogger(CotacaoDaoFactory.class);

    public CotacaoDaoFactory() {
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

    public CotacaoDao<BjCotacao> getDao() {
        return new CotacaoDao<BjCotacao>(this.session, BjCotacao.class);
    }

    //public ProdutoDao<Categoria> getCategoriaDao() {
    //    return new ProdutoDao<Categoria>(this.session, Categoria.class);
    //}
}
