public class lexicoSmall {

    public static String smallestString(int n, int k) {

        StringBuilder sb = new StringBuilder();
        int totalChars = n;
        int currSum = k;

        while (totalChars > 0) {

            if ((totalChars - 1) * 26 >= (currSum - 1)) {

                sb.append('a');
                currSum--;
            } else {

                int position = currSum % 26;
                if (position == 0) {
                    sb.append('z');
                    currSum -= 26;
                } else {
                    sb.append((char) (position-1+ 'a')); //reference point
                    currSum -= position;
                }
            }
            totalChars--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        
        int n = 5;
        int k = 42;
        System.out.println(smallestString(n, k));
    }
}
