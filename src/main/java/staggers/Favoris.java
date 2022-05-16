package staggers;

public class Favoris {

    private int id_utilisateur;
    private int id_entreprise;

    public Favoris(int id_utilisateur, int id_entreprise) {
        this.id_utilisateur = id_utilisateur;
        this.id_entreprise = id_entreprise;
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
        return "Favoris{" +
                "id_utilisateur=" + id_utilisateur +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}
