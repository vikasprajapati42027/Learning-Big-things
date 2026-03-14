// The CONTROLLER (The Brain)
public class CourseController {
    private Course model;
    private CourseView view;

    public CourseController(Course model, CourseView view) {
        this.model = model;
        this.view = view;
    }

    public void setCourseName(String name) { model.setCourseName(name); }
    public void updateView() {
        view.printCourseDetails(model.getCourseName(), model.getCourseId());
    }
}
