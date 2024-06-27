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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pet;
import model.Tutor;

/**
 *
 * @author geova
 */
public class PetDAO {

    private Connection conn;
    private TutorDAO tutorDAO;

    public PetDAO() {
        this.conn = ConnectionFactory.getConnection();
        this.tutorDAO = new TutorDAO();
    }

    public void inserir(Pet pet) {
        TutorDAO tutor;

        try {
            String sql = "insert into pet(nomePet, racaPet, especiePet, dataNascPet, sexoPet, codTutor) values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pet.getNomePet());
            stmt.setString(2, pet.getRacaPet());
            stmt.setString(3, pet.getEspeciePet());
            stmt.setDate(4, new java.sql.Date(pet.getDataNascPet().getTime()));
            stmt.setString(5, pet.getSexoPet());
            stmt.setInt(6, pet.getTutor().getCodTutor());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Pet pet) {
        try {
            String sql = "update pet set nomePet = ?, racaPet = ?, especiePet = ?, dataNascPet = ?, sexoPet = ? where codPet = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pet.getNomePet());
            stmt.setString(2, pet.getRacaPet());
            stmt.setString(3, pet.getEspeciePet());
            stmt.setDate(4, new java.sql.Date(pet.getDataNascPet().getTime()));
            stmt.setString(5, pet.getSexoPet());
            stmt.setInt(6, pet.getTutor().getCodTutor());
            stmt.setInt(7, pet.getCodPet());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int codPet) {
        try {
            String sql = "delete from pet where codPet = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codPet);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public ArrayList<Pet> selecionar() {
        ArrayList<Pet> listaPet = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Pet");
            while (rs.next()) {
                listaPet.add(
                        new Pet(
                                rs.getInt("codPet"),
                                rs.getString("nomePet"),
                                rs.getString("racaPet"),
                                rs.getString("especiePet"),
                                rs.getDate("dataNascPet"),
                                rs.getString("sexoPet")));
//                                rs.close();

            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPet;
    }

    public Pet selecionarPorCodigo(int codPet) {
        Pet pet = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pet WHERE codPet = ?");
            stmt.setInt(1, codPet);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int codTutor = rs.getInt("codTutor");
                TutorDAO tutorDAO = new TutorDAO();
                Tutor tutor = tutorDAO.selecionarPorCodigo(codTutor);

                pet = new Pet(
                        rs.getInt("codPet"),
                        rs.getString("nomePet"),
                        rs.getString("racaPet"),
                        rs.getString("especiePet"),
                        rs.getDate("dataNascPet"),
                        rs.getString("sexoPet"),
                        tutor); // Associando o tutor ao pet
//                        rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pet;
    }

    public void excluirPetsPorTutor(int codTutor) {
        try {
            String sql = "DELETE FROM pet WHERE codTutor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codTutor);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
