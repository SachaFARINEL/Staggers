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
        private int nb_stagiaire_max;
        private String description;
        private boolean est_favoris;



        public Entreprise(int id, String nom, String email, String num_tel, String nom_contact, String email_contact, String num_contact, int nb_salarie, int nb_stagiaire_max, String description, boolean est_favoris) {
            this.id = id;
            this.nom = nom;
            this.email = email;
            this.num_tel = num_tel;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.num_contact = num_contact;
            this.nb_salarie = nb_salarie;
            this.nb_stagiaire_max = nb_stagiaire_max;
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

        public int getNb_salarie() {
            return nb_salarie;
        }

        public void setNb_salarie(int nb_salarie) {
            this.nb_salarie = nb_salarie;
        }

        public int getnb_stagiaire_max() {
            return nb_stagiaire_max;
        }

        public void setnb_stagiaire_max(int nb_stagiaire_max) {
            this.nb_stagiaire_max = nb_stagiaire_max;
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
                    ", nb_stagiaire_max=" + nb_stagiaire_max +
                    ", est_favoris=" + est_favoris +
                    ", description='" + description + '\'' +
                    '}';
        }

    }

