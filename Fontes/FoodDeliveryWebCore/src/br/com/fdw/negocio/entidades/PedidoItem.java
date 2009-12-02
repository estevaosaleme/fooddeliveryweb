
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
@Table(name = "pedido_item")
@NamedQueries({@NamedQuery(name = "PedidoItem.findAll", query = "SELECT p FROM PedidoItem p"), @NamedQuery(name = "PedidoItem.findByCodigo", query = "SELECT p FROM PedidoItem p WHERE p.codigoPedidoItem = :codigoPedidoItem")})
public class PedidoItem extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEIT_CD_PEDIDO_ITEM")
    private Integer codigoPedidoItem;
    @Basic(optional = false)
    @Column(name = "PEIT_VL_COBRADO")
    private double valorCobrado;
    @Basic(optional = false)
    @Column(name = "PEIT_QN_QUANTIDADE")
    private int quantidade;
    @JoinColumn(name = "PEDI_CD_PEDIDO", referencedColumnName = "PEDI_CD_PEDIDO")
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "PRAT_CD_PRATO", referencedColumnName = "PRAT_CD_PRATO")
    @ManyToOne(optional = false)
    private Prato prato;

    public PedidoItem() {
    }

    public PedidoItem(Integer codigoPedidoItem) {
        this.codigoPedidoItem = codigoPedidoItem;
    }

    public PedidoItem(Integer codigoPedidoItem, double valorCobrado, int quantidade) {
        this.codigoPedidoItem = codigoPedidoItem;
        this.valorCobrado = valorCobrado;
        this.quantidade = quantidade;
    }

    public Integer getCodigoPedidoItem() {
        return codigoPedidoItem;
    }

    public void setCodigoPedidoItem(Integer codigoPedidoItem) {
        this.codigoPedidoItem = codigoPedidoItem;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido codigoPedido) {
        this.pedido = codigoPedido;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPedidoItem != null ? codigoPedidoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoItem)) {
            return false;
        }
        PedidoItem other = (PedidoItem) object;
        if ((this.codigoPedidoItem == null && other.codigoPedidoItem != null) || (this.codigoPedidoItem != null && !this.codigoPedidoItem.equals(other.codigoPedidoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.PedidoItem[codigoPedidoItem=" + codigoPedidoItem + "]";
    }

}
