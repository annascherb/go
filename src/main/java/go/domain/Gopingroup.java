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

/**
 *
 * @author ivc_ShherbakovIV
 */
@Entity
@Table(name = "go_pin_group")
@AssociationOverrides({
    @AssociationOverride(name = "pk.gopin",
            joinColumns = @JoinColumn(name = "PIN_ID")),
    @AssociationOverride(name = "pk.gogroup",
            joinColumns = @JoinColumn(name = "GROUP_ID"))})
public class Gopingroup implements java.io.Serializable {

    @EmbeddedId
    private GopingroupId pk = new GopingroupId();
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;
    
    @Column(name = "CREATED_BY", nullable = false, length = 10)
    private String createdBy;

    public Gopingroup() {
    }

    
    public GopingroupId getPk() {
        return pk;
    }

    public void setPk(GopingroupId pk) {
        this.pk = pk;
    }

    @Transient
    public Gopin getGopin() {
        return getPk().getGopin();
    }

    public void setGopin(Gopin gopin) {
        getPk().setGopin(gopin);
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
