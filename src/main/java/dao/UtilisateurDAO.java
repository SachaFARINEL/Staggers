package dao;

import staggers.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {


    private static final String TABLE = "AVION";
    private static final String CLE_PRIMAIRE = "numAv";

    private static final String NOM_AV = "nomAv";
    private static final String LOCALISATION = "loc";
    private static final String CAPACITE = "capacite";

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
        return null;
    }
}
