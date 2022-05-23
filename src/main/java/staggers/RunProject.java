package staggers;

import dao.AdresseDAO;
import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

import java.util.List;

public class RunProject {


    public static void main(String[] args) {

        /* Utilisateur */

        Utilisateur test = new Utilisateur(4, "BOLLORE", "Clément", null, "sio@sio",
                "0688972850", true, "masculin", "sio", false, "étudiant", "Ratus");
        //System.out.println(UtilisateurDAO.getInstance().create(test));
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(UtilisateurDAO.getInstance().update(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));
        //System.out.println(UtilisateurDAO.getInstance().getPasswordWithEmail("test"));
        //System.out.println(UtilisateurDAO.getInstance().updatePassword("sio", "sio@sio"));

        /* Entreprise */

        //System.out.println(EntrepriseDAO.getInstance().read(1));

        List listeEntreprise = EntrepriseDAO.getInstance().readAll();
        //System.out.println(listeEntreprise.get(1));

        /* Adresse */

        //Adresse testAdresse = new Adresse(0, 7, "place", "Marianne", "Plescop", 56890, "Morbihan",
        //        "France", 1, 1);
        //System.out.println(AdresseDAO.getInstance().create(testAdresse));
        //System.out.println(AdresseDAO.getInstance().update(testAdresse));
        //System.out.println(AdresseDAO.getInstance().read(2));
        //System.out.println(AdresseDAO.getInstance().delete(testAdresse));

        Connexion.fermer();
    }

}
