import java.util.Scanner;

public class problemD {

    static int n;
    static int[] p;
    static int[] t;
    static int[] times;
    static boolean[] fallen;
    static boolean[] tempFallen;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while ((n = input.nextInt()) != -1) {


            p = new int[n];
            t = new int[n];
            times = new int[n];
            fallen = new boolean[n];
            tempFallen = new boolean[n];

            for (int i = 0; i < n; i++) {
                p[i] = input.nextInt();
            }

            for (int i = 0; i < n; i++) {
                t[i] = input.nextInt();
            }

            long startTime = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                times[i] = p[i] * t[personBefore(i)];
            }

            while (true) {
                //Find next person to fall
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (!fallen[i] && !fallen[personBefore(i)] && times[i] < min) {
                        min = times[i];
                    }
                }

                if (min == Integer.MAX_VALUE) { //Nobody could fall
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if (!fallen[i] && !fallen[personBefore(i)] && times[i] == min) {
                        tempFallen[i] = true;
                    }
                }

                for (int i = 0; i < n; i++) {
                    fallen[i] = tempFallen[i];
                }
            }

            boolean allFallen = true;

            for (int i = 0; i < n; i++) {
                if (!fallen[i]) {
                    allFallen = false;
                    System.out.print(i + 1);

                    if (i != n - 1) {
                        System.out.print(" ");
                    }
                }
            }

            if (allFallen) {
                System.out.print("0");
            }

            System.out.println();
        }
    }

    private static int personBefore(int i) {
        if (i - 1 > -1) {
            return i - 1;
        } else {
            return n - 1;
        }
    }
}
