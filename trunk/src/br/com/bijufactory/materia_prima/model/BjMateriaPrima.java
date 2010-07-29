/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.materia_prima.model;

import br.com.bijufactory.cotacao.model.BjCotacao;
import br.com.bijufactory.formula.model.BjFormula;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bj_materia_prima")
@NamedQueries({@NamedQuery(name = "BjMateriaPrima.findAll", query = "SELECT b FROM BjMateriaPrima b"), 
               @NamedQuery(name = "BjMateriaPrima.findBySCodigo", query = "SELECT b FROM BjMateriaPrima b WHERE b.sCodigo = :sCodigo"),
               @NamedQuery(name = "BjMateriaPrima.findBySDescricao", query = "SELECT b FROM BjMateriaPrima b WHERE b.sDescricao = :sDescricao")})
public class BjMateriaPrima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "s_codigo")
    private String sCodigo;

    @Column(name = "s_descricao")
    private String sDescricao;

    @OneToMany(mappedBy = "sCodigoMateriaPrima")
    private Collection<BjFormula> bjFormulaCollection;

    @OneToMany(mappedBy = "sCodigoMateriaPrima")
    private Collection<BjCotacao> bjFornecedorMateriaPrimaCollection;

    public BjMateriaPrima() {
    }

    public BjMateriaPrima(String sCodigo) {
        this.sCodigo = sCodigo;
    }

    public String getSCodigo() {
        return sCodigo;
    }

    public void setSCodigo(String sCodigo) {
        this.sCodigo = sCodigo;
    }

    public String getSDescricao() {
        return sDescricao;
    }

    public void setSDescricao(String sDescricao) {
        this.sDescricao = sDescricao;
    }

    public Collection<BjFormula> getBjFormulaCollection() {
        return bjFormulaCollection;
    }

    public void setBjFormulaCollection(Collection<BjFormula> bjFormulaCollection) {
        this.bjFormulaCollection = bjFormulaCollection;
    }

    public Collection<BjCotacao> getBjFornecedorMateriaPrimaCollection() {
        return bjFornecedorMateriaPrimaCollection;
    }

    public void setBjFornecedorMateriaPrimaCollection(Collection<BjCotacao> bjFornecedorMateriaPrimaCollection) {
        this.bjFornecedorMateriaPrimaCollection = bjFornecedorMateriaPrimaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sCodigo != null ? sCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BjMateriaPrima)) {
            return false;
        }
        BjMateriaPrima other = (BjMateriaPrima) object;
        if ((this.sCodigo == null && other.sCodigo != null) || (this.sCodigo != null && !this.sCodigo.equals(other.sCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.produto.model.BjMateriaPrima[sCodigo=" + sCodigo + "]";
    }

}
