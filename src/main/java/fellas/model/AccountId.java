package fellas.model;

import java.io.Serializable;

public class AccountId implements Serializable {

    private static final long serialVersionUID = 6712815768499586210L;
    long id;
    long service;

    public AccountId(long service) {
        super();
        this.service = service;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (int) (service ^ (service >>> 32));
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
        AccountId other = (AccountId) obj;
        if (id != other.id)
            return false;
        if (service != other.service)
            return false;
        return true;
    }
}
