import java.util.*;
import java.io.*;

class codeGen 
{
	static int codegen(String eq,int regno)
	{
		int flag = type(eq);
		int opIndex=0,eqIndex;
		String op ="";
		if(flag==0)
		{
			eqIndex = eq.indexOf("=");
			if(eq.contains("*"))
			{
				op = "MUL";
				opIndex = eq.indexOf("*");
			}
			else if(eq.contains("/")) {
				op = "DIV";
				opIndex = eq.indexOf("/");
			}
			else if(eq.contains("-")) {
				op = "SUB";
				opIndex = eq.indexOf("-");
			}
			else if(eq.contains("+")) {
				op = "ADD";
				opIndex = eq.indexOf("+");
			}
			System.out.println("MOV R"+regno+" , " + eq.substring(opIndex+1,eq.length()));
			System.out.println("MOV R"+(regno+1)+" , " + eq.substring(eqIndex+1,opIndex));
			System.out.println(op+" R"+regno+" , " + "R"+(regno+1));
			System.out.println("MOV "+eq.substring(0,eqIndex)+" , R"+regno);	
			regno = regno+2;
			return regno;
		}
		else 
		{
			eqIndex=eq.indexOf("=");
			System.out.println("MOV R"+(regno)+" , " + eq.substring(eqIndex+1,eq.length()));
			System.out.println("MOV "+eq.substring(0,eqIndex)+" ,R"+regno);
			regno=regno+1;
			return regno;

		}
	
	}

	static int type(String eq)
	{
		if(eq.contains("*") || eq.contains("/") ||eq.contains("+") ||eq.contains("-")) {
        	return 0; 
        }
        return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Statements:");
		int n = sc.nextInt();
		String[] eq = new String[n];
		int regno=0;
		for (int i =0;i<n ;i++ ) {
			eq[i] = sc.next();
		}
		for (int i=0;i<n ;i++ ) {
			regno=codegen(eq[i],regno);
		}

	}
}