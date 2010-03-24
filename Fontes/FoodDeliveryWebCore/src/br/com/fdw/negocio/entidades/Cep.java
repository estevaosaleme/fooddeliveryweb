
package br.com.fdw.negocio.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "cep")
@NamedQueries(
{
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c"),
    @NamedQuery(name = "Cep.findByCodigo", query = "SELECT c FROM Cep c WHERE c.codigoCep = :codigoCep"),
    @NamedQuery(name = "Cep.findByNumeroCep", query = "SELECT c FROM Cep c WHERE c.numeroCep = :numeroCep")
})
public class Cep extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CEP_CD_CEP")
    private Integer codigoCep;
    @Basic(optional = false)
    @Column(name = "CEP_NR_CEP")
    private String numeroCep;
    @Basic(optional = false)
    @Column(name = "CEP_NM_LOGRADOURO")
    private String nomeLogradouro;
    @Basic(optional = false)
    @Column(name = "CEP_NM_BAIRRO")
    private String nomeBairro;
    @Basic(optional = false)
    @Column(name = "CEP_NM_CIDADE")
    private String nomeCidade;
    @Basic(optional = false)
    @Column(name = "CEP_SG_ESTADO")
    private String siglaEstado;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstabelecimentoCep")
    private Collection<EstabelecimentoCep> estabelecimentoCepCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "cep")
    private Collection<Cliente> clienteCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cep")
    private Collection<Estabelecimento> estabelecimentoCollection;

    public Cep() {
    }

    public Cep(Integer cepCdCep) {
        this.codigoCep = cepCdCep;
    }

    public Cep(Integer codigoCep, String numeroCep, String nomeLogradouro, String nomeBairro, String nomeCidade, String siglaEstado) {
        this.codigoCep = codigoCep;
        this.numeroCep = numeroCep;
        this.nomeLogradouro = nomeLogradouro;
        this.nomeBairro = nomeBairro;
        this.nomeCidade = nomeCidade;
        this.siglaEstado = siglaEstado;
    }

    public Integer getCodigoCep() {
        return codigoCep;
    }

    public void setCodigoCep(Integer codigoCep) {
        this.codigoCep = codigoCep;
    }

    public String getNumeroCep() {
        return numeroCep;
    }

    public void setNumeroCep(String numeroCep) {
        this.numeroCep = numeroCep;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public Collection<EstabelecimentoCep> getEstabelecimentoCepCollection() {
        return estabelecimentoCepCollection;
    }

    public void setEstabelecimentoCepCollection(Collection<EstabelecimentoCep> estabelecimentoCepCollection) {
        this.estabelecimentoCepCollection = estabelecimentoCepCollection;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Collection<Estabelecimento> getEstabelecimentoCollection() {
        return estabelecimentoCollection;
    }

    public void setEstabelecimentoCollection(Collection<Estabelecimento> estabelecimentoCollection) {
        this.estabelecimentoCollection = estabelecimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCep != null ? codigoCep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.codigoCep == null && other.codigoCep != null) || (this.codigoCep != null && !this.codigoCep.equals(other.codigoCep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Cep[codigoCep=" + codigoCep + "]";
    }

}
