package Practices;

import java.util.Arrays;
import java.util.Stack;

public class Stack_class_methods {
    public static void main(String[] args) {
        String [] words = {"hello", "hi", "goodbye", "howdy"};
        Stack <String> stacks = new Stack<>();
        stacks.addAll(Arrays.asList(words));
        System.out.println(largest(stacks));

    }
    public static String largest (Stack<String> stacks){
        Stack <String> temp_stack = new Stack<>();
        String longest_word="";
        int length=0;
        while (!stacks.isEmpty()){
            String current = stacks.pop();
            temp_stack.push(longest_word);
            if (current.length()>length){
                longest_word = current;
                length = current.length();

            }
        }
        while (!temp_stack.isEmpty()){
            stacks.push(temp_stack.pop());
        }
        System.out.println(stacks);
        return longest_word;
    }
    public static void first_method(){
        Stack <String> stack = new Stack<>();
        String [] a = {"Ilyas", "Baratov", "Hasanovich"};
        stack.addAll(Arrays.asList(a));
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
