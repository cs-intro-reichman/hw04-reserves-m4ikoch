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
        /* testing
        String testforcapvowel = "heLlo World" ;
        System.out.println(capVowelsLowRest(testforcapvowel));
        String testforcamelCase = "   tHis is test";
        System.out.println(camelCase(testforcamelCase));
        String allindex = "  this will be a test";
        char chr = 't';
        String result = "The letter " + chr +" shows in the string " + "(" + allindex + ")" + " in index:";
        int[] array = allIndexOf(allindex,chr);
        for (int i=0; i < array.length; i++) {
            result = result + " " + i + " ";
        }
        System.out.println(result);
         */
    }
    
    public static String capVowelsLowRest (String string) {
        String output = "";
        int length = string.length();
        for (int i = 0; i < length ; i++) {
            char letter = string.charAt(i);
            int ch = letter;
            //checks if the character is uppercase
            if ((65 <= ch) && (ch <= 90)) {
                //is it an uppercase vowel?
                if (ch == 65 || ch == 69 || ch == 73 || ch == 79 || ch == 85) {
                    //keeps uppercase vowel
                    output = output + letter;
                }
                else {
                    //convert to lowercase consonant
                    output = output + (char) (ch + 32);
                }
            }
            else { //character is lowercase or space
                if (((97 <= ch) && (ch <= 122)) || (ch == 32)) {
                    //is it a lowercase vowel?
                    if (ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117) {
                        //convert lower vowel to uppercase
                        output = output + (char) (ch - 32);
                    }
                    else {
                        //keeps lowercase consonant or the space
                        output = output + letter;
                    }
                }
            }
        } return output;
    }


    public static String camelCase (String string) {
        String output1 = "";
        int length = string.length();
        int index = 0;
        int spaceCount = 0;
        boolean space = false;
        // delete the first sequence of spaces, add to the output the first letter of the first word
        // and save the index of the first alphabet char in the string
        for (int i = 0; i < length ; i++) {
            char letter = string.charAt(i);
            int ch = letter;
            if (ch == 32) {
                space = true;
            }
            while (!space)
            {
                //if upper, add it to output
                if ((65 <= ch) && (ch <= 90)) {
                    output1 = output1 + letter;
                }
                else {
                    //is lower, change to upper and add it to output
                    output1 = output1 + (char) (ch + 32);
                }
                index = i + 1; //save index of 1st char after the first alphabet
                i = length; //break For loop
            }
        }
        //start checking for spaces, upper and lower from the character after the first alphabet
        // change/keep all char as lower case unless the char is space, then chance/keep uppercase and ignore the space
        for (int i = index ; i < length ; i++) {
            char letter = string.charAt(i);
            int ch = letter;
            // checking for spaces
            if (ch == 32) {
                spaceCount = spaceCount + 1;
            }
            else {
                if ((65 <= ch) && (ch <= 90))
                {
                    //is it an uppercase char?
                    //convert to lowercase character
                    if (spaceCount != 0) {
                        //starting a new word that is not the first word
                        output1 = output1 + letter;
                        spaceCount = 0;
                    }
                    else output1 = output1 + (char) (ch + 32);
                }
                else {
                    //is lowercase char
                    if ((spaceCount == 0)) {
                        //keep lower
                        output1 = output1 + letter;
                    }
                    else {
                        //convert to uppercase character
                        output1 = output1 + (char) (ch - 32);
                        spaceCount = 0;
                    }
                }
            }
        } return output1;
    }


    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        char letter;
        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            if (letter == chr){
                count = count + 1;
            }
        }
        int[] arrStr = new int[count];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            if(letter == chr) {
                arrStr[index] = i;
                index = index + 1;
            }
        }return arrStr;
    }
}
