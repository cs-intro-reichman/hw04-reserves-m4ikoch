public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // String string = args [0]; 
        // String ch = args [1];
        // char chr = ch.charAt(0);
        // System.out.println(capVowelsLowRest(string));
        //String string = "Hello World";
        //char chr = 'l';
        //printArray(allIndexOf(string,chr));
        System.out.println(camelCase(" tWo    word"));
    }

    public static String capVowelsLowRest (String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++){
            if ("a,e,i,o,u,A,E,I,O,U".indexOf(string.charAt(i)) != -1){//its a vowel
                if (string.charAt(i)>='a' && string.charAt(i)<='z'){
                    newString= newString + (char)(string.charAt(i)- 32); 
                }
                else newString= newString + (char) (string.charAt(i));
            }
            else {//its not a vowel
                if (string.charAt(i)>='A' && string.charAt(i)<='Z'){
                    newString= newString + (char) (string.charAt(i)+32); 
                }
                else newString= newString + (char) string.charAt(i);
            }
        }
        return newString;
    }

    public static String camelCase (String string) {
        String lowercaseString = "";
        String OriginalWOSpaces = deleteFirstSpace(string);//deleting the firt spaces  
        String newString = "";

        // String subsequence= string.substring(string.charAt(32),string.charAt(32)); 
        for (int i =0; i < OriginalWOSpaces.length(); i++){
                if ((OriginalWOSpaces.charAt(i) >= 'A' && OriginalWOSpaces.charAt(i) <= 'Z')){
                    lowercaseString = lowercaseString +(char)(OriginalWOSpaces.charAt(i)+ 32); 
                }
                else{
                    lowercaseString  = lowercaseString + (char) OriginalWOSpaces.charAt(i);
                }
            }

        for (int j = 0; j < lowercaseString.length(); j++){
               
                if (lowercaseString.charAt(j) == ' '){
                    if (lowercaseString.charAt(j+1)!= ' '){
                        newString = newString + (char) (lowercaseString.charAt(j+1)-32);
                        j++;}  
                }
                else
                newString = newString + (char) lowercaseString.charAt(j);

            }
            return newString;
        }

    public static int[] allIndexOf (String string, char chr) {
        int [] array = new int [countChar(string, chr)];
        int index = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i)== chr){
                array [index] = i; 
                index++;
            }
        }


        return array;
    }

    public static int countChar (String string, char chr){
        int count = 0;
        for (int i= 0; i < string.length(); i++){
            if (string.charAt(i)== chr){
                count++; 
            }
        } 
        return count;
    }

    public static void printArray(int [] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            char c = i != (array.length -1) ? ',' : '}';
            System.out.print(c);
        }
        System.out.println();
        
    }
    public static String deleteFirstSpace (String string){
        String newString = "";
        if (string.charAt(0) == ' '){
            for (int i = 1; i < string.length();i++){
                newString += (char) string.charAt(i);
            }
            return newString;
        }
        else {
            newString = string;
        }
        return newString;
    }
}