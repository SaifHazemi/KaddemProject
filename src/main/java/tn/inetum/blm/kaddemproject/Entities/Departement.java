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
public class Departement {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDepart;
    String nomDepart;
    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;
}


