package it.corso.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * La classe {@code DipendenteByDipartimentoDto} rappresenta un Data Transfer Object (DTO)
 * utilizzato per trasferire i dati relativi a un dipendente filtrato in base al suo dipartimento.
 * Include dettagli personali, lo stipendio e i ruoli del dipendente.
 * 
 * Questa classe viene utilizzata per serializzare e deserializzare i dati dei dipendenti filtrati per dipartimento
 * e per trasferirli tra i vari livelli dell'applicazione, mantenendo solo le informazioni rilevanti.
 * 
 * <ul>
 * <li>{@link #nome}: Il nome del dipendente.</li>
 * <li>{@link #cognome}: Il cognome del dipendente.</li>
 * <li>{@link #dataNascita}: La data di nascita del dipendente.</li>
 * <li>{@link #dataAssunzione}: La data di assunzione del dipendente.</li>
 * <li>{@link #stipendio}: Lo stipendio del dipendente.</li>
 * <li>{@link #ruoli}: La lista dei ruoli assegnati al dipendente, rappresentata da {@link DipendenteRuoloDto}.</li>
 * </ul>
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteByDipartimentoDto {

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private LocalDate dataAssunzione;

    private double stipendio;

    private List<DipendenteRuoloDto> ruoli;

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

    public List<DipendenteRuoloDto> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<DipendenteRuoloDto> ruoli) {
        this.ruoli = ruoli;
    }
}
