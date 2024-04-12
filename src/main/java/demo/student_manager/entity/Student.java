package demo.student_manager.entity;

import demo.student_manager.utils.StudentNumberGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_number")
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
    private Double averageScore;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentScore> scores;

    public void addScore(StudentScore score) {
        if (scores == null) {
            scores = new ArrayList<>();
        }
        scores.add(score);
        score.setStudent(this); // Set the student for the score
    }

    public Double calculateAverageScore() {
        if (scores == null || scores.isEmpty()) {
            return null; // Return null if there are no scores
        }

        int sum = 0;
        for (StudentScore score : scores) {
            sum += score.getScore();
        }

        return (double) sum / scores.size();
    }
}