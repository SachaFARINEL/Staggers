package staggers;

import dao.AdresseDAO;
import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static utils.Utils.isPasswordCorrect;

public class RunProject {


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        /* Utilisateur */

        Utilisateur test = new Utilisateur(4, 2020, "BOLLORE", "Clément", null, "farinel.sacha@gmail.com",
                "0688972850", true, "masculin", "root", false, "étudiant");
        //System.out.println(UtilisateurDAO.getInstance().create(test));
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(UtilisateurDAO.getInstance().update(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));

        /* Entreprise */

        //System.out.println(EntrepriseDAO.getInstance().read(1));

        /* Adresse */

        Adresse testAdresse = new Adresse(0, 7, "place", "Marianne", "Plescop", 56890, "Morbihan",
                "France", 1, 1);
        //System.out.println(AdresseDAO.getInstance().create(testAdresse));
        //System.out.println(AdresseDAO.getInstance().update(testAdresse));
        //System.out.println(AdresseDAO.getInstance().read(2));
        //System.out.println(AdresseDAO.getInstance().delete(testAdresse));

        /* Mot de passe */
        //System.out.println(isPasswordCorrect("root", "1000:d498fd8f028afcc6195981ec9088b577:53601e70c9c2ac44c5596e2e3c6d5db051bedd223ca308ee150eeb1f8b57211ac7b359ac5c16d0a6c2607abf673e5a27943b228874c338a1a32007e1b54532ab"));


        Connexion.fermer();
    }

}
