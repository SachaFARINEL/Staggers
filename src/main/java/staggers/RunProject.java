package staggers;

import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

public class RunProject {




    public static void main(String[] args) {
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(EntrepriseDAO.getInstance().read(1));
        Utilisateur test = new Utilisateur(3,2020, "TEST", "MAURICE",null , "farinel.sacha@gmail.com",
        "0688972850", true, "masculin", "root", false, "étudiant");
        //System.out.println(UtilisateurDAO.getInstance().create(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));
        System.out.println(UtilisateurDAO.getInstance().update(test));

        //Connexion.fermer();
    }

}
