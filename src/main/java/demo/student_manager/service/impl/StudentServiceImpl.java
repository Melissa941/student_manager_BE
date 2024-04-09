package demo.student_manager.service.impl;

import demo.student_manager.dto.StudentDto;
import demo.student_manager.entity.Student;
import demo.student_manager.exception.ResourceNotFoundException;
import demo.student_manager.mapper.StudentMapper;
import demo.student_manager.repository.StudentRepository;
import demo.student_manager.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        studentDto.setStudentNumber(String.valueOf(studentDto.getFirstName().charAt(0) + String.valueOf(UUID.randomUUID()) + studentDto.getLastName().charAt(0)));
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(String studentNumber) {
        Student student = studentRepository.findById(studentNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + studentNumber + " not found"));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getStudentByFirstName(String firstName) {
        List<Student> students = studentRepository.findByFirstNameContainingIgnoreCase(firstName);
        if (students.isEmpty())
            throw new ResourceNotFoundException("Student with first name " + firstName + " not found");
        else
            return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                    .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentByLastName(String lastName) {
        List<Student> students = studentRepository.findByLastNameContainingIgnoreCase(lastName);
        if (students.isEmpty())
            throw (new ResourceNotFoundException("Student with last name " + lastName + " not found"));
        else
            return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                    .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentByEmail(String email) {
        List<Student> students = studentRepository.findByEmailContainingIgnoreCase(email);
        if (students.isEmpty())
            throw (new ResourceNotFoundException("Student with email" + email + " not found"));
        else
            return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                    .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(String studentNumber, StudentDto updateStudent) {
        Student student = studentRepository.findById(studentNumber).orElseThrow(
                () -> new ResourceNotFoundException("Student with id " + studentNumber + " does not exist")
        );

        student.setFirstName(updateStudent.getFirstName());
        student.setLastName(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());
        student.setDateOfBirth(updateStudent.getDateOfBirth());
        student.setCellphoneNumber(updateStudent.getCellphoneNumber());
        student.setCurrentScore(updateStudent.getCurrentScore());
        student.setAverageScore(updateStudent.getAverageScore());

        Student updateStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updateStudentObj);
    }

    @Override
    public void deleteStudent(String studentNumber) {
        Student student = studentRepository.findById(studentNumber).orElseThrow(
                () -> new ResourceNotFoundException("Student with id " + studentNumber + " does not exist")
        );

        studentRepository.deleteById(studentNumber);
    }
}
