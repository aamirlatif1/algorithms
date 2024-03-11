package algo;


import java.util.HashSet;
import java.util.Set;

public class App
{

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                char number = board[i][j];
                if(number != '.'){
                    if(!seen.add(number+"row"+i)
                            || !seen.add(number+"col"+j)
                            || !seen.add(number+"block"+i/3+"-"+j/3)
                            ){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokus(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> seqSet = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char row = board[i][j];
                char col = board[j][i];
                int sr = (i/3)*3+ j/3;
                int sc = j%3 + i%3*3;
                char seq = board[sr][sc];
                if(row != '.' && rowSet.contains(row) || col != '.' && colSet.contains(col) || seq != '.' && seqSet.contains(seq)){
                    return false;
                }
                if(row != '.'){
                    rowSet.add(row);
                }
                if(col != '.'){
                    colSet.add(col);
                }
                if(seq != '.'){
                    seqSet.add(seq);
                }
            }
        }
        return true;
    }
    public static void main( String[] args )
    {
        for(int i = 0; i < 9; i++) {
            System.out.println();
            for(int j = 0; j < 9; j++){
                int sr = (i/3)*3+ j/3;
                int sc = j%3 + i%3*3;
                System.out.print(sr +","+sc+" ; ");
            }
        }
    }
}

