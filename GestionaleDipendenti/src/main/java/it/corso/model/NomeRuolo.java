package it.corso.model;

/**
 * L'enumerazione {@code NomeRuolo} rappresenta i diversi ruoli che i dipendenti possono avere all'interno di un'azienda.
 * Ogni valore di questa enum corrisponde a un ruolo specifico all'interno della struttura aziendale.
 * 
 * <ul>
 * <li>{@link #CEO}: Amministratore delegato (Chief Executive Officer) dell'azienda.</li>
 * <li>{@link #Recruiter}: Responsabile della selezione del personale.</li>
 * <li>{@link #Segretario}: Addetto alla gestione delle operazioni amministrative e di segreteria.</li>
 * <li>{@link #Impiegato}: Dipendente con mansioni amministrative e operative generiche.</li>
 * <li>{@link #Manager}: Responsabile della gestione e coordinamento di un team o un reparto.</li>
 * </ul>
 * 
 * Questa enumerazione può essere utilizzata per rappresentare il ruolo di un dipendente nel sistema.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
public enum NomeRuolo {

    CEO,
    Recruiter,
    Segretario,
    Impiegato,
    Manager
}
