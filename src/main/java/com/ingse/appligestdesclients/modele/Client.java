package com.ingse.appligestdesclients.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data  @AllArgsConstructor   @NoArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String entreprise;
    private Long numeroTVA;
    private Long siret;
    private String adresse;
    private String telephone;
    private String email;
    private int nombreDePaiements;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDePaiements;
    //numéro tva de type long
    //numéro siret de type long
    //Tester le depot distant gitHub


}
