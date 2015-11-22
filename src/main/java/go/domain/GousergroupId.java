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

import go.domain.test.Category;
import go.domain.test.Stock;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;



@Embeddable
public class GousergroupId implements java.io.Serializable {

    @ManyToOne
    private Gouser gouser;
    @ManyToOne
    private Gogroups gogroup;

    
    public Gouser getGouser() {
        return gouser;
    }

    public void setGouser(Gouser gouser) {
        this.gouser = gouser;
    }

    
    public Gogroups getGogroup() {
        return gogroup;
    }

    public void setGogroup(Gogroups gogroup) {
        this.gogroup = gogroup;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GousergroupId that = (GousergroupId) o;

        if (gouser != null ? !gouser.equals(that.gouser) : that.gouser != null) {
            return false;
        }
        if (gogroup != null ? !gogroup.equals(that.gogroup) : that.gogroup != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = (gouser != null ? gouser.hashCode() : 0);
        result = 31 * result + (gogroup != null ? gogroup.hashCode() : 0);
        return result;
    }

}
