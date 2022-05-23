package dao;

import staggers.Adresse;
import staggers.Entreprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdresseDAO extends DAO<Adresse> {

    private static final String TABLE = "ADRESSE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String NUMERO = "numero";
    private static final String TYPE_DE_VOIE = "type_de_voie";
    private static final String ADRESSE = "adresse";
    private static final String VILLE = "ville";
    private static final String CODE_POSTAL = "code_postal";
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
            String requete = "INSERT INTO " + TABLE + " (" + NUMERO + "," + TYPE_DE_VOIE + "," + ADRESSE + "," + VILLE + "," + CODE_POSTAL + "," +
                    "" + ID_UTILISATEUR + "," + ID_ENTREPRISE + ") " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setString(1, obj.getNumero());
            pst.setString(2, obj.getType_de_voie());
            pst.setString(3, obj.getAdresse());
            pst.setString(4, obj.getVille());
            pst.setString(5, obj.getCode_postal());
            pst.setInt(6, obj.getId_utilisateur());
            pst.setInt(7, obj.getId_entreprise());

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
    public boolean update(Adresse obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NUMERO + " = ?, " + TYPE_DE_VOIE + " = ?, " + ADRESSE + " = ? , " + VILLE + " = ?, " + CODE_POSTAL + " = ?, " + ID_UTILISATEUR + " = ?,  " + ID_ENTREPRISE + " = ? " +
                    "WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setString(1, obj.getNumero());
            pst.setString(2, obj.getType_de_voie());
            pst.setString(3, obj.getAdresse());
            pst.setString(4, obj.getVille());
            pst.setString(5, obj.getCode_postal());
            pst.setLong(6, obj.getId_utilisateur());
            pst.setLong(7, obj.getId_entreprise());
            pst.setInt(8, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Adresse read(int id) {
        Adresse adresse = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            adresse = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String numero = rs.getString(NUMERO);
                String type_de_voie = rs.getString(TYPE_DE_VOIE);
                String adresses = rs.getString(ADRESSE);
                String ville = rs.getString(VILLE);
                String code_postal = rs.getString(CODE_POSTAL);
                Integer id_utilisateur = Math.toIntExact(rs.getLong(ID_UTILISATEUR));
                Integer id_entreprise = Math.toIntExact(rs.getLong(ID_ENTREPRISE));

                adresse = new Adresse(id, numero, type_de_voie, adresses, ville, code_postal, id_utilisateur, id_entreprise);
                donnees.put(id, adresse);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresse;
    }


    public static Adresse readWithId(String colonne, int id) {
        Adresse adresse = null;
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + colonne + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String numero = rs.getString(NUMERO);
                String type_de_voie = rs.getString(TYPE_DE_VOIE);
                String adresses = rs.getString(ADRESSE);
                String ville = rs.getString(VILLE);
                String code_postal = rs.getString(CODE_POSTAL);
                Integer id_utilisateur = Math.toIntExact(rs.getLong(ID_UTILISATEUR));
                Integer id_entreprise = Math.toIntExact(rs.getLong(ID_ENTREPRISE));

                adresse = new Adresse(id, numero, type_de_voie, adresses, ville, code_postal, id_utilisateur, id_entreprise);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        return adresse;
    }


    public Adresse getAdresseWithId(String colonne, int id) {
        Adresse adresse = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            adresse = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + colonne + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String numero = rs.getString(NUMERO);
                String type_de_voie = rs.getString(TYPE_DE_VOIE);
                String adresses = rs.getString(ADRESSE);
                String ville = rs.getString(VILLE);
                String code_postal = rs.getString(CODE_POSTAL);
                Integer id_utilisateur = Math.toIntExact(rs.getLong(ID_UTILISATEUR));
                Integer id_entreprise = Math.toIntExact(rs.getLong(ID_ENTREPRISE));

                adresse = new Adresse(id, numero, type_de_voie, adresses, ville, code_postal, id_utilisateur, id_entreprise);
                donnees.put(id, adresse);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresse;
    }

    public List<Adresse> chercherEntrepriseParVilleLIKE(String dataUser) {
        Adresse adresse;
        List<Adresse> listeAdresse = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE id_utilisateur IS NULL AND " + VILLE + " LIKE '" + dataUser + "%'";
            ResultSet rs = Connexion.executeQuery(requete);
            listeAdresse = new ArrayList<Adresse>();
            boolean hasNext = rs.next();
            while (hasNext) {
                int id= rs.getInt(CLE_PRIMAIRE);
                String numero = rs.getString(NUMERO);
                String type_de_voie = rs.getString(TYPE_DE_VOIE);
                String adresses = rs.getString(ADRESSE);
                String ville = rs.getString(VILLE);
                String code_postal = rs.getString(CODE_POSTAL);
                Integer id_utilisateur = Math.toIntExact(rs.getLong(ID_UTILISATEUR));
                Integer id_entreprise = Math.toIntExact(rs.getLong(ID_ENTREPRISE));
                adresse = new Adresse(id, numero, type_de_voie, adresses, ville, code_postal, id_utilisateur, id_entreprise);
                listeAdresse.add(adresse);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeAdresse;
    }

    public boolean createEntAdmin(Adresse obj) {
        boolean succes = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NUMERO + "," + TYPE_DE_VOIE + "," + ADRESSE + "," + VILLE + "," + CODE_POSTAL + "," +
                       ID_ENTREPRISE + ") " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setString(1, obj.getNumero());
            pst.setString(2, obj.getType_de_voie());
            pst.setString(3, obj.getAdresse());
            pst.setString(4, obj.getVille());
            pst.setString(5, obj.getCode_postal());
            pst.setInt(6, obj.getId_entreprise());

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


}
