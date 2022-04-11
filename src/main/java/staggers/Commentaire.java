package staggers;

import java.util.Date;

public class Commentaire {

    private int id;
    private int id_utilisateur;
    private int id_entreprise;
    private String com;
    private int date;


    public Commentaire(int id, int id_utilisateur, int id_entreprise, String com, int date) {

        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.id_entreprise = id_entreprise;
        this.com = com;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", id_utilisateur=" + id_utilisateur +
                ", id_entreprise=" + id_entreprise +
                ", com='" + com + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
