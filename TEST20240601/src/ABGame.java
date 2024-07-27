//20240622_小遊戲
/* 
 * 1. 設定4位不同的數字 (0~9) ex: 8724  String String[]
 * 2. 輸入4位不同的數字 (0~9) ex: 4321  new Scanner(System.in)
 * 3. While 迴圈
 *    若數字相同且位置相同 A+1
 *    若數字相同但位置不同 B+1
 *    回傳 ?A?B
 * 4. 4A時 結束
 * 4321 => 1A1B
 * 3421 => 1A1B
 * 0324 => 2A0B
 * 0128 => 1A1B
 * (進階)5.A.答案4個數字不可重複!B.4個隨機亂數答案 0~9
*/
//我的code
import java.util.Random;
import java.util.Scanner;
/* 
//第一種random
public class ABGame {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);         
        //System.out.print("請輸入你猜測的數值(4個數): ");    
        //guess = myObj.nextLine(); 
        //System.out.println(guess);

        //------------------------------------------//       
        //Randem產生四個隨機碼每個碼都介於0~9;
        // 生成一個隨機的四位數字，每個數字都是不同的
        String answer = generateRandomNumber();
        System.out.println("Debug: 答案是 " + answer); // 這行可以在調試時使用，正式使用時應該刪除
        //------------------------------------------//
        //String[] answer = new String[] {"8","7","2","4"};//設定遊戲答案
        //String answer = "8742";
        String guess = "1234";//用戶猜測數值
        int attempts = 0;
        int A = 0;//位置和數字全對
        int B = 0;//位置不對和數字對

        while(true){            
            System.out.print("請輸入你猜測的數值(4個數): ");
            guess = myObj.nextLine();//讀取下一行字你輸入的字
            //結果顯示
            System.out.println(guess);

            // 檢查輸入的格式(不符合的文字也要考量)            
            if (guess.length() != 4 || !isValidInput(guess)) {
                System.out.println("請輸入4位不同的數字!");
                continue;
            }   

            // 用來標記已經匹配的字符，防止重複計算
            boolean[] matchedInAnswer = new boolean[4]; // 用於標記答案中的匹配字符
            boolean[] matchedInGuess = new boolean[4]; // 用於標記猜測中的匹配字符

            // 計算 A
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    A++;
                    matchedInAnswer[i] = true; // 標記為已匹配
                    matchedInGuess[i] = true; // 標記為已匹配
                }
            }
            // 計算 B
            for (int i = 0; i < 4; i++) {
                if (!matchedInGuess[i]) { // 只檢查尚未匹配的字符
                    for (int j = 0; j < 4; j++) {
                        if (!matchedInAnswer[j] && guess.charAt(i) == answer.charAt(j)) {
                            B++;
                            matchedInAnswer[j] = true; // 標記為已匹配
                            break; // 找到一個匹配後退出內部迴圈
                        }
                    }
                }
            }
            attempts++;

            //結果顯示
            if (A != 4) {
                System.out.println( A+"A"+ B +"B");//?A?B
            } else{
                System.out.println("恭喜你！4A猜對了！");//4A結束遊戲
                break;
            }
            System.out.println("已經嘗試了"+ attempts+"次");            
        }        
        myObj.close();//將 close 移到這裡，確保迴圈內部的輸入讀取不受影響
    }
    // 生成一個隨機的四位數字，每個數字都是不同的
    private static String generateRandomNumber() {
        Random random = new Random();
        char[] digits = new char[4];
        int count = 0;
        while (count < 4) {
            char digit = (char) ('0' + random.nextInt(10));
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (digits[i] == digit) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                digits[count] = digit;
                count++;
            }
        }
        return new String(digits);
    }

    // 檢查輸入是否為4位不同的數字
    private static boolean isValidInput(String input) {
        if (input.length() != 4) {
            return false;//長度不對
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);//字串中的1個字元
            if (!Character.isDigit(c) || input.indexOf(c) != input.lastIndexOf(c)) {
                return false;//四個字元要不相同
            }
        }
        return true;
    }
}
*/
/* 
//進階版:
 //A.答案4個數字不可重複!
 // B.4個隨機亂數答案 0~9(用Math.random)//第二種random

public class ABGame {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);         
        String answer = generateRandomNumber();
        System.out.println("Debug: 答案是 " + answer); // 這行可以在調試時使用，正式使用時應該刪除

        String guess = "1234";//用戶猜測數值
        int attempts = 0;
        int A = 0;//位置和數字全對
        int B = 0;//位置不對和數字對

        while(true){            
            System.out.print("請輸入你猜測的數值(4個數): ");
            guess = myObj.nextLine();//讀取下一行字你輸入的字
            //結果顯示
            System.out.println(guess);

            // 檢查輸入的格式(不符合的文字也要考量)            
            if (guess.length() != 4 || !isValidInput(guess)) {
                System.out.println("請輸入4位不同的數字!");
                continue;
            }   

            // 用來標記已經匹配的字符，防止重複計算
            boolean[] matchedInAnswer = new boolean[4]; // 用於標記答案中的匹配字符
            boolean[] matchedInGuess = new boolean[4]; // 用於標記猜測中的匹配字符

            // 計算 A
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    A++;
                    matchedInAnswer[i] = true; // 標記為已匹配
                    matchedInGuess[i] = true; // 標記為已匹配
                }
            }
            // 計算 B
            for (int i = 0; i < 4; i++) {
                if (!matchedInGuess[i]) { // 只檢查尚未匹配的字符
                    for (int j = 0; j < 4; j++) {
                        if (!matchedInAnswer[j] && guess.charAt(i) == answer.charAt(j)) {
                            B++;
                            matchedInAnswer[j] = true; // 標記為已匹配
                            break; // 找到一個匹配後退出內部迴圈
                        }
                    }
                }
            }
            attempts++;

            //結果顯示
            if (A != 4) {
                System.out.println( A+"A"+ B +"B");//?A?B
            } else{
                System.out.println("恭喜你！4A猜對了！");//4A結束遊戲
                break;
            }
            System.out.println("已經嘗試了"+ attempts+"次");            
        }        
        myObj.close();//將 close 移到這裡，確保迴圈內部的輸入讀取不受影響
    }
    // 生成一個隨機的四位數字，每個數字都是不同的
    private static String generateRandomNumber() {
        char[] digits = new char[4];
        int count = 0;
        while (count < 4) {
            char digit = (char) ('0' + (int) (Math.random() * 10));//random出來為float->強型轉int->再轉為chart
            boolean duplicate = false;//4個digit不相同
            for (int i = 0; i < count; i++) {
                if (digits[i] == digit) {
                    duplicate = true;//digit重複
                    break;//跳出
                }
            }
            if (!duplicate) {
                digits[count] = digit;//不重複 則存入第一個位置陣列
                count++;
            }
        }
        return new String(digits);//以字串回傳
    }

    // 檢查輸入是否為4位不同的數字
    private static boolean isValidInput(String input) {
        if (input.length() != 4) {
            return false;//長度不對
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);//字串中的1個字元
            if (!Character.isDigit(c) || input.indexOf(c) != input.lastIndexOf(c)) {
                return false;//四個字元要不相同
            }
        }
        return true;
    }
}
*/

