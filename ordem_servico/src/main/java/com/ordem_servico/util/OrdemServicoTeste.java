package com.ordem_servico.util;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.ordem_servico.DAO.OrdemServicoDAO;
import com.ordem_servico.model.OrdemServico;


public class OrdemServicoTeste {

    static OrdemServicoDAO ordemservicodao = new OrdemServicoDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = ordemservicodao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        OrdemServico ordemservico = new OrdemServico("observacao", Timestamp.valueOf(LocalDateTime.of(2000, 01, 01, 01, 01, 01)), Timestamp.valueOf(LocalDateTime.of(2000, 02, 01, 01, 01, 01)), "usernameresponsavel", 1, 1);
        ordemservicodao.insertOrdemServico(ordemservico);

        //buscar por ID
        System.out.println("Busca id");
        ordemservico = ordemservicodao.selectOrdemServico(1);
        System.out.println(ordemservicodao.selectOrdemServico(1));

        //update
        System.out.println("update");
        ordemservico.setObservacao("rua1");
        System.out.println(ordemservico);
        ordemservico.setDtAbertura(Timestamp.valueOf(LocalDateTime.of(2001, 01, 01, 01, 01, 01)));
        System.out.println(ordemservico);
        ordemservico.setDtSaida(Timestamp.valueOf(LocalDateTime.of(2001, 02, 01, 01, 01, 01)));
        ordemservico.setIdCliente(1);
        ordemservico.setIdEmpresa(1);
        System.out.println(ordemservico);
        ordemservicodao.updateOrdemServico(ordemservico);
        ordemservico = ordemservicodao.selectOrdemServico(1);
        System.out.println(ordemservico);

        //select all
        System.out.println("select all");
        List<OrdemServico> ordemservicos = ordemservicodao.selectAllOrdemServicos();
        ordemservicos.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // ordemservicodao.deleteOrdemServico(1);
        // ordemservicodao.selectAllOrdemServicos().forEach(System.out::println);
    }
}
