import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        Roster roster = new Roster("main");



        for (int i = 0; i < numberOfStudents; i++) {

            final String student = sc.next();
            final String module = sc.next();
            final String assessment = sc.next();
            final String grade = sc.next();

            final Assessment newAssessment = new Assessment(assessment, grade);
            final Module newModule = new Module(module).put(newAssessment);
            final Student newStudent = new Student(student).put(newModule);
            //Check if student present, or module present in student else 
            //add student, module or assessment
            roster.get(student).ifPresentOrElse(
                stud -> stud.get(module).ifPresentOrElse(
                    mod -> mod.put(newAssessment), 
                    () -> stud.put(newModule)
                    ),
                () -> roster.put(newStudent)
            );

        }

        while (sc.hasNext()) {            
            String student = sc.next();
            String module = sc.next();
            String assessment = sc.next();
            try {
                System.out.println(roster.getGrade(student, module, assessment));
            } catch (java.util.NoSuchElementException ex) {
                System.out.println(
                        "NoSuchRecordException: No such record: " + 
                        student + " " + module + " " + assessment
                );
            }
        }
    }
}


