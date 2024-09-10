package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * La classe {@code Dipartimento} rappresenta un'entità del database che modella un dipartimento aziendale.
 * Ogni dipartimento ha un ID univoco, un nome (definito dall'enum {@link NomeDipartimento}) e una lista di dipendenti
 * che fanno parte del dipartimento.
 * 
 * La relazione tra {@code Dipartimento} e {@code Dipendente} è uno a molti, 
 * dove un dipartimento può avere più dipendenti associati. La relazione è mappata usando 
 * {@code OneToMany} con le operazioni di {@code CascadeType.REFRESH} e il fetch type {@code FetchType.EAGER}.
 * 
 * Il campo {@code nome} è salvato come stringa e rappresenta un valore dell'enum {@link NomeDipartimento}.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
@Entity
@Table(name = "dipartimento")
public class Dipartimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    @Enumerated(EnumType.STRING)
    private NomeDipartimento nome;

    /**
     * La lista dei dipendenti associati al dipartimento. La relazione è uno a molti e viene gestita con
     * il fetch type {@code FetchType.EAGER}, il che significa che i dipendenti vengono caricati insieme al dipartimento.
     * Le operazioni di cascata usano {@code CascadeType.REFRESH}, e i dipendenti orfani vengono rimossi dal dipartimento.
     */
    @OneToMany(mappedBy = "dipartimento", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Dipendente> dipendenti = new ArrayList<>();

    // Getter e Setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NomeDipartimento getNome() {
        return nome;
    }

    public void setNome(NomeDipartimento nome) {
        this.nome = nome;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
}
