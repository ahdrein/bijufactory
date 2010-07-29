/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.materia_prima.controller;

import br.com.bijufactory.materia_prima.factory.MateriaPrimaDao;
import br.com.bijufactory.materia_prima.factory.MateriaPrimaDaoFactory;
import br.com.bijufactory.materia_prima.model.BjMateriaPrima;

/**
 *
 * @author HP
 */
public class MateriaPrimaController {
    private BjMateriaPrima bjMateriaPrima;
    MateriaPrimaDaoFactory factory;
    MateriaPrimaDao<BjMateriaPrima> daobjMateriaPrima;

    public MateriaPrimaController(){
        factory = new MateriaPrimaDaoFactory();
        daobjMateriaPrima = factory.getDao();
    }

    public void inicializaObjetos(){
        bjMateriaPrima = new BjMateriaPrima();
    }

    public void salvar(){
        //Inserindo nova Materia Prima
        daobjMateriaPrima.inserirAtualizar(this.bjMateriaPrima);
    }

    public void removerMateriaPrima(){
        daobjMateriaPrima.excluir(this.bjMateriaPrima);
    }

    /**
     * @return the bjMateriaPrima
     */
    public BjMateriaPrima getBjMateriaPrima() {
        return bjMateriaPrima;
    }

    public void consultarMateriaPrima(String sCodigoMateriaPrima){
        bjMateriaPrima.setSCodigo(sCodigoMateriaPrima);
        bjMateriaPrima = daobjMateriaPrima.findBySCodigo(bjMateriaPrima);
        if(bjMateriaPrima == null){
            this.inicializaObjetos();
        }
    }
}
