package demo.student_manager.exception;


public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

//public class StudentScoreServiceException extends RuntimeException {
//    public StudentScoreServiceException(String message) {
//        super(message);
//    }
//}
