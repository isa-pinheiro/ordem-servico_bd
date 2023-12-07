package com.ordem_servico.model;

public class Uf extends GenericModel {
    private String descricao;
    private Integer codigo;

    public Uf (String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public Uf (Integer id, String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
        super.setId(id);
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo () {
        return codigo;
    }

    public void setCodigo (Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Uf {" +
                "id=" + getId() +
                "descricao=" + descricao + '\'' +
                "codigo=" + codigo + 
                '}';
    }
}
