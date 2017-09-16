package sultan;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class SultanGarden
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//Input
		//Test cases
		int T = input.nextInt();
		String[] cases = new String[T];
		for (int i = 0; i < T; i++)
		{
			cases[i] = input.next();
		}

		Stack<Character> myStack = new Stack<Character>();
		//Case output
		for(int j=0;j<T;j++)
		{
			myStack.push(cases[j].charAt(0));
			for(int i =1;i<cases[j].length();i++)
			{
				myStack.push(cases[j].charAt(i));
			}

		}



	}


}
