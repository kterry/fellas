package fellas.model;

import java.io.Serializable;

public class GroupId implements Serializable {

    private static final long serialVersionUID = -4282889503332180246L;
    long id;
    long user;

    public GroupId(long id, long user) {
        super();
        this.id = id;
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (user ^ (user >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GroupId other = (GroupId) obj;
        if (id != other.id)
            return false;
        if (user != other.user)
            return false;
        return true;
    }
}
