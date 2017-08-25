package mx.ihsa.cadenas;
public class StringConcatDouble {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "ghi";
        String s4 = "jkl";
        String output = s1 + s2;
        output = output + s3 + s4;
        System.out.println(output);
    }
}
