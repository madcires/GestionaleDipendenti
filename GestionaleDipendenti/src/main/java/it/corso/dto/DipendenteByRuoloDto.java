package it.corso.dto;

import java.time.LocalDate;

/**
 * La classe {@code DipendenteByRuoloDto} rappresenta un Data Transfer Object (DTO) utilizzato
 * per trasferire i dati relativi a un dipendente filtrato in base al suo ruolo.
 * Contiene i dettagli personali, il dipartimento e lo stipendio del dipendente.
 * 
 * Questa classe viene utilizzata per serializzare e deserializzare i dati dei dipendenti in base ai ruoli
 * e per trasferirli tra i vari livelli dell'applicazione, mantenendo solo le informazioni rilevanti.
 * 
 * <ul>
 * <li>{@link #nome}: Il nome del dipendente.</li>
 * <li>{@link #cognome}: Il cognome del dipendente.</li>
 * <li>{@link #dataNascita}: La data di nascita del dipendente.</li>
 * <li>{@link #dataAssunzione}: La data di assunzione del dipendente.</li>
 * <li>{@link #stipendio}: Lo stipendio del dipendente.</li>
 * <li>{@link #dipartimento}: Il dipartimento associato al dipendente, rappresentato da {@link DipendenteDipartimentoDto}.</li>
 * </ul>
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteByRuoloDto {

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private LocalDate dataAssunzione;

    private double stipendio;

    private DipendenteDipartimentoDto dipartimento;


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

    public DipendenteDipartimentoDto getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(DipendenteDipartimentoDto dipartimento) {
        this.dipartimento = dipartimento;
    }
}
