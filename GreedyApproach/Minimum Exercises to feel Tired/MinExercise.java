import java.util.*;
public class MinExercise {
 public static int minExercisesToTire(int E, int[] A) {
 Arrays.sort(A); 
 int count = 0;
 int n = A.length;
 for (int i = n-1 ; i >= 0; i--) {
 for (int j = 0; j < 2; j++) {
 E = E - A[i];
 count++;
 if (E <= 0) return count;
 }
 }
 return -1;
 }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int E = sc.nextInt();
 int N = sc.nextInt();
 int[] A = new int[N];
 for (int i = 0; i < N; i++) A[i] = sc.nextInt();
 System.out.println(minExercisesToTire(E, A));
 }
}