package demo.student_manager.mapper;

import demo.student_manager.dto.StudentDto;
import demo.student_manager.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getStudentNumber(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDateOfBirth(),
                student.getCellphoneNumber(),
                student.getCurrentScore(),
                student.getAverageScore(),
                student.getPastScores()
        );
    }
    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getStudentNumber(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getDateOfBirth(),
                studentDto.getCellphoneNumber(),
                studentDto.getEmail(),
                studentDto.getCurrentScore(),
                studentDto.getAverageScore(),
                studentDto.getPastScores()
        );
    }
}
