package it.corso.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corso.model.Dipartimento;
import it.corso.model.Dipendente;
import it.corso.model.NomeRuolo;

/**
 * L'interfaccia {@code DipendenteDao} estende {@link CrudRepository} per fornire metodi CRUD per l'entità {@link Dipendente}.
 * Oltre alle operazioni CRUD di base, definisce metodi per cercare dipendenti tramite il nome, dipartimento, 
 * e ruoli associati.
 * 
 * <ul>
 * <li>{@link #findByNome(String)}: Restituisce una lista di dipendenti cercando in base al nome.</li>
 * <li>{@link #findByDipartimento(Dipartimento)}: Restituisce una lista di dipendenti associati a un dipartimento specifico.</li>
 * <li>{@link #findByRuolo(NomeRuolo)}: Restituisce una lista di dipendenti associati a un ruolo specifico.</li>
 * </ul>
 * 
 * @see CrudRepository
 * @see Dipendente
 * @see NomeRuolo
 * @see Dipartimento
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public interface DipendenteDao extends CrudRepository<Dipendente, Integer> {

    /**
     * Cerca i dipendenti in base al nome fornito.
     * 
     * @param nome il nome del dipendente
     * @return una lista di dipendenti con il nome specificato
     */
    List<Dipendente> findByNome(String nome);

    /**
     * Cerca i dipendenti in base al dipartimento associato.
     * 
     * @param dipartimento l'istanza del dipartimento
     * @return una lista di dipendenti appartenenti al dipartimento specificato
     */
    List<Dipendente> findByDipartimento(Dipartimento dipartimento);

    /**
     * Cerca i dipendenti in base al ruolo associato, utilizzando una query personalizzata.
     * 
     * @param ruolo il ruolo da cercare, rappresentato dall'enum {@link NomeRuolo}
     * @return una lista di dipendenti con il ruolo specificato
     */
    @Query("SELECT d FROM Dipendente d JOIN d.ruoli r WHERE r.nome = :ruolo")
    List<Dipendente> findByRuolo(@Param("ruolo") NomeRuolo ruolo);

}
