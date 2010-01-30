package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cardapio;
import br.com.fdw.negocio.processo.CardapioProcess;
import java.util.List;

public class ManterCardapio {

    private CardapioProcess cardapioProcess;

    public ManterCardapio() {
        this.cardapioProcess = new CardapioProcess();
    }

    public List<Cardapio> listarCardapios(){
        return this.cardapioProcess.getAll();
    }

    public Cardapio listarCardapio(int codigoCardapio){
        return this.cardapioProcess.getByCodigoCardapio(codigoCardapio);
    }

    public Cardapio pesquisarCardapio(String nomeCardapio){
        return this.cardapioProcess.getByNomeCardapio(nomeCardapio);
    }

    public Cardapio incluirCardapio(Cardapio cardapio){
        return this.cardapioProcess.setCardapio(cardapio);
    }

    public Cardapio alterarCardapio(Cardapio cardapio){
        return this.cardapioProcess.updateCardapio(cardapio);
    }

    public boolean excluirCardapio(Cardapio cardapio){
        return this.cardapioProcess.removeCardapio(cardapio);
    }
}
