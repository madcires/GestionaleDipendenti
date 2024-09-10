package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.NomeRuolo;
import it.corso.model.Ruolo;

/**
 * L'interfaccia {@code RuoloDao} estende {@link CrudRepository} per fornire metodi CRUD per l'entità {@link Ruolo}.
 * Oltre alle operazioni CRUD di base, definisce un metodo per cercare un ruolo specifico tramite il nome, 
 * utilizzando l'enum {@link NomeRuolo}.
 * 
 * <ul>
 * <li>{@link #findByNome(NomeRuolo)}: Restituisce un ruolo cercando in base al nome del ruolo.</li>
 * </ul>
 * 
 * @see CrudRepository
 * @see Ruolo
 * @see NomeRuolo
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public interface RuoloDao extends CrudRepository<Ruolo, Integer> {

    /**
     * Cerca un ruolo in base al nome del ruolo, rappresentato dall'enum {@link NomeRuolo}.
     * 
     * @param nomeEnum il nome del ruolo da cercare, sotto forma di {@link NomeRuolo}
     * @return il ruolo corrispondente al nome fornito, o {@code null} se non trovato
     */
    Ruolo findByNome(NomeRuolo nomeEnum);

}
