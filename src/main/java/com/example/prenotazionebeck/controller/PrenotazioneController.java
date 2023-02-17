package com.example.prenotazionebeck.controller;

import com.example.prenotazionebeck.entity.Prenotazione;
import com.example.prenotazionebeck.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

import java.util.List;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/prenotazione")
    public Prenotazione add(@RequestBody Prenotazione prenotazione){
        return prenotazioneService.save(prenotazione);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePersona(@PathVariable(value = "id") Long id, @RequestBody Prenotazione p){

        Prenotazione prenotazione = prenotazioneService.findById(id);

        prenotazione.setEmail(p.getEmail());
        prenotazione.setNomePrenotazione(p.getNomePrenotazione());
        prenotazione.setListaOrari(p.getListaOrari());

        final Prenotazione updatedP = prenotazioneService.save(prenotazione);
        return ResponseEntity.ok(updatedP);
    }



//fare tutto con localdatetime


    @GetMapping
    public List<Prenotazione> getList(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime date1,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime date2){
        return prenotazioneService.listTo(date1,date2);
    }

    @RequestMapping(value = "/pageOf", method = RequestMethod.GET)
    public Page<Prenotazione> pageOf(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return prenotazioneService.gePagination(page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        prenotazioneService.deleteById(id);
    }

    @GetMapping("/name/{var}")
    public List<Prenotazione> findByName(@PathVariable String var){
        return prenotazioneService.findByName(var);
    }

    @GetMapping("/email/{var}")
    public List<Prenotazione> findByEmail(@PathVariable String var){
        return prenotazioneService.findByEmail(var);
    }


}
