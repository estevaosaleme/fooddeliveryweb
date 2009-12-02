
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
@Table(name = "pedido")
@NamedQueries({@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"), @NamedQuery(name = "Pedido.findByCodigo", query = "SELECT p FROM Pedido p WHERE p.codigoPedido = :codigoPedido")})
public class Pedido extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEDI_CD_PEDIDO")
    private Integer codigoPedido;
    @Basic(optional = false)
    @Column(name = "PEDI_DT_HORA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraPedido;
    @Column(name = "PEDI_DT_HORA_SAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraSaida;
    @Column(name = "PEDI_DT_HORA_ENTREGA_AGENDADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEntregaAgendada;
    @Column(name = "PEDI_DT_HORA_ENTREGA_REAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEntregaReal;
    @Column(name = "PEDI_DT_HORA_FECHAMENTO_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraFechamentoPedido;
    @Basic(optional = false)
    @Column(name = "PEDI_IN_SITUACAO")
    private char situacao;
    @Column(name = "PEDI_TX_OBSERVACAO_CLIENTE")
    private String observacaoCliente;
    @Column(name = "PEDI_TX_OBSERVACAO_ESTABELECIMENTO")
    private String observacaoEstabelecimento;
    @JoinColumn(name = "CLIE_CD_CLIENTE", referencedColumnName = "CLIE_CD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "ESTA_CD_ESTABELECIMENTO", referencedColumnName = "ESTA_CD_ESTABELECIMENTO")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;
    @JoinColumn(name = "FOPA_CD_FORMA_PAGAMENTO", referencedColumnName = "FOPA_CD_FORMA_PAGAMENTO")
    @ManyToOne(optional = false)
    private FormaPagamento formaPagamento;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Collection<PedidoItem> pedidoItemCollection;

    public Pedido() {
    }

    public Pedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido(Integer codigoPedido, Date dataHoraPedido, char situacao) {
        this.codigoPedido = codigoPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.situacao = situacao;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Date getDataHoraEntregaAgendada() {
        return dataHoraEntregaAgendada;
    }

    public void setDataHoraEntregaAgendada(Date dataHoraEntregaAgendada) {
        this.dataHoraEntregaAgendada = dataHoraEntregaAgendada;
    }

    public Date getDataHoraEntregaReal() {
        return dataHoraEntregaReal;
    }

    public void setDataHoraEntregaReal(Date dataHoraEntregaReal) {
        this.dataHoraEntregaReal = dataHoraEntregaReal;
    }

    public Date getDataHoraFechamentoPedido() {
        return dataHoraFechamentoPedido;
    }

    public void setDataHoraFechamentoPedido(Date dataHoraFechamentoPedido) {
        this.dataHoraFechamentoPedido = dataHoraFechamentoPedido;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public String getObservacaoCliente() {
        return observacaoCliente;
    }

    public void setObservacaoCliente(String observacaoCliente) {
        this.observacaoCliente = observacaoCliente;
    }

    public String getObservacaoEstabelecimento() {
        return observacaoEstabelecimento;
    }

    public void setObservacaoEstabelecimento(String observacaoEstabelecimento) {
        this.observacaoEstabelecimento = observacaoEstabelecimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Collection<PedidoItem> getPedidoItemCollection() {
        return pedidoItemCollection;
    }

    public void setPedidoItemCollection(Collection<PedidoItem> pedidoItemCollection) {
        this.pedidoItemCollection = pedidoItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPedido != null ? codigoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codigoPedido == null && other.codigoPedido != null) || (this.codigoPedido != null && !this.codigoPedido.equals(other.codigoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Pedido[codigoPedido=" + codigoPedido + "]";
    }

}
