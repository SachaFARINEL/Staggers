package dao;

import staggers.Adresse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdresseDAO extends DAO<Adresse> {

    private static final String TABLE = "ADRESSE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String NUMERO = "numero";
    private static final String TYPE_DE_VOIE = "type_de_voie";
    private static final String ADRESSE = "adresse";
    private static final String VILLE = "ville";
    private static final String CODE_POSTAL = "code_postal";
    private static final String DEPARTEMENT = "departement";
    private static final String PAYS = "pays";
    private static final String ID_UTILISATEUR = "id_utilisateur";
    private static final String ID_ENTREPRISE = "id_entreprise";

    private static AdresseDAO instance = null;

    public static AdresseDAO getInstance() {
        if (instance == null) {
            instance = new AdresseDAO();
        }
        return instance;
    }

    private AdresseDAO() {
        super();
    }

    @Override
    public boolean create(Adresse obj) {
        boolean succes = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NUMERO + "," + TYPE_DE_VOIE + "," + ADRESSE + "," + VILLE + "," + CODE_POSTAL + "," + DEPARTEMENT + "," +
                    "" + PAYS + "," + ID_UTILISATEUR + "," + ID_ENTREPRISE + ") " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setInt(1, obj.getNumero());
            pst.setString(2, obj.getType_de_voie());
            pst.setString(3, obj.getAdresse());
            pst.setString(4, obj.getVille());
            pst.setInt(5, obj.getCode_postal());
            pst.setString(6, obj.getDepartement());
            pst.setString(7, obj.getPays());
            pst.setInt(8, obj.getId_utilisateur());
            pst.setInt(9, obj.getId_entreprise());

            // on exécute la mise à jour
            pst.executeUpdate();
            //Récupérer la clé qui a été générée et la pousser dans l'objet initial
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            donnees.put(obj.getId(), obj);
        } catch (SQLException e) {
            succes = false;
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public boolean delete(Adresse obj) {
        return false;
    }

    @Override
    public boolean update(Adresse obj) {
        return false;
    }

    @Override
    public Adresse read(int id) {
        return null;
    }

}
