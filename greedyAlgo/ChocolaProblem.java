import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ChocolaProblem {

    public static void main(String[] args) {

        int n = 4;
        int m = 6;

        Integer costHor[] = { 4, 1, 2 };
        Integer costVer[] = { 2, 1, 3, 1, 4 };

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;

        int cost = 0;

        while (v < costVer.length && h < costHor.length) {

            if (costVer[v] <= costHor[h]) {

                // horizontal cut

                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                // vertical cut

                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h<costHor.length){
            cost += costHor[h]*vp;
            hp++;
            h++;
        }
        while(v<costVer.length){

            cost+= costVer[v] *hp;
            vp++;
            v++;
        }

        System.out.println("Minimum cost for the single pieces of the chocolate is : "+cost);
    }
}