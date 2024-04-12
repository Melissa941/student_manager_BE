package demo.student_manager.utils;

public class StudentNumberGenerator {

    private static int studentCounter = 1;

    public static String generateStudentNumber(String firstName, String lastName) {
        // Extract first letter of first name
        String firstLetterFirstName = firstName.substring(0, 1).toUpperCase();
        // Extract first letter of last name
        String firstLetterLastName = lastName.substring(0, 1).toUpperCase();
        // Generate 6-digit number based on studentCounter
        String numbers = String.format("%06d", studentCounter++);
        // Concatenate the components to form the student number
        return firstLetterFirstName + numbers + firstLetterLastName;
    }
}