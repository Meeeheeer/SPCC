import java.util.*;
import java.io.*;

class LeftRe
{
	public static void main(String[] args) throws IOException
	{
		String input;
		System.out.println("Enter the production:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		String[] pr = input.split("->");
		String[] prod = pr[1].split("/");
		//System.out.println(prod.length);
		int[] flags = new int[prod.length];
		String root = pr[0];
		String rootdash = root + "'";
		System.out.print(root + "->");
		for (int i = 0;i < prod.length ;i++ ) 
		{	
			if(prod[i].indexOf(root) == 0)
				flags[i] = 1;
			else
			{
				if(i==prod.length-1)
					System.out.print(prod[i] + rootdash);
				else
					System.out.print(prod[i] + rootdash + "/");
			}
		}
		System.out.println();
		System.out.print(rootdash + "->");
		for (int i= 0;i < prod.length ;i++ ) 
		{
			
			if(flags[i] == 1)
				System.out.print(prod[i].substring(1) + rootdash + "/");	
		}
		System.out.print((char)238);
		System.out.println();
			
	}
}