package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Chauffeur;
import Entity.Manager;
import jakarta.persistence.NoResultException;

import java.util.List;

import static Utils.Hash.verifiedPassword;

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
    // find one manager by email
    public static Manager getManagerByEmail(String email) {

        return jpaService.runInTransaction(entityManager -> {
            try{
                return entityManager.createQuery("select a from Manager a WHERE a.email = :email", Manager.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException nre){
                return null;
            }
        });

    }

    //validate login
    public static boolean validateAdminLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        Manager manager = getManagerByEmail(email);
        assert manager != null;
        if(manager != null) {
            if (password.equals(manager.getPassword())) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
}
