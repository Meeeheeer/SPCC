import java.io.*;
import java.util.*;

class icgBool
{
	static int tc = 0,no =100;

	public static int codeGen(String eq)
	{	
		if(eq.contains("||"))
		{
			int orIndex = eq.indexOf("||");
			String orLHS = eq.substring(0,orIndex);
			String orRHS = eq.substring(orIndex+2,eq.length());
			int tcl = codeGen(orLHS);
			int tcr = codeGen(orRHS);
			System.out.println(no+": t"+tcr+"= t"+(tcl-1)+" or t"+ (tcr-1));
			tc++;
			no++;
		}
		else if(eq.contains("&&"))
		{
			int andIndex = eq.indexOf("&&");
			String andLHS = eq.substring(0,andIndex);
			String andRHS = eq.substring(andIndex+2,eq.length());
			int tcl = codeGen(andLHS);
			int tcr = codeGen(andRHS);
			System.out.println(no+": t"+tcr+"= t"+(tcl-1)+" and t"+ (tcr-1));
			tc++;
			no++;
		}
		else 
		{
			System.out.println(no + ": if "+eq+" goto "+(no+2));
			System.out.println((no+1) + ": t" + tc + " = 0; goto " + (no+3));
			System.out.println((no+2) + ": t"+tc + "= 1;");
			no = no+3;
			tc++;
		}
		return tc;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the boolean Expression:");
		String eq = sc.next();
		tc = codeGen(eq);
	}
}