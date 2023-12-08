package com.ordem_servico.util;

import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.UfDAO;
import com.ordem_servico.model.Uf;


public class UfTeste {

    static UfDAO ufdao = new UfDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = ufdao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        Uf uf = new Uf("descricao", 1);
        ufdao.insertUf(uf);

        //buscar por ID
        System.out.println("Busca id");
        uf = ufdao.selectUf(1);
        System.out.println(ufdao.selectUf(1));

        //update
        System.out.println("update");
        uf.setDescricao("rua1");
        uf.setCodigo(2);

        ufdao.updateUf(uf);
        uf = ufdao.selectUf(1);
        System.out.println(uf);

        //select all
        System.out.println("select all");
        List<Uf> ufs = ufdao.selectAllUfs();
        ufs.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // ufdao.deleteUf(1);
        // ufdao.selectAllUfs().forEach(System.out::println);
    }
}
