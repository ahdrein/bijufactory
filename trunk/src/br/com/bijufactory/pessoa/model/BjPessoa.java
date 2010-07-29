/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.pessoa.model;

import br.com.bijufactory.cotacao.model.BjCotacao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bj_pessoa", catalog = "BijuFactory", schema = "public")
@SequenceGenerator(name="seq_id_pessoa", sequenceName="seq_id_pessoa", allocationSize=1)
@NamedQueries({ @NamedQuery(name = "BjPessoa.findAll", query = "SELECT b FROM BjPessoa b"),
                @NamedQuery(name = "BjPessoa.findBySNome", query = "SELECT b FROM BjPessoa b WHERE b.sNome = :sNome"), @NamedQuery(name = "BjPessoa.findBySSobrenome", query = "SELECT b FROM BjPessoa b WHERE b.sSobrenome = :sSobrenome"),
                @NamedQuery(name = "BjPessoa.findByDDtNascimento", query = "SELECT b FROM BjPessoa b WHERE b.dDtNascimento = :dDtNascimento"),
                @NamedQuery(name = "BjPessoa.findBySCidade", query = "SELECT b FROM BjPessoa b WHERE b.sCidade = :sCidade"), @NamedQuery(name = "BjPessoa.findBySRg", query = "SELECT b FROM BjPessoa b WHERE b.sRg = :sRg"),
                @NamedQuery(name = "BjPessoa.findBySCpf", query = "SELECT b FROM BjPessoa b WHERE b.sCpf = :sCpf"),
                @NamedQuery(name = "BjPessoa.findBySTipo", query = "SELECT b FROM BjPessoa b WHERE b.sTipo = :sTipo"),
                @NamedQuery(name = "BjPessoa.findBySStatus", query = "SELECT b FROM BjPessoa b WHERE b.sStatus = :sStatus"),
                @NamedQuery(name = "BjPessoa.findById", query = "SELECT b FROM BjPessoa b WHERE b.id = :id")})

public class BjPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "s_nome")
    private String sNome;

    @Column(name = "s_sobrenome")
    private String sSobrenome;

    @Column(name = "d_dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dDtNascimento;

    @Column(name = "s_cidade")
    private String sCidade;

    @Column(name = "s_rg")
    private String sRg;

    @Column(name = "s_cpf")
    private String sCpf;

    @Column(name = "s_tipo")
    private String sTipo;

    @Column(name = "s_status")
    private String sStatus;

    @Column(name = "s_codigo")
    private String sCodigo;  

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="seq_id_pessoa")
    private Long id;

    //@OneToMany(mappedBy = "idFornecedor")
    //private Collection<BjCotacao> bjCotacaoCollection;

    public BjPessoa() {
    }

    public BjPessoa(Long id) {
        this.id = id;
    }

    public BjPessoa(Long id, String sNome) {
        this.id = id;
        this.sNome = sNome;
    }

    public String getSNome() {
        return sNome;
    }

    public void setSNome(String sNome) {
        this.sNome = sNome;
    }

    public String getSSobrenome() {
        return sSobrenome;
    }

    public void setSSobrenome(String sSobrenome) {
        this.sSobrenome = sSobrenome;
    }

    public Date getDDtNascimento() {
        return dDtNascimento;
    }

    public void setDDtNascimento(Date dDtNascimento) {
        this.dDtNascimento = dDtNascimento;
    }

    public String getSCidade() {
        return sCidade;
    }

    public void setSCidade(String sCidade) {
        this.sCidade = sCidade;
    }

    public String getSRg() {
        return sRg;
    }

    public void setSRg(String sRg) {
        this.sRg = sRg;
    }

    public String getSCpf() {
        return sCpf;
    }

    public void setSCpf(String sCpf) {
        this.sCpf = sCpf;
    }

    public String getSTipo() {
        return sTipo;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public String getSStatus() {
        return sStatus;
    }

    public void setSStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    /**
     * @return the sCodigo
     */
    public String getSCodigo() {
        return sCodigo;
    }

    /**
     * @param sCodigo the sCodigo to set
     */
    public void setSCodigo(String sCodigo) {
        this.sCodigo = sCodigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof BjPessoa)) {
            return false;
        }
        BjPessoa other = (BjPessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.pessoa.model.BjPessoa[id=" + id + "]";
    }


}
