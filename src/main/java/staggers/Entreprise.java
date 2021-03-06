package staggers;

import java.util.List;

public class Entreprise {

    private int id;
    private String nom;
    private String email;
    private String num_tel;
    private String nom_contact;
    private String email_contact;
    private String num_contact;
    private String nb_salarie;
    private String nb_stagiaire_max;
    private String description;
    private String langage;
    private List<Langage> langagesSecondaires;

    public Entreprise(int id, String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact, String nb_salarie, String nb_stagiaire_max, String description, String langage) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.num_tel = num_tel;
        this.nom_contact = nom_contact;
        this.email_contact = email_contact;
        this.num_contact = num_contact;
        this.nb_salarie = nb_salarie;
        this.nb_stagiaire_max = nb_stagiaire_max;
        this.description = description;
        this.langage = langage;
    }

    public Entreprise(String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact, String nb_salarie, String nb_stagiaire_max, String description, String langage) {
        this.nom = nom;
        this.email = email;
        this.num_tel = num_tel;
        this.nom_contact = nom_contact;
        this.email_contact = email_contact;
        this.num_contact = num_contact;
        this.nb_salarie = nb_salarie;
        this.nb_stagiaire_max = nb_stagiaire_max;
        this.description = description;
        this.langage = langage;
    }

    public Entreprise(String nom) {
        this.nom = nom;
    }

    public Entreprise(int id, String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact,
                      String nb_salarie,
                      String nb_stagiaire_max, String description, String langage, List<Langage> langagesSecondaires) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.num_tel = num_tel;
        this.nom_contact = nom_contact;
        this.email_contact = email_contact;
        this.num_contact = num_contact;
        this.nb_salarie = nb_salarie;
        this.nb_stagiaire_max = nb_stagiaire_max;
        this.description = description;
        this.langage = langage;
        this.langagesSecondaires = langagesSecondaires;
    }

    public Entreprise(String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact, String nb_salarie,
                      String nb_stagiaire_max, String description, String langage, List<Langage> langagesSecondaires) {
        this.nom = nom;
        this.email = email;
        this.num_tel = num_tel;
        this.nom_contact = nom_contact;
        this.email_contact = email_contact;
        this.num_contact = num_contact;
        this.nb_salarie = nb_salarie;
        this.nb_stagiaire_max = nb_stagiaire_max;
        this.description = description;
        this.langage = langage;
        this.langagesSecondaires = langagesSecondaires;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getnom_contact() {
        return nom_contact;
    }

    public void setnom_contact(String nom_contact) {
        this.nom_contact = nom_contact;
    }

    public String getEmail_contact() {
        return email_contact;
    }

    public void setEmail_contact(String email_contact) {
        this.email_contact = email_contact;
    }

    public String getNum_contact() {
        return num_contact;
    }

    public void setNum_contact(String num_contact) {
        this.num_contact = num_contact;
    }

    public String getNb_salarie() {
        return nb_salarie;
    }

    public void setNb_salarie(String nb_salarie) {
        this.nb_salarie = nb_salarie;
    }

    public String getnb_stagiaire_max() {
        return nb_stagiaire_max;
    }

    public void setnb_stagiaire_max(String nb_stagiaire_max) {
        this.nb_stagiaire_max = nb_stagiaire_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public List<Langage> getLangagesSecondaires() {
        return langagesSecondaires;
    }

    public void setLangagesSecondaires(List<Langage> langagesSecondaires) {
        this.langagesSecondaires = langagesSecondaires;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", nom_contact='" + nom_contact + '\'' +
                ", email_contact='" + email_contact + '\'' +
                ", num_contact='" + num_contact + '\'' +
                ", nb_salarie='" + nb_salarie + '\'' +
                ", nb_stagiaire_max='" + nb_stagiaire_max + '\'' +
                ", description='" + description + '\'' +
                ", langage='" + langage + '\'' +
                ", langagesSecondaires=" + langagesSecondaires +
                '}';
    }
}

