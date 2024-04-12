package demo.student_manager.dto;

import demo.student_manager.entity.StudentScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String cellphoneNumber;
    private Integer currentScore;
    private Double averageScore;
    private List<StudentScore> scores;
}
