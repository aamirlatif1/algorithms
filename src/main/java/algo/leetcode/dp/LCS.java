package algo.leetcode.dp;

public class LCS {
    public static String lcs(String a, String b) {
        String[][] mem = new String[a.length()][b.length()];
        return lcsAux(a, b, 0, 0, mem);
    }

    public static String lcsAux(String a, String b, int i, int j, String[][] mem) {
        if (i == a.length() || j == b.length()) return "";
        if (mem[i][j] != null) return mem[i][j];
        if (a.charAt(i) == b.charAt(j))
            return a.charAt(i) + lcsAux(a, b, i + 1, j + 1, mem);
        String sa = lcsAux(a, b, i + 1, j, mem);
        if (!sa.isEmpty())
            mem[i+1][j] = sa;
        String sb = lcsAux(a, b, i, j + 1, mem);
        if (!sb.isEmpty())
            mem[i][j+1] = sb;
        return sa.length() > sb.length() ? sa : sb;
    }

    public static void main(String[] args) {
        String lcs1 = lcs(
                "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA",
                "GTCGTTCGGAATGCCGTTGCTCTGTAAA");
        System.out.println(lcs1.equals("GTCGTCGGAAGCCGGCCGAA"));
    }
}
