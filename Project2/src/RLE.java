import java.util.Scanner;

public class RLE
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        //think about what is returned from each method

        //cycle:
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
/*
    public static int findEncodeLength(String inputString)
    {
         /**
        * This is used to pre-determine the length of the char array that will be needed to store just the
         * alphabetic character (not their character count). Note that the consecutive repeated character
         * will be counted only once for the length of the char array.
        * Parameters:
        * inputString - a string
        * Returns:
        * 0 when the input string is null, else the number of unique characters in the string.
        * Examples:
        * findEncodeLength(“aaaBBXXXAA”) => 4
        * findEncodeLength(“aaaaaaaaaaaaaaa”) => 1
        * findEncodeLength(“abc”) => 3
        * findEncodeLength("aaabbbccbbbaaa") => 5 ("aaa": 1, "bbb”: 1, "cc": 1, "bb": 1, "aaa": 1)
        */

   // }



    /*
    public static char[] decodeRLE(String rleString) //option 3
    {
        /**
         * Decodes the RLE string and returns a character array of a decoded string.
         * Parameters:
         * rleString - a string encoded in RLE format
         * Returns:
         * A character array representing decoded string.
         * Examples:
         * decodeRLE(“2A5BC”) => {‘A’, ‘A’, ‘B’, ‘B’, ‘B’, ‘B’, ‘B’, ‘C’}
         * decodeRLE(“3L3o3L”) => {‘L’, ‘L’, ‘L’, ‘o’, ‘o’, ‘o’, ‘L’, ‘L’, ‘L’}
         */
    //}


//consider calling methods within other methods (other than main)

    /*
    public static char[][] encodeRLE(String inputString) //option 2
    {
        /**
         * Encodes input string in RLE format
         * Parameters:
         * inputString - an alphabetical(includes lowercase and uppercase) string
         * Returns:
         * a multi-dimensional char array in the following form: first elements of an array will be digits
         * (char count if greater than 1) as a character followed by corresponding character.
         * Examples:
         * encodeRLE(“”HELLLOWORRRRRLD!!!!””) =>[[‘H’]
         *. [‘E’]
         * [‘3’, ‘L’]
         * [‘O’]
         * [‘5’, ‘R’]
         * [‘L’]
         * [‘D’]
         * [‘4’, ‘!’]]
         * encodeRLE(“AAAAAAAAAAAAAAAAAAAAAAA”) => [‘2’, ’3’, ’A’]
         */
    //}

}
