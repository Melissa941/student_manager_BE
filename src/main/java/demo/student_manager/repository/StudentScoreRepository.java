package demo.student_manager.repository;

import demo.student_manager.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, String> {

    List<StudentScore> findByStudentStudentNumber(String studentNumber) ;
}