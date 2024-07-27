//20240601嘗試撰寫質數辨別(詢問chatgpt輔助)
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");//呼叫系統
        PrimeChecker(); // 呼叫 PrimeChecker 方法
    }

    public static void PrimeChecker() {
        System.out.println("這是質數嗎?");
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        int number = scanner.nextInt();
        
        if (isPrime(number)) {
            System.out.println(number + " 是質數.");
        } else {
            System.out.println(number + " 不是質數.");
        }
        
        scanner.close();
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}