package dao;

import staggers.Entreprise;
import staggers.Favoris;
import staggers.Utilisateur;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static utils.Utils.hashPass;

public class FavorisDAO extends DAO<Favoris> {

    private static final String TABLE = "FAVORIS";
    private static final String ID_UTILISATEUR = "id_utilisateur";
    private static final String ID_ENTREPRISE = "id_entreprise";

    private static FavorisDAO instance = null;

    public static FavorisDAO getInstance() {
        if (instance == null) {
            instance = new FavorisDAO();
        }
        return instance;
    }

    private FavorisDAO() {
        super();
    }


    @Override
    public boolean create(Favoris obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + ID_UTILISATEUR + "," + ID_ENTREPRISE + ") " +
                    "VALUES (?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setInt(1, obj.getId_utilisateur());
            pst.setInt(2, obj.getId_entreprise());

            // on exécute la mise à jour
            pst.executeUpdate();
            //Récupérer la clé qui a été générée et la pousser dans l'objet initial
            ResultSet rs = pst.getGeneratedKeys();

        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean delete(Favoris obj) {
        boolean success = true;
        try {
            int id_utilisateur = obj.getId_utilisateur();
            int id_entreprise = obj.getId_entreprise();

            String requete = "DELETE FROM " + TABLE + " WHERE " + ID_UTILISATEUR + " = ? AND " + ID_ENTREPRISE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, id_utilisateur);
            pst.setInt(2, id_entreprise);
            pst.executeUpdate();
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean update(Favoris obj) {
        return false;
    }

    @Override
    public Favoris read(int id) {
        return null;
    }

    public List<Favoris> readAllWithId(int id_utilisateur) {
        Favoris favoris;
        List<Favoris> listeFavoris =null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + ID_UTILISATEUR + " = " + id_utilisateur ;
            ResultSet rs = Connexion.executeQuery(requete);
            listeFavoris = new ArrayList<Favoris>();
            boolean hasNext = rs.next();
            while (hasNext) {
                int id_util = rs.getInt(ID_UTILISATEUR);
                int id_entreprise = rs.getInt(ID_ENTREPRISE);
                favoris = new Favoris(id_util, id_entreprise);
                listeFavoris.add(favoris);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeFavoris;
    }

    public boolean isFavoris (int id_utilisateur, int id_entreprise) {
        boolean isFavoris = false;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + ID_UTILISATEUR + " = " + id_utilisateur + " AND " + ID_ENTREPRISE + " = " + id_entreprise;
            ResultSet rs = Connexion.executeQuery(requete);
            if (rs.next()) {
                isFavoris = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isFavoris;
    }
}
