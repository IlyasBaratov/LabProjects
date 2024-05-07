package Assignment_3;// This program creates a list of students and allows the user to
// lookup information about a student given the ID number.
// This is meant to loosely simulate what happens at the Student
// Services desk (Kodiak Corner here at Cascadia College).
//
// In real life when a student scans their Student ID card
// the computer reads their Student ID Number from the bar code
// The computer then looks up the information about the student
// and allows the employee to look and modify the information.
//

import java.util.*;


public class Student_Services_Desk {

    private static int nextSID = 22; // must be greater than any of the Students' IDs that we preload
    private static int count = 1;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Map<Integer, Student> studentInfo = new TreeMap<>();
        studentInfo.put(21, new Student(21, "Zog", "TheDestroyer",
                new ArrayList<String>(List.of("BIT 143", "MATH 411", "ENG 120"))));
        studentInfo.put(20,
                new Student(20, "Mary", "Sue", new ArrayList<String>(List.of("BIT 142", "MATH 142", "ENG 100"))));
        studentInfo.put(1,
                new Student(1, "Joe", "Bloggs", new ArrayList<String>(List.of("BIT 115", "MATH 141", "ENG 101"))));

        char choice = 'L'; // anything but 'q' is fine
        while (choice != 'q') {
            System.out.println("\nWhat would you like to do next? ");
            System.out.println("F - Find a specific student");
            System.out.println("L - List all the students (for debugging purposes)");
            System.out.println("A - Add a new student");
            System.out.println("D - Delete an existing student");
            System.out.println("M - Modify an existing student");
            System.out.println("Q - Quit (exit) the program");
            System.out.print("What is your choice?\n(type in the letter & then the enter/return key) ");
            choice = keyboard.nextLine().trim().toLowerCase().charAt(0);
            System.out.println();

            switch (choice) {
                case 'f': // Done!
                    System.out.println("Find a student (based on their ID number):\n");
                    // IMPORTANT NOTE: If you call keyboard.nextInt() (or .next(), or anything
                    // except nextLine() )
                    // then you should call keyboard.nextLine() to remove the newline (enter/return
                    // key) that nextInt()
                    // left on the input stream
                    // More info:
                    // https://hyunjileetech.github.io/java/2019/02/27/scan-nextLine()-after-scan-nextInt().html
                    // https://stackoverflow.com/a/11465208/250610
                    //
                    System.out.print("What is the ID number of the student to find? ");
                    int SID = keyboard.nextInt();
                    keyboard.nextLine();
                    if (studentInfo.containsKey(SID)){
                        System.out.println(studentInfo.get(SID).getFirstName()+", "+studentInfo.get(SID).getLastName()+"  (SID = "+SID+")");
                        System.out.println("Classes: ");
                        for (int i = 0; i < studentInfo.get(SID).getClasses().size(); i++) {
                            System.out.println("\t\t"+studentInfo.get(SID).getClasses().get(i));
                        }
                    }
                    else System.out.println("Didn't find a student with ID # " + SID);
                    break;

                case 'l': // Done!
                    if (studentInfo.isEmpty()){
                        System.out.println("There is no student in the system");
                        break;
                    }
                    System.out.println("The following students are registered:");
                    studentInfo.forEach((integer, student) -> System.out.println(student.toString()));
                    break;
                case 'a': // Done!
                    System.out.println("Adding a new student\n");
                    System.out.println("Please provide the following information:");
                    System.out.print("Student's first name? ");
                    String first_name = keyboard.nextLine();
                    System.out.print("Student's last name? ");
                    String last_name = keyboard.nextLine();
                    List<String> adding = new ArrayList<>();


                    while (true){
                        System.out.println("Type the name of class, or leave empty to stop.  Press enter/return regardless");
                        String classes = keyboard.nextLine().trim();
                        if (classes.isEmpty()){
                            break;
                        }
                        adding.add(classes);
                    }
                    studentInfo.put(nextSID+count, new Student(nextSID+count,first_name,last_name,adding));
                    count++;

                    break;
                case 'd': // Done!
                    System.out.println("Deleting an existing student\n");
                    System.out.print("What is the ID number of the student to delete? ");
                    int ID = keyboard.nextInt();
                    keyboard.nextLine();
                    if (studentInfo.containsKey(ID)){
                        studentInfo.remove(ID);
                        System.out.println("Student account found and removed from the system!");
                    }
                    else System.out.println("Didn't find a student with ID # " + ID);
                    break;
                case 'm':  // Done!
                    System.out.println("Modifying an existing student\n");
                    System.out.print("What is the ID number of the student to modify? ");
                    int key_id = keyboard.nextInt();
                    keyboard.nextLine();
                    if (!studentInfo.containsKey(key_id)){
                        System.out.println("Didn't find a student with ID "+key_id);
                        break;
                    }
                    System.out.println("Student account found!\nFor each of the following type in the " +
                            "new info or leave empty to keep the existing info. Press enter/return in both cases.");
                    System.out.print("Student's first name: " +
                            studentInfo.get(key_id).getFirstName()+ " New first name? ");
                    String new_first_name = keyboard.nextLine();
                    if (new_first_name.isEmpty()){
                        new_first_name =studentInfo.get(key_id).getFirstName();
                    }
                    System.out.print("Student's last name: " + studentInfo.get(key_id).getLastName() + " New last name? ");
                    String new_last_name = keyboard.nextLine();
                    if (new_last_name.isEmpty()){
                        new_last_name = studentInfo.get(key_id).getLastName();
                    }
                    System.out.println("Updating class list");
                    System.out.println("Here are the current classes: " + studentInfo.get(key_id).getClasses());
                    System.out.println("This program will go through all the current classes.");
                    System.out.println(
                            "For each class it will print the name of the class and then ask you if you'd like to delete or keep it.");
                    Iterator<String> iterator = studentInfo.get(key_id).getClasses().iterator();
                    while (iterator.hasNext()){
                        String class_name = iterator.next();
                        System.out.println( class_name
                                + "\nType \"d\" <enter/return> to remove, or just <enter/return> to keep ");
                        String ask = keyboard.nextLine();
                        if (ask.equals("d")){
                            iterator.remove();
                            System.out.println("Removing " + class_name + "\n");
                        }
                    }

                    while (true){
                        System.out.println("Type the name of the class you'd like to add, or leave empty to stop.  Press enter/return regardless");
                        String ask2 = keyboard.nextLine();
                        if (ask2.isEmpty()){
                            break;
                        }
                        else {
                            studentInfo.get(key_id).getClasses().add(ask2);
                        }
                    }
                    studentInfo.get(key_id).setFirstName(new_first_name);
                    studentInfo.get(key_id).setLastName(new_last_name);
                    break;
                case 'q':
                    System.out.println("Thanks for using the program - goodbye!\n");
                    break;
                default:
                    System.out.println("Sorry, but I didn't recognize the option " + choice);
                    break;
            }

        }
    }
}
