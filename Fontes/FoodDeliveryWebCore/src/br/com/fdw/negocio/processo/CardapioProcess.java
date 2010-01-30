package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Cardapio;
import br.com.fdw.persistencia.dao.CardapioDAO;
import java.util.List;

public class CardapioProcess {

    private CardapioDAO dao;

    public CardapioProcess(){
        this.dao = new CardapioDAO();
    }

    public List<Cardapio> getAll() {
        return this.dao.getAll();
    }

    public Cardapio getByCodigoCardapio(int codigoCardapio) {
        return this.dao.get(codigoCardapio);
    }

    public Cardapio getByNomeCardapio(String nomeCardapio) {
        return this.dao.getByNomeCardapio(nomeCardapio);
    }

    public Cardapio setCardapio(Cardapio cardapio) {
        Cardapio cardapioNome = getByNomeCardapio(cardapio.getNomeCardapio());
        // nao permite inclui outro cardapio com mesmo nome
        if (cardapioNome == null){
            return this.dao.save(cardapio);
        }
        else{
            throw new RuntimeException("Já existe ao menos um cardapio cadastrado com este nome: "+ cardapio.getNomeCardapio());
        }
    }

    public Cardapio updateCardapio(Cardapio cardapio) {
        Cardapio cardapioNome = getByNomeCardapio(cardapio.getNomeCardapio());
        // se a busca pelo cardapío de nome nao retornou, pode alterar esse.
        if (cardapioNome == null) {
            return this.dao.save(cardapio);
        }
        // se a busca retornou, mas é o mesmo (mesmo código), pode alterar tambem
        else if (cardapio.getCodigoCardapio().equals(cardapioNome.getCodigoCardapio())){
            return this.dao.save(cardapio);
        }
        // caso a busca retorne um que nao é o mesmo, não pode alterar
        else{
            throw new RuntimeException("O cardápio não pode ser alterado pois já existe outro cardapio com este nome.");
        }
    }

    public boolean removeCardapio(Cardapio cardapio) {
       if (cardapio.getPratoCollection() == null || cardapio.getPratoCollection().isEmpty())
       {
            return this.dao.removeObject(cardapio);
       }
       else
       {
           throw new RuntimeException("O Cardápio não pode ser excluido pois existem pratos cadastrados.");
       }
    }
}
