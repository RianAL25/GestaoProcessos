/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoProcessos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe Prova
 *
 * @author yodem
 */
@Entity
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dataProva;

    @OneToOne(fetch = FetchType.EAGER)
    private Arquivo arquivoprova;

    @OneToOne(fetch = FetchType.EAGER)
    private Arquivo arquivoGabarito;

    private String nome;

    private Short dia;

    private String cor;

    //<editor-fold defaultstate="collapsed" desc="construtores">
    public Prova() {
    }

    public Prova(LocalDate dataProva, Arquivo arquivoprova, Arquivo arquivoGabarito, Short dia, String cor) {
        this.dataProva = dataProva;
        this.arquivoprova = arquivoprova;
        this.arquivoGabarito = arquivoGabarito;
        this.dia = dia;
        this.cor = cor;
    }

    public Prova(LocalDate dataProva, Arquivo arquivoprova, Arquivo arquivoGabarito, String nome, Short dia, String cor) {
        this.dataProva = dataProva;
        this.arquivoprova = arquivoprova;
        this.arquivoGabarito = arquivoGabarito;
        this.nome = nome;
        this.dia = dia;
        this.cor = cor;
    }
    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return dataProva;
    }

    public void setData(LocalDate dataProva) {
        this.dataProva = dataProva;
    }

    public Arquivo getArquivoprova() {
        return arquivoprova;
    }

    public void setArquivoprova(Arquivo arquivoprova) {
        this.arquivoprova = arquivoprova;
    }

    public Arquivo getArquivoGabarito() {
        return arquivoGabarito;
    }

    public void setArquivoGabarito(Arquivo arquivoGabarito) {
        this.arquivoGabarito = arquivoGabarito;
    }

    public Short getDia() {
        return dia;
    }

    public void setDia(Short dia) {
        this.dia = dia;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return "Prova{"
                + "id=" + id + ","
                + " dataProva=" + dataProva + ","
                + " arquivoprova=" + arquivoprova + ","
                + " arquivoGabarito=" + arquivoGabarito + ","
                + " dia=" + dia + ","
                + " cor=" + cor
                + '}';
    }
}
