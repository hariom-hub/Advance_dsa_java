import java.util.ArrayList;

public class checkMonotonic {

    public static boolean Checkmonotonic(ArrayList<Integer> lists) {

        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < lists.size() - 1; i++) {

            if (lists.get(i) > lists.get(i + 1)) {
                inc = false;
            }
            if (lists.get(i) < lists.get(i + 1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(Checkmonotonic(list));
    }
}