package algo.leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        generate(output, n, n, "");

        return output;
    }


    public void generate(List<String> res, int open, int close, String op){
        if (open == 0 && close == 0){
            res.add(op);
            return;
        }

        if (open > 0) {
            generate(res, open -1, close, op+"(");
        }

        if (open < close) {
            generate(res, open, close-1, op+")");
        }
    }

    public static void main(String[] args) {
        var p = new GenerateParentheses();
        System.out.println(p.generateParenthesis(1));
        System.out.println(p.generateParenthesis(3));
    }

}
