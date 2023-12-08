package com.ordem_servico.util;

import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.CidadeDAO;
import com.ordem_servico.model.Cidade;


public class CidadeTeste {

    static CidadeDAO cidadedao = new CidadeDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = cidadedao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        Cidade cidade = new Cidade("descricao", 1, 1);
        cidadedao.insertCidade(cidade);

        //buscar por ID
        System.out.println("Busca id");
        cidade = cidadedao.selectCidade(1);
        System.out.println(cidadedao.selectCidade(1));

        //update
        System.out.println("update");
        cidade.setDescricao("descricao1");
        cidade.setCodigo(2);
        cidade.setIdUf(1);
        System.out.println(cidade);
        cidadedao.updateCidade(cidade);
        cidade = cidadedao.selectCidade(1);
        System.out.println(cidade);

        //select all
        System.out.println("select all");
        List<Cidade> cidades = cidadedao.selectAllCidades();
        cidades.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // cidadedao.deleteCidade(1);
        // cidadedao.selectAllCidades().forEach(System.out::println);
    }
}
