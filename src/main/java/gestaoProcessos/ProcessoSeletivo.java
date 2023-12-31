/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gestaoProcessos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe ProcessoSeletivo
 * @author yodem
 */
@Entity
public class ProcessoSeletivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String descricao;
    
    private Boolean aberto;
    
    @OneToOne
    private Edital edital;
    
    @OneToOne
    private Prova prova;
    
     @OneToMany(mappedBy = "processoSeletivo",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Inscricao> candidatos;

    //<editor-fold defaultstate="collapsed" desc="construtores">
        public ProcessoSeletivo() {     
            this.candidatos = new ArrayList<>();
        }
        
        public ProcessoSeletivo(String nome, String descricao, Boolean aberto, Edital edital, Prova prova) {
            this.nome = nome;
            this.descricao = descricao;
            this.aberto = aberto;
            this.edital = edital;
            this.prova = prova;
        }

        public ProcessoSeletivo(String nome, String descricao, Boolean aberto, Edital edital, Prova prova, List<Inscricao> candidatos) {
            this.nome = nome;
            this.descricao = descricao;
            this.aberto = aberto;
            this.edital = edital;
            this.prova = prova;
            this.candidatos = candidatos;
        }

    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Boolean getAberto() {
            return aberto;
        }

        public void setAberto(Boolean aberto) {
            this.aberto = aberto;
        }

        public Edital getEdital() {
            return edital;
        }

        public void setEdital(Edital edital) {
            this.edital = edital;
        }

        public Prova getProva() {
            return prova;
        }

        public void setProva(Prova prova) {
            this.prova = prova;
        }
        public List<Inscricao> getCandidatos() {
            return candidatos;
        }

        public void setCandidatos(List<Inscricao> candidatos) {
            this.candidatos = candidatos;
        }
    //</editor-fold>

    
    @Override
    public String toString() {
        return "ProcessoSeletivo{" + "id=" + id + ","
                + " nome=" + nome + ","
                + " descricao=" + descricao + ","
                + " aberto=" + aberto + ","
                + " edital=" + edital + ","
                + " prova=" + prova + 
                '}';
    }
    
    
}
