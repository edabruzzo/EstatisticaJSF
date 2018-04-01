/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.HashMap;
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
    public double mediaAritmetica;
    public double mediaGeometrica;
    public double mediaHarmonica;
    public  double somaValoresAmostrados = 0;
    public  double somaFrequencias = 0;
    public double somaValorFiDivideXi;
    public double somatoriaValorFiMultiplicaLogXi;
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
    
    
    
    
    public void adicionarDado(){
        try{
            amostra.getListaDadosColetados().add(dadoColetado);
            dadoColetado = 0;
        }catch(NullPointerException npe){
            System.out.println(npe.getLocalizedMessage());
            npe.printStackTrace();
        }
        
    }
    
    
    public List<Double> listaDadosColetados(){
        
        return amostra.getListaDadosColetados();
        
    }
    
    public void limparDados(){
        
        amostra.getListaDadosColetados().clear();
        
    }
    
    
    public String calculaMedias(){
        
        return "/medias?faces-redirect=true";
        
    }
    
    
    
    public void montarTabelaFrequencia(){
        
        List<Double> amostraRecebida =  this.amostra.getListaDadosColetados();
        
        HashMap<Double, Integer> tabelaFrequencia = new HashMap<Double, Integer>();
        
       for (Double valor : amostraRecebida){
           
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

    
    
    public double calcularMediaAritmetica(){
        montarTabelaFrequencia();
        double mediaAritmetica = (this.getSomaValoresAmostrados() * this.getSomaFrequencias()) / (this.getSomaFrequencias());
        this.setMediaAritmetica(mediaAritmetica); 
        return this.getMediaAritmetica();
    }
    
    
        public double calcularMediaHarmonica(){
        
              double mediaHarmonica = this.getSomaFrequencias() / this.getSomaValorFiDivideXi();
              this.setMediaHarmonica(mediaHarmonica);
             return this.getMediaHarmonica();
    }   
    
    
     public double calcularMediaGeometrica(){
        
        double logMediaGeometrica = this.getSomatoriaValorFiMultiplicaLogXi() / this.getSomaFrequencias();
        double mediaGeometrica = Math.pow(10, logMediaGeometrica);
        this.setMediaGeometrica(mediaGeometrica);
        return this.getMediaGeometrica();
    }

    
    
}
