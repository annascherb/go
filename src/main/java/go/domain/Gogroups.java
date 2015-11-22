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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ivc_ShherbakovIV
 */
@Entity
@Table(name = "go_groups")
public class Gogroups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String filename;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.gogroup", cascade = CascadeType.ALL)
    private Set<Gousergroup> goUsergroups = new HashSet<Gousergroup>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.gogroup", cascade = CascadeType.ALL)
    private Set<Gopingroup> goPingroup = new HashSet<Gopingroup>(0);

    /*
     Getter and setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Set<Gousergroup> getGoUsergroups() {
        return goUsergroups;
    }

    public void setGoUsergroups(Set<Gousergroup> goUsergroups) {
        this.goUsergroups = goUsergroups;
    }

    public Set<Gopingroup> getGoPingroup() {
        return goPingroup;
    }

    public void setGoPingroup(Set<Gopingroup> goPingroup) {
        this.goPingroup = goPingroup;
    }

}
