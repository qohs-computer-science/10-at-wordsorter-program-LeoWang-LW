// Leo Wang 
// 10/16/25 | CP 3 | Pd. 6 

import java.io.File; // Article 
import java.util.Scanner; // Used for user input 
import java.util.ArrayList; // Used to store the words 

public class WordSorter 
{
	public static void main(String[] args) 
	{

		Scanner input = new Scanner(System.in);

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
			boolean exists = false; 

			for(int i = 0; i < wordList.length; i++){
				for(int j = 0; j < wordList[i].size(); j++){
					if(wordList[i].get(j).equals(word) && exists == false)
						exists = true;
					else if( wordList[i].get(j).equals(word) && exists == true)
						wordList[i].remove(j); 
				} // end for loop 
			} // end for loop 
		} // end while loop 

		boolean stop = false; 

		while(stop == false){
			System.out.println("Menu Options: \n 1. Input (1) and then a single letter in order to recieve all words starting with the letter \n 2. Input (2) in order to recieve all words \n 3. Input (3) in order to recieve the total # of unique words \n 4. Input (4) and a word to check if the word is in the list \n 5. Input (5) and a word in order to remove a word in the list if it's there \n 6. Input (6) to leave the menu");
			int choice = input.nextInt(); 
			if(choice == 1){
				input.nextLine();
				System.out.println("Now please input a single letter");
				String letter = input.nextLine();  
				if(wordList[letter.compareTo("a")].size() == 0){
					System.out.println("No words start with this letter"); 
				} // end if statement 
				else{
				for(int x = 0; x < wordList[letter.compareTo("a")].size(); x++){
					System.out.print(wordList[letter.compareTo("a")].get(x) + " "); 
					} // end for loop 
					System.out.println("");
				} // end else statement 

			} // end if statement 

			if(choice == 2){
				for(int x = 0; x < wordList.length; x++){
				if(wordList[x].size() == 0)
					System.out.println("Empty List");
				else{
				System.out.println(((String) wordList[x].get(0)).substring(0,1)); 
				System.out.println(wordList[x]); 
				} // end else statement 

				} // end for loop 
			} // end if statement 

			if(choice == 3){
				int uniqueWords = 0; 
				for(int i = 0; i < wordList.length; i++){
					uniqueWords += wordList[i].size(); 
				} // end for loop 
				if(uniqueWords == 0){
					System.out.println("Empty List");
				} // end if statement 
				else{
					System.out.println("There are " + uniqueWords + " unique words in the article");
				} // end else statement 
			} // end if statement 

			if(choice == 4){
				System.out.println("Enter a word to begin search: ");
				input.nextLine(); 
				String searchWord = input.nextLine(); 
				boolean found = false; 
				for(int i = 0; i < wordList.length; i++){
					for(int j = 0; j < wordList[i].size(); j++){
						if(wordList[i].get(j).equals(searchWord)){
							System.out.println("Word found in the article");
							found = true; 
						} // end if statement 

					} // end for loop 
				} // end for loop 
				if(found == false)
					System.out.println("Word NOT found in the article");

			} // end if statement 

			if(choice == 5){
				System.out.println("Enter a word to remove: "); 
				input.nextLine(); 
				String removeWord = input.nextLine(); 
				boolean found = false; 
				for(int i = 0; i < wordList.length; i++){
					for(int j = 0; j < wordList[i].size(); j++){
						if(wordList[i].get(j).equals(removeWord)){
							wordList[i].remove(j); 
							System.out.println("Word sucessfully removed from the list");
							found = true; 
						} // end if statement 

					} // end for loop 
				} // end for loop 
				if(found == false)
					System.out.println("Word NOT found in the article");

			} // end if statement 

			if(choice == 6){
				System.out.println("Exiting"); 
				stop = true; 

			} // end if statement 

		} // end while loop 

	} // end main 
} // end class