package tn.inetum.blm.kaddemproject.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idEtudiant;
    String prenomE;
    String nomE;
    Option option;
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
    @ManyToMany
    private List<Equipe> equipeList ;
    @ManyToOne
    private Departement departement;

}
