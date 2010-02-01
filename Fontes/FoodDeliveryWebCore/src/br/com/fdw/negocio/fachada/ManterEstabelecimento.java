/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Estabelecimento;
import br.com.fdw.negocio.processo.EstabelecimentoProcess;
import java.util.List;

/**
 *
 * @author Paulo Daniel
 */
public class ManterEstabelecimento {

    private EstabelecimentoProcess estabelecimentoProcess;

    public ManterEstabelecimento() {
        this.estabelecimentoProcess = new EstabelecimentoProcess();
    }

    public List<Estabelecimento> listarEstabelecimentos() {
        return this.estabelecimentoProcess.getAll();
    }

    public Estabelecimento listarEstabelecimento(int codigoEstabelecimento) {
        return this.estabelecimentoProcess.getEstabelecimento(codigoEstabelecimento);
    }

    public Estabelecimento incluirEstabelecimento(Estabelecimento estabelecimento) {
        return this.estabelecimentoProcess.setEstabelecimento(estabelecimento);
    }

    public Estabelecimento alterarEstabelecimento(Estabelecimento estabelecimento) {
        return this.estabelecimentoProcess.updateEstabelecimento(estabelecimento);
    }

    public boolean excluirEstabelecimento(int codigoEstabelecimento) {
        return this.estabelecimentoProcess.removeEstabelecimento(codigoEstabelecimento);
    }
}
