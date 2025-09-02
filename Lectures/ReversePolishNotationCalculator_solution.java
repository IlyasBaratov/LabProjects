// Luca Benoit
// ITCS 143
// 2024 spring
// A4.0
// This program reads a Reverse Polish Notation mathematical Expression
// and evaluates it.  The program will show each step if the user chooses that
// otherwise the program will only print out the end result
//

// Ilyas Baratov
// IT-CS143
// 05/23/2024
// Final version


import java.util.*;

public class ReversePolishNotationCalculator_solution {

    // This gets the remainder of the input out of the Scanner
    // prints that remaining input (and also prints out the current contents of the
    // stack)
    // and then re-loads the remaining input into a new Scanner
    // This means that we can keep Scanning the remainder of the input
    private static Scanner printRemainingExpression(Stack<Double> numbers, Scanner scExpression) {

        String remainderOfExpr = scExpression.nextLine();
        System.out.println("Remaining expression: " + remainderOfExpr + " Stack: " + numbers);
        scExpression.close(); // may as well close out the old one before creating a new replacement
        return new Scanner(remainderOfExpr + "\n");
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        char evalAgain = 'y';

        ShouldWeTryAgain: while (evalAgain == 'y') {
            double nextNumber = 0;

            System.out.println("\nRPN calculator");
            System.out.println("\tSupported operators: + - * /");
            System.out.print("Type your RPN expression in so that it can be evaluated: ");
            String rpnExpr = keyboard.nextLine();

            boolean explain = false;
            System.out.print("Would you like me to explain how to expression is evaluated? (y or Y for yes, anything else means no) ");
            String szExplain = keyboard.nextLine().trim().toLowerCase();
            if (szExplain.length() == 1 && szExplain.charAt(0) == 'y') {
                System.out.println("We WILL explain the evaluation, step by step");
                explain = true;
            }
                        
            Stack<Double> numbers = new Stack<>();
            Scanner scExpr = new Scanner(rpnExpr + "\n");
            String op = null;
            while(scExpr.hasNext()) { // repeat the following while there's another token left in the Scanner:  
                if (explain) {
                    scExpr = printRemainingExpression(numbers, scExpr);
                }
                if (scExpr.hasNextDouble()) { // if the next thing in the expression is a number:
                   nextNumber = scExpr.nextDouble();
                   if (explain) {
                       System.out.println("\tPushing " + nextNumber + " onto the stack of operands (numbers)");
                   }
                   numbers.push(nextNumber);
                } else {// if the next thing in the expression is not a number then we'll assume it's an
                     op = scExpr.next();
                     if (op.length() > 1) {// (unless we find out that it's not a supported operator)
                        System.err.println("ERROR! Operator (non-numeric input) contains more than 1 character: " + op);
                        System.out.println("Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                        continue ShouldWeTryAgain; // This line will jump back to the outer loop
                     }
                  
               
              

            // // "4 3 -" should be +1, not -1
            // // When parsing the expression 4 is pushed first, then 3
            // // the second operand (the 3) is at the top (so we'll pop that into operand2)
            // // then pop the first operand (the 4) into operand1
            
                  if (numbers.isEmpty()) {
                       System.err.println("ERROR! Expected to find 2 operands (numbers) but we don't have any numbers on the stack!");
                       System.out.println("Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                       continue ShouldWeTryAgain;
                  }
                  Double op2 = numbers.pop(); /* get the top operand off the number stack */
      
                  if (numbers.isEmpty()) {
                       System.err.println("ERROR! Expected to find 2 operands (numbers) but we don't have a second number on the stack!");
                       System.out.println("Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                       continue ShouldWeTryAgain;
                  }
                  Double op1 = numbers.pop(); /* get the top operand off the number stack */
                      
                  Double result = 0.0;
                  switch (op) {
                      case ("+"):
                          result = op1 + op2;
                          break;
                      case ("-"):
                          result = op1 - op2;
                          break;
                      case ("*"):
                          result = op1 * op2;
                          break;
                      case ("/"):
                          result = op1 / op2;
                          break;    
                      default:
                          System.err.println("ERROR! Operator not recognized: " + op);
                          System.out.println("Since we can't evaluate that expression we'll ask you for another one to evaluate instead");
                          continue ShouldWeTryAgain; // This line will jump back to the outer loop
                  }
                  
                  if (explain) {
                      System.out.println("\tPopping " + op1 + " and " + op2
                       + " then applying " + op + " to them, then pushing the result of " + op1 + " " + op + " " + op2 + " back onto the stack");
                  }
                  numbers.push(result);
              }
            }
     
            // At this point we've finished reading through the expression

            if (numbers.size() > 1) { // Go through all the operands a print them out:
               System.err.println("ERROR! Ran out of operators before we used up all the operands (numbers):");
               System.err.println("\t" + numbers);
            }

            if (numbers.isEmpty()) {// If there wasn't any operands then print out this error message:
               System.err.println("ERROR! Ran out of operands (numbers)");
            }

            if (numbers.size() == 1) {// If there's exactly 1 operand then it must be the answer
               System.out.println("END RESULT: " + numbers.peek());
            }

            System.out.print("\nWould you like to evaluate another expression? (y or Y for yes, anything else to exit) ");
            String repeat = keyboard.nextLine().trim().toLowerCase();
            if (repeat.length() == 1 && repeat.charAt(0) == 'y')
                evalAgain = 'y';
            else
                evalAgain = 'n';
        }
        System.out.println("Thank you for using RPN Calculator!");
    }
}