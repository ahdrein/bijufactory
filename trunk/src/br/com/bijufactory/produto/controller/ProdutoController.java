/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.produto.controller;

import br.com.bijufactory.produto.factory.ProdutoDao;
import br.com.bijufactory.produto.factory.ProdutoDaoFactory;
import br.com.bijufactory.produto.model.BjProduto;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProdutoController {
    private BjProduto bjProduto;
    ProdutoDaoFactory factory;
    ProdutoDao<BjProduto> daobjProduto;

    public ProdutoController(){
        factory = new ProdutoDaoFactory();
        daobjProduto = factory.getDao();
    }

    public void inicializaObjetos(){
          bjProduto = new BjProduto();
    }

    public void salvar(){
        //Inserindo novo produto
        daobjProduto.inserirAtualizar(bjProduto);
    }

    public void removerProduto(){
        daobjProduto.excluir(bjProduto);
    }

    /**
     * @return the bjProdutos
     */
    public BjProduto getBjProduto() {
        return bjProduto;
    }

    public void consultarProduto(String sCodigoProduto){
        //bjProduto = new BjProduto();
        bjProduto.setSCodigo(sCodigoProduto);
        bjProduto = daobjProduto.findBySCodigo(bjProduto);
        if(bjProduto == null){
            this.inicializaObjetos();
        }
    }

    public List<BjProduto> listaTudo(){
        return daobjProduto.listaTudo();
    }
}
