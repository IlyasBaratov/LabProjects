import java.util.Arrays;
import java.util.Scanner;

class Lecture01 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 01");

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // Put your answer for #1 here: Done!

        // The output is: hello from lecture 01

        // Copy and paste the output from when you first cloned (downloaded) and ran
        // this program
        // (in other words, when you run this program, what does it print?
        // Copy that output into this file, right here, in a comment

        // Where in the textbook are the main topics for this question covered?

        // Put your answer for #2 here: Done!
        for (int i = 1; i <= 100; i++) {
             System.out.println(i);
        }

        // Where in the textbook are the main topics for this question covered?

        // Put your answer for #3 here: Done!
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                 System.out.print("*");
            }
             System.out.println();
        }

        // Where in the textbook are the main topics for this question covered?

        // Put your answer for #4 here: Done!

        Scanner input = new Scanner(System.in);
        System.out.print("How many rows would you like to print? ");
        int answer = input.nextInt();
        for (int i = 0; i < answer; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

        // Where in the textbook are the main topics for this question covered?

        // Put your answer for #5 here: Done!

        System.out.print("How many grades would you like to store? ");
        int number = input.nextInt();
        double [] list = new double[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Next grade? ");
            double grade = input.nextInt();
            list[i] = grade;
        }
        double sum = Arrays.stream(list).sum()/list.length;
        System.out.println("Average grade is: "+sum);

        // Where in the textbook are the main topics for this question covered?

        // Put your answer for #6 here: Done!
        // Where in the textbook are the main topics for this question covered?
        // NOTE: The definition of the Food class should go OUTSIDE the Lecture01
        // class. A good place to put this is at the end of the file.
        // NOTE 2: Make sure that you create a couple of Food objects here in main()
        Food candy = new Food("Candy",7,4.5);
        candy.setCallories(9);
        candy.print();
        Food burger = new Food("Burger",1000,3.6);
        burger.setRating(1);
        burger.print();
    }

}

// Placing the Food class below this line is a good place for it
class Food{
    private String name;



    private int callories = 0;
    private double rating = 0;
    public Food(){}
    public Food(String name, int callories, double rating){
        this.name = name;
        this.callories = callories;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCallories() {
        return callories;
    }

    public void setCallories(int callories) {
        this.callories = callories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public void print(){
        System.out.println("Name is: "+name+
                "\nCallories are: "+callories+
                "\nRating is: " +rating);
    }

}