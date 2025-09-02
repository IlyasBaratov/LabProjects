//import java.util.*;
//
//class Lecture05 {
//    public static void main(String[] args) {
//        System.out.println("Hello from lecture 05");
//
//        // Self-Check Problems:
//        // From Section 11.3:
//        // 16. Write the code to declare a Map that associates people’s names with their   Done!
//        // ages.
//        // Add mappings for your own name and age, as well as those of a few friends or
//        // relatives.
//        Map<String, String> family = new HashMap<>();
//        family.put("father", "Hasan");
//        family.put("mother", "Zulyayha");
//        family.put("brother", "Chary");
////        System.out.println(family);
//
//        // 18. What keys and values are contained in the following map after this code Done!
//        // executes?
//
//        // Map<Integer, String> map = new HashMap<>();
//        // map.put(8, "Eight");
//        // map.put(41, "Forty-one");
//        // map.put(8, "Ocho");
//        // map.put(18, "Eighteen");
//        // map.put(50, "Fifty");
//        // map.put(132, "OneThreeTwo");
//        // map.put(28, "Twenty-eight");
//        // map.put(79, "Seventy-nine");
//        // map.remove(41);
//        // map.remove(28);
//        // map.remove("Eight");
//        // map.put(50, "Forty-one");
//        // map.put(28, "18");
//        // map.remove(18);
//
////        50=Forty-one, 132=OneThreeTwo, 8=Ocho, 28=18, 79=Seventy-nine
//
//        // 19. Write the output produced when the following method is passed each of the    Done!
//        // following maps:
//
//        // public static void mystery(Map<String, String> map) {
//        // Map<String, String> result = new TreeMap<>();
//        // for (String key : map.keySet()) {
//        // if (key.compareTo(map.get(key)) < 0) {
//        // result.put(key, map.get(key));
//        // } else {
//        // result.put(map.get(key), key);
//        // }
//        // }
//        // System.out.println(result);
//        // }
//        // {two=deux, five=cinq, one=un, three=trois, four=quatre}
//        // {skate=board, drive=car, program=computer, play=computer}
//        // {siskel=ebert, girl=boy, H=T, ready=begin, first=last, begin=end}
//        // {cotton=shirt, tree=violin, seed=tree, light=tree, rain=cotton}
//
////        Answers:
//
////        {cing=five, deux=two, four=quatre, one=un, three=trois}
////        {board=skate, car=drive, computer=program}
////        {H=T, begin=end, boy=girl, ebert=siskel, first=last}
////        {cotton=shirt, light=tree, speed=tree, tree=violin}
//
//
//
//        // Exercises:
//        // 6. Write a method countUnique that accepts a list of integers as a parameter   Done!
//        // and returns the number of unique integer values in the list.
//        // Use a set as auxiliary storage to help you solve this problem. For example,
//        // if a list contains the values [3, 7, 3, –1, 2, 3, 7, 2, 15, 15], your method
//        // should return 5. The empty list contains 0 unique values.
//        Integer [] a_2 ={3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
//        List<Integer> for_Couont = new ArrayList_from_scratch<>(Arrays.asList(a_2));
//        int length_of_the_method = countUnique(for_Couont).toArray().length;
////        System.out.println(length_of_the_method);
//
//        // 7. Write a method countCommon that accepts two lists of integers as    Done!
//        // parameters and returns the number of unique integers that occur in both
//        // lists.
//        // Use one or more sets as storage to help you solve this problem. For example,
//        // if one list contains the values [3, 7, 3, –1, 2, 3, 7, 2, 15, 15] and the
//        // other list contains the values [–5, 15, 2, –1, 7, 15, 36], your method should
//        // return 4 because the elements –1, 2, 7, and 15 occur in both lists.
//        List <Integer> first_for_counCommon = new ArrayList_from_scratch<>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));
//        List <Integer> second_for_countCommon = new ArrayList_from_scratch<>(Arrays.asList(-5, 15, 2, -1, 7, 15, 36));
////        System.out.println(countCommon(first_for_counCommon,second_for_countCommon));
//
//        // 8. Write a method maxLength that accepts a set of strings as a parameter and    Done!
//        // that returns the length of the longest string in the list.
//        // If your method is passed an empty set, it should return 0.
//        String [] problem_8 = {"abc","abcd","a","as"};
//        Set <String> for_problem_8 = new HashSet<>(Arrays.asList(problem_8));
////        System.out.println(maxLength(for_problem_8));
//
//        // 9. Write a method hasOdd that accepts a set of integers as a parameter and    Done!
//        // returns true if the set contains at least one odd integer and false
//        // otherwise.
//        // If passed the empty set, your method should return false.
//        Set<Integer> exercise_9 = new HashSet<>(Arrays.asList(12,14,2,1,6,80));
////        System.out.println(hasOdd(exercise_9));
//
//        // 10. Write a method removeEvenLength that accepts a set of strings as a    Done!
//        // parameter and that removes all of the strings of even length from the set.
//        Set<String> exercise_10 = new HashSet<>(Arrays.asList("1234","123","12","23456"));
//        removeEvenLength(exercise_10);
////        System.out.println(exercise_10);
//
//    }
//    public static Set<Integer> countUnique(List<Integer> list){
//        Set<Integer> out = new HashSet<>(list);
//        return out;
//    }
//    public static Set<Integer> countCommon(List<Integer> first, List<Integer> second){
//        Set<Integer> out = new HashSet<>();
//        Set<Integer> helping_1 = new HashSet<>(first);
//        Set<Integer> helping_2 = new HashSet<>(second);
//        for (int num: helping_1){
//            if (helping_2.contains(num)){
//                out.add(num);
//            }
//        }
//        return out;
//    }
//    public static int maxLength (Set<String> set) {
//        int count = 0;
//        if (set.isEmpty()) {
//            return 0;
//        }
//        for (String a : set) {
//            if (count < a.length()) {
//                count = a.length();
//            }
//        }
//        return count;
//    }
//    public static void removeEvenLength(Set<String> in){
//        in.removeIf(n -> n.length() % 2 == 0);
//    }
//    public static boolean hasOdd(Set<Integer> in){
//        in.removeIf(n->n%2==0);
//        if (in.isEmpty()){
//            return false;
//        }
//        return true;
//    }
//     public static void mystery(Map<String, String> map) {
//        Map<String, String> result = new TreeMap<>();
//        for (String key : map.keySet()) {
//            if (key.compareTo(map.get(key)) < 0) {
//                result.put(key, map.get(key));
//            } else {
//                result.put(map.get(key), key);
//            }
//        }
//        System.out.println(result);
//    }
//}
