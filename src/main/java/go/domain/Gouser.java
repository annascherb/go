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
package go.domain;

import go.domain.test.StockCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ivc_ShherbakovIV
 */
@Entity
@Table(name="go_user")
public class Gouser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @ManyToOne
    private Gorole gorole;

    @OneToMany(mappedBy = "gouser", cascade = CascadeType.PERSIST)
    private List<Gocontact> gocontacts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.gouser")
    private Set<Gousergroup> goUsergroups = new HashSet<Gousergroup>(0);

    /*
     Getter and setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gorole getGorole() {
        return gorole;
    }

    public void setGorole(Gorole gorole) {
        this.gorole = gorole;
    }

    public List<Gocontact> getGocontacts() {
        return gocontacts;
    }

    public void setGocontacts(List<Gocontact> gocontacts) {
        this.gocontacts = gocontacts;
    }

    
    
    public Set<Gousergroup> getGoUsergroups() {
        return goUsergroups;
    }

    public void setGoUsergroups(Set<Gousergroup> goUsergroups) {
        this.goUsergroups = goUsergroups;
    }
    
    

}
