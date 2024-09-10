package it.corso.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * La classe {@code DipendenteDto} rappresenta un oggetto Data Transfer Object (DTO) utilizzato per trasferire
 * i dati relativi a un dipendente tra i vari livelli dell'applicazione, in particolare tra la logica di business e il livello di presentazione.
 * 
 * Questa classe contiene le informazioni di base di un dipendente, inclusi nome, cognome, data, stipendio, dipartimento e ruoli.
 * È progettata per essere utilizzata nei contesti in cui non è necessario trasferire l'intera entità {@link it.corso.model.Dipendente}, 
 * ma solo i dati rilevanti per la presentazione o il trasferimento.
 * 
 * <ul>
 * <li>{@link #nome}: Nome del dipendente.</li>
 * <li>{@link #cognome}: Cognome del dipendente.</li>
 * <li>{@link #dataNascita}: Data di nascita del dipendente.</li>
 * <li>{@link #dataAssunzione}: Data di assunzione del dipendente.</li>
 * <li>{@link #stipendio}: Stipendio del dipendente.</li>
 * <li>{@link #dipartimento}: Dipartimento a cui appartiene il dipendente, rappresentato da {@link DipendenteDipartimentoDto}.</li>
 * <li>{@link #ruoli}: Lista dei ruoli del dipendente, rappresentata da {@link DipendenteRuoloDto}.</li>
 * </ul>
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteDto {

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private LocalDate dataAssunzione;

    private double stipendio;

    private DipendenteDipartimentoDto dipartimento;

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

    public DipendenteDipartimentoDto getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(DipendenteDipartimentoDto dipartimento) {
        this.dipartimento = dipartimento;
    }

    public List<DipendenteRuoloDto> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<DipendenteRuoloDto> ruoli) {
        this.ruoli = ruoli;
    }
}
