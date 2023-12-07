package com.ordem_servico.DAO;

import com.ordem_servico.model.Cliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexaoDB {

    private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (nome, dt_nascimento, cpf, email, id_endereco) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_CLIENTE_BY_ID = "SELECT id, nome, dt_nascimento, cpf, email, id_endereco FROM cliente WHERE id = ?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente;";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE cliente SET nome = ?, dt_nascimento = ?, cpf = ?, email = ?, id_endereco = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cliente;";

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

    public void insertCliente(Cliente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setDate(2, entidade.getDtNascimento());
            preparedStatement.setString(3, entidade.getCpf());
            preparedStatement.setString(4, entidade.getEmail());
            preparedStatement.setInt(5, entidade.getIdEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente selectCliente(int id) {
        Cliente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                Date dtNascimento = rs.getDate("dt_nascimento");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                Integer idEndereco = rs.getInt("id_endereco");
                
                entidade = new Cliente(id, nome, dtNascimento, cpf, email, idEndereco);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cliente> selectAllClientes() {
        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CLIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dtNascimento = rs.getDate("dt_nascimento");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                Integer idEndereco = rs.getInt("id_endereco");
                entidades.add(new Cliente(id, nome, dtNascimento, cpf, email, idEndereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCliente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CLIENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCliente(Cliente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CLIENTE_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setDate(2, entidade.getDtNascimento());
            statement.setString(3, entidade.getCpf());
            statement.setString(4, entidade.getEmail());
            statement.setInt(5, entidade.getIdEndereco());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
