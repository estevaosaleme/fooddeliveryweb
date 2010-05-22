
package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.persistencia.dao.PratoDAO;
import java.util.List;

public class PratoProcess {
    
    private PratoDAO dao;

    public PratoProcess(){
        this.dao = new PratoDAO();
    }

    public List<Prato> getAll() {
        return this.dao.getAll();
    }

    public Prato setPrato(Prato prato){
        Prato pratoNomeCardapioPrato = getByNomeECardapio(prato.getNomePrato(),
                prato.getCardapio().getCodigoCardapio());
        // So permite incluir se nao exite outro prato com mesmo nome no mesmo cardapio
        if (pratoNomeCardapioPrato == null)
        {
            return this.dao.save(prato);
        }
        else
        {
            throw new RuntimeException("Já existe um prato cadastrado com o " +
                    "mesmo nome ("+ prato.getNomePrato()+") no mesmo cadápio " +
                    "("+ prato.getCardapio().getNomeCardapio()+").");
        }
    }

    public Prato updatePrato(Prato prato){
        Prato pratoNomeCardapio = getByNomeECardapio(prato.getNomePrato(),
                prato.getCardapio().getCodigoCardapio());

        // Se não tem um prato com o mesmo nome e cardapio, pode salvar.
        if (pratoNomeCardapio == null){
            return this.dao.save(prato);
        }
        // se já tem, mas o código é o mesmo, tambem pode salvar.
        else if (pratoNomeCardapio.getCodigoPrato().equals(prato.getCodigoPrato())){
            return this.dao.save(prato);
        }
        // se já tem um outro prato com o mesmo nome no mesmo cardapio, não pode salvar
        else {
            throw new RuntimeException("O prato não pode ser alterado, pois já" +
                    " existe um prato com esse nome nesse mesmo cardápio.");
        }
    }

    public Prato getPrato(int codigoPrato){
        return this.dao.get(codigoPrato);
    }

    public boolean removePrato(int codigoPrato){
        return this.dao.remove(codigoPrato);
    }

    public Prato getByNomeECardapio(String nomePrato, int codigoCardapio){
        return this.dao.getByNomeECardapio(nomePrato, codigoCardapio);
    }

    public List<Prato> listarByCodigoCadapio(int codigoCardapio) {
        return this.dao.listarByCodigoCardapio(codigoCardapio);
    }

    public List<Prato> listByRandom(int limite) {
        return this.dao.listByRandom(limite);
    }
}
