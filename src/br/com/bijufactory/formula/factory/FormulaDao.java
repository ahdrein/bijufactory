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
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;


public class FormulaDao<T>{
    protected final Session session;
    private final Class classe;
    private static Logger log = Logger.getLogger(FormulaDao.class);

    public FormulaDao(Session session, Class classe) {
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
        Transaction t = session.beginTransaction();
        session.merge(u);
        t.commit();
    }

    //
    public List<T> findBySCodigoProduto(BjFormula BjFormula) {
        Query query = this.session.createQuery("from BjFormula as b where b.sCodigoProduto = :sCodigo");
        query.setString("sCodigo", BjFormula.getSCodigoProduto().getSCodigo());
        List result = query.list();
        System.out.println("Number of Objects: " + result.size());
        return result;
    }

    public BjFormula findBySCodigoProdutoMateriaPrima(BjFormula BjFormula) {
        Query query = this.session.createQuery("from BjFormula as b where b.sCodigoProduto = :sCodigo and b.sCodigoMateriaPrima = :sCodigoMateriaPrima");
        query.setString("sCodigo", BjFormula.getSCodigoProduto().getSCodigo());
        query.setString("sCodigoMateriaPrima", BjFormula.getSCodigoMateriaPrima().getSCodigo());
        List result = query.list();
        System.out.println("Number of Objects: " + result.size());
        if(result.size() != 0){
            BjFormula = (BjFormula) result.get( 0);
            System.out.println(BjFormula);
        }else{
            return null;
        }
        return BjFormula;
    }
}  
