package com.ordem_servico.DAO;

import com.ordem_servico.model.ItemOrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOrdemServicoDAO extends ConexaoDB {

    private static final String INSERT_ITEMORDEMSERVICO_SQL = "INSERT INTO item_ordem_servico (descricao, preco, id_ordem_servico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ITEMORDEMSERVICO_BY_ID = "SELECT id, descricao, preco, id_ordem_servico FROM item_ordem_servico WHERE id = ?";
    private static final String SELECT_ALL_ITEMORDEMSERVICO = "SELECT * FROM item_ordem_servico;";
    private static final String DELETE_ITEMORDEMSERVICO_SQL = "DELETE FROM item_ordem_servico WHERE id = ?;";
    private static final String UPDATE_ITEMORDEMSERVICO_SQL = "UPDATE item_ordem_servico SET descricao = ?, preco = ?, id_ordem_servico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM item_ordem_servico;";

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

    public void insertItemOrdemServico(ItemOrdemServico entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ITEMORDEMSERVICO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setLong(2, entidade.getPreco());
            preparedStatement.setInt(3, entidade.getIdOrdemServico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemOrdemServico selectItemOrdemServico(int id) {
        ItemOrdemServico entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ITEMORDEMSERVICO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Long preco = rs.getLong("preco");
                Integer idOrdemServico = rs.getInt("id_ordem_servico");
                
                entidade = new ItemOrdemServico(id, descricao, preco, idOrdemServico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ItemOrdemServico> selectAllItemOrdemServicos() {
        List<ItemOrdemServico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ITEMORDEMSERVICO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Long preco = rs.getLong("preco");
                Integer idOrdemServico = rs.getInt("id_ordem_servico");
                entidades.add(new ItemOrdemServico(id, descricao, preco, idOrdemServico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteItemOrdemServico(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ITEMORDEMSERVICO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateItemOrdemServico(ItemOrdemServico entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ITEMORDEMSERVICO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setLong(2, entidade.getPreco());
            statement.setInt(3, entidade.getIdOrdemServico());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
