

package inclWords;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class seek {

	private static int qntBigWords=0;
	private static String SecondBigWord;
	private static String FirstBigWord;
	private static LinkedList<String> list;
	private static LinkedList<String> list2;
	private static int listStep=0;
	private static int Res1=0;
	
	public static void main(String[] args) {

		try {
	         
	         String text1;
	         Scanner scanner = new Scanner( new File("c:/JavaEE/words.txt") );
	         scanner.useDelimiter("\\A");
	          
	         list = new LinkedList<String>();
	         list2 = new LinkedList<String>();
	        
	         while (scanner.hasNextLine()){
		         text1 = scanner.nextLine();

		         list.add(text1);
	         }
	          scanner.close(); 
	          list2 = (LinkedList<String>) list.clone();

	        FirstBigWord = list.getFirst();
	        SecondBigWord = FirstBigWord;
			
	        String word;

	  		int resForWord=0;	
	        listStep = 0;
			while (listStep < list.size()){
	  			word = list.get( listStep );
	  			resForWord = Search(  word,0);

	  			 if(resForWord==1){
	  				qntBigWords++;
		  			 if (word.length() > FirstBigWord.length()){
			    		 SecondBigWord = FirstBigWord;
			    		 FirstBigWord = word;
			    		 
			    	 }
	  			 }
	  			listStep++;
			};	
			System.out.println("FirstBigWord:" + FirstBigWord);
			System.out.println("SecondBigWord:" + SecondBigWord);
			System.out.println("qnt Big Words:" + qntBigWords);
	      }catch(IOException e) {
	         System.out.print("Exception");
	      }
	};
	
	private static int  Search (  String word, int res) {
		int i = 0;
		int meth = 0;
		int ret = 0;
		int words = 0;
		String  word2 = ""; 
		String subWord;

		words=0;
		meth=0;
		  while (i < list2.size()) {
			word2 = list2.get(i);

			if((word.length()>word2.length())&&(word.contains(word2)))
			{
		     Scanner s = new Scanner(word).useDelimiter(word2);
		     subWord = "";
		     while(s.hasNext()){
		    	 subWord=s.next();
		    	 if( (! subWord.equals(word)) )	{
		    		  if ((! word.equals(word2))  && (!subWord.equals( ""))  ){

		    			  		meth++;
		  		    	 		ret = Search(subWord,res+1) ;//+Res1;
		  		    	 		if (ret>0)
		  		    	 		{	words=words+ret;

		    		  			}
		  		     	}
		    	 }
		     }//while subWords
		     
		     
		     s.close();
		   

				if((res==0)&&(Res1>0))
					{
				}
			}
			//-----------------
			else 	{
				if((word.equals(word2))&&(res>0)
						){
					//words++;
					Res1 = Res1 + 1;
				}
			}

			i++;
			  
			  if (Res1>0&&meth==words&&meth>0&&res==0)
			  {
			  	return 1;
			  }
			  if (Res1>0&&meth==words&&res>0)
			  {
			 
			  	  
			  	return 1;
			  }
			  meth=0;
		}//while list2
	 return 0;
		}//method
}
