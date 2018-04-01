/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Emm
 */
@ManagedBean
@SessionScoped
public class AmostraBean implements Serializable{

    
    private double dadoColetado;
    private Amostra amostra = new Amostra();
   
    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }
     
    
    public double getDadoColetado() {
        return dadoColetado;
    }

    public void setDadoColetado(double dadoColetado) {
        this.dadoColetado = dadoColetado;
    }
    
    
    public void adicionarDado(){
        try{
            amostra.getListaDadosColetados().add(dadoColetado);
        }catch(NullPointerException npe){
            System.out.println("NÃO SEI O QUE FAZER AQUI !!!");
            System.out.println(npe.getLocalizedMessage());
            npe.printStackTrace();
        }
        
    }
    
    
    public List<Double> listaDadosColetados(){
        
        return amostra.getListaDadosColetados();
        
    }
    
    
    public String calculaMedias(){
        
        return "/medias?faces-redirect=true";
        
    }
    
    
}
