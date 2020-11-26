/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.funcionario;

import data.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class FuncionarioDao extends Database {

    private PreparedStatement statment = getStatment();
    private Connection conn = getConn();
    private ResultSet contentResult;

    public int salvar(Funcionario funcionario) {
        conectar();
        int status;
        try {
            statment = conn.prepareStatement("INSERT INTO funcionarios(ra,nome,data_nascimento,estado_civil,cargo,salario,estado,cep,cidade,numero,bairro,lagradouro)  VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            statment.setString(1, funcionario.getRa());
            statment.setString(2, funcionario.getNome());
            statment.setString(3, funcionario.getDataNacimento());
            statment.setString(4, funcionario.getEstadoCivil());
            statment.setString(5, funcionario.getCargo());
            statment.setDouble(6, funcionario.getSalario());
            statment.setString(7, funcionario.getEstado());
            statment.setString(8, funcionario.getCep());
            statment.setString(9, funcionario.getCidade());
            statment.setInt(10, funcionario.getNumero());
            statment.setString(11, funcionario.getBairro());
            statment.setString(12, funcionario.getLagradouro());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        }finally{
            try {
                statment.close();
            } catch (SQLException e) {
            }
        }
        return status;
    }

    public Funcionario consulta(String ra) {
        conectar();
        Funcionario funcionario = new Funcionario();

        try {
            statment = conn.prepareStatement("SELECT * FROM funcionarios WHERE ra = ?");
            statment.setString(1, ra);
            contentResult = statment.executeQuery();
            if (contentResult.next()) {
                funcionario.setSalario(contentResult.getDouble("salario"));
                funcionario.setNome(contentResult.getString("nome"));
                funcionario.setDataNacimento(contentResult.getString("data_nascimento"));
                funcionario.setCargo(contentResult.getString("cargo"));
                funcionario.setEstadoCivil(contentResult.getString("estado_civil"));
                funcionario.setLagradouro(contentResult.getString("lagradouro"));
                funcionario.setNumero(Integer.parseInt(contentResult.getString("numero")));
                funcionario.setBairro(contentResult.getString("bairro"));
                funcionario.setCep(contentResult.getString("cep"));
                funcionario.setEstado(contentResult.getString("estado"));
                funcionario.setRa(contentResult.getString("ra"));
                funcionario.setCidade(contentResult.getString("cidade"));
            } else {
                funcionario = null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
            funcionario = null;
        }finally{
            try {
                statment.close();
            } catch (SQLException e) {
            }
        }

        return funcionario;
    }

    public int consultaProximoCodigo() {
        int codigo = 0;
        try {
            statment = conn.prepareStatement("SELECT * FROM sqlite_sequence where name='funcionarios'");
            contentResult = statment.executeQuery();
            codigo = contentResult.getInt("seq") + 1;
        } catch (SQLException e) {
            System.err.println("Error1: " + e);
            System.err.println("Error Code: " + e.getErrorCode());
        }finally{
            try {
                statment.close();
            } catch (SQLException ex) {
                
            }
        }

        return codigo;
    }
    
    public int updade(Funcionario funcionario) {
        int status;

        try {
            statment = conn.prepareStatement("UPDATE funcionarios SET nome=?,data_nacimento=?,estado_civil=?,cargo=?,salario=?,estado=?,cep=?,cidade=?,numero=?,bairro=?,lagradouro=? WHERE ra = ?");
//            statment = conn.prepareStatement("UPDATE funcionarios SET nome=? WHERE ra = ?");
            statment.setString(1, funcionario.getNome());
            statment.setString(2, funcionario.getDataNacimento());
            statment.setString(3, funcionario.getEstadoCivil());
            statment.setString(4, funcionario.getCargo());
            statment.setDouble(5, funcionario.getSalario());
            statment.setString(6, funcionario.getEstado());
            statment.setString(7, funcionario.getCep());
            statment.setString(8, funcionario.getCidade());
            statment.setInt(9, funcionario.getNumero());
            statment.setString(10, funcionario.getBairro());
            statment.setString(11, funcionario.getLagradouro());
            statment.setString(12, funcionario.getRa());
            status = statment.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
            System.err.println("Error Code: " + ex.getErrorCode());
            status = ex.getErrorCode();
        }finally{
            try {
                statment.close();
            } catch (SQLException e) {
            }
        }

        return status;
    }
}
