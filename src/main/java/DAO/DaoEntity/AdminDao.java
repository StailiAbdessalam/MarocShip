package DAO.DaoEntity;

import DAO.AbstractHibernateDAO;
import Entity.Admin;

public class AdminDao extends AbstractHibernateDAO<Admin> {

    public AdminDao() {
        TableName="Admin";
        setEntity(Admin.class);
    }

    

}
