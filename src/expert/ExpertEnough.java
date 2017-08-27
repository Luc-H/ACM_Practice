package expert;

import java.util.Scanner;

public class ExpertEnough
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 0; i < T; i++)
		{
			int D = input.nextInt();
			String[] cars = new String[D];
			for (int j = 0; j < D; j++)
			{
				cars[j] = input.nextLine();
			}

			int numQueries = input.nextInt();

			for(int k=0; k<numQueries; k++)
			{
				int price = input.nextInt();
				int cnt =0;
				for(int u=0; u<D; u++)
				{
				}
			}
		}
	}
}
