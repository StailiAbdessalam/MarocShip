package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Chauffeur implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chauffeur")
    private int idChauffeur;
    @Basic
    @Column(name = "vehicule_id")
    private Integer vehiculeId;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "max")
    private double max;
    @Basic
    @Column(name = "point_fidelite")
    private int pointFidelite;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "vehicule_id", referencedColumnName = "id_vehicule", nullable = false, insertable = false, updatable = false)
    private Vehicule vehiculeByVehiculeId;

    public int getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(int idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public Integer getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(Integer vehiculeId) {
        this.vehiculeId = vehiculeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public int getPointFidelite() {
        return pointFidelite;
    }

    public void setPointFidelite(int pointFidelite) {
        this.pointFidelite = pointFidelite;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chauffeur chauffeur = (Chauffeur) o;

        if (idChauffeur != chauffeur.idChauffeur) return false;
        if (Double.compare(chauffeur.max, max) != 0) return false;
        if (pointFidelite != chauffeur.pointFidelite) return false;
        if (vehiculeId != null ? !vehiculeId.equals(chauffeur.vehiculeId) : chauffeur.vehiculeId != null) return false;
        if (nom != null ? !nom.equals(chauffeur.nom) : chauffeur.nom != null) return false;
        if (prenom != null ? !prenom.equals(chauffeur.prenom) : chauffeur.prenom != null) return false;
        if (email != null ? !email.equals(chauffeur.email) : chauffeur.email != null) return false;
        if (password != null ? !password.equals(chauffeur.password) : chauffeur.password != null) return false;
        if (createdAt != null ? !createdAt.equals(chauffeur.createdAt) : chauffeur.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idChauffeur;
        result = 31 * result + (vehiculeId != null ? vehiculeId.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        temp = Double.doubleToLongBits(max);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + pointFidelite;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public Vehicule getVehiculeByVehiculeId() {
        return vehiculeByVehiculeId;
    }

    public void setVehiculeByVehiculeId(Vehicule vehiculeByVehiculeId) {
        this.vehiculeByVehiculeId = vehiculeByVehiculeId;
    }
}
