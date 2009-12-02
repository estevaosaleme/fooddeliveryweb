
package br.com.fdw.negocio.entidades;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Entity
@Table(name = "funcionamento")
@NamedQueries({@NamedQuery(name = "Funcionamento.findAll", query = "SELECT f FROM Funcionamento f"), @NamedQuery(name = "Funcionamento.findByCodigo", query = "SELECT f FROM Funcionamento f WHERE f.codigoFuncionamento = :codigoFuncionamento")})
public class Funcionamento extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FUNC_CD_FUNCIONAMENTO")
    private Integer codigoFuncionamento;
    @Basic(optional = false)
    @Column(name = "FUNC_IN_DIA_SEMANA")
    private char diaSemana;
    @Basic(optional = false)
    @Column(name = "FUNC_HR_ABERTURA")
    @Temporal(TemporalType.TIME)
    private Date horaAbertura;
    @Basic(optional = false)
    @Column(name = "FUNC_HR_FECHAMENTO")
    @Temporal(TemporalType.TIME)
    private Date horaFechamento;
    @Basic(optional = false)
    @Column(name = "FUNC_VL_CUSTA_ENTREGA")
    private double valorCustoEntrega;
    @Basic(optional = false)
    @Column(name = "FUNC_MD_TEMPO_ENTREGA")
    @Temporal(TemporalType.TIME)
    private Date tempoEntrega;
    @JoinColumn(name = "ESTA_CD_ESTABELECIMENTO", referencedColumnName = "ESTA_CD_ESTABELECIMENTO")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;

    public Funcionamento() {
    }

    public Funcionamento(Integer codigoFuncionamento) {
        this.codigoFuncionamento = codigoFuncionamento;
    }

    public Funcionamento(Integer codigoFuncionamento, char diaSemana, Date horaAbertura, Date horaFechamento, double valorCustoEntrega, Date tempoEntrega) {
        this.codigoFuncionamento = codigoFuncionamento;
        this.diaSemana = diaSemana;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.valorCustoEntrega = valorCustoEntrega;
        this.tempoEntrega = tempoEntrega;
    }

    public Integer getCodigoFuncionamento() {
        return codigoFuncionamento;
    }

    public void setCodigoFuncionamento(Integer codigoFuncionamento) {
        this.codigoFuncionamento = codigoFuncionamento;
    }

    public char getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(char diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public double getValorCustoEntrega() {
        return valorCustoEntrega;
    }

    public void setValorCustoEntrega(double valorCustoEntrega) {
        this.valorCustoEntrega = valorCustoEntrega;
    }

    public Date getTempoEntrega() {
        return tempoEntrega;
    }

    public void setTempoEntrega(Date tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
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
        hash += (codigoFuncionamento != null ? codigoFuncionamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionamento)) {
            return false;
        }
        Funcionamento other = (Funcionamento) object;
        if ((this.codigoFuncionamento == null && other.codigoFuncionamento != null) || (this.codigoFuncionamento != null && !this.codigoFuncionamento.equals(other.codigoFuncionamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Funcionamento[codigoFuncionamento=" + codigoFuncionamento + "]";
    }

}
