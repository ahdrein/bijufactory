/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.cotacao.model;

import br.com.bijufactory.materia_prima.model.BjMateriaPrima;
import br.com.bijufactory.pessoa.model.BjPessoa;
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
@Table(name = "bj_cotacao")
@SequenceGenerator(name="seq_id_cotacao", sequenceName="seq_id_cotacao", allocationSize=1)
@NamedQueries({@NamedQuery(name = "BjCotacao.findAll", query = "SELECT b FROM BjCotacao b"),
               @NamedQuery(name = "BjCotacao.findById", query = "SELECT b FROM BjCotacao b WHERE b.id = :id")})
public class BjCotacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="seq_id_cotacao")
    private Long id;

    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    @ManyToOne
    private BjPessoa idFornecedor;

    @JoinColumn(name = "s_codigo_materia_prima", referencedColumnName = "s_codigo")
    @ManyToOne
    private BjMateriaPrima sCodigoMateriaPrima;

    @Column(name = "n_valor_custo")
    private Float nValorCusto;

    public BjCotacao() {
    }

    public BjCotacao(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BjPessoa getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(BjPessoa idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public BjMateriaPrima getSCodigoMateriaPrima() {
        return sCodigoMateriaPrima;
    }

    public void setSCodigoMateriaPrima(BjMateriaPrima sCodigoMateriaPrima) {
        this.sCodigoMateriaPrima = sCodigoMateriaPrima;
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
        if (!(object instanceof BjCotacao)) {
            return false;
        }
        BjCotacao other = (BjCotacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.produto.model.BjCotacao[id=" + id + "]";
    }

    /**
     * @return the nValorCusto
     */
    public Float getnValorCusto() {
        return nValorCusto;
    }

    /**
     * @param nValorCusto the nValorCusto to set
     */
    public void setnValorCusto(Float nValorCusto) {
        this.nValorCusto = nValorCusto;
    }

}
