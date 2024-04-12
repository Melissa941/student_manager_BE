package demo.student_manager.service.impl;

import demo.student_manager.entity.Student;
import demo.student_manager.entity.StudentScore;
import demo.student_manager.exception.StudentNotFoundException;
import demo.student_manager.repository.StudentRepository;
import demo.student_manager.repository.StudentScoreRepository;
import demo.student_manager.service.StudentScoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentScoreServiceImp implements StudentScoreService {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentScore saveScore(String studentNumber, StudentScore studentScore) {
        // Find the student by ID
        Student student = studentRepository.findById(studentNumber)
                .orElseThrow(() -> new StudentNotFoundException("Student with student number " + studentNumber + " not found"));

        // Set the student for the new score
        student.setCurrentScore(studentScore.getScore());
        student.setAverageScore(student.calculateAverageScore());
        studentScore.setStudent(student);

        //Add the new score to the student's list of scores
        student.addScore(studentScore);

        // Save the updated student entity
        studentRepository.save(student);

        // Save and return the new student score
        return studentScoreRepository.save(studentScore);
    }

    public List<StudentScore> getScoresByStudentNumber(String studentNumber) {
        // Find the student by ID
        studentRepository.findById(studentNumber)
                .orElseThrow(() -> new StudentNotFoundException("Student with student number " + studentNumber + " not found"));
        return studentScoreRepository.findByStudentStudentNumber(studentNumber);
    }
}