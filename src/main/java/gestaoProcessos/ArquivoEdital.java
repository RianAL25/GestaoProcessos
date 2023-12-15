/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gestaoProcessos;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Classe ArquivoEdital
 * @author yodem
 */
@Entity(name="edital")
public class ArquivoEdital 
        extends Arquivo 
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public ArquivoEdital() {
            super();
        }
        
        public ArquivoEdital(String nome, String path) {    
            super(nome, path);
        }
        
    //</editor-fold>

    @Override
    public String toString() {
        return super.toString();
    }
}