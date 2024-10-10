package lab1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(String.format("%s is a palindrome", s));
            }
        }
    }

    public static String reverseString(String s) {
        String revStr = "";
        for (int j = 0; j < s.length(); j++) {
            revStr = s.charAt(j) + revStr;
        }
        return revStr;
    }

    public static boolean isPalindrome(String s) {
        if (s.equals(reverseString(s))) {
            return true;
        }
        return false;
    }
}