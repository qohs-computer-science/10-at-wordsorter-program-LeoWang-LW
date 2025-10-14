import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	

		String word = "";
		ArrayList [] wordList = new ArrayList [26];
		for(int x =0; x < wordList.length; x++)
			wordList[x] = new ArrayList <String>(); 

		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			word = word.toLowerCase();
		
			int index = word.substring(0,1).compareTo("a"); 
			wordList[index].add(word); 

			for(int i = 0; i < wordList.length; i++){
				for(String temp: wordList.get(i))
					if(wordList[i].equals(temp))
						wordList[i].remove(i);
			}
			
		}
		for (int x = 0; x < wordList.length; x++) {
		System.out.println(wordList[x]);
		}

	}
}