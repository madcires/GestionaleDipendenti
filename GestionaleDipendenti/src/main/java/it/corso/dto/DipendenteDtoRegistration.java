package it.corso.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * La classe {@code DipendenteDtoRegistration} rappresenta un Data Transfer Object (DTO)
 * utilizzato per la registrazione di un nuovo dipendente. Contiene i campi necessari per
 * creare un nuovo dipendente, con opportune annotazioni di validazione.
 * 
 * Questa classe è utilizzata per garantire che i dati immessi durante la creazione di
 * un dipendente siano validi, grazie alle annotazioni di validazione come {@link NotNull}, 
 * {@link Past}, {@link Pattern}, {@link Positive}, {@link NotEmpty} e {@link Size}.
 * 
 * <ul>
 * <li>{@link #nome}: Il nome del dipendente.</li>
 * <li>{@link #cognome}: Il cognome del dipendente.</li>
 * <li>{@link #dataNascita}: La data di nascita del dipendente (deve essere nel passato).</li>
 * <li>{@link #dataAssunzione}: La data di assunzione del dipendente (deve essere nel passato).</li>
 * <li>{@link #stipendio}: Lo stipendio del dipendente (deve essere un valore positivo).</li>
 * <li>{@link #dipartimento}: Il nome del dipartimento a cui appartiene il dipendente.</li>
 * <li>{@link #ruoli}: La lista dei ruoli assegnati al dipendente (almeno uno richiesto).</li>
 * </ul>
 * 
 * Le annotazioni di validazione assicurano che:
 * <ul>
 * <li>Il nome e il cognome contengano solo caratteri ammessi.</li>
 * <li>La data di nascita e la data di assunzione siano nel passato.</li>
 * <li>Lo stipendio sia un valore positivo.</li>
 * <li>Sia specificato almeno un ruolo per il dipendente.</li>
 * </ul>
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 *
 */
public class DipendenteDtoRegistration {

    @NotNull(message = "Il nome è obbligatorio")
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{2,255}", message = "Nome con caratteri non ammessi")
    private String nome;

    @NotNull(message = "Il cognome è obbligatorio")
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{2,255}", message = "Cognome con caratteri non ammessi")
    private String cognome;

    @NotNull(message = "La data di nascita è obbligatoria")
    @Past(message = "La data di nascita deve essere nel passato")
    private LocalDate dataNascita;

    @NotNull(message = "La data di assunzione è obbligatoria")
    @Past(message = "La data di assunzione deve essere nel passato")
    private LocalDate dataAssunzione;

    @Positive(message = "Lo stipendio deve essere un valore positivo")
    private double stipendio;

    @NotNull(message = "Il dipartimento è obbligatorio")
    @Size(min = 2, max = 255, message = "Il dipartimento deve avere una lunghezza compresa tra 2 e 255 caratteri")
    private String dipartimento;

    @NotEmpty(message = "Devi specificare almeno un ruolo")
    private List<String> ruoli;


    // Getter e Setter
    
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

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public List<String> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<String> ruoli) {
        this.ruoli = ruoli;
    }
}
