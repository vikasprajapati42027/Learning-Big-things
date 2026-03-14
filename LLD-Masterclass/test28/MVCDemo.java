public class MVCDemo {
    public static void main(String[] args) {
        Course model = new Course();
        model.setCourseId("JAVA-101");
        model.setCourseName("Core Java Mastery");

        CourseView view = new CourseView();
        CourseController controller = new CourseController(model, view);

        controller.updateView();
        controller.setCourseName("Advanced Java LLD");
        controller.updateView();
    }
}
