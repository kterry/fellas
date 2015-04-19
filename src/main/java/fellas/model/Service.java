package fellas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Service {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    
}
