import java.util.*;
import java.io.*;

class icgControl
{
	static int n=0,no=100,tc=0;

	static int findControlType(String cc)
	{
		if(cc.contains("while"))
			return 0;
		else
			return 1;
	}
	static void genCode(String[] loop)
	{
		int controlType = findControlType(loop[0]);
		if(controlType == 0)
		{
			int closeBracket = loop[0].indexOf(')');
			System.out.println(no + " : if "+loop[0].substring(6,closeBracket)+" goto "+(no+2));
			System.out.println((no+1) + " : " + " goto "+(no+n));
			no = no + 2;
			for (int i=2;i< n-1;i++ )
			{	
				System.out.println(no + " : "+loop[i]);
				no++;
			}
			System.out.println(no + " : goto 100");
			System.out.println((no+1) + " : Last");
		}
		if(controlType == 1)
		{
			String[] forCondition = loop[0].split(";");
			System.out.println(no+" : "+forCondition[0].substring(4,forCondition[0].length()));
			no++;
			System.out.println(no+" : if "+forCondition[1] + " goto " + (no+2));
			no++;
			System.out.println(no+" : "+"goto "+(no+n-1));
			no++;
			for (int i=2;i< n-1;i++ ) {
				System.out.println(no + " : "+loop[i]);
				no++;
			}
			System.out.println(no + " : " + forCondition[2].substring(0,forCondition[2].length()-1) + " goto 101" );
			System.out.println((no+1) + " : Last");
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of Statements");
		n = sc.nextInt();
		String[] loop = new String[n];
		for (int i=0;i < n ;i++ ) {
			loop[i] = sc.next();
		}
		genCode(loop);
	}
}