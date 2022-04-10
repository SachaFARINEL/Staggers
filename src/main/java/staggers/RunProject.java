package staggers;

import dao.AdresseDAO;
import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

public class RunProject {


    public static void main(String[] args) {
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(EntrepriseDAO.getInstance().read(1));
        Utilisateur test = new Utilisateur(4, 2020, "BOLLORE", "Clément", null, "farinel.sacha@gmail.com",
                "0688972850", true, "masculin", "root", false, "étudiant");
        //System.out.println(UtilisateurDAO.getInstance().create(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));
        //System.out.println(UtilisateurDAO.getInstance().update(test));
        Adresse testAdresse = new Adresse(0, 7, "place", "Marianne", "Plescop", 56890, "Morbihan",
        "France", 1, 1);
        System.out.println(AdresseDAO.getInstance().create(testAdresse));
        Connexion.fermer();
    }

}
