
package br.com.fdw.negocio.entidades;

import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Entity
@Table(name = "cliente")
@NamedQueries(
{
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Cliente.findByNumeroCpf", query = "SELECT c FROM Cliente c WHERE c.numeroCpf = :numeroCpf")
})

public class Cliente extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIE_CD_CLIENTE")
    private Integer codigoCliente;
    @Basic(optional = false)
    @Column(name = "CLIE_NM_CLIENTE")
    private String nomeCliente;
    @Basic(optional = false)
    @Column(name = "CLIE_NR_CPF")
    private String numeroCpf;
    @Basic(optional = false)
    @Column(name = "CLIE_IN_SEXO")
    private char sexo;
    @Basic(optional = false)
    @Column(name = "CLIE_DT_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "CLIE_NR_CELULAR")
    private String numeroCelular;
    @Column(name = "CLIE_NR_TELEFONE_FIXO")
    private String numeroTelefoneFixo;
    @Basic(optional = false)
    @Column(name = "CLIE_TX_EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "CLIE_TX_SENHA")
    private String senha;
    @Basic(optional = false)
    @Column(name = "CLIE_TX_ENDERECO")
    private String endereco;
    @Column(name = "CLIE_TX_PONTO_REFERENCIA")
    private String pontoReferencia;
    @Basic(optional = false)
    @Column(name = "CLIE_IN_STATUS")
    private char status;
    @JoinColumn(name = "CEP_CD_CEP", referencedColumnName = "CEP_CD_CEP")
    @ManyToOne(optional = false)
    private Cep cep;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Pedido> pedidoCollection;

    public Cliente() {
    }

    public Cliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente(Integer codigoCliente, String nomeCliente, String numeroCpf, char sexo, Date DataNascimento, String email, String senha, String endereco, char status) {
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.numeroCpf = numeroCpf;
        this.sexo = sexo;
        this.dataNascimento = DataNascimento;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.status = status;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroTelefoneFixo() {
        return numeroTelefoneFixo;
    }

    public void setNumeroTelefoneFixo(String numeroTelefoneFixo) {
        this.numeroTelefoneFixo = numeroTelefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Cliente[codigoCliente=" + codigoCliente + "]";
    }

}
