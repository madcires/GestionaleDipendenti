package it.corso.dto;

import it.corso.model.NomeRuolo;

/**
 * La classe {@code DipendenteRuoloDto} rappresenta un Data Transfer Object (DTO) utilizzato per trasferire
 * i dati relativi a un ruolo di un dipendente. Contiene il nome del ruolo, che è rappresentato dall'enum {@link NomeRuolo}.
 * 
 * Questa classe viene utilizzata per serializzare e deserializzare i dati relativi ai ruoli dei dipendenti.
 * 
 * <ul>
 * <li>{@link #nome}: Il nome del ruolo assegnato al dipendente, rappresentato come valore dell'enum {@link NomeRuolo}.</li>
 * </ul>
 * 
 * @see NomeRuolo
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public class DipendenteRuoloDto {

    public NomeRuolo nome;

    // Getter e Setter
    
    public NomeRuolo getNome() {
        return nome;
    }

    public void setNome(NomeRuolo nome) {
        this.nome = nome;
    }

}
