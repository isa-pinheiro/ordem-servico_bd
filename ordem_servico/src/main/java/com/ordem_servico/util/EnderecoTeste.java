package com.ordem_servico.util;

import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.EnderecoDAO;
import com.ordem_servico.model.Endereco;


public class EnderecoTeste {

    static EnderecoDAO enderecodao = new EnderecoDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = enderecodao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        Endereco endereco = new Endereco("rua", "numero", "bairro", "cep", 1);
        enderecodao.insertEndereco(endereco);

        //buscar por ID
        System.out.println("Busca id");
        endereco = enderecodao.selectEndereco(1);
        System.out.println(enderecodao.selectEndereco(1));

        //update
        System.out.println("update");
        endereco.setRua("rua1");
        endereco.setNumero("numero1");
        endereco.setBairro("bairro1");
        endereco.setCep("cep1");
        endereco.setIdCidade(1);
        enderecodao.updateEndereco(endereco);
        endereco = enderecodao.selectEndereco(1);
        System.out.println(endereco);

        //select all
        System.out.println("select all");
        List<Endereco> enderecos = enderecodao.selectAllEnderecos();
        enderecos.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // enderecodao.deleteEndereco(1);
        // enderecodao.selectAllEnderecos().forEach(System.out::println);
    }
}
