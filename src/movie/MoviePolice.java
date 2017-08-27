package movie;

import java.util.Scanner;

/**
 * 3 1
 * 000011
 * 1101111111
 * 1111100000
 * 1000111
 */
public class MoviePolice
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int numSignatures = input.nextInt();
		//System.out.println(numSignatures);
		int numClips = input.nextInt();
		//System.out.println(numClips);

		String[] signatures = new String[numSignatures];
		String[] clips = new String[numClips];

		input.nextLine();
		//Get signatures
		for (int i = 0; i < numSignatures; i++)
		{
			signatures[i] = input.nextLine();
			//System.out.println(signatures[i]);
		}
		//Get clips
		for (int i = 0; i < numClips; i++)
		{
			clips[i] = input.nextLine();
		}


		//Check Hamming Distance

		for (int i = 0; i < numClips; i++)
		{
			int[] minScores = new int[numSignatures];
			for (int q = 0; q < numSignatures; q++)
			{
				minScores[q] = -1;
			}


			for (int j = 0; j < numSignatures; j++)
			{
				if (clips[i].length() <= signatures[j].length())
				{
					minScores[i] = testClip(clips[i], signatures[j]);
				}
			}
			outputMin(minScores);

		}
	}

	private static void outputMin(int[] minScores)
	{
		int temp = 100000000;
		int index = -1;
		for (int i = 0; i < minScores.length; i++)
		{
			if (minScores[i] < temp)
			{
				temp = minScores[i];
				index = i;
			}
		}
		System.out.println(index + 1);
	}

	/**
	 * @param clip
	 * @param signature
	 * @return
	 */
	private static int testClip(String clip, String signature)
	{
		int clipLength = clip.length();
		int signatureLength = signature.length();
		int score = 0;
		int minScore = score;

		//Start at 0 and move one along each time
		for (int i = 0; i < signatureLength - clipLength + 1; i++)
		{
			for (int charNum = 0; charNum < clipLength; charNum++)
			{
				if (clip.charAt(charNum) != signature.charAt(charNum + i))
				{
					score++;
				}
			}

			if (score < minScore)
			{
				minScore = score;
			}
			score = 0;
		}

		return minScore;
	}
}
