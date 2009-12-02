package br.com.fdw.negocio.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "estabelecimento_cep")
@NamedQueries({@NamedQuery(name = "EstabelecimentoCep.findAll", query = "SELECT e FROM EstabelecimentoCep e"), @NamedQuery(name = "EstabelecimentoCep.findByCodigo", query = "SELECT e FROM EstabelecimentoCep e WHERE e.codigoEstabelecimentoCep = :codigoEstabelecimentoCep")})
public class EstabelecimentoCep extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESCE_CD_ESTA_CEP")
    private Integer codigoEstabelecimentoCep;
    @JoinColumn(name = "CEP_CD_CEP", referencedColumnName = "CEP_CD_CEP")
    @ManyToOne(optional = false)
    private Cep cep;
    @JoinColumn(name = "ESTA_CD_ESTABELECIMENTO", referencedColumnName = "ESTA_CD_ESTABELECIMENTO")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;

    public EstabelecimentoCep() {
    }

    public EstabelecimentoCep(Integer codigoEstabelecimentoCep) {
        this.codigoEstabelecimentoCep = codigoEstabelecimentoCep;
    }

    public Integer getCodigoEstabelecimentoCep() {
        return codigoEstabelecimentoCep;
    }

    public void setCodigoEstabelecimentoCep(Integer codigoEstabelecimentoCep) {
        this.codigoEstabelecimentoCep = codigoEstabelecimentoCep;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstabelecimentoCep != null ? codigoEstabelecimentoCep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstabelecimentoCep)) {
            return false;
        }
        EstabelecimentoCep other = (EstabelecimentoCep) object;
        if ((this.codigoEstabelecimentoCep == null && other.codigoEstabelecimentoCep != null) || (this.codigoEstabelecimentoCep != null && !this.codigoEstabelecimentoCep.equals(other.codigoEstabelecimentoCep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.EstabelecimentoCep[codigoEstabelecimentoCep=" + codigoEstabelecimentoCep + "]";
    }

}
