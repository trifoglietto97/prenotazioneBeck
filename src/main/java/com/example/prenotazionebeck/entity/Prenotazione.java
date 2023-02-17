package com.example.prenotazionebeck.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrenotazione;

    private String nomePrenotazione;
    private String email;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "idPrenotazione", referencedColumnName = "idPrenotazione")
    private List<Orari> listaOrari;
}
