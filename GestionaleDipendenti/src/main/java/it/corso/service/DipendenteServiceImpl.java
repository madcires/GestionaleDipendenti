package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.DipartimentoDao;
import it.corso.dao.DipendenteDao;
import it.corso.dao.RuoloDao;
import it.corso.dto.DipendenteByDipartimentoDto;
import it.corso.dto.DipendenteByRuoloDto;
import it.corso.dto.DipendenteDto;
import it.corso.dto.DipendenteDtoRegistration;
import it.corso.dto.DipendenteDtoUpdate;
import it.corso.model.Dipartimento;
import it.corso.model.Dipendente;
import it.corso.model.NomeDipartimento;
import it.corso.model.NomeRuolo;
import it.corso.model.Ruolo;

/**
 * L'implementazione della classe {@code DipendenteService} che gestisce le operazioni sui dipendenti.
 * Fornisce metodi per registrare, modificare, eliminare e recuperare dipendenti, oltre a cercarli
 * in base al nome, dipartimento o ruolo.
 * 
 * Questa classe utilizza {@link ModelMapper} per convertire tra entità e DTO.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
@Service
public class DipendenteServiceImpl implements DipendenteService {

    @Autowired
    private DipendenteDao dipendenteDao;

    @Autowired
    private DipartimentoDao dipartimentoDao;

    @Autowired
    private RuoloDao ruoloDao;

    private ModelMapper mapper = new ModelMapper();

    /**
     * Registra un nuovo dipendente con i dati forniti. 
     * Cerca il dipartimento e i ruoli in base agli enum e li associa al dipendente.
     * 
     * @param dipendenteDto il DTO contenente i dati del dipendente
     */
    @Override
    public void registrationDipendente(DipendenteDtoRegistration dipendenteDto) {
        try {
            Dipendente dipendente = mapper.map(dipendenteDto, Dipendente.class);
            NomeDipartimento nomeDipEnum = NomeDipartimento.valueOf(dipendenteDto.getDipartimento());
            Dipartimento dipartimento = dipartimentoDao.findByNome(nomeDipEnum);
            List<String> ruoliString = dipendenteDto.getRuoli();
            List<Ruolo> ruoli = new ArrayList<>();
            for (String ruoloString : ruoliString) {
                NomeRuolo nomeRuoloEnum = NomeRuolo.valueOf(ruoloString);
                ruoli.add(ruoloDao.findByNome(nomeRuoloEnum));
            }
            if (dipartimento != null && !ruoli.isEmpty()) {
                dipendente.setDipartimento(dipartimento);
                dipendente.setRuoli(ruoli);
                dipendenteDao.save(dipendente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica i dati di un dipendente esistente.
     * 
     * @param dipendenteDto il DTO contenente i nuovi dati del dipendente
     */
    @Override
    public void updateDipendenteData(DipendenteDtoUpdate dipendenteDto) {
        try {
            Optional<Dipendente> dipendenteOptional = dipendenteDao.findById(dipendenteDto.getId());
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                dipendente.setNome(dipendenteDto.getNome());
                dipendente.setCognome(dipendenteDto.getCognome());
                dipendente.setDataNascita(dipendenteDto.getDataNascita());
                dipendente.setDataAssunzione(dipendenteDto.getDataAssunzione());
                dipendente.setStipendio(dipendenteDto.getStipendio());
                Dipartimento dipartimento = dipartimentoDao.findById(dipendenteDto.getDipartimento()).get();
                List<Integer> ruoliId = dipendenteDto.getRuoli();
                List<Ruolo> ruoli = new ArrayList<>();
                if (dipartimento != null && !ruoliId.isEmpty()) {
                    dipendente.setDipartimento(dipartimento);
                    ruoliId.forEach(id -> ruoli.add(ruoloDao.findById(id).get()));
                    dipendente.setRuoli(ruoli);
                    dipendenteDao.save(dipendente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un dipendente in base al suo ID.
     * 
     * @param id l'ID del dipendente da eliminare
     */
    @Override
    public void deleteDipendenteById(int id) {
        try {
            Optional<Dipendente> dipendenteOptional = dipendenteDao.findById(id);
            if (dipendenteOptional.isPresent()) {
                dipendenteDao.delete(dipendenteOptional.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Restituisce una lista di tutti i dipendenti registrati.
     * 
     * @return una lista di DTO dei dipendenti
     */
    @Override
    public List<DipendenteDto> getAllDipendenti() {
        try {
            List<Dipendente> dipendenti = (List<Dipendente>) dipendenteDao.findAll();
            List<DipendenteDto> dipendentiDto = new ArrayList<>();
            dipendenti.forEach(d -> dipendentiDto.add(mapper.map(d, DipendenteDto.class)));
            return dipendentiDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Restituisce i dati di un dipendente in base al suo ID.
     * 
     * @param id l'ID del dipendente da recuperare
     * @return un DTO contenente i dati del dipendente, o {@code null} se non trovato
     */
    @Override
    public DipendenteDto getDipendenteById(int id) {
        try {
            Optional<Dipendente> dipendenteOptional = dipendenteDao.findById(id);
            if (dipendenteOptional.isPresent()) {
                Dipendente dipendente = dipendenteOptional.get();
                return mapper.map(dipendente, DipendenteDto.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cerca dipendenti in base al nome fornito.
     * 
     * @param nomeDipendente il nome del dipendente da cercare
     * @return una lista di DTO dei dipendenti con il nome specificato
     */
    @Override
    public List<DipendenteDto> getDipendentiByNome(String nomeDipendente) {
        try {
            List<Dipendente> dipendenti = dipendenteDao.findByNome(nomeDipendente);
            List<DipendenteDto> dipendentiDto = new ArrayList<>();
            if (!dipendenti.isEmpty()) {
                dipendenti.forEach(d -> dipendentiDto.add(mapper.map(d, DipendenteDto.class)));
                return dipendentiDto;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cerca dipendenti in base al dipartimento.
     * 
     * @param nomeDipartimento il nome del dipartimento da cercare
     * @return una lista di DTO dei dipendenti nel dipartimento specificato
     */
    @Override
    public List<DipendenteByDipartimentoDto> getDipendentiByDipartimento(String nomeDipartimento) {
        try {
            NomeDipartimento nomeDipEnum = NomeDipartimento.valueOf(nomeDipartimento);
            Dipartimento dipartimento = dipartimentoDao.findByNome(nomeDipEnum);
            List<Dipendente> dipendenti = dipendenteDao.findByDipartimento(dipartimento);
            List<DipendenteByDipartimentoDto> dipendentiDto = new ArrayList<>();
            if (!dipendenti.isEmpty()) {
                dipendenti.forEach(d -> dipendentiDto.add(mapper.map(d, DipendenteByDipartimentoDto.class)));
                return dipendentiDto;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cerca dipendenti in base al ruolo.
     * 
     * @param nomeRuolo il nome del ruolo da cercare
     * @return una lista di DTO dei dipendenti con il ruolo specificato
     */
    @Override
    public List<DipendenteByRuoloDto> getDipendentiByRuolo(String nomeRuolo) {
        try {
            NomeRuolo nomeRuoloEnum = NomeRuolo.valueOf(nomeRuolo);
            List<Dipendente> dipendenti = dipendenteDao.findByRuolo(nomeRuoloEnum);
            List<DipendenteByRuoloDto> dipendentiDto = new ArrayList<>();
            if (!dipendenti.isEmpty()) {
                dipendenti.forEach(d -> dipendentiDto.add(mapper.map(d, DipendenteByRuoloDto.class)));
                return dipendentiDto;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
