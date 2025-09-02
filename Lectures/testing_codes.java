import java.awt.*;

public class testing_codes implements Comparable<Point>{
    private int x;
    private int y;
    public testing_codes(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point other){
        if (x < other.x){
            return -1;

        } else if (x > other.x) {
            return 1;
        }
        else return 0;
    }

    public static void main(String[] args) {

    }
}
