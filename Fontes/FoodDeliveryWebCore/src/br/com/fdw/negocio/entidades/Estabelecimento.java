
package br.com.fdw.negocio.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "estabelecimento")
@NamedQueries(
{
    @NamedQuery(name = "Estabelecimento.findAll", query = "SELECT e FROM Estabelecimento e"),
    @NamedQuery(name = "Estabelecimento.findByCodigo", query = "SELECT e FROM Estabelecimento e WHERE e.codigoEstabelecimento = :codigoEstabelecimento"),
    @NamedQuery(name = "Estabelecimento.findByNumeroCnpj", query = "SELECT e FROM Estabelecimento e WHERE e.numeroCnpj = :numeroCnpj")
})

public class Estabelecimento extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTA_CD_ESTABELECIMENTO")
    private Integer codigoEstabelecimento;
    @Basic(optional = false)
    @Column(name = "ESTA_NM_FANTASIA")
    private String nomeFantasia;
    @Basic(optional = false)
    @Column(name = "ESTA_NM_RAZAO_SOCIAL")
    private String nomeRazaoSocial;
    @Basic(optional = false)
    @Column(name = "ESTA_NR_CNPJ")
    private String numeroCnpj;
    @Column(name = "ESTA_TX_SLOGAN")
    private String slogan;
    @Basic(optional = false)
    @Column(name = "ESTA_TX_ENDERECO")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "ESTA_TX_EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "ESTA_NR_TELEFONE_FIXO")
    private String numeroTelefoneFixo;
    @Basic(optional = false)
    @Column(name = "ESTA_NM_RESPONSAVEL")
    private String nomeResponsavel;
    @Column(name = "ESTA_NR_CELULAR_RESPONSAVEL")
    private String numeroCelularResponsavel;
    @Basic(optional = false)
    @Column(name = "ESTA_IN_STATUS")
    private char status;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "estabelecimento")
    private Collection<Cardapio> cardapioCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabelecimento")
    private Collection<EstabelecimentoCep> estabelecimentoCepCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabelecimento")
    private Collection<EstabelecimentoFormaPagamento> estabelecimentoFormaPagamentoCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabelecimento")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "CEP_CD_CEP", referencedColumnName = "CEP_CD_CEP")
    @ManyToOne(optional = false)
    private Cep cep;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estabelecimento")
    private Collection<Funcionamento> funcionamentoCollection;

    public Estabelecimento() {
    }

    public Estabelecimento(Integer codigoEstabelecimento) {
        this.codigoEstabelecimento = codigoEstabelecimento;
    }

    public Estabelecimento(Integer codigoEstabelecimento, String nomeFantasia, String nomeRazaoSocial, String numeroCnpj, String endereco, String email, String numeroTelefoneFixo, String nomeResponsavel, char status) {
        this.codigoEstabelecimento = codigoEstabelecimento;
        this.nomeFantasia = nomeFantasia;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.numeroCnpj = numeroCnpj;
        this.endereco = endereco;
        this.email = email;
        this.numeroTelefoneFixo = numeroTelefoneFixo;
        this.nomeResponsavel = nomeResponsavel;
        this.status = status;
    }

    public Integer getCodigoEstabelecimento() {
        return codigoEstabelecimento;
    }

    public void setCodigoEstabelecimento(Integer codigoEstabelecimento) {
        this.codigoEstabelecimento = codigoEstabelecimento;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getNumeroCnpj() {
        return numeroCnpj;
    }

    public void setNumeroCnpj(String numeroCnpj) {
        this.numeroCnpj = numeroCnpj;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefoneFixo() {
        return numeroTelefoneFixo;
    }

    public void setNumeroTelefoneFixo(String numeroTelefoneFixo) {
        this.numeroTelefoneFixo = numeroTelefoneFixo;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNumeroCelularResponsavel() {
        return numeroCelularResponsavel;
    }

    public void setNumeroCelularResponsavel(String numeroCelularResponsavel) {
        this.numeroCelularResponsavel = numeroCelularResponsavel;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Collection<Cardapio> getCardapioCollection() {
        return cardapioCollection;
    }

    public void setCardapioCollection(Collection<Cardapio> cardapioCollection) {
        this.cardapioCollection = cardapioCollection;
    }

    public Collection<EstabelecimentoCep> getEstabelecimentoCepCollection() {
        return estabelecimentoCepCollection;
    }

    public void setEstabelecimentoCepCollection(Collection<EstabelecimentoCep> estabelecimentoCepCollection) {
        this.estabelecimentoCepCollection = estabelecimentoCepCollection;
    }

    public Collection<EstabelecimentoFormaPagamento> getEstabelecimentoFormaPagamentoCollection() {
        return estabelecimentoFormaPagamentoCollection;
    }

    public void setEstabelecimentoFormaPagamentoCollection(Collection<EstabelecimentoFormaPagamento> estabelecimentoFormaPagamentoCollection) {
        this.estabelecimentoFormaPagamentoCollection = estabelecimentoFormaPagamentoCollection;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Collection<Funcionamento> getFuncionamentoCollection() {
        return funcionamentoCollection;
    }

    public void setFuncionamentoCollection(Collection<Funcionamento> funcionamentoCollection) {
        this.funcionamentoCollection = funcionamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstabelecimento != null ? codigoEstabelecimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento other = (Estabelecimento) object;
        if ((this.codigoEstabelecimento == null && other.codigoEstabelecimento != null) || (this.codigoEstabelecimento != null && !this.codigoEstabelecimento.equals(other.codigoEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Estabelecimento[codigoEstabelecimento=" + codigoEstabelecimento + "]";
    }

}
