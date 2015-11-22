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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
@Table(name = "go_pins")
public class Gopin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int pin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.gopin")
    private Set<Gopingroup> goPingroup = new HashSet<Gopingroup>(0);

    @PrePersist
    protected void onCreate() {
        date1 = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        date1 = new Date();
    }

    /*
     Getter and setter
     */
    public Set<Gopingroup> getGoPingroup() {
        return goPingroup;
    }

    public void setGoPingroup(Set<Gopingroup> goPingroup) {
        this.goPingroup = goPingroup;
    }

}
