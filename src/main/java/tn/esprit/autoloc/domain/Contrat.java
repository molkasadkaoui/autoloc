package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;

    @Column(precision = 10, scale = 2)
    private BigDecimal montantTotal;

    private Boolean valide;

    // 1 Contrat → 1 Reservation
    @OneToOne(mappedBy = "contrat")
    private Reservation reservation;

    // 1 Contrat → N Paiements
    @OneToMany(
            mappedBy = "contrat",
            cascade = CascadeType.ALL
    )
    private List<Paiement> paiements;
}