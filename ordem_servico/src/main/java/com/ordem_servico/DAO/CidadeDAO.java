package com.ordem_servico.DAO;

import com.ordem_servico.model.Cidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends ConexaoDB {

    private static final String INSERT_CIDADE_SQL = "INSERT INTO cidade (descricao, codigo, id_uf) VALUES (?, ?, ?);";
    private static final String SELECT_CIDADE_BY_ID = "SELECT id, descricao, codigo, id_uf FROM cidade WHERE id = ?";
    private static final String SELECT_ALL_CIDADE = "SELECT * FROM cidade;";
    private static final String DELETE_CIDADE_SQL = "DELETE FROM cidade WHERE id = ?;";
    private static final String UPDATE_CIDADE_SQL = "UPDATE cidade SET descricao = ?, codigo = ?, id_uf = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cidade;";

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

    public void insertCidade(Cidade entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CIDADE_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getCodigo());
            preparedStatement.setInt(3, entidade.getIdUf());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cidade selectCidade(int id) {
        Cidade entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CIDADE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                Integer idUf = rs.getInt("id_uf");
                entidade = new Cidade(id, descricao, codigo, idUf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cidade> selectAllCidades() {
        List<Cidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CIDADE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                Integer idUf = rs.getInt("id_uf");
                entidades.add(new Cidade(id, descricao, codigo, idUf));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CIDADE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCidade(Cidade entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CIDADE_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getCodigo());
            statement.setInt(3, entidade.getIdUf());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
