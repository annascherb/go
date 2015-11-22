/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.domain.dao;

import go.domain.Gorole;
import go.domain.Gouser;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ivc_ShherbakovIV
 */
public interface GORoleDAOInterface {

    public Session openCurrentSession();

    public Session openCurrentSessionwithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionwithTransaction();

    public void persist(Gorole entity);

    public void update(Gorole entity);

    public Gorole findById(long id);

    public List<Gorole> findAll();
    
    public void delete(Gorole entity);

    public void deleteAll();
}
