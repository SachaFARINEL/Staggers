package dao;

import staggers.Utilisateur;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.time.LocalDateTime;

import static utils.Utils.hashPass;

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
    private static final String QUESTION_SECRETE = "question_secrete";

    private static UtilisateurDAO instance = null;

    public static UtilisateurDAO getInstance() {
        if (instance == null) {
            instance = new UtilisateurDAO();
        }
        return instance;
    }

    private UtilisateurDAO() {
        super();
    }


    @Override
    public boolean create(Utilisateur obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + PROMO + "," + NOM + "," + PRENOM + "," + DATE_NAISSANCE + "," + EMAIL + "," + NUM_TEL + "," +
                    "" + ADMIS_STAGE + "," + SEXE + "," + MOT_DE_PASSE + "," + EST_ADMIN + "," + ROLE + "," + QUESTION_SECRETE + ") " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            pst.setInt(1, obj.getPromo());
            pst.setString(2, obj.getNom());
            pst.setString(3, obj.getPrenom());
            pst.setObject(4, obj.getDate_naissance());
            pst.setString(5, obj.getEmail());
            pst.setString(6, obj.getNum_tel());
            pst.setBoolean(7, obj.isAdmis_stage());
            pst.setString(8, obj.getSexe());
            pst.setString(9, obj.getMot_de_passe());
            pst.setBoolean(10, obj.isEst_admin());
            pst.setString(11, obj.getRole());
            pst.setString(12, obj.getQuestion_secrete());

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
    public boolean delete(Utilisateur obj) {
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
    public boolean update(Utilisateur obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + PROMO + " = ?, " + NOM + " = ?, " + PRENOM + " = ? , " + DATE_NAISSANCE + " = ?, " + EMAIL + " = ?, " + NUM_TEL + " = ?, " + ADMIS_STAGE + " = ?, " + SEXE + " = ?,  " + MOT_DE_PASSE + " = ?, " + EST_ADMIN + " = ?, " + ROLE + " = ?, " + QUESTION_SECRETE + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, obj.getPromo());
            pst.setString(2, obj.getNom());
            pst.setString(3, obj.getPrenom());
            pst.setObject(4, obj.getDate_naissance());
            pst.setString(5, obj.getEmail());
            pst.setString(6, obj.getNum_tel());
            pst.setBoolean(7, obj.isAdmis_stage());
            pst.setString(8, obj.getSexe());
            pst.setString(9, obj.getMot_de_passe());
            pst.setBoolean(10, obj.isEst_admin());
            pst.setString(11, obj.getRole());
            pst.setString(12, obj.getQuestion_secrete());
            pst.setInt(13, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Utilisateur read(int id) {
        Utilisateur utilisateur = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            utilisateur = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                int idUser = rs.getInt(CLE_PRIMAIRE);
                int promo = rs.getInt(PROMO);
                String nom = rs.getString(NOM);
                String prenom = rs.getString(PRENOM);
                LocalDateTime date_naissance = rs.getObject(DATE_NAISSANCE, LocalDateTime.class);
                String email = rs.getString(EMAIL);
                String num_tel = rs.getString(NUM_TEL);
                boolean admis_stage = rs.getBoolean(ADMIS_STAGE);
                String sexe = rs.getString(SEXE);
                String mot_de_passe = rs.getString(MOT_DE_PASSE);
                boolean est_admin = rs.getBoolean(EST_ADMIN);
                String role = rs.getString(ROLE);
                String question_secrete = rs.getString(QUESTION_SECRETE);
                utilisateur = new Utilisateur(idUser, promo, nom, prenom, date_naissance, email, num_tel, admis_stage, sexe, mot_de_passe, est_admin, role, question_secrete);
                donnees.put(id, utilisateur);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return utilisateur;
    }

    public String getWithEmail(String recherche, String mail) {
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

    public void updatePassword(String newMotDePasse, String email) {
        boolean success = true;
        try {
            String requete = "UPDATE " + TABLE + " SET " + MOT_DE_PASSE + " = ?" + " WHERE " + EMAIL + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setString(1, hashPass(newMotDePasse));
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            success = false;
            e.printStackTrace();
        }
    }


    public Utilisateur getUserWithMail(String mail) {
        Utilisateur utilisateur = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + EMAIL + " = '" + mail + "'";
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            int id = rs.getInt(CLE_PRIMAIRE);
            int promo = rs.getInt(PROMO);
            String nom = rs.getString(NOM);
            String prenom = rs.getString(PRENOM);
            LocalDateTime date_naissance = rs.getObject(DATE_NAISSANCE, LocalDateTime.class);
            String email = rs.getString(EMAIL);
            String num_tel = rs.getString(NUM_TEL);
            boolean admis_stage = rs.getBoolean(ADMIS_STAGE);
            String sexe = rs.getString(SEXE);
            String mot_de_passe = rs.getString(MOT_DE_PASSE);
            boolean est_admin = rs.getBoolean(EST_ADMIN);
            String role = rs.getString(ROLE);
            String question_secrete = rs.getString(QUESTION_SECRETE);
            utilisateur = new Utilisateur(id, promo, nom, prenom, date_naissance, email, num_tel, admis_stage, sexe, mot_de_passe, est_admin, role, question_secrete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    public boolean updateProfilUtilisateurWithoutPassword(Utilisateur obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NOM + " = ?, " + PRENOM + " = ? , " + DATE_NAISSANCE + " = ?, " + EMAIL + " = ?, " + NUM_TEL + " = ?, " + SEXE + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getPrenom());
            pst.setObject(3, obj.getDate_naissance());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getNum_tel());
            pst.setString(6, obj.getSexe());
            pst.setInt(7, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    public boolean updateProfilUtilisateurWithPassword(Utilisateur obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NOM + " = ?, " + PRENOM + " = ? , " + DATE_NAISSANCE + " = ?, " + EMAIL + " = ?, " + NUM_TEL + " = ?, " + SEXE + " = ?,  " + MOT_DE_PASSE + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getPrenom());
            pst.setObject(3, obj.getDate_naissance());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getNum_tel());
            pst.setString(6, obj.getSexe());
            pst.setString(7, hashPass(obj.getMot_de_passe()));
            pst.setInt(8, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }


}
