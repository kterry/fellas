package fellas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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

    @ManyToOne
    @Id
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "profileId", referencedColumnName = "id",
                            insertable = false, updatable = false),
                    @JoinColumn(name = "profileUserId", referencedColumnName = "userId",
                            insertable = false, updatable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "groupId", referencedColumnName = "id",
                            insertable = false, updatable = false),
                    @JoinColumn(name = "groupUserId", referencedColumnName = "userId",
                            insertable = false, updatable = false) })
    private List<Group> groups; // CHECK profileUserId == groupUserId in SQL

    public Profile() {
    }

    public Profile(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Group> getGroups() {
        return groups;
    }

}
