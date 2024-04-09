
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//gre

public class Activities {

    public static void main(String[] args) {

        // aaya samajh👍👍👍
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int activities = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {

            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function
        Arrays.sort(activities,Comparator<T>.comparingDouble(o -> o[2]));

        // end time bases sorting
        int maxAct = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        int lastEnd = end[0];
        maxAct = 1;
        ans.add(0);

        for (int i = 1; i < end.length; i++) {

            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Number of activities : " + maxAct);
        // Activities

        System.out.println("selected activities ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}