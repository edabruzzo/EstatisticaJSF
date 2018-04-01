/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 


/**
 *
 * @author Emm
 */
@ManagedBean
@ViewScoped
public class CalculosBean {

    
    public double mediaAritmetica;
    public double mediaGeometrica;
    public double mediaHarmonica;
    public  double somaValoresAmostrados = 0;
    public  double somaFrequencias = 0;
    public double somaValorFiDivideXi;
    public double somatoriaValorFiMultiplicaLogXi;
    
    public AmostraBean amostraBean;
    
    
     /**
     * Creates a new instance of CalculosBean
     */
    public CalculosBean() {
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

  
    
    public double getSomaValorFiDivideXi() {
        return somaValorFiDivideXi;
    }

    public void setSomaValorFiDivideXi(double somaValorFiDivideXi) {
        this.somaValorFiDivideXi = somaValorFiDivideXi;
    }

    public double getSomatoriaValorFiMultiplicaLogXi() {
        return somatoriaValorFiMultiplicaLogXi;
    }

    public void setSomatoriaValorFiMultiplicaLogXi(double somatoriaValorFiMultiplicaLogXi) {
        this.somatoriaValorFiMultiplicaLogXi = somatoriaValorFiMultiplicaLogXi;
    }
    
    
    public void montarTabelaFrequencia(){
        
        List<Double> amostra =  amostraBean.listaDadosColetados();
        
        HashMap<Double, Integer> tabelaFrequencia = new HashMap<Double, Integer>();
        
        for (double valor : amostra){
            
            if (!tabelaFrequencia.containsKey(valor)){
                
                tabelaFrequencia.put(valor, 0);
                
            }
            
            tabelaFrequencia.put(valor, (tabelaFrequencia.get(valor)+1));
            
        }
        
        for (Double key : tabelaFrequencia.keySet()){
            
            somaValoresAmostrados += key;
	    somaFrequencias += tabelaFrequencia.get(key);
            
            double valorXi = key;
            int valorFi = tabelaFrequencia.get(key);
	    
            this.somaValorFiDivideXi += (valorFi / valorXi);
            this.somatoriaValorFiMultiplicaLogXi += (valorFi * Math.log10(valorXi));  
        }
        
        
    }

    
    
    public void calcularMediaAritmetica(){
        double mediaAritmetica = (this.getSomaValoresAmostrados() * this.getSomaFrequencias()) / (this.getSomaFrequencias());
        this.setMediaAritmetica(mediaAritmetica);  
        
    }
    
    
        public void calcularMediaHarmonica(){
        
              double mediaHarmonica = this.getSomaFrequencias() / this.getSomaValorFiDivideXi();
              this.setMediaHarmonica(mediaHarmonica);
             
    }   
    
    
     public void calcularMediaGeometrica(){
        
        double logMediaGeometrica = this.getSomatoriaValorFiMultiplicaLogXi() / this.getSomaFrequencias();
        double mediaGeometrica = Math.pow(10, logMediaGeometrica);
        this.setMediaGeometrica(mediaGeometrica);
    }

    
    
}
