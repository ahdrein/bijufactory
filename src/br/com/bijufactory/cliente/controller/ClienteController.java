/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.cliente.controller;

import br.com.bijufactory.pessoa.factory.PessoaDao;
import br.com.bijufactory.pessoa.factory.PessoaDaoFactory;
import br.com.bijufactory.pessoa.model.BjPessoa;

/**
 *
 * @author HP
 */
public class ClienteController {
    private BjPessoa bjCliente;
    PessoaDaoFactory factory;
    PessoaDao<BjPessoa> daobjCliente;

    public ClienteController(){
        factory = new PessoaDaoFactory();
        daobjCliente = factory.getDao();
    }

    public void inicializaObjetos(){
        bjCliente = new BjPessoa();
    }

    public void salvar(){
        //Inserindo nova Materia Prima
        daobjCliente.inserirAtualizar(this.bjCliente);
    }

    public void removerCliente(){
        daobjCliente.excluir(this.bjCliente);
    }

    /**
     * @return the bjCliente
     */
    public BjPessoa getbjCliente() {
        return bjCliente;
    }

    public void consultarCliente(String sNomeCliente){
        bjCliente.setSNome(sNomeCliente);
        bjCliente = daobjCliente.findBySNome(bjCliente);
        if(bjCliente == null){
            this.inicializaObjetos();
        }
    }
}
