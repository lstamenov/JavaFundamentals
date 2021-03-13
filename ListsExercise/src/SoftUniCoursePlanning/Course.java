package SoftUniCoursePlanning;

public class Course {
    String lessonName;
    String exerciseLesson = "None";

    Course(String lessonName){
        this.lessonName = lessonName;
    }

    Course(String lessonName, String exerciseLesson){
        this.lessonName = lessonName;
        this.exerciseLesson = exerciseLesson;
    }


    public String getLessonName() {
        return lessonName;
    }

    public String getExerciseLesson() {
        return exerciseLesson;
    }

    public void setExerciseLesson(String exerciseLesson) {
        this.exerciseLesson = exerciseLesson;
    }
}
