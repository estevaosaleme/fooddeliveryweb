
package br.com.fdw.negocio.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cardapio")
@NamedQueries(
{
    @NamedQuery(name = "Cardapio.findAll", query = "SELECT c FROM Cardapio c"),
    @NamedQuery(name = "Cardapio.findByCodigo", query = "SELECT c FROM Cardapio c WHERE c.codigoCardapio = :codigoCardapio"),
    @NamedQuery(name = "Cardapio.findByNomeCardapio", query = "SELECT c FROM Cardapio c WHERE c.nomeCardapio = :nomeCardapio"),
    @NamedQuery(name = "Cardapio.listByCodigoEstabelecimento", query = "SELECT c FROM Cardapio c WHERE c.estabelecimento.codigoEstabelecimento = :codigoEstabelecimento")
})
public class Cardapio extends PersistentObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CARD_CD_CARDAPIO")
    private Integer codigoCardapio;
    @Basic(optional = false)
    @Column(name = "CARD_NM_CARDAPIO")
    private String nomeCardapio;
    @JoinColumn(name = "ESTA_CD_ESTABELECIMENTO", referencedColumnName = "ESTA_CD_ESTABELECIMENTO")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;
//    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapio")
    private Collection<Prato> pratoCollection;

    public Cardapio() {
    }

    public Cardapio(Integer codigoCardapio) {
        this.codigoCardapio = codigoCardapio;
    }

    public Cardapio(Integer codigoCardapio, String nomeCardapio) {
        this.codigoCardapio = codigoCardapio;
        this.nomeCardapio = nomeCardapio;
    }

    public Integer getCodigoCardapio() {
        return codigoCardapio;
    }

    public void setCodigoCardapio(Integer codigoCardapio) {
        this.codigoCardapio = codigoCardapio;
    }

    public String getNomeCardapio() {
        return nomeCardapio;
    }

    public void setNomeCardapio(String nomeCardapio) {
        this.nomeCardapio = nomeCardapio;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Collection<Prato> getPratoCollection() {
        return pratoCollection;
    }

    public void setPratoCollection(Collection<Prato> pratoCollection) {
        this.pratoCollection = pratoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCardapio != null ? codigoCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio other = (Cardapio) object;
        if ((this.codigoCardapio == null && other.codigoCardapio != null) || (this.codigoCardapio != null && !this.codigoCardapio.equals(other.codigoCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Cardapio[codigoCardapio=" + codigoCardapio + "]";
    }

}
