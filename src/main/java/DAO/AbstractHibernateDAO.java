package DAO;

import Utuls.JPAService;
import java.io.Serializable;
import java.util.List;

public abstract class  AbstractHibernateDAO<T extends Serializable> {
    private Class<T> Entity;

    protected String TableName;
    protected static JPAService jpaService = JPAService.getInstance();

    public void setEntity(Class<T> SetEntity) {
        this.Entity = SetEntity;
    }

    // find one by id
    public T findOne(long id){
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.find(Entity,id);
        });
    }

    // find all
     public List findAll(){
        return jpaService.runInTransaction(entityManager -> {
           return entityManager.createQuery("from "+Entity.getName()).getResultList();
        });
     }

    // add one
    public T create(T entity){
        return jpaService.runInTransaction(entityManager -> {
            entityManager.persist(entity);
           return null;
        });
    }

    // update one
    public T update(T entity){
        return jpaService.runInTransaction(entityManager -> {
           return entityManager.merge(entity);
        });
    }

    // delete one
    public void delete(T entity){
        jpaService.runInTransaction(entityManager -> {
             entityManager.remove(entityManager.merge(entity));
             return null;
        });
    }

    //delete By id
    public void deleteById(long id){
        T entity = findOne(id);
        delete(entity);
    }





}
