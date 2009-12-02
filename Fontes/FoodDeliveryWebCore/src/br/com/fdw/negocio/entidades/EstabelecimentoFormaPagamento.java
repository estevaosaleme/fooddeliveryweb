
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
@Table(name = "estabelecimento_forma_pagamento")
@NamedQueries({@NamedQuery(name = "EstabelecimentoFormaPagamento.findAll", query = "SELECT e FROM EstabelecimentoFormaPagamento e"), @NamedQuery(name = "EstabelecimentoFormaPagamento.findByCodigo", query = "SELECT e FROM EstabelecimentoFormaPagamento e WHERE e.codigoEstabelecimentoFormaPagamento = :codigoEstabelecimentoFormaPagamento")})
public class EstabelecimentoFormaPagamento extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESFO_CD_ESTA_FOPA")
    private Integer codigoEstabelecimentoFormaPagamento;
    @JoinColumn(name = "ESTA_CD_ESTABELECIMENTO", referencedColumnName = "ESTA_CD_ESTABELECIMENTO")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;
    @JoinColumn(name = "FOPA_CD_FORMA_PAGAMENTO", referencedColumnName = "FOPA_CD_FORMA_PAGAMENTO")
    @ManyToOne(optional = false)
    private FormaPagamento formaPagamento;

    public EstabelecimentoFormaPagamento() {
    }

    public EstabelecimentoFormaPagamento(Integer codigoEstabelecimentoFormaPagamento) {
        this.codigoEstabelecimentoFormaPagamento = codigoEstabelecimentoFormaPagamento;
    }

    public Integer getCodigoEstabelecimentoFormaPagamento() {
        return codigoEstabelecimentoFormaPagamento;
    }

    public void setCodigoEstabelecimentoFormaPagamento(Integer CodigoEstabelecimentoFormaPagamento) {
        this.codigoEstabelecimentoFormaPagamento = CodigoEstabelecimentoFormaPagamento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstabelecimentoFormaPagamento != null ? codigoEstabelecimentoFormaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstabelecimentoFormaPagamento)) {
            return false;
        }
        EstabelecimentoFormaPagamento other = (EstabelecimentoFormaPagamento) object;
        if ((this.codigoEstabelecimentoFormaPagamento == null && other.codigoEstabelecimentoFormaPagamento != null) || (this.codigoEstabelecimentoFormaPagamento != null && !this.codigoEstabelecimentoFormaPagamento.equals(other.codigoEstabelecimentoFormaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.EstabelecimentoFormaPagamento[codigoEstabelecimentoFormaPagamento=" + codigoEstabelecimentoFormaPagamento + "]";
    }

}
