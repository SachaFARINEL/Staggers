package staggers;

public class Adresse {
    //test
    private int id;
    private String numero;
    private String type_de_voie;
    private String adresse;
    private String ville;
    private String code_postal;
    private Integer id_utilisateur;
    private Integer id_entreprise;

    public Adresse(int id, String numero, String type_de_voie, String adresse, String ville, String code_postal,
                   Integer id_utilisateur, Integer id_entreprise) {
        this.id = id;
        this.numero = numero;
        this.type_de_voie = type_de_voie;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.id_utilisateur = id_utilisateur;
        this.id_entreprise = id_entreprise;
    }

    public Adresse(String numero, String type_de_voie, String adresse, String ville, String code_postal,
                   Integer id_utilisateur, Integer id_entreprise) {
        this.numero = numero;
        this.type_de_voie = type_de_voie;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.id_utilisateur = id_utilisateur;
        this.id_entreprise = id_entreprise;
    }
    public Adresse(String numero, String type_de_voie, String adresse, String ville, String code_postal,
                    Integer id_entreprise) {
        this.numero = numero;
        this.type_de_voie = type_de_voie;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.id_entreprise = id_entreprise;
    }

    public Adresse(int id,String numero, String type_de_voie, String adresse, String ville, String code_postal,
                   Integer id_entreprise) {
        this.id = id;
        this.numero = numero;
        this.type_de_voie = type_de_voie;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.id_entreprise = id_entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Integer getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Integer id_entreprise) {
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
                ", id_utilisateur=" + id_utilisateur +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}

