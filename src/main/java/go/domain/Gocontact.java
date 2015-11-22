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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name="go_contacts")
public class Gocontact implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @ManyToOne
    private Gotypecont gotypecont;

    @ManyToOne
    private Gouser gouser;

    /*
     Getter and setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Gotypecont getGotypecont() {
        return gotypecont;
    }

    public void setGotypecont(Gotypecont gotypecont) {
        this.gotypecont = gotypecont;
    }

    public Gouser getGouser() {
        return gouser;
    }

    public void setGouser(Gouser gouser) {
        this.gouser = gouser;
    }

}
