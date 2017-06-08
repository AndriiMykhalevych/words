

package inclWords;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.MatchResult;
public class seek {

	private static int qntMainWords=0;
	private static String SecondBigWord;
	private static String FirstBigWord;
	private static LinkedList<String> list;
	private static int listStep=0;
	
	public static void main(String[] args) {

		try {
	         
	         String text1;
	         Scanner scanner = new Scanner( new File("c:/JavaEE/words.txt") );
	         scanner.useDelimiter("\\A");
	          
	         list = new LinkedList<String>();
	         LinkedList<String> list2 = new LinkedList<String>();
	        
	         while (scanner.hasNextLine()){
		         text1 = scanner.nextLine();
		         //System.out.print(text1+";");
		         list.add(text1);
	         }
	          scanner.close(); 
	          list2 = list;

	        FirstBigWord = list.getFirst();
	        SecondBigWord = FirstBigWord;
			
	        String word;
	        //int listStep=0;
			while (listStep < list.size()){
	  			word = list.get( listStep );
	  			System.out.println(word+";");
	  			
	  			Search(list2,word);
	  			listStep++;
			};
			System.out.println("FirstBigWord:" + FirstBigWord);
			System.out.println("SecondBigWord:" + SecondBigWord);
			System.out.println("qntMainWords:" + qntMainWords);
	      }catch(IOException e) {
	         System.out.print("Exception");
	      }
	};
	
	private static int  Search ( LinkedList<String> l2, String w) {
		int i = 0;
		int Res1 = 0;
		int res = 0;
		String word, word2; 
		String strCut;
  			
		  while (i < l2.size()) {
			word2 = l2.get(i);
			System.out.print(word2+"~");

		     Scanner s = new Scanner(word2);
		     strCut = s.findInLine("(\\w+)" + w + "(\\w+)");
		     if (strCut != null){
				     MatchResult result1 = s.match();
				     s.close();
				     System.out.println();
				     System.out.println(result1.groupCount());
				     
				     LinkedList<String> list3 = new LinkedList<String>();
				     for (int i2 = 0; i2 < result1.groupCount(); i2++)
				     {  //l2.addLast(result.group(i2));
				    	 System.out.print(":"+result1.group(i2)+";"+res);
				    	 list3.add(result1.group(i2));
				    	 listStep++;
				    	 if (listStep < list.size()){
				    		 word = list.get( listStep );
				    		 res = Search(list3,word) + res;
				    		 list3.clear();
				    	 };
				    	 list3.clear();
				    	 
				     }
				     System.out.println("res:"+res);
				    // if (res>0){//(res == result1.groupCount()-1){
				    	 if (word2.length() > FirstBigWord.length()){
				    		 SecondBigWord = FirstBigWord;
				    		 FirstBigWord = word2;
				    	 }
				    	 else Res1=0;
				    	 
				    	 l2.remove(i);
				    	 qntMainWords++;
				    	 Res1 = 1;
				    	 
				     //}else Res1=0;
		     };
		     s.close();
		     i++;
		}
/*		listStep++;
	
	
	}//while listStep
		listNew.clear();*/
		return Res1;
	}
}
