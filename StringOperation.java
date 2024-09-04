import java.util.Scanner;
public class StringOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
            System.out.println("Please enter a string:");
            String input = scan.nextLine();
            System.out.println("Which operation would you like to perform with the input String");
            String[] arr = {"1.Append", "2.CountWords", "3.Replace", "4.isPalindrome", "5.Splice", "6.Split", "7.MaxRepeatingCharacter", "8.Sort", "9.Shift" ,"10.Reverse"};
            for(int i=0 ; i<arr.length ; i++){
                System.out.println(arr[i] + "\n");
                }
            System.out.println("Enter which operation you would like to perform by entering the number of the operation that is mentioned with the operation:");
            int operation = scan.nextInt();
            if (operation<=10 && operation>=1) {
                
            
            switch (operation) {
                case 1: 
                append(input);
                    break;
            
                case 2:
                countWords(input);
                    break;

                case 3:
                replaceString(input);


                    break;
                case 4:
                if (isPalindrome(input)){
                    System.out.println("The input String " + input + " is a palindrome.");
                }
                else 
                System.out.println("The input String " + input + " is not a palindrome.");


                    break;
                case 5:
                spliceString(input);

                    break;
                case 6:
                splitString(input);
            
                    break;
                case 7:
                maxRepeat(input);

                    break;
                case 8:
                sort(input);

                    break;
                case 9:
                shift(input);

                    break;
                case 10:
                reverse(input);

                    break;

            }
        }
        else{
            System.out.println("Enter a valid number of the given operation.");
        }
        scan.close();

        

        
    }
    // First operation - Append String

    public static void append (String s){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String you want to append:");
        String newString = scan.nextLine();
        String appendedString = s + " " + newString;
        System.out.println("Here we goo:" + appendedString);
        scan.close();   
    }

    // Second Operation - countWord
    public static void countWords(String s) {
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            
            if (Character.isLetterOrDigit(s.charAt(i)) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetterOrDigit(s.charAt(i)) && isWord) {
                
                wordCount++;
                isWord = false; 
            } else if (Character.isLetterOrDigit(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        System.out.println("There are " + wordCount + " words in your string.");

        
    }

    // Third Operation - Replace
    public static void replaceString(String s) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the character to be replaced: ");
        char charToReplace = scanner.next().charAt(0);
        System.out.print("Enter the replacement character: ");
        char replacementChar = scanner.next().charAt(0);
        scanner.close();

        
        String resultString = "";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == charToReplace) {
                resultString += replacementChar;
            } else {
                resultString += currentChar;
            }
        }

        System.out.println("The modified string is: " + resultString);
    }

    // Fourth Operation - isPalindrome
    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0 ; i <= len/2 ; i++){
            if (s.charAt(i) != s.charAt(len-i-1)) {
                return false;
                
            }

        }
        return true;
        }

    // Fifth Operation - Splice
    public static String spliceString(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Starting index:");
        int start = sc.nextInt();
        System.out.println("Enter the length of the substring:");
        int length = sc.nextInt();
        sc.close();

        
        if (start < 0 || start >= str.length() || length < 0 || (start + length) > str.length()) {
            return "Invalid start index or length.";
        }
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            
            if (i < start || i >= start + length) {
                result += str.charAt(i);
            }
        }

        System.out.println("Original String: " + str);
        System.out.println("Modified String: " + result);
         return "";
    }
    // Sixth Operation - Split
    public static void splitString(String str) {
        // Calculate the number of words to determine the size of the array
        int wordCount = 1;  // Start with 1 because the last word won't have a space after it
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Create an array to hold the words
        String[] words = new String[wordCount];

        // Split the string into words
        String currentWord = "";
        int wordIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                currentWord += str.charAt(i);
            } else {
                words[wordIndex] = currentWord;
                wordIndex++;
                currentWord = "";  // Reset currentWord for the next word
            }
        }

        // Add the last word to the array
        words[wordIndex] = currentWord;
        System.out.print("The required array of words is: [");
        for ( int i = 0 ; i < wordCount ; i++){
            System.out.print( words[i] + ",");
            
        }
        System.out.println("]");
    }


    //Seventh Operation - MaxRepeat
    public static void maxRepeat(String str) {
        int[] frequency = new int[256]; //array to store frequency of the 
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }

        int maxFrequency = 0;
        char mostFrequentChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (frequency[str.charAt(i)] > maxFrequency) {
                maxFrequency = frequency[str.charAt(i)];
                mostFrequentChar = str.charAt(i);
            }
        }

        System.out.println("The most frequent character is: " + mostFrequentChar + " that is " + maxFrequency + " times." );
    }

    //Eighth Operation - Sort
    public static void sort(String s){
        char[] arr = s.toCharArray();
        for( int i = 0 ; i < arr.length - 1 ;i++){
            for( int j =i+1 ; j < arr.length ; j++){
                if( arr[i] > arr[j]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        String sorted = new String(arr);
        System.out.println("The sorted string is: " + sorted);
    }
    //Ninth Operation - Shift
    public static void shift(String s ){
        Scanner scan = new Scanner(System.in);
        String newString = "";

        System.out.println("Enter the number of character from the start:");
        int n = scan.nextInt();
        int len = s.length();
        for(int i = n ; i < len ; i++ ){
            newString += s.charAt(i);
         }
        for( int j = 0; j < n ; j++ ){
            newString += s.charAt(j);
        }
        
         scan.close();

         System.out.println("The output string is: " + newString);

         


    }

    // Tenth Operation- 
    public static void reverse(String s){
        String reversed = "";
        int len = s.length();
        for( int i = len-1 ; i >= 0 ; i--){
            reversed += s.charAt(i);
        }
        System.out.println("The reversed string is:" + reversed);
    }
    
}
