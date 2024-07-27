//20240601 Java結構介紹筆記
//public公開可使用;static固定
//void 回傳值(不會回覆值return 數值、字串..)
//String字串
//args

//import java.util.Scanner;
/* 
public class App {
    public static void main(String[] args) throws Exception {
        String text = "Hello, World!";
        System.out.println(text);//呼叫系統
        test();//呼叫test()
        ping();//呼叫ping()
        AdditionNum();
    }
    //main固定使用方法，若想要顯示"Hello, Cathy!"，這個文字，則要呼叫下方function
    public static void test(){
        System.out.println("Hello, Cathy!");//呼叫系統
    }
    public static void ping(){
        System.out.println("Introduction: I'm Cathy!");
    }
    public static void AdditionNum(){
        Scanner scan = new Scanner(System.in);        
        double num1;
        double num2;
        double sum;

        System.out.print("請輸入第一個數字: ");
        num1 = scan.nextDouble();
        System.out.print("請輸入第二個數字: ");        
        num2 = scan.nextDouble();
        sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);

        scan.close();
    }
}
*/
public class App {
    public static void main(String[] args) throws Exception {
        //String text = "Hello, World!";
        //System.out.println(text);//呼叫系統

        //FOR練習1:20240608
        /*int total = 0;
        for(int i = 1 ; i < 101 ;i++)//初始化;"i++" == "i=i+1"
        {
            //System.out.println("Hi");
            //System.out.println("Hi " +i);
            total = total +i;
        }
        System.out.println("Hi! " +total);
        */

        //FOR練習2:20240608
        /* 
        int total = 0;
        int [] arg1 ={1,3,5,7,9,11,13,15,17,19};
        for(int i = 0 ; i < 10 ;i++)//初始化;"i++" == "i=i+1"
        {
            //System.out.println("Hi");
            //System.out.println("Hi " +arg1[i]);
            total = total + arg1[i];
        }
        System.out.println("Hi! " +total);
        */

        //while練習1:20240608
        /*
        while (true)
        {
            System.out.println("ok ");//ctrl+C可以停止
        }
        */

        //while練習2:與FOR有同等效用20240608
        /*
        int count = 0;
        while (count<10)
        {
            count ++;
            System.out.println("ok! ");//ctrl+C可以停止
        }
        */
        int total = 0;
        int[] arrrr1 = {1,3,5,7,9,11,13,15,17,19};
        for( int i=0   ;   i<10  ;  i++ )
        {
            //System.out.println("Hi! "+ar1[i]);
            total = total + arrrr1[i] ;
        }
        System.out.println("Hi! "+total);
    
    }
    private int money;
    private String name;
    public String note;
    public void setName(String n)
    {
        this.name = n;
        System.out.println("設定完成");
        getMoney(100);
    }
    public String getName()
    {
        return name;
    }
    private int getMoney(int m)
    {
        if(money>m)
        {
            money=money-m;
            return m;
        }
        else
        {
            return 0;
        }
        
        //System.out.println("領取"+m+"元成功");
    }

}
