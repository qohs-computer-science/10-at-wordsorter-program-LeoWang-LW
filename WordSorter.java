import java.io.File;
import java.util.Scanner;
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
		String [][] wordList = new String[26][1000];
		int[] wordCount = new int[26];



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

			char firstLetter = 'a'; 
			int index = firstLetter; 
			boolean exist = false;  

			for(int i =0; i < wordCount.length; i++){
				if(wordList.equals(word));
					exist = true; 
			}



			System.out.println(word);
			System.out.println(index); 
		}
	}
}