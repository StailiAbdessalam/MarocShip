package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Livraison implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_livraison")
    private int idLivraison;
    @Basic
    @Column(name = "responsable_id")
    private Integer responsableId;
    @Basic
    @Column(name = "ville_depart")
    private Date villeDepart;
    @Basic
    @Column(name = "ville_arrivee")
    private Date villeArrivee;
    @Basic
    @Column(name = "prix")
    private double prix;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "poids")
    private int poids;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "responsable_id", referencedColumnName = "id_responsable", nullable = false, insertable = false, updatable = false)
    private Responsable responsableByResponsableId;

    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Integer getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public Date getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(Date villeDepart) {
        this.villeDepart = villeDepart;
    }

    public Date getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(Date villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livraison livraison = (Livraison) o;

        if (idLivraison != livraison.idLivraison) return false;
        if (Double.compare(livraison.prix, prix) != 0) return false;
        if (poids != livraison.poids) return false;
        if (responsableId != null ? !responsableId.equals(livraison.responsableId) : livraison.responsableId != null)
            return false;
        if (villeDepart != null ? !villeDepart.equals(livraison.villeDepart) : livraison.villeDepart != null)
            return false;
        if (villeArrivee != null ? !villeArrivee.equals(livraison.villeArrivee) : livraison.villeArrivee != null)
            return false;
        if (status != null ? !status.equals(livraison.status) : livraison.status != null) return false;
        if (createdAt != null ? !createdAt.equals(livraison.createdAt) : livraison.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(livraison.updatedAt) : livraison.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idLivraison;
        result = 31 * result + (responsableId != null ? responsableId.hashCode() : 0);
        result = 31 * result + (villeDepart != null ? villeDepart.hashCode() : 0);
        result = 31 * result + (villeArrivee != null ? villeArrivee.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + poids;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Responsable getResponsableByResponsableId() {
        return responsableByResponsableId;
    }

    public void setResponsableByResponsableId(Responsable responsableByResponsableId) {
        this.responsableByResponsableId = responsableByResponsableId;
    }
}
