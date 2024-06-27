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
 * @author geova
 */
public class Agendamento {

    private int id;
    private Servico servico;
    private Pet pet;
    private Date dataAgendamento;
    private String horarioAgendamento;

    public Agendamento() {

    }

    public Agendamento(int id, Servico servico) {
        this.id = id;
        this.servico = servico;
    }

    public Agendamento(int id, Date dataAgendamento, String horarioAgendamento) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
    }

//    public Agendamento(Servico servico, Pet pet, String dataAgendamento, String horarioAgendamento) {
//        this.servico = servico;
//        this.pet = pet;
//        try {
//            this.dataAgendamento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataAgendamento);
//        } catch (ParseException ex) {
//            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.horarioAgendamento = horarioAgendamento;
//    }

    public Agendamento(Servico servico, Pet pet, Date dataAgendamento, String horarioAgendamento) {
        this.servico = servico;
        this.pet = pet;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
    }
    
    

    public Agendamento(int id, Servico servico, Pet pet, java.sql.Date dataAgendamento, String horarioAgendamento) {
        this.id = id;
        this.servico = servico;
        this.pet = pet;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
    }

    public int getId() {
        return id;
    }

    public Agendamento(int id, Servico servico, Pet pet, String dataAgendamento, String horarioAgendamento) {
        this.id = id;
        this.servico = servico;
        this.pet = pet;
        try {
            this.dataAgendamento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataAgendamento);
        } catch (ParseException ex) {
            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.horarioAgendamento = horarioAgendamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(String horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

}
