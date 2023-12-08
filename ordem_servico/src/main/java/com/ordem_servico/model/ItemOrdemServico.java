package com.ordem_servico.model;

public class ItemOrdemServico extends GenericModel {
    private String descricao;
    private long preco;
    private Integer idOrdemServico;

    public ItemOrdemServico (String descricao, long preco, Integer idOrdemServico) {
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
    }

    public ItemOrdemServico (Integer id, String descricao, long preco, Integer idOrdemServico) {
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
        super.setId(id);
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    public long getPreco () {
        return preco;
    }

    public void setPreco (Long preco) {
        this.preco = preco;
    }

    public Integer getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    @Override
    public String toString() {
        return "ItemOrdemServico{" +
                "id=" + getId() +
                "descricao=" + descricao + '\'' +
                "preco=" + preco + '\'' +
                "idOrdemServico=" + idOrdemServico +
                '}';
    }


}
