import java.util.Arrays;

public class bubbles {

    public static void main(String[] args) {
        int[] x = { 1, 2, 4, 5, 7, 5, 3, 67, 8 };
        bubblesTransformer(x);
     for(int s: x){
System.out.println(s);
     }
    }

    public static void bubblesTransformer(int[] list) {

        for (int phase = 0; phase < list.length; phase++) {
System.out.println("i here now");
                for (int i = 0; i < list.length - 1; i++) {
                    System.out.println("im inside");
                if (list[i] > list[i + 1]) {
      System.out.println("im switching now");
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                }

            }
        }

    }

}