package com.app.vente_vehiculews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;

@Entity

/*fiche annonce
@NamedNativeQuery(
        name="getAnnonce",
        query = "select * from v_listannonce_utilisateur where idannonce=?1",
        resultClass=AnnonceDetails.class
)*/

public class AnnonceDetails extends Annonce{

    @Override
    public String toString() {
        return "AnnonceDetails{" +
                "idannonce=" + idannonce +
                ",idutilisateur=" + idutilisateur +
                ", titre='" + titre +
                ", photo=" + photo +
                ", prix=" + prix +
                ", statusvente=" + statusvente +
                ", validation_annonce=" + validation_annonce +
                '}';
    }
}
