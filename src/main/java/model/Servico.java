/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucas
 */
public class Servico {
    
    private int idServico;
    private String nomeServico;

    public Servico() {
    
    }
    
    public Servico(int idServico, String nomeServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }   
    
    @Override
    public String toString(){
        return  this.nomeServico;
    }
    
}
