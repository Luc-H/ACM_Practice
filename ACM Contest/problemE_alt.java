import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

public class problemE_alt {

    private static ArrayList<Integer> daddy = new ArrayList<Integer>();
    private static ArrayList<Integer> mommy = new ArrayList<Integer>();
    private static ArrayList<Integer> sister = new ArrayList<Integer>();
    private static ArrayList<Integer> brother = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            daddy.clear();
            mommy.clear();
            sister.clear();
            brother.clear();

            String line = input.nextLine();
            if (line.equals("-1")) System.exit(0);

            String[] currentQuery = line.split(" ");
            Integer numerator = Integer.parseInt(currentQuery[0]);
            Integer denominator = Integer.parseInt(currentQuery[1]);

            String cache = numerator.toString();

            int currDigit = Integer.parseInt(cache.substring(0,1));
            cache = cache.substring(1); // trims leading character
            while (true) {
                try {
                    brother.add(div(currDigit,denominator)+Integer.parseInt(cache.substring(0,1)));
                } catch (Exception E) {
                    break;
                }
                currDigit = brother.get(brother.size()-1);
                if (cache.length()>1) {
                    cache = cache.substring(1); // trims leading character
                } else {
                    // last time
                    cache = "";
                    div(currDigit,denominator);
                    break;
                }


            }
            /*
            System.out.println(daddy.toString());
            System.out.println(mommy.toString());
            System.out.println(sister.toString());
            System.out.println(brother.toString());
            */

            // FORMATTING
            String topLine = "  ";
            for (Object i : daddy.toArray()) {
                topLine+=i.toString();
            }
            if (sister.get(sister.size()-1) != 0) {
                topLine += "r" + sister.get(sister.size()-1);
            }
            System.out.println(topLine);

            String secondLine = " +";
            for (int i = 0; i < topLine.length() - 2; i++) {
                secondLine += "-";
            }
            System.out.println(secondLine);

            System.out.println(denominator + "|" + numerator);

            int level = 3;
            int count = 0;

            while(count < sister.size()) {
                printAtLevel(level,String.valueOf(mommy.get(count)));
                printAtLevel(level,addChars("",String.valueOf(mommy.get(count)).length(),"-"));
                level++;
                try {
                    printAtLevel(level,String.valueOf(brother.get(count)));
                    //count++;
                } catch (Exception e) {
                    break;
            }
            count++;

            //String padding = " ";
            /*
            while (count < sister.size()) {
                if (mommy.get(count) < 10) padding += " ";
                System.out.println(padding + mommy.get(count));
                System.out.println(padding + addChars("",String.valueOf(mommy.get(count)).length(),"-"));
                try {
                    if (sister.get(count) == 0)
                        padding = addChars(padding,1," ");
                    System.out.println(padding + brother.get(count));
                    //padding = addChars(padding.toString(),String.valueOf(brother.get(count)).length()," ");
                } catch(Exception e) {
                    break;
                }
                //
                count++;
                */
            }

            printAtLevel(level-1,String.valueOf(sister.get(sister.size()-1)));
            //System.out.println(padding + sister.get(sister.size()-1));

            System.out.println("-*-");

        }

    }

    private static int div(int num, int den) {
        int whole = num/den;
        int remainder = num%den;

        daddy.add(whole);
        mommy.add(whole*den);
        sister.add(num - whole*den);

        return 10*remainder;

    }

    private static String addChars(String in, int n, String toAdd) {
        for (int i = 0; i < n; i++) {
            in += toAdd;
        }
        return in;
    }

    private static String fillLeft(String in, int n) {
        String temp = "";
        for (int j = 0; j< n; j++) {
            temp += " ";
        }
        return temp + in;
    }

    private static void printAtLevel(int level, String number) {
        int whitespace = level - number.length();
        System.out.println(fillLeft(number,whitespace));
    }

}
