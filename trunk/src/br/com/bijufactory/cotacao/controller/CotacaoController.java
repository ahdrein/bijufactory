/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.cotacao.controller;

import br.com.bijufactory.pessoa.factory.PessoaDao;
import br.com.bijufactory.pessoa.factory.PessoaDaoFactory;
import br.com.bijufactory.cotacao.factory.CotacaoDao;
import br.com.bijufactory.cotacao.factory.CotacaoDaoFactory;
import br.com.bijufactory.cotacao.model.BjCotacao;
import br.com.bijufactory.materia_prima.factory.MateriaPrimaDao;
import br.com.bijufactory.materia_prima.factory.MateriaPrimaDaoFactory;
import br.com.bijufactory.materia_prima.model.BjMateriaPrima;
import br.com.bijufactory.pessoa.model.BjPessoa;
import br.com.bijufactory.ui.FormCadastroCotacao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.NoResultException;

/**
 *
 * @author HP
 */
public class CotacaoController {
    private BjCotacao bjFornecedorMateriaPrima = new BjCotacao();;
    CotacaoDaoFactory factory;

    CotacaoDao<BjCotacao> daobjFornecedorMateriaPrima;
    private ArrayList<BjCotacao> collectionFornecedorMateriaPrima;
    private ArrayList<BjCotacao> collectionFornecedorMateriaPrimaRemoved;

    private BjMateriaPrima bjMateriaPrima;
    MateriaPrimaDaoFactory factoryMateriaPrima;
    MateriaPrimaDao<BjMateriaPrima> daobjMateriaPrima;

    private BjPessoa bjFornecedor = new BjPessoa();
    PessoaDaoFactory factoryFornecedor;
    PessoaDao<BjPessoa> daobjFornecedor;

    public CotacaoController(){
        factory = new CotacaoDaoFactory();
        daobjFornecedorMateriaPrima = factory.getDao();

        factoryMateriaPrima = new MateriaPrimaDaoFactory();
        daobjMateriaPrima = factoryMateriaPrima.getDao();

        factoryFornecedor = new PessoaDaoFactory();
        daobjFornecedor = factoryFornecedor.getDao();

        this.inicializaObjetos();
    }

    public void inicializaObjetos(){
        collectionFornecedorMateriaPrima = new ArrayList<BjCotacao>();
        collectionFornecedorMateriaPrimaRemoved = new ArrayList<BjCotacao>();

        bjFornecedor = new BjPessoa();
        bjFornecedorMateriaPrima = new BjCotacao();
        bjMateriaPrima = new BjMateriaPrima();
    }

    public String validaFornecedor(String sCodigoFornecedor){
        //bjProduto = new BjProduto();
        bjFornecedor.setSCodigo(sCodigoFornecedor);
        try{
            bjFornecedor = daobjFornecedor.findBySCodigo(bjFornecedor);
        }catch(NoResultException e){
            return "Não encontrado o fornecedor informado";
        }

        if(bjFornecedor == null){
            return "Nao encontrado o fornecedor informado";
        }

        bjFornecedorMateriaPrima.setIdFornecedor(bjFornecedor);
        return "";
    }

    public ArrayList<BjCotacao> validaFornecedorMateriaPrima(){
        //collectionFormula = new ArrayList<BjFormula>();

        try{
            collectionFornecedorMateriaPrima = (ArrayList<BjCotacao>) daobjFornecedorMateriaPrima.findBySCodigoFornecedor(bjFornecedorMateriaPrima);
        }catch(NoResultException e){
            return null;
        }

        if(collectionFornecedorMateriaPrima == null){
            return null;
        }
       
        return collectionFornecedorMateriaPrima;
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

    public String salvar(FormCadastroCotacao jFrame){
        Iterator i = jFrame.getModelo().getDataVector().iterator();
        Vector p;
        this.removerFornecedorMateriaPrima();
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

            bjFornecedorMateriaPrima.setnValorCusto( Float.parseFloat( p.get(1).toString() ) );

            bjFornecedorMateriaPrima.setSCodigoMateriaPrima(bjMateriaPrima);
            daobjFornecedorMateriaPrima.inserirAtualizar(bjFornecedorMateriaPrima);
        }
        return "OK";
    }

    public List<BjCotacao> list() {
        return daobjFornecedorMateriaPrima.listaTudo();
    }

    public void removerFornecedorMateriaPrima(){
        Iterator i = collectionFornecedorMateriaPrimaRemoved.iterator();
        while(i.hasNext()){
            daobjFornecedorMateriaPrima.excluir((BjCotacao)i.next());
        }
    }

    /**
     * @param collectionMateriaPrimaRemoved the collectionMateriaPrimaRemoved to set
     */
    public void addCollectionFormulaRemoved(String sCodigoMateriaPrimaRemoved) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFornecedorMateriaPrima.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFornecedorMateriaPrimaRemoved.add(bjFornecedorMateriaPrima);
    }

    /**
     * @param collectionMateriaPrimaRemoved the collectionMateriaPrimaRemoved to set
     */
    public void addCollectionFormula(String sCodigoMateriaPrimaRemoved) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFornecedorMateriaPrima.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFornecedorMateriaPrima.add(bjFornecedorMateriaPrima);
    }

    public void removerCollectionFormula(String sCodigoMateriaPrimaRemoved, String nQtde) {
        bjMateriaPrima = new BjMateriaPrima();
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrimaRemoved);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        bjFornecedorMateriaPrima.setSCodigoMateriaPrima(bjMateriaPrima);

        this.collectionFornecedorMateriaPrima.remove(bjFornecedorMateriaPrima);
    }

    /**
     * @return the collectionFormula
     */
    public ArrayList<BjCotacao> getCollectionFornecedorMateriaPrima() {
        return collectionFornecedorMateriaPrima;
    }

    /**
     * @return the collectionFormulaRemoved
     */
    public ArrayList<BjCotacao> getCollectionFornecedorMateriaPrimaRemoved() {
        return collectionFornecedorMateriaPrimaRemoved;
    }

    /**
     * @param collectionFormulaRemoved the collectionFormulaRemoved to set
     */
    public void setCollectionFornecedorMateriaPrimaRemoved(ArrayList<BjCotacao> collectionFornecedorMateriaPrimaRemoved) {
        this.collectionFornecedorMateriaPrimaRemoved = collectionFornecedorMateriaPrimaRemoved;
    }
}
