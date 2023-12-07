package com.ordem_servico.util;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.ClienteDAO;
import com.ordem_servico.model.Cliente;


public class ClienteTeste {

    static ClienteDAO clientedao = new ClienteDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = clientedao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        Cliente cliente = new Cliente("nome", Date.valueOf("2000-01-01"), "cpf", "email", 1);
        clientedao.insertCliente(cliente);

        //buscar por ID
        System.out.println("Busca id");
        cliente = clientedao.selectCliente(1);
        System.out.println(clientedao.selectCliente(1));

        //update
        System.out.println("update");
        cliente.setNome("nome1");
        cliente.setDtNascimento(Date.valueOf("2001-01-01"));
        cliente.setCpf("cep1");
        cliente.setEmail("email1");
        cliente.setIdEndereco(1);
        clientedao.updateCliente(cliente);
        cliente = clientedao.selectCliente(1);
        System.out.println(cliente);

        //select all
        System.out.println("select all");
        List<Cliente> clientes = clientedao.selectAllClientes();
        clientes.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // clientedao.deleteCliente(1);
        // clientedao.selectAllClientes().forEach(System.out::println);
    }
}
