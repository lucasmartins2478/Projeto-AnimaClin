/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Pet {

    private int codPet;
    private String nomePet;
    private String racaPet;
    private String especiePet;
    private Date dataNascPet;
    private String sexoPet;
    private Tutor tutor;

    public Pet() {

    }

    public Pet(int codPet, String nomePet, String racaPet, String especiePet, Date dataNascPet, String sexoPet) {
        this.codPet = codPet;
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.especiePet = especiePet;
        this.dataNascPet = dataNascPet;
        this.sexoPet = sexoPet;
    }

    public Pet(int codPet, String nomePet, String racaPet, String especiePet, java.sql.Date dataNascPet, String sexoPet, Tutor tutor) {
        this.codPet = codPet;
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.especiePet = especiePet;
        this.dataNascPet = dataNascPet;
        this.sexoPet = sexoPet;
        this.tutor = tutor;
    }   

    public Pet(String nomePet, String racaPet, String especiePet, String dataNascPet, String sexoPet, Tutor tutor) {
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.especiePet = especiePet;
        try {
            this.dataNascPet = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataNascPet);
        } catch (ParseException ex) {
            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sexoPet = sexoPet;
        this.tutor = tutor;
    }

    public Pet(int codPet, String nomePet, String racaPet, String especiePet,
            String dataNascPet, String sexoPet, Tutor tutor) {
        this.codPet = codPet;
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.especiePet = especiePet;
        try {
            this.dataNascPet = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataNascPet);
        } catch (ParseException ex) {
            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sexoPet = sexoPet;
        this.tutor = tutor;
    }

    public void setCodPet(int codPet) {
        this.codPet = codPet;
    }

    public int getCodPet() {
        return codPet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public void setEspeciePet(String especiePet) {
        this.especiePet = especiePet;
    }

    public String getEspeciePet() {
        return especiePet;
    }

    public Date getDataNascPet() {
        return dataNascPet;
    }

    public void setDataNascPet(Date dataNascPet) {
        this.dataNascPet = dataNascPet;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(String sexoPet) {
        this.sexoPet = sexoPet;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return this.getNomePet();
    }


}
