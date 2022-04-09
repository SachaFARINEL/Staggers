package staggers;

import java.util.Date;

    public class Entreprise {


        private int id;
        private String nom;
        private String email;
        private String num_tel;
        private String nom_contact;
        private String email_contact;
        private String num_contact;
        private int nb_salarie;
        private int nb_stagiaire;
        private boolean est_favoris;
        private String description;


        public Entreprise(int id, String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact, int nb_salarie, int nb_stagiaire, boolean est_favoris, String description) {
            this.id = id;
            this.nom = nom;
            this.email = email;
            this.num_tel = num_tel;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.num_contact = num_contact;
            this.nb_salarie = nb_salarie;
            this.nb_stagiaire = nb_stagiaire;
            this.est_favoris = est_favoris;
            this.description = description;
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

        public String getNom_contact() {
            return nom_contact;
        }

        public void setNom_contact(String nom_contact) {
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

        public int getNb_salarie() {
            return nb_salarie;
        }

        public void setNb_salarie(int nb_salarie) {
            this.nb_salarie = nb_salarie;
        }

        public int getNb_stagiaire() {
            return nb_stagiaire;
        }

        public void setNb_stagiaire(int nb_stagiaire) {
            this.nb_stagiaire = nb_stagiaire;
        }

        public boolean isEst_favoris() {
            return est_favoris;
        }

        public void setEst_favoris(boolean est_favoris) {
            this.est_favoris = est_favoris;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
                    ", nb_salarie=" + nb_salarie +
                    ", nb_stagiaire=" + nb_stagiaire +
                    ", est_favoris=" + est_favoris +
                    ", description='" + description + '\'' +
                    '}';
        }

    }

