import java.util.Scanner;

public class Main
{
	public static String getPlacement(String keyword, int[] keywordLength) {
		 String placement = "";
			for (int a=1; a<keyword.length()+1;a++){
	            for (int b=0;b<keyword.length();b++){
	                if (keywordLength[b]==a){
	                    placement+=b;
	                }
	            }
			}
		return placement;
	 }
	public static void main (String [ ] args)
	{
		String str =" ";										//the string that will be encrypted
		String keyword = " ";									//the keyword used to cipher the text
		String alpabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";			//the alphabet we use
		Scanner kb = new Scanner(System.in);					//initialize the scanner
		System.out.print("Enter your text to encrypt: ");
		str = kb.nextLine();									//store the text to be encrypted in str
		str = str.replaceAll(" ","");							//replaces all spaces in the text with ""
		System.out.print("Enter your keyword: ");
		keyword = kb.nextLine();								//store the keyword in 'keyword'
		kb.close();
		
		
		
		
		int[] keywordLength = new int[keyword.length()];		//creates a new array to store the numeric value of the keyword
		keyword = keyword.toUpperCase();						//converts the keyword to upper-case for simplicity
		
		int result = 0;
		for(int a=0;a<alpabet.length();a++) {					//for loop that goes through the whole alphabet comparing the character to the keyword characters in the array
			for(int b=0; b<keyword.length(); b++) {
				if(alpabet.charAt(a) == keyword.charAt(b)){
					result++;
					keywordLength[b] = result;
				}
			}
		}//end for
		
		
		
		while(str.length()%keyword.length() !=0) {				//while loop that adds an 'x' to the end of the string so it will fill in the array evenly if need be
			str = str + 'x';
		}//end while
		
		int rows = str.length()/keyword.length();				//determines the amount of rows needed for the array
		char[][] grid = new char[rows][keyword.length()];		//creates an array for the text
		int c = 0;
		for(int a=0; a<rows;a++) {								//for loop that places the characters in the array
			for(int b=0;b<keyword.length();b++) {
				grid[a][b] = str.charAt(c);
				c++;
			}//end for
		}//end for
		
		String placement = getPlacement(keyword, keywordLength); //method that retrieves the order to place the text
		
		StringBuilder finalResult = new StringBuilder();		//StringBuilder to store the final ciphered text
		for (int a=0,b=0;a<=rows;a++, b++){						//for loop that forms the string according to the order of the keyword
			int x;
            if (b == keyword.length()){
                break;
            } 
            else{
               x = Character.getNumericValue(placement.charAt(b));
            }//end if
            for (int z = 0;z < rows;z++){
                finalResult.append(grid[z][x]);          
            }//end for
		}//end for
		
		
		System.out.print("The encrypted message using Columnar Cipher is: " + finalResult);
		System.out.print("\n*Note the filler character for whitespace is an 'x'");
		
		
	}
}
