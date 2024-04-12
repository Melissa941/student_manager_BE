package demo.student_manager.service;

import demo.student_manager.entity.StudentScore;
import java.util.List;

public interface StudentScoreService {

    StudentScore saveScore(String studentNumber, StudentScore studentScore);

    List<StudentScore> getScoresByStudentNumber(String studentNumber);
}