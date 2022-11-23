package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Chauffeur;

import java.util.List;

public class ChauffeurDao extends AbstractHibernateDAO<Chauffeur> {
    // initial a type of Dao
    public void ChauffeurDao(){
        TableName="Chauffeur";
        setEntity(Chauffeur.class);
    }

    //get Chauffeur By Id
    public Chauffeur getChauffeurById(long id){
        return findOne(id);
    }

    //get All Chauffeur
    public List<Chauffeur> getAllChauffeur(){
        return findAll();
    }

    //cretate chauffeur
    public void cretaChauffeur(Chauffeur chauffeur){
        create(chauffeur);
    }
    //delete chauffeur
    public void deleteChauffeurByID(long id){
        deleteById(id);
    }



}
