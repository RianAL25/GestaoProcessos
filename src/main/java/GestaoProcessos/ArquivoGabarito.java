/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe ArquivoGabarito
 * @author yodem
 */
@Entity(name="gabarito")
public class ArquivoGabarito
        extends Arquivo
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">
        public ArquivoGabarito() {
            super();
        }

        public ArquivoGabarito(String nome, String path) {
            super(nome, path);
        }
    //</editor-fold>

    @Override
    public String toString() {
        return "ArquivoGabarito{" + '}';
    }
    
}
