package tn.inetum.blm.kaddemproject.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDetailEquipe;
    int salle;
    String thematique;
    @OneToOne(mappedBy = "detailequipe")
    private Equipe equipe;
}
