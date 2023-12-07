package com.ordem_servico.util;

import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.EmpresaDAO;
import com.ordem_servico.model.Empresa;


public class EmpresaTeste {

    static EmpresaDAO empresadao = new EmpresaDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = empresadao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        Empresa empresa = new Empresa("nomefantasia", "cnpj", "slogan", 1);
        empresadao.insertEmpresa(empresa);

        //buscar por ID
        System.out.println("Busca id");
        empresa = empresadao.selectEmpresa(1);
        System.out.println(empresadao.selectEmpresa(1));

        //update
        System.out.println("update");
        empresa.setNomeFantasia("rua1");
        empresa.setCnpj("numero1");
        empresa.setSlogan("bairro1");
        empresa.setIdEndereco(1);
        empresadao.updateEmpresa(empresa);
        empresa = empresadao.selectEmpresa(1);
        System.out.println(empresa);

        //select all
        System.out.println("select all");
        List<Empresa> empresas = empresadao.selectAllEmpresas();
        empresas.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // empresadao.deleteEmpresa(1);
        // empresadao.selectAllEmpresas().forEach(System.out::println);
    }
}
