package algorithms.datastructures.arrays;

import java.util.Scanner;

public class KadanesAlgorithm {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = scanner.nextInt();
            }
            int ps = A[0], cs = A[0];

            for (int k = 1; k < A.length; k++) {
                if(cs < 0){
                    cs = A[k];
                } else {
                    cs += A[k];
                }
                if (cs > ps) {
                    ps = cs;
                }
            }
            System.out.println(ps);

        }
    }
}
