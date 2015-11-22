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

import go.domain.Gorole;
import go.domain.Gouser;
import go.utils.HibernateUtils;
import java.util.List;
import lombok.Data;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


@Data
public class GORoleDAOInterfaceImpl implements GORoleDAOInterface{
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
    public void persist(Gorole entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Gorole entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Gorole findById(long id) {
        Gorole res = (Gorole) getCurrentSession().get(Gorole.class, id);
        return res;
    }


    @Override
    public void delete(Gorole entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Gorole> findAll() {
        List<Gorole> res = (List<Gorole>) getCurrentSession().createQuery("from Gorole").list();
        return res;
    }

    @Override
    public void deleteAll() {
        List<Gorole> entityList = findAll();
        for (Gorole entity : entityList) {
            delete(entity);
        }
    }

}
