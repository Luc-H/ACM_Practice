package Practoce;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemD
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			scanner.nextLine();
			char[] line = scanner.nextLine().toCharArray();

			int k = scanner.nextInt();

			ArrayList<Integer> lengths = new ArrayList<>();
			ArrayList<Character> letters = new ArrayList<>();

			int indexLine = 0;
			while (indexLine < line.length) {
				letters.add(line[indexLine]);

				indexLine++;

				StringBuilder stringBuilder = new StringBuilder();

				while (indexLine < line.length && '0' <= line[indexLine] && line[indexLine] <= '9') {
					stringBuilder.append(line[indexLine]);
					indexLine++;
				}

				lengths.add(Integer.parseInt(stringBuilder.toString()));
			}


			int minLength = Integer.MAX_VALUE;
			int start = -1;
			int end = -1;

			int pairs;
			int cgPairs = 0;

			while (true) {

				for (int j = 0; j < letters.size(); j++) {
					for (int l = j; l < letters.size(); l++) {
						if (arePair( letters.get(i), letters.get(l),  cgPairs <= k)) {
							//Calculate the distance between the two
							int distance = 0;
							for (int m = j + 1; m < l - 1; m++) {
								distance += lengths.get(m);
							}

							if (distance < minLength) {
								minLength = distance;
								start = j;
								end = l;
							}
						}
					}
				}

				if (minLength == Integer.MAX_VALUE)
				{
					break;
				}

				if (letters.get(start) == 'G' || letters.get(start) == 'C') {
					cgPairs++;
				}

				//Pair start and end

				System.out.println("end1 " + letters.get(end));

				for (int j = 0; j < end - start - 1; j++) {
					letters.remove(start + 1);
					lengths.remove(start + 1);
				}

				end = start + 1;

				System.out.println("end2 " + letters.get(end));

				if (lengths.get(start) == 1) {
					lengths.remove(start);
					letters.remove(start);

					end = start;
				} else {
					lengths.set(start, lengths.get(start) - 1);
				}

				if (lengths.get(end) == 1) {
					lengths.remove(end);
					letters.remove(end);
				} else {
					lengths.set(end, lengths.get(end) - 1);
				}
			}
		}
	}

	private static boolean arePair(char a, char b, boolean hitK) {
		if (a == 'A' && b == 'U') return true;

		if (a == 'U' && b == 'A') return true;

		if (a == 'C' && b == 'G' && !hitK) return true;

		if (a == 'G' && b == 'C' && !hitK) return true;

		return false;
	}
}