//teacher code(含進階解法)20240629
import java.util.HashSet; // Import the HashSet class: items where every item is unique
public class ABGame {
    //給別人服務用的
    //public ABGame(){}//預設就存在了
    public ABGame(){test();}
    public ABGame(String name){}
    public ABGame(int age){}
    public void test(){}//

    public static void testtest(){}//自己程式用
    public static void main(String[] args) throws Exception {
        //隨機出0~9
        //四個位置數字不可重複
        String[] ans = new String[]{"2","3","0","5"};//ans在外
        HashSet<String> tempans = new HashSet<String>();//建立一個空集合
        int k=0;//計數 index(指標)
        while(k < 4){//ans更新在此
            int a = (int)(Math.random()*10);
            String aa = String.valueOf(a);//int轉string
            tempans.add(aa);//隨機數放入集合中
            k = tempans.size();//set 集合是沒有順序性的

            /* 
            //確認是否同步
            if(k==0){//第一個數直接新增
                ans[k] = aa;//直接存在答案第一個位置eg."1"
                k++;
            } else{
                //確認是否重複
                boolean ok = true;//起始值設定重複
                for(int i=0; i<k; i++){//第二個位置開始比較
                    if(ans[i].equals(aa)){//第二個位置的值(字串)=第一個位置的值(字串)
                        ok =false;
                        break;//跳出迴圈
                    }
                }
                if(ok){//不重複則新增
                    ans[k] = aa;//不重複 則到下一個位置賦予一個隨機數字值
                    k++;
                }
            }            
            */
        }
        tempans.toArray(ans);//完成後固定成array 倒出結果
        Scanner s = new Scanner(System.in);
        while(true){ 

            int A = 0 ;
            int B = 0 ;
            System.out.print("請輸入四個不同的數字: ");
            String ss= s.nextLine();
            //計算?A ?B
            if(ss.length() != 4){//檢查長度
                System.out.println("長度不對");
            }else {
                //取得每一個數字
                for(int i=0; i<4; i++){
                    String n = ss.substring(i, i+1);
                    for(int j=0; j<4; j++){ 
                        //比對與ans數字是否相同
                        if(ans[j].equals(n)){
                            //比對位置是否相同
                            if(i==j){
                                A++;
                            } else{
                                B++;
                            }
                        }
                    }
                }
            
                //顯示結果
                System.out.println(A +"A"+ B +"B");
                if(A == 4){
                    System.out.println("Win!");
                    break;
                }
            }
           
        }
        s.close();

    }
}
