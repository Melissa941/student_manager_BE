package demo.student_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @Column(name = "student_number",  nullable = false)
    private String studentNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "cellphone_number", nullable = false, unique = true)
    private String cellphoneNumber;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "current_score")
    private Integer currentScore;
    @Column(name = "average_score")
    private Integer averageScore;
    @Column(name = "past_scores")
    private String pastScores;
}