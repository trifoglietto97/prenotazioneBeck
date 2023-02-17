package com.example.prenotazionebeck.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOra;
    private LocalDateTime date;
}
