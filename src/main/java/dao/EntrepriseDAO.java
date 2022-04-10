package dao;

import staggers.Entreprise;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EntrepriseDAO extends DAO<Entreprise> {

    private static final String TABLE = "ENTREPRISE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String NOM = "nom";
    private static final String EMAIL = "email";
    private static final String NUM_TEL = "num_tel";
    private static final String NOM_CONTACT = "nom_contact";
    private static final String EMAIL_CONTACT = "email_contact";
    private static final String NUM_CONTACT = "num_contact";
    private static final String NB_SALARIE = "nb_salarie";
    private static final String NB_STAGIAIRE_MAX = "nb_stagiaire_max";
    private static final String DESCRIPTION = "description";
    private static final String EST_FAVORIS = "est_favoris";

    private static EntrepriseDAO instance = null;

    public static EntrepriseDAO getInstance() {
        if (instance == null) {
            instance = new EntrepriseDAO();
        }
        return instance;
    }

    public EntrepriseDAO() {
        super();
    }

    @Override
    public boolean create(Entreprise obj) {
        return false;
    }

    @Override
    public boolean delete(Entreprise obj) {
        return false;
    }

    @Override
    public boolean update(Entreprise obj) {
        return false;
    }

    @Override
    public Entreprise read(int id) {
        Entreprise entreprise = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            entreprise = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();

                String nom = rs.getString(NOM);
                String email = rs.getString(EMAIL);
                String num_tel = rs.getString(NUM_TEL);
                String nom_contact = rs.getString(NOM_CONTACT);
                String email_contact = rs.getString(EMAIL_CONTACT);
                String num_contact = rs.getString(NUM_CONTACT);
                int nb_salarie = rs.getInt(NB_SALARIE);
                int nb_stagiaire_max = rs.getInt(NB_STAGIAIRE_MAX);
                String description = rs.getString(DESCRIPTION);
                boolean est_favoris = rs.getBoolean(EST_FAVORIS);

                entreprise = new Entreprise(id, nom, email, num_tel, nom_contact, email_contact, num_contact, nb_salarie, nb_stagiaire_max, description, est_favoris);
                donnees.put(id, entreprise);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }
}

