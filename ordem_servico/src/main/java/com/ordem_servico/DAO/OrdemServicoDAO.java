package com.ordem_servico.DAO;

import com.ordem_servico.model.OrdemServico;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO extends ConexaoDB {

    private static final String INSERT_ORDEMSERVICO_SQL = "INSERT INTO ordem_servico (observacao, dt_abertura, dt_saida, username_responsavel, id_cliente, id_empresa) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ORDEMSERVICO_BY_ID = "SELECT id, observacao, dt_abertura, dt_saida, username_responsavel, id_cliente, id_empresa FROM ordem_servico WHERE id = ?";
    private static final String SELECT_ALL_ORDEMSERVICO = "SELECT * FROM ordem_servico;";
    private static final String DELETE_ORDEMSERVICO_SQL = "DELETE FROM ordem_servico WHERE id = ?;";
    private static final String UPDATE_ORDEMSERVICO_SQL = "UPDATE ordem_servico SET observacao = ?, dt_abertura = ?, dt_saida = ?, username_responsavel = ?, id_cliente = ?, id_empresa = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM ordem_servico;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertOrdemServico(OrdemServico entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ORDEMSERVICO_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setTimestamp(2, entidade.getDtAbertura());
            preparedStatement.setTimestamp(3, entidade.getDtSaida());
            preparedStatement.setString(4, entidade.getUsernameResponsavel());
            preparedStatement.setInt(5, entidade.getIdCliente());
            preparedStatement.setInt(6, entidade.getIdEmpresa());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdemServico selectOrdemServico(int id) {
        OrdemServico entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ORDEMSERVICO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Timestamp dtAbertura = rs.getTimestamp("dt_abertura");
                Timestamp dtSaida = rs.getTimestamp("dt_saida");
                String usernameResponsavel = rs.getString("username_responsavel");
                Integer idCliente = rs.getInt("id_cliente");
                Integer idEmpresa = rs.getInt("id_empresa");
                
                entidade = new OrdemServico(id, observacao, dtAbertura, dtSaida, usernameResponsavel, idCliente, idEmpresa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<OrdemServico> selectAllOrdemServicos() {
        List<OrdemServico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ORDEMSERVICO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Timestamp dtAbertura = rs.getTimestamp("dt_abertura");
                Timestamp dtSaida = rs.getTimestamp("dt_saida");
                String usernameResponsavel = rs.getString("username_responsavel");
                Integer idCliente = rs.getInt("id_cliente");
                Integer idEmpresa = rs.getInt("id_empresa");
                entidades.add(new OrdemServico(id, observacao, dtAbertura, dtSaida, usernameResponsavel, idCliente, idEmpresa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteOrdemServico(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ORDEMSERVICO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateOrdemServico(OrdemServico entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ORDEMSERVICO_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setTimestamp(2, entidade.getDtAbertura());
            statement.setTimestamp(3, entidade.getDtSaida());
            statement.setString(4, entidade.getUsernameResponsavel());
            statement.setInt(5, entidade.getIdCliente());
            statement.setInt(6, entidade.getIdEmpresa());
            statement.setInt(7, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
