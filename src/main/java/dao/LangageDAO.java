package dao;

import staggers.Entreprise;
import staggers.Langage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LangageDAO extends DAO<Langage> {

    private static final String TABLE = "LANGAGE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String LIBELLE = "libelle";

    private static LangageDAO instance = null;

    public static LangageDAO getInstance() {
        if (instance == null) {
            instance = new LangageDAO();
        }
        return instance;
    }

    private LangageDAO() {
        super();
    }

    @Override
    public boolean create(Langage obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + LIBELLE + ") " +
                    "VALUES (?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setString(1, obj.getLibelle());
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
    public boolean delete(Langage obj) {
        return false;
    }

    @Override
    public boolean update(Langage obj) {
        return false;
    }

    @Override
    public Langage read(int id) {
        return null;
    }

    public Langage readWithLibelleLangage(String nomTechno) {
        Langage langage = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + LIBELLE + " = '" + nomTechno + "'";
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            int id = rs.getInt(CLE_PRIMAIRE);
            String libelle = rs.getString(LIBELLE);
            langage = new Langage(id, libelle);
        } catch (SQLException e) {
            System.out.println("le langage n'est pas en BD");
        }
        return langage;
    }

    public List<Langage> getListeLangage(int id) {
        Langage langage;
        List<Langage> listeLangage = null;
        try {
            String requete = "SELECT * FROM ASSO_ENTREPRISE_LANGAGE A JOIN LANGAGE L ON A.id_langage = L.id WHERE id_entreprise = " + id ;
            ResultSet rs = Connexion.executeQuery(requete);
            listeLangage = new ArrayList<>();
            boolean hasNext = rs.next();
            while (hasNext) {
                int idLangage = rs.getInt(CLE_PRIMAIRE);
                String libelle = rs.getString(LIBELLE);
                langage = new Langage(idLangage, libelle);
                listeLangage.add(langage);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeLangage;
    }
}
