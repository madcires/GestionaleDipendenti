package it.corso.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * La classe {@code DipendenteDtoUpdate} rappresenta un Data Transfer Object (DTO) utilizzato per l'aggiornamento
 * dei dati di un dipendente. Contiene campi come ID, nome, cognome, data, stipendio, dipartimento e ruoli.
 * 
 * Le annotazioni di validazione sono utilizzate per garantire che i dati forniti per l'aggiornamento siano corretti
 * e conformi ai requisiti.
 * 
 * <ul>
 * <li>{@link #id}: L'ID del dipendente (deve essere maggiore di 0).</li>
 * <li>{@link #nome}: Il nome del dipendente (deve contenere solo caratteri alfabetici ammessi).</li>
 * <li>{@link #cognome}: Il cognome del dipendente (deve contenere solo caratteri alfabetici ammessi).</li>
 * <li>{@link #dataNascita}: La data di nascita del dipendente (deve essere una data passata).</li>
 * <li>{@link #dataAssunzione}: La data di assunzione del dipendente (deve essere una data passata).</li>
 * <li>{@link #stipendio}: Lo stipendio del dipendente (deve essere un valore positivo).</li>
 * <li>{@link #dipartimento}: L'ID del dipartimento associato al dipendente (deve essere maggiore di 0).</li>
 * <li>{@link #ruoli}: La lista degli ID dei ruoli associati al dipendente (deve essere non nulla).</li>
 * </ul>
 * 
 * Le annotazioni di validazione assicurano che:
 * <ul>
 * <li>Il nome e il cognome contengano solo caratteri ammessi.</li>
 * <li>L'ID del dipendente e del dipartimento siano validi (maggiori di 0).</li>
 * <li>Le date di nascita e di assunzione siano nel passato.</li>
 * <li>Lo stipendio sia un valore positivo.</li>
 * <li>La lista dei ruoli non sia vuota o nulla.</li>
 * </ul>
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteDtoUpdate {

    @NotNull(message = "L'id è obbligatorio")
    @Min(value = 0, message = "L'id del dipendente deve essere maggiore di 0")
    private int id;

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
    @Min(value = 0, message = "L'id del dipartimento deve essere maggiore di 0")
    private int dipartimento;

    @NotNull(message = "Il campo ruoli è obbligatorio")
    private List<Integer> ruoli;

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

    public int getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(int dipartimento) {
        this.dipartimento = dipartimento;
    }

    public List<Integer> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<Integer> ruoli) {
        this.ruoli = ruoli;
    }

}
