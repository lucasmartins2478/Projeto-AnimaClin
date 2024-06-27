/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Tutor;
import view.visualizar.VisualizarTutor;

/**
 *
 * @author geova
 */
public class TutorDAO {

    private Connection conn;

    public TutorDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public void inserir(Tutor tutor) {
        try {
            String sql = "insert into tutor(nomeTutor, cpfTutor, emailTutor, telefoneTutor, enderecoTutor) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tutor.getNomeTutor());
            stmt.setString(2, tutor.getCpfTutor());
            stmt.setString(3, tutor.getEmailTutor());
            stmt.setString(4, tutor.getTelefoneTutor());
            stmt.setString(5, tutor.getEnderecoTutor());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Tutor tutor) {
        try {
            String sql = "update tutor set nomeTutor = ?, cpfTutor = ?, emailTutor = ?, telefoneTutor = ?, enderecoTutor = ? where codTutor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tutor.getNomeTutor());
            stmt.setString(2, tutor.getCpfTutor());
            stmt.setString(3, tutor.getEmailTutor());
            stmt.setString(4, tutor.getTelefoneTutor());
            stmt.setString(5, tutor.getEnderecoTutor());
            stmt.setInt(6, tutor.getCodTutor());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int codTutor) {
        try {
            String sql = "delete from tutor where codTutor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codTutor);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public ArrayList<Tutor> selecionar() {
        ArrayList<Tutor> listaTutor = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Tutor");
            while (rs.next()) {
                listaTutor.add(
                        new Tutor(
                                rs.getInt("codTutor"),
                                rs.getString("nomeTutor"),
                                rs.getString("cpfTutor"),
                                rs.getString("emailTutor"),
                                rs.getString("telefoneTutor"),
                                rs.getString("enderecoTutor")));
//                                rs.close();
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTutor;
    }

    public Tutor selecionarPorCodigo(int codTutor) {
        Tutor tutor = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from tutor where codTutor = ?");
            stmt.setInt(1, codTutor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tutor = new Tutor(
                        rs.getInt("codTutor"),
                        rs.getString("nomeTutor"),
                        rs.getString("cpfTutor"),
                        rs.getString("emailTutor"),
                        rs.getString("telefoneTutor"),
                        rs.getString("enderecoTutor"));
//                        rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tutor;
    }

//    public void VisualizarTutores(Tutor tutor) {
//
//        try {
//            Connection conn = ConnectionFactory.getConnection();
//
//            PreparedStatement stmt = conn.prepareStatement("select * from Tutor");
//
//            ResultSet rs = stmt.executeQuery();
//
//            DefaultTableModel modelo = (DefaultTableModel) tbDadosTutor.getModel();
//            modelo.setNumRows(0);
//
//            while (rs.next()) {
//                modelo.addRow(new Object[]{rs.getString("nomeTutor"), rs.getString("cpfTutor"), rs.getString("emailTutor"), rs.getString("telefoneTutor"), rs.getString("enderecoTutor")});
//            }
//
////            Connection.closeConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(VisualizarTutor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
