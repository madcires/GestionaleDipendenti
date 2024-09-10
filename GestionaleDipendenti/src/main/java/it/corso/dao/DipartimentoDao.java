package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Dipartimento;
import it.corso.model.NomeDipartimento;

/**
 * L'interfaccia {@code DipartimentoDao} estende {@link CrudRepository} per fornire
 * metodi CRUD per l'entità {@link Dipartimento}. Oltre alle operazioni CRUD di base, 
 * definisce un metodo per cercare un dipartimento tramite il nome utilizzando l'enum {@link NomeDipartimento}.
 * 
 * <ul>
 * <li>{@link #findByNome(NomeDipartimento)}: Restituisce un dipartimento cercando in base al nome del dipartimento.</li>
 * </ul>
 * 
 * @see CrudRepository
 * @see Dipartimento
 * @see NomeDipartimento
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public interface DipartimentoDao extends CrudRepository<Dipartimento, Integer> {

    /**
     * Cerca un dipartimento in base al nome del dipartimento, rappresentato dall'enum {@link NomeDipartimento}.
     * 
     * @param nomeEnum il nome del dipartimento da cercare, sotto forma di {@link NomeDipartimento}
     * @return il dipartimento corrispondente al nome fornito, o {@code null} se non trovato
     */
    Dipartimento findByNome(NomeDipartimento nomeEnum);
    
}
