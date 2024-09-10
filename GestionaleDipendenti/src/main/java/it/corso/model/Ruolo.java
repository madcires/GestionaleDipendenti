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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * La classe {@code Ruolo} rappresenta un'entità che modella un ruolo aziendale assegnato ai dipendenti.
 * Ogni ruolo ha un ID univoco e un nome, che è un valore dell'enum {@link NomeRuolo}.
 * 
 * La relazione tra {@code Ruolo} e {@code Dipendente} è molti-a-molti, dove un ruolo può essere assegnato a più dipendenti,
 * e un dipendente può avere più ruoli. La tabella di raccordo per questa relazione è definita come {@code dipendente_ruolo}.
 * 
 * La tabella associata nel database è definita come {@code ruolo}.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
@Entity
@Table(name = "ruolo")
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    @Enumerated(EnumType.STRING)
    private NomeRuolo nome;

    /**
     * La lista dei dipendenti associati a questo ruolo. La relazione è molti-a-molti e viene gestita con
     * il fetch type {@code FetchType.EAGER}, il che significa che i dipendenti vengono caricati insieme al ruolo.
     * Le operazioni di cascata usano {@code CascadeType.REFRESH}.
     * La tabella di raccordo utilizzata è definita come {@code dipendente_ruolo}.
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "dipendente_ruolo", 
        joinColumns = @JoinColumn(name = "id_ruolo", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_dipendente", referencedColumnName = "id")
    )
    private List<Dipendente> dipendenti = new ArrayList<>();

    // Getter e Setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NomeRuolo getNome() {
        return nome;
    }

    public void setNome(NomeRuolo nome) {
        this.nome = nome;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

}
