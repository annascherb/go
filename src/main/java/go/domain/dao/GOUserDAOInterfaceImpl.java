/*
 $Author$
 $Date$
 $Revision$
 $Source$
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.domain.dao;

import go.domain.Gouser;
import go.utils.HibernateUtils;
import java.util.List;
import lombok.Data;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivc_ShherbakovIV
 */
@Data
public class GOUserDAOInterfaceImpl implements GOUserDAOInterface {

    private Session currentSession;

    private Transaction currentTransaction;

    @Override
    public Session openCurrentSession() {
        currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        return currentSession;
    }

    @Override
    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtils.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    @Override
    public void closeCurrentSession() {
        currentSession.close();
    }

    @Override
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public void persist(Gouser entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Gouser entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Gouser findById(long id) {
        Gouser res = (Gouser) getCurrentSession().get(Gouser.class, id);
        return res;
    }

    @Override
    public Gouser findByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(Gouser.class);
        List<Gouser> res = (List<Gouser>) criteria.add(Restrictions.eq("name", name)).list();
        if (res.size() == 0) {
            return null;
        } else {
            return res.get(0);
        }

    }

    @Override
    public void delete(Gouser entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Gouser> findAll() {
        List<Gouser> res = (List<Gouser>) getCurrentSession().createQuery("from Category").list();
        return res;
    }

    @Override
    public void deleteAll() {
        List<Gouser> entityList = findAll();
        for (Gouser entity : entityList) {
            delete(entity);
        }
    }
}
