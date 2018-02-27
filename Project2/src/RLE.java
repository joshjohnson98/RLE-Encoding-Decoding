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



    public static int numOfDigits(int num) //why is this useful?
    {
        /**
         * numOfDigits calculates the number of digits in a positive integer
         * Parameters:
         * num - a non-negative integer
         * Returns:
         * The number of digits in num
         */
         int digits = 0;
         while (num>=1){
             num/=10;
             digits++;
         }
         return digits;
    }




    public static char[] toCharArray(int charCount, char strchar) //use for encoding
    {
        /**
         * Given a character and its count, returns an array of character representing its count first as digits and
         * then the corresponding character. Example, [‘1’, ‘2’, ‘c’] represents 12 count of a character c.
         * Parameters:
         *strchar - a character
         * charCount - an integer indicating the frequency of strchar
         * Returns:
         * A char array with its first elements being digits of a positive integer from a most significant to a least
         * significant digit if char count is greater than 1. If char count is equal to 1, returns an array of a
         * character itself. Moreover, returns null if char count is less than or equal to zero.
         * Example:
         * toCharArray(100, ‘C’) => {‘1’, ‘0’, ‘0’, ‘C’}
         * toCharArray(9, ‘A’) => {‘9’, ‘A’}
         * toCharArray(10, ‘b’) => {‘1’, ‘0’, ‘b’}
         */
        int digits = numOfDigits(charCount);
        char [] charArray = new char[digits+1];

        double value = (double) charCount;
        charArray[digits] = strchar; //last entry in charArray
        for (int i=digits-1; i>=0; i--){
            value = Math.floor(value%10);
            char nextChar = (char) value;

            //use int to string
            //divide similarly to numOfDigits to find each digit (like matlab credit card Q)
            //and/or modulus 10 for last digit
            charArray[i] = nextChar;
            value /= 10; //round down here too?

        }



        return charArray;
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
