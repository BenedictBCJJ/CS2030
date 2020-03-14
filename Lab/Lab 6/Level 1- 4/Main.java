import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        String student;
        String module;
        String assessment;
        String grade;
        Assessment newAssessment;
        Module newModule;
        Student newStudent;

        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        Roster roster = new Roster("main");



        for (int i = 0; i < numberOfStudents; i++) {

            student = sc.next();
            module = sc.next();
            assessment = sc.next();
            grade = sc.next();
            newAssessment = new Assessment(assessment, grade);
            newModule = new Module(module).put(newAssessment);
            newStudent = new Student(student).put(newModule);


            if (roster.get(student) != null && roster.get(student).get(module) != null) {
                roster.get(student).get(module).put(newAssessment);
            } else if (roster.get(student) != null) {
                roster.get(student).put(newModule);
            } else {
                roster.put(newStudent);
            }

            
        }
        while (sc.hasNext()) {
            student = sc.next();
            module = sc.next();
            assessment = sc.next();

            try {
                grade = roster.getGrade(student, module, assessment);
                System.out.println(grade);
            } catch (NoSuchRecordException ex) {
                System.out.println(ex);
            }
        }
    }
}

