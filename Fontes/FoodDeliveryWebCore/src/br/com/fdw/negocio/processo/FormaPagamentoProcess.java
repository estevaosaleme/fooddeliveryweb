package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.FormaPagamento;
import br.com.fdw.persistencia.dao.FormaPagamentoDAO;
import java.util.List;

public class FormaPagamentoProcess {

    private FormaPagamentoDAO dao;

    public FormaPagamentoProcess() {
        this.dao = new FormaPagamentoDAO();
    }

    public List<FormaPagamento> getAll() {
        return this.dao.getAll();
    }

    public FormaPagamento getByCodigoCardapio(int codigoFormaPagamento) {
        return this.dao.get(codigoFormaPagamento);
    }

    public FormaPagamento getByNomeFormaPagamento(String nomeFormaPagamento) {
        return this.dao.getByNomeFormaPagamento(nomeFormaPagamento);
    }

     public FormaPagamento setFormaPagamento(FormaPagamento formaPagamento) {
         FormaPagamento formaPagamentoNome = getByNomeFormaPagamento(formaPagamento.getNomeTipoPagamento());
        
        // nao permite inclui outra forma de pagamento com mesmo nome
        if (formaPagamentoNome == null){
            return this.dao.save(formaPagamento);
        }
        else{
            throw new RuntimeException("Já existe ao menos um cardapio cadastrado com este nome: "+ formaPagamento.getNomeTipoPagamento());
        }
    }

    public FormaPagamento updateFormaPagamento(FormaPagamento formaPagamento) {
        FormaPagamento nomeFormaPagamento = getByNomeFormaPagamento(formaPagamento.getNomeTipoPagamento());
        // se a busca pelo cardapío de nome nao retornou, pode alterar esse.
        if (nomeFormaPagamento == null) {
            return this.dao.save(formaPagamento);
        }
        // caso a busca retorne um que nao é o mesmo, não pode alterar
        else{
            throw new RuntimeException("A forma de pagamento não pode ser inserida pois já existe outra forma de pagamento com este nome.");
        }
    }

    public boolean removeFormaPagamento(int codigoFormaPagamento){
        return this.dao.remove(codigoFormaPagamento);
    }

}
