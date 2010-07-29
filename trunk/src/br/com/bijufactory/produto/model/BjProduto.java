/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.produto.model;

import br.com.bijufactory.formula.model.BjFormula;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bj_produto")
@NamedQueries({@NamedQuery(name = "BjProduto.findAll", query = "SELECT b FROM BjProduto b"),
               @NamedQuery(name = "BjProduto.findBySCodigo", query = "SELECT b FROM BjProduto b WHERE b.sCodigo = :sCodigo"),
               @NamedQuery(name = "BjProduto.findBySDescricao", query = "SELECT b FROM BjProduto b WHERE b.sDescricao = :sDescricao"),
               @NamedQuery(name = "BjProduto.findByNVlrCusto", query = "SELECT b FROM BjProduto b WHERE b.nVlrCusto = :nVlrCusto"),
               @NamedQuery(name = "BjProduto.findByNPeso", query = "SELECT b FROM BjProduto b WHERE b.nPeso = :nPeso"),
               @NamedQuery(name = "BjProduto.findByNIndiceAuAg", query = "SELECT b FROM BjProduto b WHERE b.nIndiceAuAg = :nIndiceAuAg")})
public class BjProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "s_codigo")
    private String sCodigo;

    @Column(name = "s_descricao")
    private String sDescricao;

    @Column(name = "n_vlr_custo")
    private Double nVlrCusto;

    @Column(name = "n_peso")
    private Double nPeso;

    @Column(name = "n_indice_au_ag")
    private String nIndiceAuAg;

    @Lob
    @Column(name = "imagem")
    private FileInputStream imagem;

    @OneToMany(mappedBy = "sCodigoProduto")
    private Collection<BjFormula> bjFormulaCollection;

    public BjProduto() {
    }

    public BjProduto(String sCodigo) {
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

    public Double getNVlrCusto() {
        return nVlrCusto;
    }

    public void setNVlrCusto(Double nVlrCusto) {
        this.nVlrCusto = nVlrCusto;
    }

    public Double getNPeso() {
        return nPeso;
    }

    public void setNPeso(Double nPeso) {
        this.nPeso = nPeso;
    }

    public String getNIndiceAuAg() {
        return nIndiceAuAg;
    }

    public void setNIndiceAuAg(String nIndiceAuAg) {
        this.nIndiceAuAg = nIndiceAuAg;
    }

    //public Object getImgProd() {
    //    return imgProd;
    //}

    //public void setImgProd(Object imgProd) {
    //    this.imgProd = imgProd;
    //}

    public Collection<BjFormula> getBjFormulaCollection() {
        return bjFormulaCollection;
    }

    public void setBjFormulaCollection(Collection<BjFormula> bjFormulaCollection) {
        this.bjFormulaCollection = bjFormulaCollection;
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
        if (!(object instanceof BjProduto)) {
            return false;
        }
        BjProduto other = (BjProduto) object;
        if ((this.sCodigo == null && other.sCodigo != null) || (this.sCodigo != null && !this.sCodigo.equals(other.sCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.produto.model.BjProduto[sCodigo=" + sCodigo + "]";
    }

    /**
     * @return the imagem
     */
    public FileInputStream getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(FileInputStream imagem) {
        this.imagem = imagem;
    }

}
