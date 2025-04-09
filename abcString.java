public class abcString {
    public static String printabc(){
        StringBuilder result = new StringBuilder();
        String pattern = "bba";
        int n = pattern.length();
        for (int i = 0; i < n; i++) {
            for (char c = 'a'; c <= 'c'; c++) {
            result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
      String a = printabc();
      System.out.println(a);






    }

}
