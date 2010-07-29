/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bj_user")
@NamedQueries({@NamedQuery(name = "BjUser.findAll", query = "SELECT b FROM BjUser b"), @NamedQuery(name = "BjUser.findById", query = "SELECT b FROM BjUser b WHERE b.id = :id"), @NamedQuery(name = "BjUser.findBySUser", query = "SELECT b FROM BjUser b WHERE b.sUser = :sUser"), @NamedQuery(name = "BjUser.findBySPass", query = "SELECT b FROM BjUser b WHERE b.sPass = :sPass"), @NamedQuery(name = "BjUser.findBySNome", query = "SELECT b FROM BjUser b WHERE b.sNome = :sNome"), @NamedQuery(name = "BjUser.findBySAtivo", query = "SELECT b FROM BjUser b WHERE b.sAtivo = :sAtivo"), @NamedQuery(name = "BjUser.findByNTentativas", query = "SELECT b FROM BjUser b WHERE b.nTentativas = :nTentativas")})
public class BjUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "s_user")
    private String sUser;
    @Basic(optional = false)
    @Column(name = "s_pass")
    private String sPass;
    @Basic(optional = false)
    @Column(name = "s_nome")
    private String sNome;
    @Column(name = "s_ativo")
    private String sAtivo;
    @Column(name = "n_tentativas")
    private BigInteger nTentativas;

    public BjUser() {
    }

    public BjUser(BigDecimal id) {
        this.id = id;
    }

    public BjUser(BigDecimal id, String sPass, String sNome) {
        this.id = id;
        this.sPass = sPass;
        this.sNome = sNome;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSUser() {
        return sUser;
    }

    public void setSUser(String sUser) {
        this.sUser = sUser;
    }

    public String getSPass() {
        return sPass;
    }

    public void setSPass(String sPass) {
        this.sPass = sPass;
    }

    public String getSNome() {
        return sNome;
    }

    public void setSNome(String sNome) {
        this.sNome = sNome;
    }

    public String getSAtivo() {
        return sAtivo;
    }

    public void setSAtivo(String sAtivo) {
        this.sAtivo = sAtivo;
    }

    public BigInteger getNTentativas() {
        return nTentativas;
    }

    public void setNTentativas(BigInteger nTentativas) {
        this.nTentativas = nTentativas;
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
        if (!(object instanceof BjUser)) {
            return false;
        }
        BjUser other = (BjUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bijufactory.produto.model.BjUser[id=" + id + "]";
    }

}
