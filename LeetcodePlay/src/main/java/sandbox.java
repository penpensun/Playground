public class sandbox {

    public static void sandboxMethod() {
        String str = "abcde";
        char[] strChars = str.toCharArray();
        System.out.println(strChars);
        strChars[0] = 'd';
        System.out.println(strChars);
        System.out.println("The original word");
        System.out.println(str);
    }

    public static void main(String args[]){
        sandboxMethod();
    }


}
