
package br.com.fdw.negocio.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "forma_pagamento")
@NamedQueries({@NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f"), @NamedQuery(name = "FormaPagamento.findByCodigo", query = "SELECT f FROM FormaPagamento f WHERE f.codigoFormaPagamento = :codigoFormaPagamento")})
public class FormaPagamento extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOPA_CD_FORMA_PAGAMENTO")
    private Integer codigoFormaPagamento;
    @Basic(optional = false)
    @Column(name = "FOPA_NM_TIPO_PAGAMENTO")
    private String nomeTipoPagamento;
    @Lob
    @Column(name = "FOPA_MM_ICONE")
    private byte[] icone;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "formaPagamento")
    private Collection<EstabelecimentoFormaPagamento> estabelecimentoFormaPagamentoCollection;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamento")
    private Collection<Pedido> pedidoCollection;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer codigoFormaPagamento) {
        this.codigoFormaPagamento = codigoFormaPagamento;
    }

    public FormaPagamento(Integer codigoFormaPagamento, String nomeTipoPagamento) {
        this.codigoFormaPagamento = codigoFormaPagamento;
        this.nomeTipoPagamento = nomeTipoPagamento;
    }

    public Integer getCodigoFormaPagamento() {
        return codigoFormaPagamento;
    }

    public void setCodigoFormaPagamento(Integer codigoFormaPagamento) {
        this.codigoFormaPagamento = codigoFormaPagamento;
    }

    public String getNomeTipoPagamento() {
        return nomeTipoPagamento;
    }

    public void setNomeTipoPagamento(String nomeTipoPagamento) {
        this.nomeTipoPagamento = nomeTipoPagamento;
    }

    public byte[] getIcone() {
        return icone;
    }

    public void setIcone(byte[] icone) {
        this.icone = icone;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFormaPagamento != null ? codigoFormaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.codigoFormaPagamento == null && other.codigoFormaPagamento != null) || (this.codigoFormaPagamento != null && !this.codigoFormaPagamento.equals(other.codigoFormaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.FormaPagamento[codigoFormaPagamento=" + codigoFormaPagamento + "]";
    }

}
