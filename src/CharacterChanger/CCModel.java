package CharacterChanger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class CCModel 
{
	private char[][] charList = {{'a','A','@','4'}, {'b','B','6','8'}, {'c','C'}, {'d','D'}, {'e','E','3'}, {'f','F'}, 
			{'g','G'}, {'h','H'}, {'i','I','!','|'}, {'j','J'}, {'k','K'}, {'l','L'}, 
			{'m','M'}, {'n','N'}, {'o','O','0'}, {'p','P'}, {'q','Q','9'}, {'r','R'}, 
			{'s','S','$','5'}, {'t','T','7'}, {'u','U'}, {'v','V'}, {'w','W'}, {'x','X'}, 
			{'y','Y'}, {'z','Z','2'}, {'0','o','O'}, {'1'}, {'2','z','Z'}, {'3','e','E'}, 
			{'4','a','A'}, {'5','s','S','$'}, {'6','b'}, {'7','t','T'}, {'8','B'}, {'9','q'}};
	
	public String newString(String temp) throws IOException
	{
		int max = 100;
		int min = 0;
		Random rand = new Random();
		int counter = 0;
		String result = "";
		Dictionary charDictionary = newDictionary();
		while (counter < temp.length())
		{
			int rng = rand.nextInt(max - min + 1) + min;
			result = result + newCharacter(temp.charAt(counter), rng, charDictionary);
			counter++;
		}
		return result;
	}
	
	public char newCharacter(char temp, int rng, Dictionary charDictionary) throws IOException
	{
		char[] charArray = (char[]) charDictionary.get(temp);
		if (charArray == null)
			if (charDictionary.get((char)(temp+32)) != null)
				charArray = (char[]) charDictionary.get((char)(temp+32));
			else
				return temp;
		if (charArray.length != 0)
			temp = charArray[rng%charArray.length];
		else
			temp = charArray[0];
		return temp;
	}
	
	public Dictionary newDictionary() throws IOException
	{
		Dictionary<Character, char[]> charDictionary = new Hashtable<Character, char[]>();
		int i = 0;
		while(i < charList.length)
		{
			charDictionary.put(charList[i][0], charList[i]);
			i++;
		}
		/*
		BufferedReader bfr = new BufferedReader(new FileReader("char_replace.txt"));
		String temp;
		while((temp = bfr.readLine()) != null)
		{
			char[] charArray = temp.toCharArray();
			charDictionary.put(temp.charAt(0), charArray);
		}
		bfr.close();
		*/
		
		return charDictionary;
	}
}
