package kz.xodbar.bitlabadvancedspringcoursesproject.entity.course;

import javax.persistence.*;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "rating", scale = 1, precision = 2)
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @ManyToOne
    private CourseCategory category;

}
