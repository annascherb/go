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

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class GopingroupId implements java.io.Serializable {

    @ManyToOne
    private Gopin gopin;
    @ManyToOne
    private Gogroups gogroup;

    public Gopin getGopin() {
        return gopin;
    }

    public void setGopin(Gopin gopin) {
        this.gopin = gopin;
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

        GopingroupId that = (GopingroupId) o;

        if (gopin != null ? !gopin.equals(that.gopin) : that.gopin != null) {
            return false;
        }
        if (gogroup != null ? !gogroup.equals(that.gogroup) : that.gogroup != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = (gopin != null ? gopin.hashCode() : 0);
        result = 31 * result + (gogroup != null ? gogroup.hashCode() : 0);
        return result;
    }

}
