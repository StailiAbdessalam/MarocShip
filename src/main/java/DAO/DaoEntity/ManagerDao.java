package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Chauffeur;
import Entity.Manager;

import java.util.List;

public class ManagerDao extends AbstractHibernateDAO<Manager> {
    public ManagerDao() {
        TableName="Manager";
        setEntity(Manager.class);
    }
    //get Manager By Id
    public Manager getManagerById(long id){
        return findOne(id);
    }

    //get All Manager
    public List<Manager> getAllManager(){
        return findAll();
    }

    //cretate Manager
    public void cretaManager(Manager manager){
        create(manager);
    }
    //delete Manager
    public void deleteManagerByID(long id){
        deleteById(id);
    }
}
