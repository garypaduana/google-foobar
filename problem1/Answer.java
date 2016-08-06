package com.google.challenges; 

public class Answer {   
    public static int answer(int n) { 
        // Your code goes here.
        for(int b = 2; b < 36; b++){
            String val = toBase(n, b);
            if(isPalindrome(val)){
                return b;
            }
        }
        return 0;
    }
    
    public static String toBase(int num10, int base){
        int start = (int) Math.floor(Math.log(num10) / Math.log(base));
        int ans = 0;
        StringBuilder result = new StringBuilder();
        
        for(int i = start; i >= 0; i--){
            ans = (int) (num10 / Math.pow(base, i));
            
            if(ans > 0){
                num10 = (int) (num10 - ans * Math.pow(base, i));
            }
            result.append(baseChar(ans));
        }
        return result.toString();
    }
    
    public static String baseChar(int val){
        if(val < 10){
            return Integer.toString(val);
        }
        return String.valueOf((char)((val - 10) + 65));
    } 
    
    public static boolean isPalindrome(String str){
        return str.equals(reverse(str));
    }
    
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        
        char[] chars = str.toCharArray();
        for(int i = chars.length - 1; i >= 0; i--){
            sb.append(String.valueOf(chars[i]));
        }
        return sb.toString();
    }
}

// With some quick groovy as a test:
// (0..1000).each(){print "${Answer.answer(it)}  "}
