package demo.student_manager.controller;

import demo.student_manager.dto.StudentDto;
import demo.student_manager.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    //Build Add Student REST API
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudent = studentService.createStudent(studentDto);
//        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        return ResponseEntity.ok("Student successfully created!");
    }

    //Build Get Student REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentByStudentNumber(@PathVariable("id") String studentNumber) {
        StudentDto studentDto = studentService.getStudentById(studentNumber);
//        return new ResponseEntity<>(studentDto, HttpStatus.OK);
        return ResponseEntity.ok(studentDto);
    }

    //Build Get All Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

//    Build Get Student by Criteria REST API
    @GetMapping("/get/firstname/{id}")
    public ResponseEntity<List<StudentDto>> getStudentByFirstName(@PathVariable("id") String firstName){
        List<StudentDto> students = studentService.getStudentByFirstName(firstName);
        return ResponseEntity.ok(students);
    }

//    Build Get Student by Criteria REST API
    @GetMapping("/get/lastname/{id}")
    public ResponseEntity<List<StudentDto>> getStudentByLastName(@PathVariable("id") String lastName){
        List<StudentDto> students = studentService.getStudentByLastName(lastName);
        return ResponseEntity.ok(students);
    }

    //    Build Get Student by Criteria REST API
    @GetMapping("/get/email/{id}")
    public ResponseEntity<List<StudentDto>> getStudentByEmail(@PathVariable("id") String email){
        List<StudentDto> students = studentService.getStudentByEmail(email);
        return ResponseEntity.ok(students);
    }

    //Build Update Student REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") String id, @RequestBody StudentDto updateStudent) {
        StudentDto studentDto = studentService.updateStudent(id,updateStudent);
        return ResponseEntity.ok(studentDto);
    }

    //Build Delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String studentNumber) {
        studentService.deleteStudent(studentNumber);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
