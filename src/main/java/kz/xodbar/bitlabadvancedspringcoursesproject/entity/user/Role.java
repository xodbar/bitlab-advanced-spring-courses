package kz.xodbar.bitlabadvancedspringcoursesproject.entity.user;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
