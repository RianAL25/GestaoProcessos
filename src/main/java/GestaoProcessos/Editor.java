/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GestaoProcessos;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Classe Editor
 * @author yodem
 */
@Entity(name = "editor")
public class Editor 
        extends Usuario
        implements Serializable {

    private static final long serialVersionUID = 1L;

    public Editor() {
    }

    @Override
    public String toString() {
        return "Editor{" + '}';
    }

}