package poly.edu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Size(max = 50)
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Size(max = 50)
    @NotNull
    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;

    @Size(max = 50)
    @NotNull
    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "Photo", nullable = false, length = 50)
    private String photo;

    @NotNull
    @Column(name = "Activated", nullable = false)
    private Byte activated;

    @NotNull
    @Column(name = "Admin", nullable = false)
    private Byte admin;

    @OneToMany(mappedBy = "username")
    private Set<Order> orders = new LinkedHashSet<>();

}