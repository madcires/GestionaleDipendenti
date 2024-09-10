package it.corso.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.corso.dto.DipendenteByDipartimentoDto;
import it.corso.dto.DipendenteByRuoloDto;
import it.corso.dto.DipendenteDto;
import it.corso.dto.DipendenteDtoRegistration;
import it.corso.dto.DipendenteDtoUpdate;
import it.corso.service.DipendenteService;
import jakarta.validation.Valid;

/**
 * La classe {@code DipendenteController} gestisce le richieste HTTP relative alle operazioni sui dipendenti.
 * Fornisce vari endpoint per registrare, aggiornare, eliminare e recuperare dipendenti,
 * oltre a fornire metodi per cercare i dipendenti tramite nome, dipartimento o ruolo.
 * 
 * @author Madalina Cires
 * @author Giorgia Alloisio
 * @author Alessia Boasi
 * 
 */
@RestController
@RequestMapping("/api/dipendente")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    /**
     * Endpoint per registrare un nuovo dipendente.
     * Valida l'input e verifica che i ruoli forniti abbiano il formato corretto.
     *
     * @param dipendenteDto il DTO del dipendente da registrare
     * @return una risposta 200 OK in caso di successo, 400 Bad Request in caso di errore
     */
    @PostMapping("/registration")
    public ResponseEntity<Void> registrationDipendente(@Valid @RequestBody DipendenteDtoRegistration dipendenteDto) {
        try {
            List<String> nomiRuolo = dipendenteDto.getRuoli();
            for (String ruolo : nomiRuolo) {
                if (!Pattern.matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$", ruolo)) {
                    return ResponseEntity.badRequest().build();
                }
            }
            dipendenteService.registrationDipendente(dipendenteDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per ottenere tutti i dipendenti.
     *
     * @return una lista di {@link DipendenteDto} o una risposta 400 Bad Request in caso di errore
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<DipendenteDto>> getAllDipendenti() {
        try {
            List<DipendenteDto> dipendenti = dipendenteService.getAllDipendenti();
            return ResponseEntity.ok(dipendenti);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per ottenere un dipendente tramite il suo ID.
     *
     * @param id l'ID del dipendente
     * @return un {@link DipendenteDto} o una risposta 400 Bad Request se l'ID è invalido
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<DipendenteDto> getDipendenteById(@PathVariable int id) {
        try {
            if (id > 0) {
                DipendenteDto dipendenteDto = dipendenteService.getDipendenteById(id);
                return ResponseEntity.ok(dipendenteDto);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per cercare dipendenti tramite nome.
     * Normalizza il nome rimuovendo gli spazi e capitalizzando correttamente.
     *
     * @param nome il nome del dipendente da cercare
     * @return una lista di {@link DipendenteDto} o una risposta 400 Bad Request in caso di errore
     */
    @GetMapping("/get/nomeDipendente")
    public ResponseEntity<List<DipendenteDto>> getDipendenteByNome(@RequestParam(required = false) String nome) {
        try {
            if (nome != null && !nome.isEmpty()) {
                String nomeSenzaSpazi = nome.replaceAll("\\s+", "");
                String nomeConvertito = nomeSenzaSpazi.substring(0, 1).toUpperCase() + nomeSenzaSpazi.substring(1).toLowerCase();
                List<DipendenteDto> dipendentiDto = dipendenteService.getDipendentiByNome(nomeConvertito);
                return ResponseEntity.ok(dipendentiDto);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per cercare dipendenti tramite il dipartimento.
     *
     * @param dipartimento il nome del dipartimento da cercare
     * @return una lista di {@link DipendenteByDipartimentoDto} o una risposta 400 Bad Request in caso di errore
     */
    @GetMapping("/get/nomeDipartimento")
    public ResponseEntity<List<DipendenteByDipartimentoDto>> getDipendenteByDipartimento(@RequestParam(required = false) String dipartimento) {
        try {
            if (dipartimento != null && !dipartimento.isEmpty()) {
                List<DipendenteByDipartimentoDto> dipendentiDto = dipendenteService.getDipendentiByDipartimento(dipartimento);
                return ResponseEntity.ok(dipendentiDto);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per cercare dipendenti tramite il ruolo.
     *
     * @param ruolo il nome del ruolo da cercare
     * @return una lista di {@link DipendenteByRuoloDto} o una risposta 400 Bad Request in caso di errore
     */
    @GetMapping("/get/nomeRuolo")
    public ResponseEntity<List<DipendenteByRuoloDto>> getDipendenteByRuolo(@RequestParam(required = false) String ruolo) {
        try {
            if (ruolo != null && !ruolo.isEmpty()) {
                List<DipendenteByRuoloDto> dipendentiDto = dipendenteService.getDipendentiByRuolo(ruolo);
                return ResponseEntity.ok(dipendentiDto);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per modificare i dati di un dipendente.
     *
     * @param dipendenteDto il DTO contenente i dati aggiornati del dipendente
     * @return una risposta 200 OK in caso di successo, 400 Bad Request in caso di errore
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateDipendenteData(@RequestBody DipendenteDtoUpdate dipendenteDto) {
        try {
            dipendenteService.updateDipendenteData(dipendenteDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint per eliminare un dipendente tramite il suo ID.
     *
     * @param id l'ID del dipendente da eliminare
     * @return una risposta 200 OK in caso di successo, 400 Bad Request se l'ID è invalido
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDipendenteById(@PathVariable int id) {
        try {
            if (id > 0) {
                dipendenteService.deleteDipendenteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
