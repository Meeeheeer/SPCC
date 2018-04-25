import java.util.*;
import java.io.*;

class assembler
{
	
	static Boolean isMachine(String word)
	{
		if(word.equals("L")||word.equals("A")||word.equals("ST"))
			return true;
		return false;
	}

	static Boolean isSymbol(String word)
	{
		if(word.equals("FOUR")||word.equals("FIVE")||word.equals("TEMP")||word.equals("PRG"))
			return true;
		return false;
	}

	static Boolean isPesudo(String word)
	{
		if(word.equals("START")||word.equals("USING")||word.equals("DC")||word.equals("DS")||word.equals("END"))
			return true;
		return false;
	}

	static Boolean isLiterals(String word)
	{
		if(word.contains("=F'2'"))
			return true;
		return false;
	}

	static void printMachineOP(String op,BufferedWriter motFile) throws IOException
	{
		String result = op + "\t-\t04\tRX";
		motFile.write(result);
		motFile.newLine();
	}

	static void printPesudoOP(String op,BufferedWriter potFile) throws IOException
	{
		String result = op +"\tPL_"+op;
		potFile.write(result);
		potFile.newLine();
	}

	static void printSymbolOP(String op,int relAddr,BufferedWriter stFile) throws IOException
	{
		String result;
		if(op.equals("PGR"))
			result=(op+"\t"+relAddr+"\t01\tR");
		else 
			result=(op+"\t"+relAddr+"\t04\tR");
		stFile.write(result);
		stFile.newLine();
	}

	static void printLiteralOP(String op,int relAddr,BufferedWriter ltFile) throws IOException
	{
		String result = "F'2'\t"+relAddr+"\t04\tR";
		ltFile.write(result);
		ltFile.newLine();
	}

	public static void main(String[] args) throws IOException {
		String temp="";
		String[] keyWord;
		int count=0,relAddr=0;

		BufferedReader br = new BufferedReader(new FileReader("InputAssembelr.txt"));
		BufferedWriter motFile = new BufferedWriter(new FileWriter("mot.txt",true));
		BufferedWriter potFile = new BufferedWriter(new FileWriter("pot.txt",true));
		BufferedWriter stFile = new BufferedWriter(new FileWriter("st.txt",true));
		BufferedWriter ltFile = new BufferedWriter(new FileWriter("lt.txt",true));

		while((temp=br.readLine())!=null){
			if(count>2)
				relAddr+=4;
			count++;
			keyWord=temp.split(" ");
			for (int i=0;i < keyWord.length;i++ ) {
				if(isMachine(keyWord[i]))
					printMachineOP(keyWord[i],motFile);
				else if(isPesudo(keyWord[i]))
					printPesudoOP(keyWord[i],potFile);
				else if(isSymbol(keyWord[i]))
					printSymbolOP(keyWord[i],relAddr,stFile);
				else if(isLiterals(keyWord[i]))
					printLiteralOP(keyWord[i],relAddr,ltFile);

			}

		}

		br.close();
		motFile.close();
		potFile.close();
		stFile.close();
		ltFile.close();
	}
}