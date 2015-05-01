package fellas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(AccountId.class)
public class Account {

    @Id
    private String id;

    @ManyToOne
    @Id
    @JoinColumn(name = "serviceId", referencedColumnName = "id")
    private Service service;

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public Service getService() {
        return service;
    }
}
