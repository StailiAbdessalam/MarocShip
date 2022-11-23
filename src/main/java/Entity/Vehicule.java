package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Vehicule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vehicule")
    private int idVehicule;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "max_poids")
    private int maxPoids;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "vehiculeByVehiculeId")
    private Collection<Chauffeur> chauffeursByIdVehicule;

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMaxPoids() {
        return maxPoids;
    }

    public void setMaxPoids(int maxPoids) {
        this.maxPoids = maxPoids;
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

        Vehicule vehicule = (Vehicule) o;

        if (idVehicule != vehicule.idVehicule) return false;
        if (maxPoids != vehicule.maxPoids) return false;
        if (nom != null ? !nom.equals(vehicule.nom) : vehicule.nom != null) return false;
        if (createdAt != null ? !createdAt.equals(vehicule.createdAt) : vehicule.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVehicule;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + maxPoids;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public Collection<Chauffeur> getChauffeursByIdVehicule() {
        return chauffeursByIdVehicule;
    }

    public void setChauffeursByIdVehicule(Collection<Chauffeur> chauffeursByIdVehicule) {
        this.chauffeursByIdVehicule = chauffeursByIdVehicule;
    }
}
