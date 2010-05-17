/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.portal;

import br.com.fdw.negocio.entidades.Prato;

/**
 *
 * @author pedro
 */
public class pratoQuantidade {

    private Prato prato;
    private int quantidade;


    public pratoQuantidade(Prato prato, int quantidade)
    {
        setPrato(prato);
        setQuantidade(quantidade);
    }

    public pratoQuantidade()
    {
    }
    /**
     * @return the prato
     */
    public Prato getPrato() {
        return prato;
    }

    /**
     * @param prato the prato to set
     */
    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomePrato(){
        return this.prato.getNomePrato();
    }

    public int getCodigoPrato(){
        return this.prato.getCodigoPrato();
    }
}
