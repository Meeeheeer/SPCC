import java.io.*;
import java.util.*;

class macro
{
	public static void main(String[] args) throws IOException{
		int mntc=0,mdtc=0,clac=0,plac=0;

		String[] mnTable = new String[30];
		String[] mdTable = new String[30];
		String[] plaTable = new String[30];
		String[] claTable = new String[30];
		String[] macronameTable = new String[30];
		String[] argsName;
		String[] argsArray;

		BufferedReader br = new BufferedReader(new FileReader("InputMacro.txt"));
		BufferedWriter mntFile = new BufferedWriter(new FileWriter("mnt.txt",true));
		BufferedWriter mdtFile = new BufferedWriter(new FileWriter("mdt.txt",true));
		BufferedWriter plaFile = new BufferedWriter(new FileWriter("pla.txt",true));
		BufferedWriter claFile = new BufferedWriter	(new FileWriter("cla.txt",true));

		String temp = "";
		String macroname = "";
		String[] lineArray;
		int i,j,flag=0;

		while((temp=br.readLine())!=null)
		{

			for(i=0;i<mntc;i++)
			{
				if(temp.contains(macronameTable[i]))
				{
					argsArray = temp.split(" ");
					argsName = argsArray[1].split(",");
					for (j=0;j<argsName.length ; j++) 
					{
						claTable[clac] = argsName[j];
						claFile.write(claTable[clac]);
						claFile.newLine();
						clac++;		
					}
					break;
				}
			}
			if(flag==1)
				{
					mdTable[mdtc] = mdtc+" "+temp;
					mdtFile.write(mdTable[mdtc]);
					mdtFile.newLine();
					mdtc++;
					if(temp.contains("MEND"))
						flag=0;
				}
			if(temp.contains("MACRO"))
			{
				flag = 1;
				lineArray=temp.split(" ");
				macroname = lineArray[1];
				macronameTable[mntc] = macroname;
				mnTable[mntc] = mntc +" "+macroname+" "+mdtc;
				mntFile.write(mnTable[mntc]);
				mntFile.newLine();
				mntc++;
				for(i = 2;i<lineArray.length;i++)
				{
					if(i == lineArray.length-1)
						plaTable[plac] = plac+" "+lineArray[i];
					else 
						plaTable[plac] = plac+" "+lineArray[i].substring(0,lineArray[i].length()-1);
					plaFile.write(plaTable[plac]);
					plaFile.newLine();
					plac++;
				}

			}
		}

		br.close();
		mntFile.close();
		mdtFile.close();
		plaFile.close();
		claFile.close();

	}
}