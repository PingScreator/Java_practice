//20240613
/*
 * 終極密碼小遊戲: 1~50 1~28 1~28 10 10~28 20 20~28 25 正確 你用了幾次?
 * 1.數值1~99
 * 2.嘗試次數10次
 * 3.猜錯，要告知範圍
 */

import java.util.Scanner;

public class UltimateNumberGame {
        public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);
        int lowerBound = 1; // 設定範圍下限
        int upperBound = 99; // 設定範圍上限
        int answer = 13; 
        int guess;//用戶猜測數值
        int attempt = 0; // 猜測次數

        System.out.println("終極密碼遊戲開始！請猜一個介於 " + lowerBound + " 和 " + upperBound + " 之間的數字。");
        //while (true)
        for (attempt = 0 ; attempt <11 ;attempt++)
        {
            System.out.print("請輸入你猜測的數值: ");
            guess = myObj.nextInt();//讀取下一行字你輸入的字
            //attempt++;//嘗試次數0+1
            //若猜測數值低於上次建議的數值範圍，則顯示錯誤!
            if (guess < lowerBound || guess > upperBound) {
                System.out.println("輸入錯誤！請猜一個介於 " + lowerBound + " 到 " + upperBound + " 之間的數字。");
                continue;
            }

            if (guess == answer) {
                System.out.println("恭喜你！猜對了！總共猜了 " + attempt + " 次。");
                break;
            } else if (guess < answer) {
                lowerBound = guess + 1;
                System.out.println("太低了！範圍應是 " + lowerBound + " 到 " + upperBound + "之間。");
            } else {
                upperBound = guess - 1;
                System.out.println("太高了！範圍應是 " + lowerBound + " 到 " + upperBound + "之間。");
            }

            if(attempt == 10){
                System.out.println("輸入錯誤!已經猜測達10次,遊戲結束!答案是:"+ answer);
            }
        }
        myObj.close();        
    }

}
