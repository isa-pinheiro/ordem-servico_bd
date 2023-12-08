package com.ordem_servico.util;

import java.sql.SQLException;
import java.util.List;

import com.ordem_servico.DAO.ItemOrdemServicoDAO;
import com.ordem_servico.model.ItemOrdemServico;


public class ItemOrdemServicoTeste {

    static ItemOrdemServicoDAO itemordemservicodao = new ItemOrdemServicoDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("count");
        int c = itemordemservicodao.count();
        System.out.println(c);

        //salvar
        System.out.println("Salvar");
        ItemOrdemServico itemordemservico = new ItemOrdemServico("descricao", 2l, 1);
        itemordemservicodao.insertItemOrdemServico(itemordemservico);

        //buscar por ID
        System.out.println("Busca id");
        itemordemservico = itemordemservicodao.selectItemOrdemServico(1);
        System.out.println(itemordemservicodao.selectItemOrdemServico(1));

        //update
        System.out.println("update");
        itemordemservico.setDescricao("descricao1");
        itemordemservico.setPreco(3l);
        itemordemservico.setIdOrdemServico(1);
        itemordemservicodao.updateItemOrdemServico(itemordemservico);
        itemordemservico = itemordemservicodao.selectItemOrdemServico(1);
        System.out.println(itemordemservico);

        //select all
        System.out.println("select all");
        List<ItemOrdemServico> itemordemservicos = itemordemservicodao.selectAllItemOrdemServicos();
        itemordemservicos.forEach(System.out::println);

        //delete
        // System.out.println("delete");
        // itemordemservicodao.deleteItemOrdemServico(1);
        // itemordemservicodao.selectAllItemOrdemServicos().forEach(System.out::println);
    }
}
