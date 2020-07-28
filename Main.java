import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 9901;
        int n = sc.nextInt();
        int [][] A = new int[3][n]; // A[0][n] = n번째 칸에 배치안하는 경우의 수, A[1][n] = n번째 칸의 왼쪽에 배치하는 경우의 수, A[0][n] = n번째 칸의 오른쪽에 배치하는 경우의 수
        // Bottom-Up
        // 점화식 : A[0][i] = A[0][i-1] + A[1][i-1] + A[2][i-1]
        //         A[1][i] = A[0][i-1] + A[2][i-1]
        //         A[2][i] = A[0][i-1] + A[1][i-1]
        A[0][0] = 1;
        A[1][0] = 1;
        A[2][0] = 1;
        for (int i=1;i<n;i++) {
            A[0][i] = A[0][i-1] + A[1][i-1] + A[2][i-1];
            A[1][i] = A[0][i-1] + A[2][i-1];
            A[2][i] = A[0][i-1] + A[1][i-1];
            A[0][i] %= mod;
            A[1][i] %= mod;
            A[2][i] %= mod;
        }
        int temp = (A[0][n-1] + A[1][n-1] + A[2][n-1])%mod;
        System.out.println(temp);
    }
}
