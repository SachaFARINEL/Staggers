package dao;

import staggers.Commentaire;
import staggers.Entreprise;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentaireDAO extends DAO<Commentaire> {

    private static final String TABLE = "COMMENTAIRE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String ID_UTILISATEUR = "id_utilisateur";
    private static final String ID_ENTREPRISE = "id_entreprise";
    private static final String COM = "com";
    private static final String DATE = "date";

    private static CommentaireDAO instance = null;

    public static CommentaireDAO getInstance() {
        if (instance == null) {
            instance = new CommentaireDAO();
        }
        return instance;


    }

    private CommentaireDAO() {
        super();
    }

    @Override
    public boolean create(Commentaire obj) {
        boolean succes = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + ID_UTILISATEUR + "," + ID_ENTREPRISE + "," + COM + "," + DATE + ")" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setInt(1, obj.getId_utilisateur());
            pst.setInt(2, obj.getId_entreprise());
            pst.setString(3, obj.getCom());
            pst.setObject(4, obj.getDate());


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
    public boolean delete(Commentaire obj) {
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
    public boolean update(Commentaire obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + ID_UTILISATEUR + " = ?, " + ID_ENTREPRISE + " = ?, " + COM + " = ? , " + DATE + " = ? " +
                    " WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, obj.getId_utilisateur());
            pst.setInt(2, obj.getId_entreprise());
            pst.setString(3, obj.getCom());
            pst.setObject(4, obj.getDate());
            pst.setInt(5, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Commentaire read(int id) {
        Commentaire commentaire = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            commentaire = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                int id_utilisateur = rs.getInt(ID_UTILISATEUR);
                int id_entreprise = rs.getInt(ID_ENTREPRISE);
                String com = rs.getString(COM);
                LocalDateTime date = rs.getObject(DATE, LocalDateTime.class);

                commentaire = new Commentaire(id, id_utilisateur, id_entreprise, com, date);
                donnees.put(id, commentaire);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return commentaire;
    }

    public List<Commentaire> readAll(int id_entrepriseSelected) {
        Commentaire commentaire = null;
        List<Commentaire> listeCommentaire =null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE id_entreprise = " + id_entrepriseSelected;
            ResultSet rs = Connexion.executeQuery(requete);
            listeCommentaire = new ArrayList<Commentaire>();
            boolean hasNext = rs.next();
            while (hasNext) {
                int id = rs.getInt(CLE_PRIMAIRE);
                int id_utilisateur = rs.getInt(ID_UTILISATEUR);
                int id_entreprise = rs.getInt(ID_ENTREPRISE);
                String com = rs.getString(COM);
                LocalDateTime date = rs.getObject(DATE, LocalDateTime.class);
                commentaire = new Commentaire(id, id_utilisateur, id_entreprise, com, date);
                listeCommentaire.add(commentaire);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCommentaire;
    }
}

