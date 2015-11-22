/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.domain.dao;

import go.domain.Gouser;
import java.util.List;
import org.hibernate.Session;


public interface GOUserDAOInterface {

    public Session openCurrentSession();

    public Session openCurrentSessionwithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionwithTransaction();

    public void persist(Gouser entity);

    public void update(Gouser entity);

    public Gouser findById(long id);

    public Gouser findByName(String name);

    public void delete(Gouser entity);

    public List<Gouser> findAll();

    public void deleteAll();
}
