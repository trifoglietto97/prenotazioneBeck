package com.example.prenotazionebeck.controller;

import com.example.prenotazionebeck.entity.Prenotazione;
import com.example.prenotazionebeck.repository.PrenotazioneRepository;
import com.example.prenotazionebeck.service.PrenotazioneService;
import jakarta.activation.MimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;




    @GetMapping("/prenotazione/getAll")
    public List<Prenotazione> getAll(){
        List<Prenotazione> result = prenotazioneService.getAll();
        System.out.println("NUMERO DI RISULTATI " + result.size());
        return result;
    }

    @PostMapping("/prenotazione")
    public Prenotazione add(@RequestBody Prenotazione prenotazione){
        return prenotazioneService.save(prenotazione);
    }

    @PutMapping("/prenotazione/{id}")
    public ResponseEntity<Prenotazione> updatePersona(@PathVariable(value = "id") Long id, @RequestBody Prenotazione p){

        Prenotazione prenotazione = prenotazioneService.findById(id);

        prenotazione.setEmail(p.getEmail());
        prenotazione.setNomePrenotazione(p.getNomePrenotazione());
        prenotazione.setDate(p.getDate());

        final Prenotazione updatedP = prenotazioneService.save(prenotazione);
        return ResponseEntity.ok(updatedP);
    }



//fare tutto con localdatetime


    @GetMapping("/prenotazione")
    public List<Prenotazione> getList(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime date1,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime date2){
        return prenotazioneService.listTo(date1,date2);
    }

    @RequestMapping(value = "/pageOf", method = RequestMethod.GET)
    public Page<Prenotazione> pageOf(@RequestParam(defaultValue = "0",required = false) Integer page, @RequestParam(defaultValue = "10", required = false) Integer size) {
        return prenotazioneService.gePagination(page, size);
    }

    @DeleteMapping("/prenotazione/{id}")
    public void deleteById(@PathVariable Long id){
        prenotazioneService.deleteById(id);
    }

    @GetMapping("/search/{var}")
    public List<Prenotazione> findName(@PathVariable String var){
        return prenotazioneService.findByName(var);
    }

    @GetMapping("/prenotazione/email/{var}")
    public List<Prenotazione> findByEmail(@PathVariable String var){
        return prenotazioneService.findByEmail(var);
    }


}
