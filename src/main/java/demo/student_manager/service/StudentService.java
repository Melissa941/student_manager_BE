package demo.student_manager.service;

import demo.student_manager.dto.StudentDto;
import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(String StudentNumber);

    List<StudentDto> getStudentByFirstName(String firstName);

    List<StudentDto> getStudentByLastName(String lastName);

    List<StudentDto> getStudentByEmail(String email);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(String studentNumber, StudentDto studentDto);

    void deleteStudent(String studentNumber);
}
