/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Servico;
import model.Tutor;

/**
 *
 * @author geova
 */
public class ServicosDAO {

    private Connection conn;
//    private ServicosDAO servicoDAO;

    public ServicosDAO() {
        conn = ConnectionFactory.getConnection();
//        this.servicoDAO = new ServicosDAO();
    }

    public ArrayList<Servico> selecionar() {
        ArrayList<Servico> listaServico = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from servicos");
            while (rs.next()) {
                listaServico.add(
                        new Servico(
                                rs.getInt("codServico"),
                                rs.getString("nomeServico")));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServico;
    }

}
