package com.ordem_servico.model;

import java.sql.Timestamp;

public class OrdemServico extends GenericModel {
    private String observacao;
    private Timestamp dtAbertura;
    private Timestamp dtSaida;
    private String usernameResponsavel;
    private Integer idCliente;
    private Integer idEmpresa;

    public OrdemServico (Timestamp dtAbertura, String usernameResponsavel, Integer idCliente, Integer idEmpresa) {
        this.dtAbertura = dtAbertura;
        this.usernameResponsavel = usernameResponsavel;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico (String observacao, Timestamp dtAbertura, String usernameResponsavel, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.dtAbertura = dtAbertura;
        this.usernameResponsavel = usernameResponsavel;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico (Timestamp dtAbertura, Timestamp dtSaida, String usernameResponsavel, Integer idCliente, Integer idEmpresa) {
        this.dtAbertura = dtAbertura;
        this.dtSaida = dtSaida;
        this.usernameResponsavel = usernameResponsavel;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico (String observacao, Timestamp dtAbertura, Timestamp dtSaida, String usernameResponsavel, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.dtAbertura = dtAbertura;
        this.dtSaida = dtSaida;
        this.usernameResponsavel = usernameResponsavel;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico (Integer id, String observacao, Timestamp dtAbertura, Timestamp dtSaida, String usernameResponsavel, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.dtAbertura = dtAbertura;
        this.dtSaida = dtSaida;
        this.usernameResponsavel = usernameResponsavel;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Timestamp dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Timestamp getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Timestamp dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getUsernameResponsavel() {
        return usernameResponsavel;
    }

    public void setUsernameResponsavel(String usernameResponsavel) {
        this.usernameResponsavel = usernameResponsavel;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "id=" + getId() +
                "observacao=" + observacao + '\'' +
                "dtAbertura=" + dtAbertura + '\'' +
                "dtSaida=" + dtSaida + '\'' +
                "usernameResponsavel=" + usernameResponsavel + '\'' +
                "idCliente=" + idCliente + '\'' +
                "idEmpresa=" + idEmpresa + 
                '}';
    }


}
