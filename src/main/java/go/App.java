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
package go;

import go.domain.Gorole;
import go.domain.dao.GORoleDAOInterface;
import go.domain.dao.GORoleDAOInterfaceImpl;
import go.domain.dao.GOUserDAOInterface;
import go.domain.dao.GOUserDAOInterfaceImpl;
import go.utils.HibernateUtils;
import org.hibernate.Hibernate;


public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");
        
        GORoleDAOInterface DAO = new GORoleDAOInterfaceImpl();
        DAO.openCurrentSessionwithTransaction();
        Gorole role1 = new Gorole();
        role1.setRoleName("admin");
        DAO.persist(role1);
        DAO.closeCurrentSessionwithTransaction();   
        
        
        HibernateUtils.shutdown();
    }
}
