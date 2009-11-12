/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "cep")
@NamedQueries({@NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c")})
public class Cep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CEP_NR_CEP")
    private Integer cepNrCep;
    @Basic(optional = false)
    @Column(name = "CEP_NM_BAIRRO")
    private String cepNmBairro;
    @Basic(optional = false)
    @Column(name = "CEP_NM_CIDADE")
    private String cepNmCidade;
    @Basic(optional = false)
    @Column(name = "CEP_NM_ESTADO")
    private String cepNmEstado;
    @Basic(optional = false)
    @Column(name = "CEP_NM_LOGRADOURO")
    private String cepNmLogradouro;

    public Cep() {
    }

    public Cep(Integer cepNrCep) {
        this.cepNrCep = cepNrCep;
    }

    public Cep(Integer cepNrCep, String cepNmBairro, String cepNmCidade, String cepNmEstado, String cepNmLogradouro) {
        this.cepNrCep = cepNrCep;
        this.cepNmBairro = cepNmBairro;
        this.cepNmCidade = cepNmCidade;
        this.cepNmEstado = cepNmEstado;
        this.cepNmLogradouro = cepNmLogradouro;
    }

    public Integer getCepNrCep() {
        return cepNrCep;
    }

    public void setCepNrCep(Integer cepNrCep) {
        this.cepNrCep = cepNrCep;
    }

    public String getCepNmBairro() {
        return cepNmBairro;
    }

    public void setCepNmBairro(String cepNmBairro) {
        this.cepNmBairro = cepNmBairro;
    }

    public String getCepNmCidade() {
        return cepNmCidade;
    }

    public void setCepNmCidade(String cepNmCidade) {
        this.cepNmCidade = cepNmCidade;
    }

    public String getCepNmEstado() {
        return cepNmEstado;
    }

    public void setCepNmEstado(String cepNmEstado) {
        this.cepNmEstado = cepNmEstado;
    }

    public String getCepNmLogradouro() {
        return cepNmLogradouro;
    }

    public void setCepNmLogradouro(String cepNmLogradouro) {
        this.cepNmLogradouro = cepNmLogradouro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepNrCep != null ? cepNrCep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.cepNrCep == null && other.cepNrCep != null) || (this.cepNrCep != null && !this.cepNrCep.equals(other.cepNrCep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Business.Entity.Cep[cepNrCep=" + cepNrCep + "]";
    }

}
