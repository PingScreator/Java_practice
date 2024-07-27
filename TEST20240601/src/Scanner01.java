//scanner 20240613
//1. 建立密碼
//2. 輸入密碼:共有10次錯誤機會
//3. 輸入正確或錯誤時的提示剩下幾次機會

import java.util.Scanner;

public class Scanner01 {
    public static void main(String[] args) throws Exception {
    Scanner myObj = new Scanner(System.in);//定義Scanner
    String password = "abc123";//密碼
    //String textWord;//用戶端輸入的文字
    // Enter username and press Enter
    System.out.println("Enter password:");//輸入密碼

    int attempts = 5;//最大嘗試錯誤

        for (int i = 1; i <= attempts; i++){
            String textWord = myObj.nextLine(); //用戶端輸入的文字    

            if (textWord.equals(password)){
                //檢查密碼是否正確(字串比對)
                System.out.println("輸入正確!");
                break;
            }
            else{
            int change = attempts - i;
                if(change > 0){
                    System.out.println("輸入錯誤!剩下 " + change + "次機會");
                    System.out.println("提示 : BD ");                 
                }else{
                    System.out.println("輸入錯誤!不可再嘗試!!! ");
                }
            }
        } 
        //myObj.close(); // 關閉 Scanner  
    }
}
