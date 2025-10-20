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
@Table(name = "categories")
public class Category {
    @Id
    @Size(max = 4)
    @Column(name = "Id", nullable = false, length = 4)
    private String id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new LinkedHashSet<>();

}