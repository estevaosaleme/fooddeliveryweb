package br.com.fdw.mbean;

import br.com.fdw.negocio.entidades.Cep;
import br.com.fdw.negocio.fachada.ManterCep;
import java.util.List;

public class CepBean {
    private Cep cep;
    private ManterCep manterCep;

    public CepBean() {
        this.cep = new Cep();
        this.manterCep = new ManterCep();
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep categoria) {
        this.cep = categoria;
    }

    public List<Cep> getListarCeps() {
        return this.manterCep.listarCeps();
    }
}
