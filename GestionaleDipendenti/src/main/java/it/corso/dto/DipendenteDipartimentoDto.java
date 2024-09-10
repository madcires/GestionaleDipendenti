package it.corso.dto;

import it.corso.model.NomeDipartimento;

/**
 * La classe {@code DipendenteDipartimentoDto} rappresenta un Data Transfer Object (DTO) utilizzato per trasferire
 * i dati relativi al dipartimento di un dipendente. Contiene il nome del dipartimento, rappresentato dall'enum {@link NomeDipartimento}.
 * 
 * Questa classe viene utilizzata per serializzare e deserializzare i dati relativi ai dipartimenti associati ai dipendenti,
 * mantenendo una struttura chiara per il trasferimento dei dati.
 * 
 * <ul>
 * <li>{@link #nome}: Il nome del dipartimento a cui il dipendente appartiene, rappresentato come valore dell'enum {@link NomeDipartimento}.</li>
 * </ul>
 * 
 * @see NomeDipartimento
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteDipartimentoDto {

    private NomeDipartimento nome;
    
    // Getter e Setter

    public NomeDipartimento getNome() {
        return nome;
    }
    
    public void setNome(NomeDipartimento nome) {
        this.nome = nome;
    }
}
