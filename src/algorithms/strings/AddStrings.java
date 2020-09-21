package algorithms.strings;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "23"));
    }

    private static String addStrings(String s1, String s2) {
        int maxLength = Math.max(s1.length(), s2.length());
        int a = 0, b = 0, sum = 0, carry = 0;
        StringBuffer buff = new StringBuffer();
        for (int i = maxLength - 1; i >= 0; i--) {
            if (i > s1.length() - 1) {
                a = 0;
            } else {
                a = s1.charAt(i) - '0';
            }
            if (i > s2.length() - 1) {
                b = 0;
            } else {
                b = s2.charAt(i) - '0';
            }

            sum = a + b;
            carry = sum / 10;
            int remainder = sum % 10;
            if (carry > 0) {
                buff.insert(0, remainder);
            } else {
                buff.insert(0, sum);
            }
        }
        if (carry > 0) {
            buff.insert(0, carry);
        }
        return buff.toString();
    }
}
