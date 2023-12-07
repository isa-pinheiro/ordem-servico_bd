package com.ordem_servico.model;

public class Endereco extends GenericModel {
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private Integer idCidade;


    public Endereco (String rua, String bairro, String cep, Integer idCidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.idCidade = idCidade;
    }

    public Endereco (String rua, String numero, String bairro, String cep, Integer idCidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.idCidade = idCidade;
    }

    public Endereco (Integer id, String rua, String numero, String bairro, String cep, Integer idCidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.idCidade = idCidade;
        super.setId(id);
    }

    public String getRua () {
        return rua;
    }

    public void setRua (String rua) {
        this.rua = rua;
    }

    public String getNumero () {
        return numero;
    }

    public void setNumero (String numero) {
        this.numero = numero;
    }

    public String getBairro () {
        return bairro;
    }

    public void setBairro (String bairro) {
        this.bairro = bairro;
    }

    public String getCep () {
        return cep;
    }

    public void setCep (String cep) {
        this.cep = cep;
    }

    public Integer getIdCidade () {
        return idCidade;
    }

    public void setIdCidade (Integer idCidade) {
        this.idCidade = idCidade;
    }

    @Override
    public String toString() {
        return "Endereco {" +
                "id=" + getId() +
                "rua=" + rua + '\'' +
                "numero=" + numero + '\'' +
                "bairro=" + bairro +
                "cep=" + cep + '\'' +
                "idCidade=" + idCidade +
                '}';
    }
}
