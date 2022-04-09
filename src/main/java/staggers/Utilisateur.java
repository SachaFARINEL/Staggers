package staggers;


import java.sql.Date;

public class Utilisateur {

    private int id;
    private int promo;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String email;
    private String num_tel;
    private boolean admis_stage;
    private String sexe;
    private String mot_de_passe;
    private boolean est_admin;
    private String role;


    public Utilisateur(int id, int promo, String nom, String prenom, Date date_naissance, String email, String num_tel,
                       boolean admis_stage, String sexe, String mot_de_passe, boolean est_admin, String role) {
        this.id = id;
        this.promo = promo;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.num_tel = num_tel;
        this.admis_stage = admis_stage;
        this.sexe = sexe;
        this.mot_de_passe = mot_de_passe;
        this.est_admin = est_admin;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public boolean isAdmis_stage() {
        return admis_stage;
    }

    public void setAdmis_stage(boolean admis_stage) {
        this.admis_stage = admis_stage;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public boolean isEst_admin() {
        return est_admin;
    }

    public void setEst_admin(boolean est_admin) {
        this.est_admin = est_admin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", promo=" + promo +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", email='" + email + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", admis_stage=" + admis_stage +
                ", sexe='" + sexe + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", est_admin=" + est_admin +
                ", role='" + role + '\'' +
                '}';
    }
}
