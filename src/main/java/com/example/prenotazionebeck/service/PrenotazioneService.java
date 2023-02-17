package com.example.prenotazionebeck.service;

import com.example.prenotazionebeck.entity.Prenotazione;
import com.example.prenotazionebeck.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public List<Prenotazione> findAllByString(String var){
        return prenotazioneRepository.findAllByNomePrenotazioneContains(var);
    }

    public List<Prenotazione> findByName(String name){
        return prenotazioneRepository.findAllByNomePrenotazione(name);
    }

    public List<Prenotazione> findByEmail(String email){
        return prenotazioneRepository.findAllByEmail(email);
    }

    public void delete(Long id){
        prenotazioneRepository.deleteByIdPrenotazione(id);
    }

    public Prenotazione findById(Long id){
        return prenotazioneRepository.findByIdPrenotazione(id);
    }

    public Prenotazione save(Prenotazione p){
        return prenotazioneRepository.save(p);
    }

    public List<Prenotazione> getAll(){
        return prenotazioneRepository.findAll();
    }

    public List<Prenotazione> listTo(LocalDateTime date1, LocalDateTime date2){
        return prenotazioneRepository.findAllByListaOrari_DateBetween(date1, date2);
    }

    public Page<Prenotazione> gePagination(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nomePrenotazione");
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return prenotazioneRepository.findAll(pageable);
    }

    public void deleteById(Long id){
        prenotazioneRepository.deleteById(id);
    }

}

