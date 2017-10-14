package Practoce;
import java.util.*;

public class ProblemB
{
	public static void main(String[] args){
		Scanner input1 = new Scanner(System.in);
		int cases = input1.nextInt();
		String waste = input1.nextLine();
		int index = 1;

		while(index <= cases)
		{
			String S = input1.nextLine();
			String T = input1.nextLine();
			int qs = 0;
			int wrong1s = 0;
			int wrong0s = 0;
			for (int j = 0; j < S.length(); j++)
			{
				if(S.charAt(j)!=T.charAt(j)){
					if (S.charAt(j)=='1'){
						wrong1s++;
					}
					else if (S.charAt(j)=='0'){
						wrong0s++;
					}
					else if (S.charAt(j)=='?'){
						qs++;
					}
				}
			}
			int moves = qs;
			if (wrong0s<wrong1s){
				moves+=wrong0s;
				wrong1s-=wrong0s;
				wrong0s=0;
			}
			else{
				moves+=wrong1s;
				wrong0s-=wrong1s;
				wrong1s=0;
			}
			moves+=wrong0s;
			if(wrong1s>0){
				moves=-1;
			}

			System.out.println("Case "+index+": "+moves);
			index++;
		}
	}
}
