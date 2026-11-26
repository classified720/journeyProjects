package journeyProjects;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String args[]){
        menu();

    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        int [] scores = new int[30];
        String[] marks = {"1.Add student","2.Show all", "3.Show stats","4.Quit"};

        while(true){

            for(int i=0; i<marks.length; i++){
                System.out.println(marks[i]);
            }
            System.out.print("Enter a choice: ");
            int choice = Integer.valueOf(scanner.nextLine());

            if (choice == 4){
                break;

            }else if(choice == 1){
                addStudents(scanner,students,scores);

            }else if(choice == 2){
                ShowAll(scanner, students, scores);

            }else if(choice == 3){
                System.out.println("wait");

            }else{
                System.out.println("Invalid Choice!");
            }
        }
        scanner.close();
    }
    public static void addStudents(Scanner scanner, ArrayList<String> students, int[] scores){

        while (students.size() < scores.length) {
            System.out.print("Enter student name (or 'done' to stop): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            int score;

            while (true) {
                System.out.print("Enter score: ");
                score = Integer.valueOf(scanner.nextLine());
                if (score >= 0 && score <= 100) {
                    break;
                }
                System.out.println("Invalid input, score must be 0 to 100");
            }


            scores[students.size()] = score;
            students.add(name);
        }

    }
    public static void ShowAll(Scanner scanner, ArrayList<String> students, int[] scores){
        boolean stop = false;
        System.out.println();
        System.out.println("Here are the entered students and their respective marks:");
        System.out.println();
        while (!stop){
            if(students.size() ==0){
                System.out.println("No Students Added Yet!");
                break;
            }
            for (int i=0; i< students.size(); i++){
                System.out.printf("%s: %d :%s\n", students.get(i),scores[i],letterGrade(scores[i]));
            }
            stop = true;
        }
        System.out.println();
    }
    public static String letterGrade(int score){
        if (score >= 80){
            return "A";
        }else if (score >= 70){
            return "B";
        }
        else if (score >= 60){
            return "C";
        }
        else if (score >= 50){
            return "D";
        }
        else if (score >= 40){
            return "E";
        }
        else{
            return "F";
        }
            

    }

}