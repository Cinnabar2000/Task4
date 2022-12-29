import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(textEditor(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println("Task 2");
        System.out.println(Arrays.toString(split("()()()")));
        System.out.println(Arrays.toString(split("((()))")));
        System.out.println(Arrays.toString(split("((()))(())()()(()())")));
        System.out.println(Arrays.toString(split("((())())(()(()()))")));
        System.out.println("Task 3");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println("Task 4");
        System.out.println(overTime(new double [] {9,17,30,1.5}));
        System.out.println(overTime(new double [] {16,18,30,1.8}));
        System.out.println(overTime(new double [] {13.25,15,30,1.5}));
        System.out.println("Task 5");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println("Task 6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println("Task 7");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.println("Task 8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("Task 9");
        System.out.println(trouble(451999277, 117772299));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println("Task 10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }


    public static String textEditor(int n, int k, String s){
        String rez = "";
        String[] words = s.split(" ");
        int charCounter = 0;
        //boolean isWord;
        for (String word : words){
            //проверка на корректность слова
            /*
            isWord = true;
            char[] chars = word.toCharArray();
            for(int i = 0; i<chars.length; i++){
                if (!isLetter(chars[i])){
                    isWord = false;
                    break;
                }
            }*/
                if (charCounter + word.length() <= k){
                    if ("".equals(rez)){
                        rez += word;
                    }else{
                        rez += " ";
                        rez += word;
                    }
                    charCounter += word.length();
                }else{
                    charCounter = word.length();
                    rez += "\n";
                    rez += word;
                }
        }
        return rez;
    }


    public static String[] split(String s){
        String rez = "";
        int leftBracket = 0;
        int rightBracket = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='('){
                leftBracket ++;
                rez += "(";
            }else if(s.charAt(i)==')'){
                rightBracket++;
                rez += ")";
                if (leftBracket == rightBracket){
                    rez += " ";
                }
            }
        }
        String[] finalrez = rez.split(" ");
        return  finalrez;
    }

    public static String toCamelCase(String s){
        String rez = "";
        boolean isBig = false;
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == '_'){
                isBig = true;
            }else{
                if (isBig){
                    rez += s.substring(i,i+1).toUpperCase();
                    isBig = false;
                }else{
                rez += s.charAt(i);
            }
            }
        }
        return rez;
    }

    public static String toSnakeCase(String s){
        String rez = "";
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) < 'Z' && s.charAt(i) > 'A'){
                rez += "_";
                rez += s.substring(i,i+1).toLowerCase();
            }else{
                rez += s.charAt(i);
            }
        }
        return rez;
    }

    public static String overTime(double[] arr){

        double sum;
        double buff = arr[1]-17;
        if (buff > 0){
            sum = ((arr[1]-arr[0] - buff)*arr[2]) + (buff * arr[2] * arr[3]);
        }else{
            sum = (arr[1]-arr[0])*arr[2];
        }
        //sum = Math.round(sum*100.00)/100.00;
        String rez = "$" + String.format("%.2f", sum);
        return rez;
    }

    public static String BMI(String weight, String height){
        String[] w = weight.split(" ");
        double wrez;
        double hrez;
        double rez;
        if("pounds".equals(w[1])){
            wrez = Double.parseDouble(w[0]) * 0.45359 ;
        }else{
            wrez = Double.parseDouble(w[0]);
        }
        String[] h = height.split(" ");
        if("inches".equals(h[1])){
            hrez = Double.parseDouble(h[0]) * 0.0254;
        }else{
            hrez = Double.parseDouble(h[0]);
        }
        rez = wrez*10/(hrez*hrez);
        rez = Math.round(rez);
        rez /= 10;
        if (rez<18.5)
            return rez+" Underweight";
        if (rez>=18.5 && rez<=24.9)
            return rez+" Normal weight";
        return rez+" Overweight";
    }

    public static int bugger(int num){
        int buff = 1;
        int k = 0;
        while(num > 9){
            int len = (int) (Math.log10(num) + 1);
            while (len >= 0){
                buff = buff * num % 10;
                len = len - 1;
                num = num/10;
                k = k+1;
            }
            num = buff;
        }
        return k;
    }

    public static String toStarShorthand(String a){
        if (a.isEmpty())
            return "";
        String rez = "";
        int k = 1;
        char buff1 = a.charAt(0);
        a += ' ';
        for (int i = 1; i < a.length(); i++){
            char buff2 = a.charAt(i);
            if (buff2 == buff1) {
                k += 1;
            }
            else {
                rez += buff1;
                if (k > 1){
                    rez += "*" + k;
                }
                k = 1;
                buff1 = buff2;
            }
        }
        return rez;
    }

    static public boolean doesRhyme( String str1, String str2){       //рифма строк по условию одинаковых гласных
        int buff1 = str1.lastIndexOf(" ");
        int buff2 = str2.lastIndexOf(" ");
        int a1 = 0;
        int a2 = 0;
        int e1 = 0;
        int e2 = 0;
        int u1 = 0;
        int u2 = 0;
        int i1 = 0;
        int i2 = 0;
        int o1 = 0;
        int o2 = 0;

        for (int i = buff1 + 1; i < str1.length(); i++){
            switch (str1.charAt(i)){
                case ('a'):
                case ('A'):
                    a1 += 1;
                    break;
                case ('e'):
                case ('E'):
                    e1 += 1;
                    break;
                case ('u'):
                case ('U'):
                    u1 += 1;
                    break;
                case ('i'):
                case ('I'):
                    i1 += 1;
                    break;
                case ('o'):
                case ('O'):
                    o1 += 1;
                    break;
            }

        }

        for (int i=buff2+1; i<str2.length();i++){
            switch (str2.charAt(i)){
                case ('a'):
                case ('A'):
                    a2 += 1;
                    break;
                case ('e'):
                case ('E'):
                    e2 += 1;
                    break;
                case ('u'):
                case ('U'):
                    u2 += 1;
                    break;
                case ('i'):
                case ('I'):
                    i2 += 1;
                    break;
                case ('o'):
                case ('O'):
                    o2 += 1;
                    break;
            }
        }
        return a1 == a2 && e1 == e2 && u1 == u2 && i1 == i2 && o1 == o2;
    }



    static public boolean trouble(long a, long b){
        String str1 = Long.toString(a);
        String str2 = Long.toString(b);
        long [] arr1 = new long[str1.length()];
        long [] arr2 = new long [str2.length()];
        for (int i = str1.length() - 1; i >= 0; i--) {
            arr1[i] = a % 10;
            a /= 10;
        }
        for (int i = str2.length() - 1; i >= 0; i--) {
            arr2[i] = b % 10;
            b /= 10;
        }
        for (int i = 2; i < str1.length(); i++){
            for (int j = 1; j < str2.length(); j++){
                if(arr1[i]==arr1[i-1]&&arr1[i-1]==arr1[i-2]&&arr1[i]==arr2[j]&&arr1[i-2]==arr2[j-1]){
                    return true;
                }
            }
        }
        return false;

    }

    public static int countUniqueBooks(String a, char ch){
        int s = 0;
        String rez = "";
        int buff1 = 0;
        int buff2 = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == ch){
                s++;
                if (s==1){
                    buff1 = i;
                }else if (s==2){
                    buff2 = i;
                    s = 0;
                    rez = rez + a.substring(buff1 + 1, buff2);
                }
            }
        }
        char[] chars = rez.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.length();

    }


}