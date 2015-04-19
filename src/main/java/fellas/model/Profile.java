package fellas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * Person profile.
 */
@Entity
@IdClass(ProfileId.class)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    private long userId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "id", referencedColumnName = "profileId"),
                    @JoinColumn(name = "userId",
                            referencedColumnName = "userId") },
            inverseJoinColumns = {
                    @JoinColumn(name = "id", referencedColumnName = "groupId"),
                    @JoinColumn(name = "userId",
                            referencedColumnName = "userId") })
    private List<Group> groups;

    public Profile() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
