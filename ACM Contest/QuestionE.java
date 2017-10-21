import java.util.Scanner;

public class QuestionE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        while(!line.equals("-1"))
        {
            String[] temp = line.split(" ");

            Integer A = Integer.parseInt(temp[0]);
            Integer B = Integer.parseInt(temp[1]);
            Integer divisor = A/B;
            Integer remainder = A%B;

            System.out.printf("  " );

            line = "-1";

        }
    }
}
