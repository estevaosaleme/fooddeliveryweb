
package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.negocio.processo.PratoProcess;
import java.util.List;

public class ManterPrato {

    private PratoProcess pratoProcess;

    public ManterPrato(){
        this.pratoProcess = new PratoProcess();
    }

    public List<Prato> listarPratos(){
        return this.pratoProcess.getAll();
    }

    public Prato consultarPrato(int codigoPrato){
        return this.pratoProcess.getPrato(codigoPrato);
    }

    public Prato pesquisarPrato(String nomePrato, int codigoCardapio) {
        return this.pratoProcess.getByNomeECardapio(nomePrato, codigoCardapio);
    }

    public Prato incluirPrato(Prato prato){
        return this.pratoProcess.setPrato(prato);
    }

    public Prato atualizarPrato(Prato prato){
        return this.pratoProcess.updatePrato(prato);
    }

    public boolean excluirPrato(int codigoPrato){
        return this.pratoProcess.removePrato(codigoPrato);
    }

    public List<Prato> listarByCodigoCardapio(int codigoCardapio){
        return this.pratoProcess.listarByCodigoCadapio(codigoCardapio);
    }
}
