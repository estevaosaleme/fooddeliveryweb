/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Estabelecimento;
import br.com.fdw.persistencia.dao.EstabelecimentoDAO;
import java.util.List;

/**
 *
 * @author Paulo Daniel
 */
public class EstabelecimentoProcess {

    private EstabelecimentoDAO dao;

    public EstabelecimentoProcess() {
        this.dao = new EstabelecimentoDAO();
    }

    public List<Estabelecimento> getAll() {
        return this.dao.getAll();
    }

    public Estabelecimento setEstabelecimento(Estabelecimento estabelecimento) {
        Estabelecimento estabelecimentoNumeroCnpj = getByNumeroCnpj(estabelecimento.getNumeroCnpj());
        if (estabelecimentoNumeroCnpj == null) {
            return this.dao.save(estabelecimento);
        } else {
            throw new RuntimeException("Já existe um estabelecimento cadastrado com o CNPJ: "+ estabelecimento.getNumeroCnpj());
        }
    }

    public Estabelecimento updateEstabelecimento(Estabelecimento estabelecimento) {
        Estabelecimento estabelecimentoNumeroCnpj = getByNumeroCnpj(estabelecimento.getNumeroCnpj());
        if (estabelecimentoNumeroCnpj != null && estabelecimento.getCodigoEstabelecimento() == estabelecimentoNumeroCnpj.getCodigoEstabelecimento()) {
            return this.dao.save(estabelecimento);
        } else {
            if (estabelecimentoNumeroCnpj != null && (!estabelecimento.equals(estabelecimentoNumeroCnpj) && estabelecimentoNumeroCnpj.getCodigoEstabelecimento() > 0)) {
                throw new RuntimeException("O número do cnpj não pode ser alterado pois já existe outro cnpj com este número.");
            } else {
                return this.dao.save(estabelecimento);
            }
        }
    }

    public Estabelecimento getEstabelecimento(int codigoEstabelecimento) {
        return this.dao.get(codigoEstabelecimento);
    }

    public boolean removeEstabelecimento(int codigoEstabelecimento) {
        return this.dao.remove(codigoEstabelecimento);
    }

    private Estabelecimento getByNumeroCnpj(String numeroCnpj) {
        return this.dao.getByNumeroCnpj(numeroCnpj);
    }
}
