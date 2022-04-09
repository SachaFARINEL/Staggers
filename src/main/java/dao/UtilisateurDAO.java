package dao;

import staggers.Utilisateur;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UtilisateurDAO extends DAO<Utilisateur> {


    private static final String TABLE = "UTILISATEUR";
    private static final String CLE_PRIMAIRE = "id";

    private static final String PROMO = "promo";
    private static final String NOM = "nom";
    private static final String PRENOM = "prenom";
    private static final String DATE_NAISSANCE = "date_naissance";
    private static final String EMAIL = "email";
    private static final String NUM_TEL = "num_tel";
    private static final String ADMIS_STAGE = "admis_stage";
    private static final String SEXE = "sexe";
    private static final String MOT_DE_PASSE = "mot_de_passe";
    private static final String EST_ADMIN = "est_admin";
    private static final String ROLE = "role";

    private static UtilisateurDAO instance=null;

    public static UtilisateurDAO getInstance(){
        if (instance==null){
            instance = new UtilisateurDAO();
        }
        return instance;
    }

    private UtilisateurDAO() {
        super();
    }

    @Override
    public boolean create(Utilisateur obj) {
        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) {
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) {
        return false;
    }

    @Override
    public Utilisateur read(int id) {
        Utilisateur utilisateur = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            utilisateur=donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                int promo = rs.getInt(PROMO);
                String nom = rs.getString(NOM);
                String prenom = rs.getString(PRENOM);
                Date date_naissance = rs.getDate(DATE_NAISSANCE);
                String email = rs.getString(EMAIL);
                String num_tel = rs.getString(NUM_TEL);
                boolean admis_stage = rs.getBoolean(ADMIS_STAGE);
                String sexe = rs.getString(SEXE);
                String mot_de_passe = rs.getString(MOT_DE_PASSE);
                boolean est_admin = rs.getBoolean(EST_ADMIN);
                String role = rs.getString(ROLE);
                utilisateur = new Utilisateur (id, promo, nom, prenom, date_naissance, email, num_tel, admis_stage, sexe, mot_de_passe, est_admin, role);
                donnees.put(id, utilisateur);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return utilisateur;
    }


}
