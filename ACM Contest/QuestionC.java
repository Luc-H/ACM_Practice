import java.util.Scanner;

public class QuestionC {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = "";
        String[] temp = line.split(" ");

        // = answer
        int[] nums = new int[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            nums[i]=Integer.parseInt(temp[i]);
        }

    }
}
