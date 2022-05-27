package dao;

import staggers.Conseil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConseilDAO extends DAO<Conseil> {

    private static final String TABLE = "CONSEIL";
    private static final String CLE_PRIMAIRE = "id";


    private static final String CONSEIL = "conseil";


    private static ConseilDAO instance = null;

    public static ConseilDAO getInstance() {
        if (instance == null) {
            instance = new ConseilDAO();
        }
        return instance;
    }


    @Override
    public boolean create(Conseil obj) {
        boolean succes = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + CONSEIL + ") " +
                    "VALUES (?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion

            pst.setString(1, obj.getConseils());


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
    public boolean delete(Conseil obj) {
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
    public boolean update(Conseil obj) {

        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + CONSEIL + "= ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

            pst.setString(1, obj.getConseils());

            pst.setInt(2, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }


    @Override
    public Conseil read(int id) {
        Conseil conseil = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            conseil = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();

                String conseils = rs.getString(CONSEIL);

                conseil = new Conseil(id, conseils);
                donnees.put(id, conseil);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conseil;
    }


}
