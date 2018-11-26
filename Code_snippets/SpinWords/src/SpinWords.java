public class SpinWords {

  public String spinWords(String sentence) {
    //TODO: Code stuff here
	  String[] words = sentence.split(" ");
	  String temp2 = "";
	  String finalSent = "";
	  for (String element : words){
		  if (element.length() >= 5){
			  for(int i = element.length()-1; i>=0; i--){
				  String temp = element.charAt(i)+"";
				  temp2 = temp2 + temp;
				  System.out.println(i+" "+temp);
			  }
			  System.out.println(temp2);
		  }
		  if (temp2.length() > 0){
			  finalSent += temp2;
		  }else{
			  finalSent += element;
		  }
		  if (words.length > 1){
			  finalSent +=" ";
		  }
		  temp2 ="";
	  }
	  if (finalSent.charAt(finalSent.length()-1) == ' '){
		  finalSent = finalSent.substring(0,finalSent.length()-1);
	  }
	  return finalSent;
  }
}