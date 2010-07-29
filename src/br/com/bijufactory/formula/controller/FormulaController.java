/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.formula.controller;

import br.com.bijufactory.formula.factory.FormulaDao;
import br.com.bijufactory.formula.factory.FormulaDaoFactory;
import br.com.bijufactory.formula.model.BjFormula;
import br.com.bijufactory.materia_prima.factory.MateriaPrimaDao;
import br.com.bijufactory.materia_prima.factory.MateriaPrimaDaoFactory;
import br.com.bijufactory.materia_prima.model.BjMateriaPrima;
import br.com.bijufactory.produto.factory.ProdutoDao;
import br.com.bijufactory.produto.factory.ProdutoDaoFactory;
import br.com.bijufactory.produto.model.BjProduto;
import br.com.bijufactory.ui.FormCadastroFormula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.NoResultException;

/**
 *
 * @author HP
 */
public class FormulaController {
    private BjFormula bjFormula = new BjFormula();;
    FormulaDaoFactory factory;
    FormulaDao<BjFormula> daobjFormula;
    private ArrayList<BjFormula> collectionFormula;
    private ArrayList<BjFormula> collectionFormulaRemoved;

    private BjMateriaPrima bjMateriaPrima;
    MateriaPrimaDaoFactory factoryMateriaPrima;
    MateriaPrimaDao<BjMateriaPrima> daobjMateriaPrima;

    private BjProduto bjProduto = new BjProduto();
    ProdutoDaoFactory factoryProduto;
    ProdutoDao<BjProduto> daobjProduto;

    public FormulaController(){
        factory = new FormulaDaoFactory();
        daobjFormula = factory.getDao();

        factoryMateriaPrima = new MateriaPrimaDaoFactory();
        daobjMateriaPrima = factoryMateriaPrima.getDao();

        factoryProduto = new ProdutoDaoFactory();
        daobjProduto = factoryProduto.getDao();

        this.inicializaObjetos();
    }

    public void inicializaObjetos(){
        collectionFormula = new ArrayList<BjFormula>();
        collectionFormulaRemoved = new ArrayList<BjFormula>();

        bjProduto = new BjProduto();
        bjFormula = new BjFormula();
        bjMateriaPrima = new BjMateriaPrima();
    }


    public String validaProduto(String sCodigoProduto){
        //bjProduto = new BjProduto();
        bjProduto.setSCodigo(sCodigoProduto);
        try{
            bjProduto = daobjProduto.findBySCodigo(bjProduto);
        }catch(NoResultException e){
            return "Não encontrado o produto informado";
        }

        if(bjProduto == null){
            return "Nao encontrado o Produto informado";
        }

        bjFormula.setSCodigoProduto(bjProduto);
        return "";
    }

    public ArrayList<BjFormula> validaFormula(){
        //collectionFormula = new ArrayList<BjFormula>();
        try{
            collectionFormula = (ArrayList<BjFormula>) daobjFormula.findBySCodigoProduto(bjFormula);
        }catch(NoResultException e){
            return null;
        }

        if(collectionFormula == null){
            return null;
        }
       
        return collectionFormula;
    }

    public String validaMateriaPrima(String sCodigoMateriaPrima){
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrima);
        try{
            bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        }catch(NoResultException e){
            return "Não encontrado o produto informado";
        }

        if(bjMateriaPrima == null){
            return "Nao encontrado a materia prima informada";
        }
        return "";
    }

    public String salvar(FormCadastroFormula jFrame){
        Iterator i = jFrame.getModelo().getDataVector().iterator();
        Vector p;
        this.removerFormula();
        while(i.hasNext()){
            p = (Vector)i.next();
            System.out.println(p);

            bjMateriaPrima = new BjMateriaPrima();

            bjMateriaPrima.setSCodigo(p.get(0).toString());
            try{
                bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
            }catch(NoResultException e){
                e.printStackTrace();
            }

            //bjFormula.setSCodigoProduto(bjProduto);

            bjFormula.setNQtde(Long.parseLong(  p.get(1).toString() ));

            bjFormula.setSCodigoMateriaPrima(bjMateriaPrima);
            daobjFormula.inserirAtualizar(bjFormula);
        }
        return "OK";
    }

    public List<BjFormula> list() {
        return daobjFormula.listaTudo();
    }

    public void removerFormula(){
        Iterator i = collectionFormulaRemoved.iterator();
        while(i.hasNext()){
            daobjFormula.excluir((BjFormula)i.next());
        }
    }

    /**
     * @param collectionMateriaPrimaRemoved the collectionMateriaPrimaRemoved to set
     */
    public void addCollectionFormulaRemoved(String sCodigoMateriaPrimaRemoved) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFormula.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFormulaRemoved.add(bjFormula);
    }

    /**
     * @param collectionMateriaPrimaRemoved the collectionMateriaPrimaRemoved to set
     */
    public void addCollectionFormula(String sCodigoMateriaPrimaRemoved) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFormula.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFormula.add(bjFormula);
    }

    public void removerCollectionFormula(String sCodigoMateriaPrimaRemoved, String nQtde) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFormula.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFormula.remove(bjFormula);
    }

    /**
     * @return the collectionFormula
     */
    public ArrayList<BjFormula> getCollectionFormula() {
        return collectionFormula;
    }

    /**
     * @return the collectionFormulaRemoved
     */
    public ArrayList<BjFormula> getCollectionFormulaRemoved() {
        return collectionFormulaRemoved;
    }

    /**
     * @param collectionFormulaRemoved the collectionFormulaRemoved to set
     */
    public void setCollectionFormulaRemoved(ArrayList<BjFormula> collectionFormulaRemoved) {
        this.collectionFormulaRemoved = collectionFormulaRemoved;
    }
}
