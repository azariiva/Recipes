package recipes.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotBlank
    @NotEmpty
    @Column(name = "category")
    private String category;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "date")
    @UpdateTimestamp
    private LocalDateTime date;

    @NotEmpty
    @Size(min = 1)
    @Column(name = "ingredients")
    @ElementCollection
    @CollectionTable(name = "INGREDIENTS", joinColumns = @JoinColumn(name = "id"))
    private List<String> ingredients;

    @NotEmpty
    @Size(min = 1)
    @Column(name = "directions")
    @ElementCollection
    @CollectionTable(name = "DIRECTIONS", joinColumns = @JoinColumn(name = "id"))
    private List<String> directions;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id.equals(recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
