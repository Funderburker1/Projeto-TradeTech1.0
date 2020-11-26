/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.cliente;

import data.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class ClienteDao extends Database {

    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;

    public int salvar(Fisico cliente) {
        int status=0;

        try {
            statment = conn.prepareStatement("INSERT INTO clientes(nome,numero,estado,cep,cidade,bairro,lagradouro) VALUES(?,?,?,?,?,?,?)");
            statment.setString(1, cliente.getNome());
            statment.setInt(2, cliente.getNumero());
            statment.setString(3, cliente.getEstado());
            statment.setString(4, cliente.getCep());
            statment.setString(5, cliente.getCidade());
            statment.setString(6, cliente.getBairro());
            statment.setString(7, cliente.getLagradouro());
            statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            return ex.getErrorCode();
        } finally {
            try {
                statment.close();
                try {
                    conectar();
                    statment = conn.prepareStatement("INSERT INTO fisica(cpf,estado_civil,data_nascimento,codigo) VALUES(?,?,?,?)");
                    statment.setString(1, cliente.getCpf());
                    statment.setString(2, cliente.getEstadoCivil());
                    statment.setString(3, cliente.getDataNascimento());
                    statment.setInt(4, cliente.getCodigoCliente());
                    status = statment.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                    System.err.println("Error Code: " + ex.getErrorCode());
                    excluir(cliente.getCodigoCliente());
                    return ex.getErrorCode();
                } finally {
                    try {
                        statment.close();
                    } catch (SQLException ex) {

                    }
                }
            }catch(SQLException ex){
                
            }
        }

        return status;
    }

    public int consultaProximoCodigo() {
        conectar();
        int codigo = 0;
        try {
            statment = conn.prepareStatement("SELECT * FROM sqlite_sequence where name='clientes'");
            contentResult = statment.executeQuery();
            codigo = contentResult.getInt("seq") + 1;
            System.out.println(codigo);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return codigo;
    }

    private void excluir(int codigo) {
        try {
            System.out.println("exluir " + codigo);
            statment = conn.prepareStatement("DELETE FROM clientes WHERE codigo=?;");
            statment.setInt(1, codigo);
            statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }
    }

    public int updade(Fisico cliente) {
        int status;

        try {
            statment = conn.prepareStatement("UPDATE clientes SET nome=?,numero=?,estado=?,cep=?,cidade=?,bairro=?,lagradouro=? WHERE codigo = ?");
            statment.setString(1, cliente.getNome());
            statment.setInt(2, cliente.getNumero());
            statment.setString(3, cliente.getEstado());
            statment.setString(4, cliente.getCep());
            statment.setString(5, cliente.getCidade());
            statment.setString(6, cliente.getBairro());
            statment.setString(7, cliente.getLagradouro());
            statment.setInt(8, cliente.getCodigo());
            statment.executeUpdate();

            statment = conn.prepareStatement("UPDATE fisica SET cpf=?,data_nascimento=?,estado_civil=? WHERE codigo = ?");
            statment.setString(1, cliente.getCpf());
            statment.setString(2, cliente.getDataNascimento());
            statment.setString(3, cliente.getEstadoCivil());
            statment.setInt(4, cliente.getCodigo());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return status;
    }

    public Fisico consultaFisico(String cpf) {
        Fisico cliente = new Fisico();

        try {
            statment = conn.prepareStatement("SELECT * FROM fisica WHERE cpf = ?");
            statment.setString(1, cpf);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                cliente.setCpf(contentResult.getString("cpf"));
                cliente.setDataNascimento(contentResult.getString("data_nascimento"));
                cliente.setEstadoCivil(contentResult.getString("estado_civil"));
                cliente.setCodigoCliente(contentResult.getInt("codigo"));

                statment = conn.prepareStatement("SELECT * FROM clientes WHERE codigo = ?");
                statment.setInt(1, cliente.getCodigoCliente());
                contentResult = statment.executeQuery();

                cliente.setNome(contentResult.getString("nome"));
                cliente.setLagradouro(contentResult.getString("lagradouro"));
                cliente.setBairro(contentResult.getString("bairro"));
                cliente.setCep(contentResult.getString("cep"));
                cliente.setCidade(contentResult.getString("cidade"));
                cliente.setEstado(contentResult.getString("estado"));
                cliente.setNumero(contentResult.getInt("numero"));
                cliente.setCodigo(contentResult.getInt("codigo"));
            } else {
                cliente = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            cliente = null;
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return cliente;
    }
    
    public Cliente consultaCodigo(int codigo){
        Cliente cliente = new Cliente();
        try {
            statment = conn.prepareStatement("SELECT * FROM clientes WHERE codigo = ?");
            statment.setInt(1, codigo);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                cliente.setNome(contentResult.getString("nome"));
                cliente.setLagradouro(contentResult.getString("lagradouro"));
                cliente.setBairro(contentResult.getString("bairro"));
                cliente.setCep(contentResult.getString("cep"));
                cliente.setCidade(contentResult.getString("cidade"));
                cliente.setEstado(contentResult.getString("estado"));
                cliente.setNumero(contentResult.getInt("numero"));
                cliente.setCodigo(contentResult.getInt("codigo"));
            } else {
                cliente = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            cliente = null;
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return cliente;
    }

    public int salvar(Juridico cliente) {
        int status;

        try {
            statment = conn.prepareStatement("INSERT INTO clientes(nome,numero,estado,cep,cidade,bairro,lagradouro) VALUES(?,?,?,?,?,?,?)");
            statment.setString(1, cliente.getNome());
            statment.setInt(2, cliente.getNumero());
            statment.setString(3, cliente.getEstado());
            statment.setString(4, cliente.getCep());
            statment.setString(5, cliente.getCidade());
            statment.setString(6, cliente.getBairro());
            statment.setString(7, cliente.getLagradouro());
            statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            return ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }
        try {
            conectar();
            statment = conn.prepareStatement("INSERT INTO juridica(cnpj,codigo) VALUES(?,?)");
            statment.setString(1, cliente.getCnpj());
            statment.setInt(2, cliente.getCodigoCliente());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            excluir(cliente.getCodigoCliente());
            return ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return status;
    }

    public int updade(Juridico cliente) {
        int status;

        try {
            statment = conn.prepareStatement("UPDATE clientes SET nome=?,numero=?,estado=?,cep=?,cidade=?,bairro=?,lagradouro=? WHERE codigo = ?");
            statment.setString(1, cliente.getNome());
            statment.setInt(2, cliente.getNumero());
            statment.setString(3, cliente.getEstado());
            statment.setString(4, cliente.getCep());
            statment.setString(5, cliente.getCidade());
            statment.setString(6, cliente.getBairro());
            statment.setString(7, cliente.getLagradouro());
            statment.setInt(8, cliente.getCodigo());
            status = statment.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return status;
    }

    public Juridico consultaJuridico(String cnpj) {
        Juridico cliente = new Juridico();

        try {
            statment = conn.prepareStatement("SELECT * FROM juridica WHERE cnpj = ?");
            statment.setString(1, cnpj);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                cliente.setCnpj(contentResult.getString("cnpj"));
                cliente.setCodigoCliente(contentResult.getInt("codigo"));

                statment = conn.prepareStatement("SELECT * FROM clientes WHERE codigo = ?");
                statment.setInt(1, cliente.getCodigoCliente());
                contentResult = statment.executeQuery();

                cliente.setNome(contentResult.getString("nome"));
                cliente.setLagradouro(contentResult.getString("lagradouro"));
                cliente.setBairro(contentResult.getString("bairro"));
                cliente.setCep(contentResult.getString("cep"));
                cliente.setCidade(contentResult.getString("cidade"));
                cliente.setEstado(contentResult.getString("estado"));
                cliente.setNumero(contentResult.getInt("numero"));
                cliente.setCodigo(contentResult.getInt("codigo"));
            } else {
                cliente = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            cliente = null;
        } finally {
            try {
                statment.close();
            } catch (SQLException ex) {

            }
        }

        return cliente;
    }
}
