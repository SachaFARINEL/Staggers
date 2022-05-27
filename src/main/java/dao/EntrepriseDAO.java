package dao;

import staggers.Entreprise;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    private static final String LANGAGE = "langage";


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

    private Entreprise getEntreprise(ResultSet rs) throws SQLException {
        Entreprise entreprise;
        int id = rs.getInt((CLE_PRIMAIRE));
        String nom = rs.getString(NOM);
        String email = rs.getString(EMAIL);
        String num_tel = rs.getString(NUM_TEL);
        String nom_contact = rs.getString(NOM_CONTACT);
        String email_contact = rs.getString(EMAIL_CONTACT);
        String num_contact = rs.getString(NUM_CONTACT);
        String nb_salarie = rs.getString(NB_SALARIE);
        String nb_stagiaire_max = rs.getString(NB_STAGIAIRE_MAX);
        String description = rs.getString(DESCRIPTION);
        String langage = rs.getString(LANGAGE);
        entreprise = new Entreprise(id, nom, email, num_tel, nom_contact, email_contact, num_contact, nb_salarie, nb_stagiaire_max, description, langage);
        return entreprise;
    }

    @Override
    public boolean create(Entreprise obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NOM + "," + EMAIL + "," + NUM_TEL + "," + NOM_CONTACT + "," + EMAIL_CONTACT + "," +
                    "" + NUM_CONTACT + "," + NB_SALARIE + "," + NB_STAGIAIRE_MAX + "," + DESCRIPTION + "," + LANGAGE + ") " +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getEmail());
            pst.setString(3, obj.getNum_tel());
            pst.setString(4, obj.getnom_contact());
            pst.setString(5, obj.getEmail_contact());
            pst.setString(6, obj.getNum_contact());
            pst.setString(7, obj.getNb_salarie());
            pst.setString(8, obj.getnb_stagiaire_max());
            pst.setString(9, obj.getDescription());
            pst.setString(10, obj.getLangage());

            // on exécute la mise à jour
            pst.executeUpdate();
            //Récupérer la clé qui a été générée et la pousser dans l'objet initial
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            donnees.put(obj.getId(), obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;

    }

    @Override
    public boolean delete(Entreprise obj) {
        boolean success = true;
        try {
            int id = obj.getId();
            String requete = "DELETE FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            donnees.remove(id);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean update(Entreprise obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NOM + " = ?, " + EMAIL + " = ?, " + NUM_TEL + " = ? , " + NOM_CONTACT + " = ?, " + EMAIL_CONTACT + " = ?, " + NUM_CONTACT + " = ?, " + NB_SALARIE + " = ?, " + NB_STAGIAIRE_MAX + " = ?,  " + DESCRIPTION + " = ?, " + LANGAGE + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getEmail());
            pst.setString(3, obj.getNum_tel());
            pst.setString(4, obj.getnom_contact());
            pst.setString(5, obj.getEmail_contact());
            pst.setString(6, obj.getNum_contact());
            pst.setString(7, obj.getNb_salarie());
            pst.setString(8, obj.getnb_stagiaire_max());
            pst.setString(9, obj.getDescription());
            pst.setString(10, obj.getLangage());
            pst.setInt(11, id);

            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
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

                entreprise = getEntreprise(rs);
                donnees.put(id, entreprise);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }

    public List<Entreprise> readAll() {
        Entreprise entreprise = null;
        List<Entreprise> listeEntreprise = null;
        try {
            String requete = "SELECT * FROM " + TABLE;
            ResultSet rs = Connexion.executeQuery(requete);
            listeEntreprise = new ArrayList<Entreprise>();
            boolean hasNext = rs.next();
            while (hasNext) {
                entreprise = getEntreprise(rs);
                listeEntreprise.add(entreprise);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeEntreprise;
    }

    public String getWithEmailEnt(String recherche, String mail) {
        String reponseRequete = null;
        System.out.println("Recherche dans la BD");
        try {
            String requete = "SELECT " + recherche + " FROM " + TABLE + " WHERE " + EMAIL + " = '" + mail + "'";
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            reponseRequete = rs.getString(recherche);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reponseRequete;
    }

    public List<Entreprise> chercherEntrepriseParNomLIKE(String dataUser) {
        Entreprise entreprise = null;
        List<Entreprise> listeEntreprise = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + NOM + " LIKE '" + dataUser + "%'";
            ResultSet rs = Connexion.executeQuery(requete);
            listeEntreprise = new ArrayList<Entreprise>();
            boolean hasNext = rs.next();
            while (hasNext) {
                entreprise = getEntreprise(rs);
                listeEntreprise.add(entreprise);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeEntreprise;
    }

    public List<Entreprise> chercherEntrepriseParLangageLIKE(String dataUser) {
        Entreprise entreprise = null;
        List<Entreprise> listeEntreprise = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + LANGAGE + " LIKE '%" + dataUser + "%'";
            ResultSet rs = Connexion.executeQuery(requete);
            listeEntreprise = new ArrayList<Entreprise>();
            boolean hasNext = rs.next();
            while (hasNext) {
                entreprise = getEntreprise(rs);
                listeEntreprise.add(entreprise);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeEntreprise;
    }


}

