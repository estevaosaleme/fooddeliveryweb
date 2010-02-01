/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.fachada;

import br.com.fdw.negocio.entidades.Cliente;
import br.com.fdw.negocio.processo.ClienteProcess;
import java.util.List;

/**
 *
 * @author Paulo Daniel
 */
public class ManterCliente {

    private ClienteProcess clienteProcess;

    public ManterCliente() {
        this.clienteProcess = new ClienteProcess();
    }

    public List<Cliente> listarClientes() {
        return this.clienteProcess.getAll();
    }

    public Cliente listarCliente(int codigoCliente) {
        return this.clienteProcess.getCliente(codigoCliente);
    }

    public Cliente incluirCliente(Cliente cliente) {
        return this.clienteProcess.setCliente(cliente);
    }

    public Cliente alterarCliente(Cliente cliente) {
        return this.clienteProcess.updateCliente(cliente);
    }

    public boolean excluirCliente(int codigoCliente) {
        return this.clienteProcess.removeCliente(codigoCliente);
    }
}
