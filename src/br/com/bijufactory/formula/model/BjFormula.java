/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.formula.model;

import br.com.bijufactory.produto.model.*;
import br.com.bijufactory.materia_prima.model.BjMateriaPrima;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bj_formula")
@SequenceGenerator(name="seq_id_formula", sequenceName="seq_id_formula", allocationSize=1)
@NamedQueries({@NamedQuery(name = "BjFormula.findAll", query = "SELECT b FROM BjFormula b"), 
               @NamedQuery(name = "BjFormula.findByNQtde", query = "SELECT b FROM BjFormula b WHERE b.nQtde = :nQtde"),
               @NamedQuery(name = "BjFormula.findById", query = "SELECT b FROM BjFormula b WHERE b.id = :id")})
public class BjFormula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "n_qtde")
    private Long nQtde;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="seq_id_formula")
    private Long id;

    @JoinColumn(name = "s_codigo_materia_prima", referencedColumnName = "s_codigo")
    @ManyToOne
    private BjMateriaPrima sCodigoMateriaPrima;

    //@OneToMany(mappedBy="BjMateriaPrima", fetch=FetchType.LAZY)
    //@Cascade(CascadeType.ALL)
    //private List<BjMateriaPrima> collectionMateriaPrima;

    @JoinColumn(name = "s_codigo_produto", referencedColumnName = "s_codigo")
    @ManyToOne
    private BjProduto sCodigoProduto;

    public BjFormula() {
    }

    public BjFormula(Long id) {
        this.id = id;
    }

    public Long getNQtde() {
        return nQtde;
    }

    public void setNQtde(Long nQtde) {
        this.nQtde = nQtde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BjMateriaPrima getSCodigoMateriaPrima() {
        return sCodigoMateriaPrima;
    }

    public void setSCodigoMateriaPrima(BjMateriaPrima sCodigoMateriaPrima) {
        this.sCodigoMateriaPrima = sCodigoMateriaPrima;
    }

    public BjProduto getSCodigoProduto() {
        return sCodigoProduto;
    }

    public void setSCodigoProduto(BjProduto sCodigoProduto) {
        this.sCodigoProduto = sCodigoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BjFormula)) {
            return false;
        }
        BjFormula other = (BjFormula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.produto.model.BjFormula[id=" + id + "]";
    }

}
