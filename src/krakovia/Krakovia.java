package krakovia;

import java.math.BigInteger;
import java.util.Scanner;

public class Krakovia
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int F = input.nextInt();
		int cnt = 1;
		while (N != 0 &&F != 0)
		{
			BigInteger[] items = new BigInteger[N];
			for (int i = 0; i < N; i++)
			{
				items[i] = input.nextBigInteger();
			}


			for (int i = 1; i < items.length; i++)
			{
				items[0] = items[0].add(items[i]);
			}
			System.out.print("Bill #" + cnt + " costs " + items[0] + ": each friend should pay " + items[0].divide(new BigInteger("" + F)));
			cnt++;
			N = input.nextInt();
			F = input.nextInt();
		}
	}
}
