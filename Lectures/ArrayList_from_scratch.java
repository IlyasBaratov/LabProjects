public class ArrayList_from_scratch {
    public static void main(String[] args) {
        NodeArray<Integer> list = new NodeArray<>();
        int [] numbers= {1,2,3,4,5,6,7,8,4,23,3,523,5,67,2,234,64,565};
        for (int n : numbers){
            list.add(n);
        }
        System.out.println(list.toString());
    }
}
class NodeArray <T> {
    private T[] array;
    private int size;

    public NodeArray(){
        array = (T[]) new Object[5];
        size=0;
    }
    public void add(T element){
        if (size==array.length){
            resize();
        }
        array[size] = element;
        size++;
    }
    private void resize(){
        T [] newArray = (T[]) new Object[array.length*2];
        for (int i=0; i<array.length;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public T get(int index){
        if (index>=size || index<0){
            throw new IndexOutOfBoundsException("index: "+index+", Size: "+size);
        }
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder out= new StringBuilder("[");
        for (int n=0; n<array.length; n++) {
            if (array[n] != null) {
                out.append(array[n]);
                if (n < size - 1) {
                    out.append(", ");
                }
            }
            else continue;
        }
        out.append("]");
        return out.toString();
    }
}
