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
    private double somaValoresAmostrados = 0;
    private double somaFrequencias = 0;
    
    
    
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
    
    
    
    public double getSomaValoresAmostrados() {
        return somaValoresAmostrados;
    }

    public void setSomaValoresAmostrados(double somaValoresAmostrados) {
        this.somaValoresAmostrados = somaValoresAmostrados;
    }

    public double getSomaFrequencias() {
        return somaFrequencias;
    }

    public void setSomaFrequencias(double somaFrequencias) {
        this.somaFrequencias = somaFrequencias;
    }

  
    
    public void montarTabelaFrequencia(Amostra amostra){
        
        HashMap<Double, Integer> tabelaFrequencia = new HashMap<Double, Integer>();
        
        for (double valor : amostra.getListaDadosColetados()){
            
            if (!tabelaFrequencia.containsKey(valor)){
                
                tabelaFrequencia.put(valor, 0);
                
            }
            
            tabelaFrequencia.put(valor, (tabelaFrequencia.get(valor)+1));
            
        }
        
        for (Double key : tabelaFrequencia.keySet()){
            
            somaValoresAmostrados += key;
	    somaFrequencias += tabelaFrequencia.get(key);
            
            
        }
        
        
    }

    
    
}
