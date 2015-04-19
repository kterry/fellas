/**
 * 
 */
package fellas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * User model class.
 *
 */
@Entity
@IdClass(GroupId.class)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Id
    private long userId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Profile> profiles;

    public Group() {
    }

    public long getId() {
        return id;
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

}
