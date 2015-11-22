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

import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "go_user_group")
@AssociationOverrides({
    @AssociationOverride(name = "pk.gouser",
            joinColumns = @JoinColumn(name = "USER_ID")),
    @AssociationOverride(name = "pk.gogroup",
            joinColumns = @JoinColumn(name = "GROUP_ID"))})
public class Gousergroup implements java.io.Serializable {

    @EmbeddedId
    private GousergroupId pk = new GousergroupId();
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;
    
    @Column(name = "CREATED_BY", nullable = false, length = 10)
    private String createdBy;

    public Gousergroup() {
    }

    
    public GousergroupId getPk() {
        return pk;
    }

    public void setPk(GousergroupId pk) {
        this.pk = pk;
    }

    @Transient
    public Gouser getGouser() {
        return getPk().getGouser();
    }

    public void setGouser(Gouser gouser) {
        getPk().setGouser(gouser);
    }

    @Transient
    public Gogroups getGogroup() {
        return getPk().getGogroup();
    }

    public void setCategory(Gogroups group) {
        getPk().setGogroup(group);
    }

    
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Gousergroup that = (Gousergroup) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);

    }
}
