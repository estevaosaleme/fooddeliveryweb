/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fdw.negocio.processo;

import br.com.fdw.negocio.entidades.Cliente;
import br.com.fdw.persistencia.dao.ClienteDAO;
import java.util.List;

/**
 *
 * @author Paulo Daniel
 */
public class ClienteProcess {

    private ClienteDAO dao;

    public ClienteProcess() {
        this.dao = new ClienteDAO();
    }

    public List<Cliente> getAll() {
        return this.dao.getAll();
    }

    public Cliente setCliente(Cliente cliente) {
        Cliente clienteNumeroCpf = getByNumeroCpf(cliente.getNumeroCpf());
        if (clienteNumeroCpf == null) {
            return this.dao.save(cliente);
        } else {
            throw new RuntimeException("Já existe um cliente cadastrado com o CPF: "+ cliente.getNumeroCpf());
        }
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteNumeroCpf = getByNumeroCpf(cliente.getNumeroCpf());
        if (clienteNumeroCpf != null && cliente.getCodigoCliente() == clienteNumeroCpf.getCodigoCliente()) {
            return this.dao.save(cliente);
        } else {
            if (clienteNumeroCpf != null && (!cliente.equals(clienteNumeroCpf) && clienteNumeroCpf.getCodigoCliente() > 0)) {
                throw new RuntimeException("O número do cpf não pode ser alterado pois já existe outro cpf com este número.");
            } else {
                return this.dao.save(cliente);
            }
        }
    }

    public Cliente getCliente(int codigoCliente) {
        return this.dao.get(codigoCliente);
    }

    public boolean removeCliente(int codigoCliente) {
        return this.dao.remove(codigoCliente);
    }

    public Cliente getByNumeroCpf(String numeroCpf) {
        return this.dao.getByNumeroCpf(numeroCpf);
    }


}
