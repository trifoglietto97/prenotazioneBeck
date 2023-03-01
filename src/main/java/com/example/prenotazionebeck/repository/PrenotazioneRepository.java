package com.example.prenotazionebeck.repository;

import com.example.prenotazionebeck.entity.Prenotazione;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {


    List<Prenotazione> findAllByNomePrenotazione(String nome);
    List<Prenotazione> findAllByEmail(String email);
    void deleteByIdPrenotazione(Long id);
    public Prenotazione findByIdPrenotazione(Long id);
    List<Prenotazione> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Prenotazione> findAllByNomePrenotazioneContains(String var); //cerca nome

    Prenotazione save(Prenotazione p);
    List<Prenotazione> findAll();


    Page<Prenotazione> findByNomePrenotazioneContaining(String title, Pageable pageable);


}
