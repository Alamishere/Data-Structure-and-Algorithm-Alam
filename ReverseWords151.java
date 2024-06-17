public class ReverseWords151 {

    public static void main(String[] args) {
        System.out.println(ReverseString("Hello I am testing this String"));
    }

    static String  ReverseString(String s){
        //first split the String and out it in String Array
          String[] words=  s.split(" +");
        // Reverse the String using StringBuilder to mutate the String
        // without creating a new object
        StringBuilder reversedString = new StringBuilder();
        //reverse the String
        for(int i=words.length-1;i>=0;i--){ 
            //Append is method in StringBuilder to add or concatenate Strings in Java         
            reversedString.append(words[i]);
            reversedString.append(" ");
        }
        return reversedString.toString().trim();
    }
    
}
