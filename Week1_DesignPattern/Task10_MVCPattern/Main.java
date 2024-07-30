public class Main {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", 123, "A");

        // Create a StudentView
        StudentView view = new StudentView();

        // Create a StudentController
        StudentController controller = new StudentController(student, view);

        // Update view with initial details
        controller.updateView();

        // Update student details using controller
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Update view with new details
        controller.updateView();
    }
}
