/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucas
 */
public class Tutor {
    
    private int codTutor;
    private String nomeTutor;
    private String cpfTutor;
    private String emailTutor;
    private String telefoneTutor;
    private String enderecoTutor;
    
    
    public Tutor(){
        
    }

    public Tutor(int codTutor, String nomeTutor) {
        this.codTutor = codTutor;
        this.nomeTutor = nomeTutor;
    }
    
    

    public Tutor(String nomeTutor, String cpfTutor, String emailTutor, String telefoneTutor, String enderecoTutor) {
        this.nomeTutor = nomeTutor;
        this.cpfTutor = cpfTutor;
        this.emailTutor = emailTutor;
        this.telefoneTutor = telefoneTutor;
        this.enderecoTutor = enderecoTutor;
    }
    
    public Tutor(int codTutor , String nomeTutor , String cpfTutor , String emailTutor , 
            String telefoneTutor , String enderecoTutor){
        this.codTutor = codTutor;
        this.nomeTutor = nomeTutor;
        this.cpfTutor = cpfTutor;
        this.emailTutor = emailTutor;
        this.telefoneTutor = telefoneTutor;
        this.enderecoTutor = enderecoTutor;    
    }
    public void setCodTutor(int codTutor){
        this.codTutor = codTutor;
    }
    public int getCodTutor(){
        return codTutor;
    }
    public void setNomeTutor(String nomeTutor){
        this.nomeTutor = nomeTutor;
    }
    public String getNomeTutor(){
        return nomeTutor;
    }
    public void setCpfTutor(String cpfTutor){
        this.cpfTutor = cpfTutor;
    }
    public String getCpfTutor(){
        return cpfTutor;
    }
    public void setEmailTutor(String emailTutor){
        this.emailTutor = emailTutor;
    }
    public String getEmailTutor(){
        return emailTutor;
    }
    public void setTelefoneTutor(String telefoneTutor){
        this.telefoneTutor = telefoneTutor;
    }
    public String getTelefoneTutor(){
        return telefoneTutor;
    }
    public void setEnderecoTutor(String enderecoTutor){
        this.enderecoTutor = enderecoTutor;
    }
    public String getEnderecoTutor(){
        return enderecoTutor;
    }
//    public void setPetTutor(Pet petTutor){
//        this.petTutor = petTutor;
//    }
//    public Pet getPetTutor(){
//        return petTutor;
//    }
    
    public String toString(){
        return this.nomeTutor;
    }
    
    
}
