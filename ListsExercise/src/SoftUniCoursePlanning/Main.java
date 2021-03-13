package SoftUniCoursePlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();
        String[] arrayOfLessons = scanner.nextLine().split(", ");

        for (String lesson : arrayOfLessons) {
            Course course = new Course(lesson);
            courses.add(course);
        }

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] command = input.split(":");
            String action = command[0];

            switch (action) {
                case "Add" -> {
                    String lessonToAdd = command[1];
                    if (!contain(courses, lessonToAdd)) {
                        Course course = new Course(lessonToAdd);
                        courses.add(course);
                    }
                }
                case "Swap" -> {
                    String lesson1 = command[1];
                    String lesson2 = command[2];
                    if (contain(courses, lesson1) && contain(courses, lesson2)) {
                        int lesson1Index = returnIndex(courses, lesson1);
                        int lesson2Index = returnIndex(courses, lesson2);

                        Course oldLesson = courses.get(lesson1Index);
                        courses.set(lesson1Index, courses.get(lesson2Index));
                        courses.set(lesson2Index, oldLesson);
                    }
                }
                case "Remove" -> {
                    String lessonToRemove = command[1];
                    if (contain(courses, lessonToRemove)) {
                        int indexOfLesson = returnIndex(courses, lessonToRemove);
                        courses.remove(indexOfLesson);
                    }
                }
                case "Exercise" -> {
                    String lessonTitle = command[1];
                    String lessonExerciseTitle = lessonTitle + "-Exercise";
                    if (contain(courses, lessonTitle)) {
                        int indexOfLesson = returnIndex(courses, lessonTitle);
                        if (courses.get(indexOfLesson).getExerciseLesson().equals("None")) {
                            courses.get(indexOfLesson).setExerciseLesson(lessonExerciseTitle);
                        }
                    } else {
                        Course course = new Course(lessonTitle, lessonExerciseTitle);
                        courses.add(course);
                    }
                }
                case "Insert" -> {
                    String lessonNameToInsert = command[1];
                    int index = Integer.parseInt(command[2]);
                    if (!contain(courses, lessonNameToInsert)) {
                        int realIndex = refactorIndex(courses, index);
                        Course course = new Course(lessonNameToInsert);
                        courses.add(realIndex, course);
                    }
                }
            }
            input = scanner.nextLine();
        }
        int countObj = 0;
        int numberInList = 1;
        while (countObj < courses.size()) {
            if (courses.get(countObj).getExerciseLesson().equals("None")) {
                System.out.println(numberInList + "." + courses.get(countObj).getLessonName());
                numberInList++;
            } else {
                System.out.println(numberInList + "." + courses.get(countObj).getLessonName());
                numberInList++;
                System.out.println(numberInList + "." + courses.get(countObj).getExerciseLesson());
                numberInList++;
            }
            countObj++;
        }
    }
    static int refactorIndex(List<Course> courses, int index){
        int indexCount = 0;
        int indexToReturn = 0;

        while (indexCount < index){
            if (!courses.get(indexToReturn).getExerciseLesson().equals("None")) {
                indexCount++;
            }else {
                indexCount += 2;
            }
            indexToReturn++;
        }
        return indexToReturn;
    }

    static boolean contain(List<Course> courses, String lesson){
        for (Course course : courses) {
            if (course.getLessonName().equals(lesson)){
                return true;
            }
        }
        return false;
    }
    static int returnIndex(List<Course> courses, String lesson){
        int index = -1;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getLessonName().equals(lesson)){
                index = i;
            }
        }
        return index;
    }
}
