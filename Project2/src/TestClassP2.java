import java.util.Scanner;

public class TestClassP2 {

    public static int numOfDigits(int num) //why is this useful?
    {
        /*
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
        /*
         * Given a character and its count, returns an array of character representing its count first as digits and
         * then the corresponding character. Example, [‘1’, ‘2’, ‘c’] represents 12 count of a character c.
         * Parameters:
         * strchar - a character
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
        char[] charArray = new char[digits + 1];


        charArray[digits] = strchar; //last entry in charArray
        int position = 0;
        for (int i = digits - 1; i >= 0; i--) {
            System.out.println(charCount);
            charCount = (charCount % 10);
            //Round down. (account for the integer value changing to double?)
            //Or will it automatically truncate (this would be nice)
            System.out.println(charArray);
            char nextChar = (char) charCount;

            //use int to string
            //divide similarly to numOfDigits to find each digit (like matlab credit card Q)
            //and/or modulus 10 for last digit
            charArray[position] = nextChar; //CHANGE (for loop goes backwards)
            position++;
            charCount /= 10; //round down here too?

        }
        return charArray;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter charCount: ");
        int charCount = scan.nextInt();
        System.out.println("Enter strchar: ");
        char strchar = scan.next().charAt(0);
        char[] charArrayDisplay = toCharArray(charCount,strchar);
        System.out.println(charArrayDisplay);

    }
}
