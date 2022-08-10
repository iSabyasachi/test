package test.string;
import java.util.*;

public class Utility{
    public static void main(String[] args) {
        collectionUtility();
        //arrayUtility();
        //stringUtility();
    }
    public static void collectionUtility(){
        //List<String> list = Arrays.asList("abc","def","ghi");
        //Collections.sort(list);
        //System.out.println(list);
        
        List<String> list = Arrays.asList("abc","def","ghi");
        int index = Collections.binarySearch(list, "def");
        System.out.println(index);


    }
    public static void arrayUtility(){
        //String str = "abcde";
        //char[] chars = str.toCharArray();
        //System.out.println(Arrays.toString(chars));

        //char[] newChars = Arrays.copyOf(chars,3);
        //System.out.println(new String(chars));
        //System.out.println(new String(newChars));
        
        //char[] charsTwo = Arrays.copyOfRange(chars,2,4);
        //System.out.println(new String(charsTwo));

        //boolean[] charsThree = new boolean[3];
        //Arrays.fill(charsThree, false);
        //System.out.println(Arrays.toString(charsThree)); 

        //char[] chars = new char[]{'d','a','c','b','f','e'};
        //Arrays.sort(strs);  
        //Arrays.sort(chars,1,5);  
        //System.out.println(Arrays.toString(chars));

        //String[] strs = new String[]{"a","b","c","d","e"};    
        //int index = Arrays.binarySearch(strs, "c");
        //System.out.println(index);

        String[] firstArray = new String[]{"a","b","c"};
        String[] secondArray = new String[]{"a","b","c"};
        System.out.println(Arrays.equals(firstArray, secondArray));
    }
    public static void stringUtility(){
        //String str = "abc&def";
        //String[] subStrs = str.split("&");
        //System.out.println(Arrays.toString(subStrs));

        //String str = "abc&def";
        //int index = str.indexOf("&");
        //System.out.println(index);
        //System.out.println(str.substring(0, index));
        //System.out.println(str.substring(index+1,str.length()));

        //String str = "abc&def&ghi";
        //int index = str.lastIndexOf("&");
        //System.out.println(index);
        //System.out.println(str.contains("&def"));
        //System.out.println(str.startsWith("a"));

        String str = "abcDEF";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }    
}

