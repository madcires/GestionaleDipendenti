package it.corso.service;

import java.util.List;

import it.corso.dto.DipendenteByDipartimentoDto;
import it.corso.dto.DipendenteByRuoloDto;
import it.corso.dto.DipendenteDto;
import it.corso.dto.DipendenteDtoRegistration;
import it.corso.dto.DipendenteDtoUpdate;

/**
 * L'interfaccia {@code DipendenteService} definisce i metodi per la gestione dei dipendenti
 * nell'applicazione. Fornisce metodi per registrare, modificare, eliminare e recuperare
 * dipendenti, nonché per cercare dipendenti in base a nome, dipartimento o ruolo.
 * 
 * <ul>
 * <li>{@link #registrationDipendente(DipendenteDtoRegistration)}: Registra un nuovo dipendente.</li>
 * <li>{@link #updateDipendenteData(DipendenteDtoUpdate)}: Aggiorna i dati di un dipendente esistente.</li>
 * <li>{@link #deleteDipendenteById(int)}: Elimina un dipendente in base al suo ID.</li>
 * <li>{@link #getDipendenteById(int)}: Recupera un dipendente in base al suo ID.</li>
 * <li>{@link #getAllDipendenti()}: Restituisce tutti i dipendenti.</li>
 * <li>{@link #getDipendentiByNome(String)}: Cerca dipendenti in base al nome.</li>
 * <li>{@link #getDipendentiByDipartimento(String)}: Cerca dipendenti in base al dipartimento.</li>
 * <li>{@link #getDipendentiByRuolo(String)}: Cerca dipendenti in base al ruolo.</li>
 * </ul>
 * 
 * @see DipendenteDtoRegistration
 * @see DipendenteDtoUpdate
 * @see DipendenteDto
 * @see DipendenteByDipartimentoDto
 * @see DipendenteByRuoloDto
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public interface DipendenteService {

    /**
     * Registra un nuovo dipendente.
     * 
     * @param dipendenteDto il DTO contenente i dati del nuovo dipendente
     */
    void registrationDipendente(DipendenteDtoRegistration dipendenteDto);

    /**
     * Modifica i dati di un dipendente esistente.
     * 
     * @param dipendenteDto il DTO contenente i dati aggiornati del dipendente
     */
    void updateDipendenteData(DipendenteDtoUpdate dipendenteDto);

    /**
     * Elimina un dipendente in base al suo ID.
     * 
     * @param id l'ID del dipendente da eliminare
     */
    void deleteDipendenteById(int id);

    /**
     * Recupera un dipendente in base al suo ID.
     * 
     * @param id l'ID del dipendente da recuperare
     * @return il DTO contenente i dati del dipendente, o {@code null} se non trovato
     */
    DipendenteDto getDipendenteById(int id);

    /**
     * Restituisce tutti i dipendenti.
     * 
     * @return una lista di DTO di tutti i dipendenti
     */
    List<DipendenteDto> getAllDipendenti();

    /**
     * Cerca dipendenti in base al nome.
     * 
     * @param nome il nome del dipendente da cercare
     * @return una lista di DTO dei dipendenti con il nome specificato
     */
    List<DipendenteDto> getDipendentiByNome(String nome);

    /**
     * Cerca dipendenti in base al dipartimento.
     * 
     * @param nomeDipartimento il nome del dipartimento da cercare
     * @return una lista di DTO dei dipendenti appartenenti al dipartimento specificato
     */
    List<DipendenteByDipartimentoDto> getDipendentiByDipartimento(String nomeDipartimento);

    /**
     * Cerca dipendenti in base al ruolo.
     * 
     * @param nomeRuolo il nome del ruolo da cercare
     * @return una lista di DTO dei dipendenti con il ruolo specificato
     */
    List<DipendenteByRuoloDto> getDipendentiByRuolo(String nomeRuolo);

}
