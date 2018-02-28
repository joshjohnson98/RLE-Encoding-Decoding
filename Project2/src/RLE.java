import java.util.Scanner;

public class RLE
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        //think about what is returned from each method

        // Cycle:
        // 1. Menu
        // 2. User picks option
        // 3. Either enter message. View Decoded Message. Or View Encoded Message.
        // Repeat

        boolean running = true;
        while (running) {
            menu();
            int option = scan.nextInt();
            switch (option) {
                case 1:   //get inputString
                    System.out.print("\nEnter message: ");
                    String inputString = scan.next();
                    break;
                case 2:   //encode string and view
                    System.out.print("\nThe encoded data is: ");


                    break;
                case 3:   //decode string and view OR just view inputString?
                          //do I have to use the decoding method as instructed
                          //even if it's not necessary?
                    System.out.print("\nThe decoded data is: ");


                    break;
                case 4:   //exit program
                    running = false;
                    System.out.print("\nProgram terminated");
                    return;
                //default case not needed? user needs to input correct #?
            }
        }
    }

    public static void menu()
    {
        System.out.println("What would you like to do?");
        System.out.println("1.Input string to be encoded");
        System.out.println("2.View encoded string");
        System.out.println("3.View decoded string");
        System.out.println("4.Exit program");
        System.out.print("Option: ");
    }



    public static int numOfDigits(int num)
    {
         int digits = 0;
         while (num>=1){
             num/=10;     //divide by 10 each time for next digit
             digits++;
         }
         return digits;
    }



    public static char[] toCharArray(int charCount, char strchar) //use for encoding
    {
        if (charCount <= 0) {
            char[] charArray = new char[1];
            return charArray;               //return null
        } else if (charCount == 1) {
            char[] charArray = new char[1];
            charArray[0] = strchar;
            return charArray;               //return the character itself
        } else {
            int digits = numOfDigits(charCount);
            char[] charArray = new char[digits + 1];

            charArray[digits] = strchar;    //last entry in charArray is the letter
            int original = charCount;

            for (int i = digits - 1; i >= 0; i--) {
                charCount = (original % 10);    //observes the last digit in the #
                charArray[i] = (char) (charCount + 48); //converts int to corresponding char and assigns to charArray
                original /= 10;                 //divide by 10 each time to check next digit (integer is truncated)
            }
            return charArray;
        }
    }



    //Note: This method is intended to pre-determine the size of an array as an array is of fixed length.

    public static int findEncodeLength(String inputString)
    {
        if (inputString == null) {      //return 0 when string is null
            return 0;
        }
        else {
            int encodeLength = 1;
            char letter;
            char previousLetter = inputString.charAt(0);

            for (int i = 0; i < inputString.length(); i++) { //go through inputString character by character
                letter = inputString.charAt(i);
                if (previousLetter != letter) {     //if the previous character is not equal to the current character
                    encodeLength++;                 //increment encodeLength
                }
                previousLetter = letter;
            }
            return encodeLength;
        }
    }



    public static char[] decodeRLE(String rleString)
    {
        int num = 1;            //if a letter shows up without numbers before it, it is counted once
        int previousNum = 0;    //used to handle decimal place for numbers that are more than one digit
        //Find length of decoded array first
        int length = 0;

        for (int i = 0; i < rleString.length(); i++) {
            if ((rleString.charAt(i) >= 65 && rleString.charAt(i) <= 90) || (rleString.charAt(i) >= 97 && rleString.charAt(i) <= 122)) {
                //this is a letter....should I account for non-letters, non-numbers?
                //increase range of values to include punctuation and spaces if necessary
                length += num;      //when you hit a letter, at the number before the letter
                previousNum = 0;    //reset num values
                num = 1;
            } else {
                num = rleString.charAt(i) - 48;
                num = num + previousNum*10;    //handles decimal place (for numbers that are more than one digit)
                previousNum = num;
            }
        }

        char [] decoded = new char[length]; //Initialize char array with length found previously
        int position = 0;
        num = 1;
        previousNum = 0;
        for (int i = 0; i < rleString.length(); i++) {
            if ((rleString.charAt(i) >= 65 && rleString.charAt(i) <= 90) || (rleString.charAt(i) >= 97 && rleString.charAt(i) <= 122)) {
                //this is a letter. repeat this value "num" times
                for (int x=0; x < num; x++){
                    decoded[position] = rleString.charAt(i);
                    position++;
                }
                previousNum = 0;
                num = 1;
            } else {
                num = rleString.charAt(i) - 48;
                num = num + previousNum*10;
                previousNum = num;
            }
        }
        return decoded;
    }


    public static char[][] encodeRLE(String inputString)
    {
        int length = findEncodeLength(inputString);
        //Create STAGGERED array because # of cols in each row might not be consistent
        char [][] encoded = new char [length][];
        int arrayRow = 0;
        int charCount = 1;

        //Technique:
        //Go through inputString char by char
        //Keep a running tally of the charCount
        //If you hit a new character (nextChar ~= currentChar),
        //initialize a row using toCharArray w/ inputs "charCount" and "currentChar"
        //Reset variables

        char currentChar = inputString.charAt(0);
        char nextChar = inputString.charAt(0);
        boolean endOfString = false;

        for (int i = 0; i < inputString.length(); i++) {
            if (i >= inputString.length()-1){
                endOfString = true;
            }
            else {
                nextChar = inputString.charAt(i + 1);
            }
            if ((nextChar != currentChar)||endOfString) { //next char doesn't match current char or you've reached the end of the sting
                if (charCount>1) {
                    encoded[arrayRow] = toCharArray(charCount,currentChar);
                }
                else{
                    encoded[arrayRow] = new char[1];
                    encoded[arrayRow][0] = currentChar;
                }
                arrayRow++;  //move to the next row of the multi-dimensional array and repeat process
                charCount = 1;
                currentChar = nextChar;
            } else {
                charCount++;
            }
        }
        return encoded;
    }


}
