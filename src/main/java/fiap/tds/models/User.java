package fiap.tds.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "ccr_user")
public class User extends PanacheEntity {
    public String username;
    public String password;
}
