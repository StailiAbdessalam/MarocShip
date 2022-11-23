package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Chauffeur;
import Entity.Livraison;

import java.util.List;

public class LivraisonDao extends AbstractHibernateDAO<Livraison> {

    public LivraisonDao() {
        TableName="Livraison";
        setEntity(Livraison.class);
    }

    //get Livraison By Id
    public Livraison getLivraisonById(long id){
        return findOne(id);
    }

    //get All Livraison
    public List<Livraison> getAllLivraison(){
        return findAll();
    }

    //cretate chauffeur
    public void cretaLivraison(Livraison chauffeur){
        create(chauffeur);
    }
    //delete chauffeur
    public void deleteLivraisonByID(long id){
        deleteById(id);
    }
}
