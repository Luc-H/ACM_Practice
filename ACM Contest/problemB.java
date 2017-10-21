import java.util.Scanner;

public class problemB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            char[] p = input.nextLine().toCharArray();
            int[] b = kmpPreprocess(p);

            for (int i = 0; i < p.length; i++) {
                System.out.printf("%3d", i);
            }
            System.out.println();

            for (int i = 0; i < p.length; i++) {
                System.out.printf("%3c", p[i]);
            }

            System.out.println();

            for (int i = 0; i < b.length; i++) {
                System.out.printf("%3d", b[i]);
            }

            System.out.println();
        }
    }

    private static int[] kmpPreprocess(char[] p) {
        int[] b = new int[p.length + 1];

        b[0] = -1;

        int i = 0;
        int j = -1;

        while (i < p.length) {
            while (j >= 0 && p[i] != p[j]) j = b[j];

            i++;
            j++;
            b[i] = j;
        }

        return b;
    }
}
