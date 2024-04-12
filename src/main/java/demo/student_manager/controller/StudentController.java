package demo.student_manager.controller;

import demo.student_manager.dto.StudentDto;
import demo.student_manager.entity.StudentScore;
import demo.student_manager.service.StudentScoreService;
import demo.student_manager.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentScoreService studentScoreService;

    /**
     * Create a new student
     *
     * @param studentDto
     * @return string with success response
     */
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody final StudentDto studentDto) {

        studentService.createStudent(studentDto);
        return ResponseEntity.ok("Student successfully created!");
    }

    /**
     * Identify student by using student number
     *
     * @param studentNumber
     * @return student data that matches student number
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentByStudentNumber(@PathVariable("id") final String studentNumber) {

        return ResponseEntity.ok(studentService.getStudentById(studentNumber));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/get/firstname/{firstName}")
    public ResponseEntity<List<StudentDto>> getStudentByFirstName(@PathVariable("firstName") final String firstName) {

        return ResponseEntity.ok(studentService.getStudentByFirstName(firstName));
    }

    @GetMapping("/get/lastname/{lastName}")
    public ResponseEntity<List<StudentDto>> getStudentByLastName(@PathVariable("lastName") final String lastName) {

        return ResponseEntity.ok(studentService.getStudentByLastName(lastName));
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<List<StudentDto>> getStudentByEmail(@PathVariable("email") final String email) {

        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") final String id, @RequestBody final StudentDto updateStudent) {

        return ResponseEntity.ok(studentService.updateStudent(id, updateStudent));
    }

    /**
     * Add student score with use of their student number
     *
     * @param studentNumber
     * @param studentScore
     * @return
     */
    @PostMapping("/score/{studentNumber}")
    public ResponseEntity<String> saveScore(@PathVariable("studentNumber") final String studentNumber, @RequestBody final StudentScore studentScore) {

        studentScoreService.saveScore(studentNumber, studentScore);
        return ResponseEntity.ok("Student score successfully Added!");
    }

    /**
     * Get student pass score using their student number
     *
     * @param studentNumber
     * @return
     */

    @GetMapping("/get/score/{studentNumber}")
    public ResponseEntity<List<StudentScore>> getScoresByStudentNumber(@PathVariable("studentNumber") final String studentNumber) {

        return ResponseEntity.ok(studentScoreService.getScoresByStudentNumber(studentNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") final String studentNumber) {

        studentService.deleteStudent(studentNumber);
        return ResponseEntity.ok("Student deleted successfully");
    }
}