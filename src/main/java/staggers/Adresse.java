package staggers;

import java.sql.Date;

public class Adresse {

    private int id;
    private int numero;
    private String type_de_voie;
    private String adresse;
    private String ville;
    private int code_postal;
    private String departement;
    private String pays;
    private int id_utilisateur;
    private int id_entreprise;

    public Adresse(int id, int numero, String type_de_voie, String adresse, String ville, int code_postal,
                   String departement, String pays, int id_utilisateur, int id_entreprise) {
        this.id = id;
        this.numero = numero;
        this.type_de_voie = type_de_voie;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.departement = departement;
        this.pays = pays;
        this.id_utilisateur = id_utilisateur;
        this.id_entreprise = id_entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getType_de_voie() {
        return type_de_voie;
    }

    public void setType_de_voie(String type_de_voie) {
        this.type_de_voie = type_de_voie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", type_de_voie='" + type_de_voie + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", code_postal=" + code_postal +
                ", departement='" + departement + '\'' +
                ", pays='" + pays + '\'' +
                ", id_utilisateur=" + id_utilisateur +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}

