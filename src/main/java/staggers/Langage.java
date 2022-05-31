package staggers;

public class Langage {

    private int id;
    private String libelle;

    public Langage(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Langage(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Langage{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
