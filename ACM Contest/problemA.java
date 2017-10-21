import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
import java.util.StringTokenizer;

public class problemA {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        continuousLoop: while (true) {
            String nextLine = input.nextLine();

            int[] alphabetArray = new int[26];

            if (nextLine.equals("-1"))
                System.exit(0);

            StringTokenizer thisLine = new StringTokenizer(nextLine);
            int numOfWords = 0;

            int numTokens = thisLine.countTokens();
            for (int n = 0; n < numTokens; n++) {
                //System.out.println(n + " " + numTokens);
                String currentToken = thisLine.nextToken();
                //System.out.println(currentToken);
                boolean isWord = false;
                innerLoop: for (int eachChar = 0; eachChar < currentToken.length(); eachChar++) {

                    if (Character.isLetter(currentToken.charAt(eachChar))) {
                        isWord = true;
                        break innerLoop;
                    }
                }

                if (isWord) numOfWords++;

            }

            for (int i = 0; i < nextLine.length(); i++) {
                char currChar = nextLine.charAt(i);

                if (Character.isLetter(currChar)) {
                    alphabetArray[(int)(Character.toLowerCase(currChar))-97]++;
                }
            }

            System.out.print(numOfWords + " ");

            for (int j = 0; j < alphabetArray.length - 1; j++) {
                System.out.print(alphabetArray[j] + " ");
            }
            System.out.print(alphabetArray[25] + "\n");

        }

    }
}
