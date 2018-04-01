/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 


/**
 *
 * @author Emm
 */
@ManagedBean
@SessionScoped
public class CalculosBean {

    
    private double mediaAritmetica;
    private double mediaGeometrica;
    private double mediaHarmonica;
    private Amostra amostra;
    
    
    
     /**
     * Creates a new instance of CalculosBean
     */
    public CalculosBean() {
    }

    
    
    

    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }
    
    
   
    public double getMediaAritmetica() {
        return mediaAritmetica;
    }

    public void setMediaAritmetica(double mediaAritmetica) {
        this.mediaAritmetica = mediaAritmetica;
    }

    public double getMediaGeometrica() {
        return mediaGeometrica;
    }

    public void setMediaGeometrica(double mediaGeometrica) {
        this.mediaGeometrica = mediaGeometrica;
    }

    public double getMediaHarmonica() {
        return mediaHarmonica;
    }

    public void setMediaHarmonica(double mediaHarmonica) {
        this.mediaHarmonica = mediaHarmonica;
    }
    
    
    public HashMap<Double, Integer> montarTabelaFrequencia(Amostra amostra){
        
        HashMap<Double, Integer> tabelaFrequencia = new HashMap<Double, Integer>();
        
        return tabelaFrequencia;
        
    }
    
    
    
    
}
