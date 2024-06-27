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
import model.Agendamento;

/**
 *
 * @author geova
 */
public class AgendamentoDAO {

    private Connection conn;

    public AgendamentoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public void inserir(Agendamento agendamento) {
        try {
            String sql = "insert into agendamento(dataAgendamento, horarioagendamento, idPet, idServico) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(agendamento.getDataAgendamento().getTime()));
            stmt.setString(2, agendamento.getHorarioAgendamento());
            stmt.setInt(3, agendamento.getPet().getCodPet());
            stmt.setInt(6, agendamento.getServico().getIdServico());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Agendamento> selecionar() {
        ArrayList<Agendamento> listaAgendamento = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Agendamento");
            while (rs.next()) {
                listaAgendamento.add(
                        new Agendamento(
                                rs.getInt("codAgendamento"),
                                rs.getDate("horarioAgendamento"),
                                rs.getString("horarioagendamento")
                                ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAgendamento;
    }

}
