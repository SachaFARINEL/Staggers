package staggers;

public class Conseil {

    private int id;
    private String conseils;

    public Conseil(int id, String conseils) {
        this.id = id;
        this.conseils = conseils;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConseils() {
        return conseils;
    }

    public void setConseils(String conseils) {
        this.conseils = conseils;
    }

    @Override
    public String toString() {
        return "Conseil{" +
                "id=" + id +
                ", conseils='" + conseils + '\'' +
                '}';
    }
}
