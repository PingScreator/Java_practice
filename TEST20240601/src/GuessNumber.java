//20240627
import java.util.Scanner;
/*
public class GuessNumber {
    //隨機產生數字的終極密碼遊戲
    public static void play(){
        for(int i=0 ; i<10; i++){
            // 2~98 0~1 =>0~97 +2 => 2~98             
            //Math.random()
            //生成一個介於 0.0（包含）到 1.0（不包含）之間的隨機雙精度浮點數
            //隨機數乘以 97，得到一個範圍在 0.0 到 97.0 之間的隨機雙精度浮點數，且 97.0 不包含在內
            //結果的基礎上加上 2，得到一個範圍在 2.0 到 99.0 之間的隨機雙精度浮點數，且 99.0 不包含在內
            //
            //double a = Math.random()*97+2;
            //System.out.println((int)a);//強型轉換
        }
    }
}
*/

//猜數字 (終極密碼)
public class GuessNumber {
    //呼叫play
    public static void play(){
        //出題: 隨機取得1個數字 範圍是2~98   0~1*97  0~96 +2 2~98
        int answer = (int)(Math.random()*97+2);
        //System.out.println(ans);
        int start = 1;
        int end = 99;
        Scanner scanner = new Scanner(System.in);
        System.out.println("數字範圍1-99，請輸入數字回答");
        // 八次機會
        for (int i = 1; i < 9; i++) {
            int ss = scanner.nextInt();
            if (ss > answer) {
                end = ss;
                System.out.println("數字範圍" + start + "-" + end + "，還剩下" + (8 - i) + "次機會");
            } else if (ss < answer) {
                start = ss;
                System.out.println("數字範圍" + start + "-" + end + "，還剩下" + (8 - i) + "次機會");
            } else if (ss == answer) {
                System.out.println("回答正確");
            }
        }
        scanner.close();
    }
}