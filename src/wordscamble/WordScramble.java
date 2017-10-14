package wordscamble;

import java.util.Arrays;
import java.util.Scanner;

public class WordScramble
{
	public static void main(String[] args)
	{
		Scanner inS = new Scanner(System.in);

		String sentence = inS.nextLine();

		String[] words = sentence.split(" ");
		String[] newWords = new String[words.length];

		for(int i=0;i<words.length;i++)
		{
			newWords[i]=reverse(words[i]);
		}
		for(int i=0;i<newWords.length;i++)
		{
			System.out.println(newWords[i]);
		}

	}

	private static String reverse(String a)
	{
		char[] b = a.toCharArray();
		char[] c = new char[b.length];
		for(int i =0;i<c.length;i++)
		{
			c[i]=b[b.length-i-1] ;
		}
		return Arrays.toString(c);
	}

}
