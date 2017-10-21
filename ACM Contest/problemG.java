import java.util.Scanner;

public class problemG {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {


            int n = input.nextInt();

            if (n==-1) break;

            int l = input.nextInt();

            double result = (l/Math.tan(2*Math.PI/(2*n)));

            System.out.printf("%.3f%n",result);
        }

    }
}
