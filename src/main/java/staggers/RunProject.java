package staggers;

import dao.AdresseDAO;
import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

public class RunProject {


    public static void main(String[] args) {

        /* Utilisateur */

        Utilisateur test = new Utilisateur(4, 2020, "BOLLORE", "Clément", null, "sio@sio",
                "0688972850", true, "masculin", "sio", false, "étudiant", "Ratus");
        //System.out.println(UtilisateurDAO.getInstance().create(test));
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(UtilisateurDAO.getInstance().update(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));
        //System.out.println(UtilisateurDAO.getInstance().getPasswordWithEmail("test"));
        //System.out.println(UtilisateurDAO.getInstance().updatePassword("sio", "sio@sio"));

        /* Entreprise */

        //System.out.println(EntrepriseDAO.getInstance().read(1));

        /* Adresse */

        Adresse testAdresse = new Adresse(0, 7, "place", "Marianne", "Plescop", 56890,  1, 1);
        //System.out.println(AdresseDAO.getInstance().create(testAdresse));
        //System.out.println(AdresseDAO.getInstance().update(testAdresse));
        //System.out.println(AdresseDAO.getInstance().read(2));
        //System.out.println(AdresseDAO.getInstance().delete(testAdresse));

        Connexion.fermer();
    }

}
