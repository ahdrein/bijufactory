/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.fornecedor.controller;

import br.com.bijufactory.pessoa.factory.PessoaDao;
import br.com.bijufactory.pessoa.factory.PessoaDaoFactory;
import br.com.bijufactory.pessoa.model.BjPessoa;

/**
 *
 * @author HP
 */
public class FornecedorController {
    private BjPessoa bjFornecedor;
    PessoaDaoFactory factory;
    PessoaDao<BjPessoa> daobjFornecedor;

    public FornecedorController(){
        factory = new PessoaDaoFactory();
        daobjFornecedor = factory.getDao();
    }

    public void inicializaObjetos(){
        bjFornecedor = new BjPessoa();
    }

    public void salvar(){
        //Inserindo nova Materia Prima
        daobjFornecedor.inserirAtualizar(this.bjFornecedor);
    }

    public void removerMateriaPrima(){
        daobjFornecedor.excluir(this.bjFornecedor);
    }

    /**
     * @return the bjFornecedor
     */
    public BjPessoa getbjFornecedor() {
        return bjFornecedor;
    }

    public void consultarMateriaPrima(String sCodigoFornecedor){
        bjFornecedor.setSCodigo(sCodigoFornecedor);
        bjFornecedor = daobjFornecedor.findBySCodigo(bjFornecedor);
        if(bjFornecedor == null){
            this.inicializaObjetos();
        }
    }
}
