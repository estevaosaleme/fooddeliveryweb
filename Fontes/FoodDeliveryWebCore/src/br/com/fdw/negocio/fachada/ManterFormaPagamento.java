package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.FormaPagamento;
import br.com.fdw.negocio.processo.FormaPagamentoProcess;
import java.util.List;

public class ManterFormaPagamento {

    private FormaPagamentoProcess formaPagamentoProcess;

    public ManterFormaPagamento() {
        this.formaPagamentoProcess = new FormaPagamentoProcess();
    }

    public List<FormaPagamento> ListarFormasPagamento() {
        return this.formaPagamentoProcess.getAll();
    }

    public FormaPagamento listarFormaPagamento(int codigoFormaPagamento){
        return this.formaPagamentoProcess.getByCodigoCardapio(codigoFormaPagamento);
    }

    public FormaPagamento pesquisarFormaPagamento(String nomeFormaPagamento){
        return this.formaPagamentoProcess.getByNomeFormaPagamento(nomeFormaPagamento);
    }

    public FormaPagamento incluirFormaPagamento(FormaPagamento formaPagamento){
        return this.formaPagamentoProcess.setFormaPagamento(formaPagamento);
    }

    public FormaPagamento alterarFormaPagamento(FormaPagamento formaPagamento){
        return this.formaPagamentoProcess.updateFormaPagamento(formaPagamento);
    }

    public boolean excluirFormaPagamento(int codigoFormaPagamento){
        return this.formaPagamentoProcess.removeFormaPagamento(codigoFormaPagamento);
    }
     
}
