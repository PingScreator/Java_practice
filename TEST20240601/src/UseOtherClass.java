//20240629---Class 應用(隨機碼)

import java.util.Arrays;

public class UseOtherClass {
    public static void main(String[] args) throws Exception {
        //目標:隨機產生4個不重複的數字
        //初始化產生不重複隊列 0~9
        int[] init = new int[10];
        for(int i=0; i<10; i++){
            init[i]=i;//數字i存入init第i個位置
        }

        //隨機產生4個不重複的數字
        int[] digits = new int[4];
        int size = 10;

        //這個過程會重複四次
        for (int i = 0; i < 4; i++) {
            // 目標:隨機取得位置 (0 ~ size-1)
            int a = (int) (Math.random() * size);
            // 提取目標位置數字
            digits[i] = init[a];//隨機數字存入digits[]空陣列
            // 移除選取的數字並向前移動剩餘的數字(隨機取得位置 (0 ~ size-1))
            for (int j = a; j < size - 1; j++) {
                //操作方式:移除 init 陣列中索引為 a 的數字，並將後面的數字依次向前移動，以填補被移除的數字位置
                init[j] = init[j + 1];//將後面的數字依次向前移動，以填補被移除的數字位置
            }
            size--;
            
        }
        
        // 打印生成的數字
        String Ans = Arrays.toString(digits);
        System.out.println(Ans); // 打印生成的數字
        

        //完成四個不同數字的選取
        //GuessNumber.play();//隨機產生數字的終極密碼遊戲
    }
}


//課堂最後20240622
/* 
public class UseOtherClass {
    public static void main(String[] args) throws Exception {
        String s = new String();
        String s2 = String.valueOf(20);

        ABGame ab = new ABGame();//String n = String.valueOf(0);//展現出()內有多種DATA形態的Class
        ab.test();
        ForImport fi1 = new ForImport();
        System.out.println(fi1.nameis());
        ForImport fi2 = new ForImport("小白");
        System.out.println(fi2.nameis());
        System.out.println(ForImport.nameiss());
        //ABGame ab2 = new ABGame("路人乙");
        //ABGame ab3 = new ABGame(15);
        //ABGame ab4 = new ABGame()"路人乙",15);
        //System.out.println("完成");//參考自己專案的class 互相不用定義哪裡來的;所以class命名盡量不要與常用java家的class相同
        //ABGame.main(new String[]{});
    }
}
*/