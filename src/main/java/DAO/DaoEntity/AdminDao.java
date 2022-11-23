package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Admin;

public class AdminDao extends AbstractHibernateDAO<Admin> {

    // initial a type of Dao
    public AdminDao() {
        TableName="Admin";
        setEntity(Admin.class);
    }

    //find admin by id
    public Admin findAdminByID(long id){
        return findOne(id);
    }



}
