public class zuihouyigedancichangdu {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length() - 1;

        while (len >= 0 && s.charAt(len) == ' ')
            len--;
        if (len < 0) {
            return 0;
        }
        int num = 0;
        while (len >= 0 && s.charAt(len) != ' ') {
            len--;
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        zuihouyigedancichangdu z = new zuihouyigedancichangdu();
        System.out.println(z.lengthOfLastWord("hello world   "));
    }

}
