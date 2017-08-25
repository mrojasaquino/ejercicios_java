package mx.ihsa.cadenas;
public class StringBuilderSingle {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        System.out.println(sb.toString());
    }
}
