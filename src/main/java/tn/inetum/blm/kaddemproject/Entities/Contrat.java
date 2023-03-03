package tn.inetum.blm.kaddemproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contrat {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idContrat;
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive;
    private Integer montantContrat;
    @ManyToOne
    @JsonIgnore
    private Etudiant etudiant;
}
