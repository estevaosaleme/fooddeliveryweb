
package br.com.fdw.negocio.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "prato")
@NamedQueries(
{
    @NamedQuery(name = "Prato.findAll", query = "SELECT p FROM Prato p"),
    @NamedQuery(name = "Prato.findByCodigo", query = "SELECT p FROM Prato p WHERE p.codigoPrato = :codigoPrato"),
    @NamedQuery(name = "Prato.findByNomeECardapio", query = "SELECT p FROM Prato p WHERE p.nomePrato = :nomePrato AND p.cardapio.codigoCardapio = :codigoCardapio")

}
)
public class Prato extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRAT_CD_PRATO")
    private Integer codigoPrato;
    @Basic(optional = false)
    @Column(name = "PRAT_NM_PRATO")
    private String nomePrato;
    @Basic(optional = false)
    @Lob
    @Column(name = "PRAT_DS_PRATO")
    private String descricaoPrato;
    @Lob
    @Column(name = "PRAT_MM_FOTO")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "PRAT_MD_TAMANHO")
    private String tamanho;
    @Basic(optional = false)
    @Column(name = "PRAT_VL_UNITARIO")
    private double valorUnitario;
    @JoinColumn(name = "CARD_CD_CARDAPIO", referencedColumnName = "CARD_CD_CARDAPIO")
    @ManyToOne(optional = false)
    private Cardapio cardapio;

    public Prato() {
    }

    public Prato(Integer codigoPrato) {
        this.codigoPrato = codigoPrato;
    }

    public Prato(Integer codigoPrato, String nomePrato, String descricaoPrato, String tamanho, double valorUnitario) {
        this.codigoPrato = codigoPrato;
        this.nomePrato = nomePrato;
        this.descricaoPrato = descricaoPrato;
        this.tamanho = tamanho;
        this.valorUnitario = valorUnitario;
    }

    public Integer getCodigoPrato() {
        return codigoPrato;
    }

    public void setCodigoPrato(Integer codigoPrato) {
        this.codigoPrato = codigoPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPrato != null ? codigoPrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prato)) {
            return false;
        }
        Prato other = (Prato) object;
        if ((this.codigoPrato == null && other.codigoPrato != null) || (this.codigoPrato != null && !this.codigoPrato.equals(other.codigoPrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Prato[codigoPrato=" + codigoPrato + "]";
    }

}
