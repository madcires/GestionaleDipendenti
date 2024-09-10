package it.corso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * La classe {@code Dipendente} rappresenta un'entità che modella un dipendente aziendale nel sistema.
 * Ogni dipendente ha un ID univoco, nome, cognome, data di nascita, data di assunzione e stipendio.
 * 
 * Un dipendente può appartenere a un dipartimento specifico e può avere più ruoli, modellando una relazione
 * molti-a-uno con {@code Dipartimento} e una relazione molti-a-molti con {@code Ruolo}.
 * 
 * La tabella associata nel database è definita come {@code dipendente}.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "data_assunzione")
    private LocalDate dataAssunzione;

    @Column(name = "stipendio")
    private double stipendio;

    /**
     * Il dipartimento a cui appartiene il dipendente. 
     * Definisce una relazione molti-a-uno con l'entità {@code Dipartimento}.
     * Viene usato il fetch type {@code FetchType.EAGER} per caricare il dipartimento insieme al dipendente.
     * Le operazioni di cascata utilizzano {@code CascadeType.REFRESH}.
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dipartimento", referencedColumnName = "id")
    private Dipartimento dipartimento;

    /**
     * La lista di ruoli che il dipendente possiede, modellata come una relazione molti-a-molti con {@code Ruolo}.
     * La tabella di raccordo è definita come {@code dipendente_ruolo}.
     * Viene usato il fetch type {@code FetchType.EAGER} per caricare i ruoli insieme al dipendente.
     * Le operazioni di cascata utilizzano {@code CascadeType.REFRESH}.
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "dipendente_ruolo", 
        joinColumns = @JoinColumn(name = "id_dipendente", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_ruolo", referencedColumnName = "id")
    )
    private List<Ruolo> ruoli = new ArrayList<>();

    
    // Getter e Setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public List<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

}
