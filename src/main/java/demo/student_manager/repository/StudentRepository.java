package demo.student_manager.repository;

import demo.student_manager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByFirstNameContainingIgnoreCase(String firstName) ;
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    List<Student> findByEmailContainingIgnoreCase(String email);
}
