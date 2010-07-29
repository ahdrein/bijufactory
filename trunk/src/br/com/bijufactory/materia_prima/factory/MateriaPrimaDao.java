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
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;


public class MateriaPrimaDao<T>{
    protected final Session session;
    private final Class classe;
    private static Logger log = Logger.getLogger(MateriaPrimaDao.class);

    public MateriaPrimaDao(Session session, Class classe) {
        this.session = session;
        this.classe = classe;
    }

    protected Session getSession(){
        return this.session;
    }

    public void inserirAtualizar(T u){
        try{
            Transaction t = session.beginTransaction();
            //session.save(u);
            session.saveOrUpdate(u);
            log.info("Inserindo/Alterando: " + u.toString() + "%s");
            session.flush();
            t.commit();
            log.info("Objeto inserido/atualizado: " + u.toString() + "!");
        }catch(Exception e){
            log.fatal(e);
        }
    }


    public List<T> listaTudo() {
        // TODO Auto-generated method stub
        return this.session.createCriteria(this.classe).list();

    }

    public T procura(Long id) {
        return (T) session.load(this.classe, id);
    }

    public void excluir(T u) {
        Transaction t = session.beginTransaction();
        session.delete(u);
        log.debug(u);
        log.info("Excluindo objeto: " + u.toString() + " - %s");
        t.commit();
        log.info("Objeto excluido: " + u.toString() + "!");
    }

    public void atualiza(T u) {
        // TODO Auto-generated method stub
        Transaction t = session.beginTransaction();
        session.merge(u);
        t.commit();
    }

    /*public T findBySCodigo(BjMateriaPrima bjMateriaPrima) {
        Query q = (Query) this.session.getNamedQuery("BjMateriaPrima.findBySCodigo");
        q.setParameter("sCodigo", bjMateriaPrima.getSCodigo());

        return (T)q.getSingleResult();
    }*/

    public T findBySCodigo(BjMateriaPrima bjMateriaPrima) {
        Query query = this.session.createQuery("from BjMateriaPrima as b where b.sCodigo = :sCodigo");
        query.setString("sCodigo", bjMateriaPrima.getSCodigo());
        List result = query.list();
        System.out.println("Number of Objects: " + result.size());
        if(result.size() != 0){
            bjMateriaPrima = (BjMateriaPrima) result.get( 0);
            System.out.println(bjMateriaPrima);
        }else{
            return null;
        }

        return (T)bjMateriaPrima;
    }

}  
