
import java.util.LinkedList;

public class checkpalindromeLL {

    public static boolean isPalindrome(LinkedList<Integer> head){

        for(int i=0;i<head.size()-1;i++){
            if(head.get(i) == head.get(head.size()-1)){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args){

        LinkedList<Integer>ll = new LinkedList<>();

        
    }
    
}
