//public class test_codes_3{
//    public static void main(String[] args) {
//        linked_list_2<String> first = new linked_list_2<>();
//        first.add("Ilyas");
//        first.add("Baratov");
//        first.add("Hasan ogly");
//        System.out.println(first);
//    }
//}
//class linkedNode <T>{
//    T value;
//    linkedNode<T> next;
//    public linkedNode(T value){
//        this.value = value;
//        this.next = null;
//    }
////    public int countNodes(){
////
////    }
//}
//class linked_list_2<T> {
//    private linkedNode<T> head;
//
//    public linked_list_2(){
//        this.head = null;
//    }
//    public void add(T node){
//        linkedNode<T> first = new linkedNode<>(node);
//        first.next = head;
//        head = first;
//    }
//    public String toString(){
//        linkedNode<T> first = head;
//        StringBuilder out = new StringBuilder("[");
//        while (first.next!=null){
//            out.append(first.value);
//            first = first.next;
//        }
//        out.append("]");
//        return out.toString();
//    }
//}