//Solution20240620-22---66.PlusOne
//Way1:直接處理數組進位
//Way2:將數組轉換為整數進行加一運算
/*
 * (這個方法有個問題：如果 int 值超出範圍（例如 999999999），
 * 可能會導致數據丟失或計算錯誤。這裡不會影響到 question1 的測試，但對於很大的數字會出問題)
 */
//Way3:使用 BigInteger 來處理任意長度的數組
import java.util.Arrays;//使用plusOne2
import java.math.BigInteger;//plusOne3

public class Solution20240620 {
    public static void main(String[] args) throws Exception {
        //檢測運算
        //由於數組是引用類型，傳遞時會影響到同一個數組實例，因此需要創建數組的副本來避免數據被修改。
        int[] question1 = new int[]{9,8,7,6,5,4,3,2,1,0};
        //int[] question2 = new int[]{9};
        //int[] question3 = new int[]{9,8,7,6,5,4,3,2,1,0};//way a1

        /* 原始程式碼
        int[] answay1 = plusOne(question1);
        int[] answay1_2 = plusOne(question2);

        int[] answay2 = plusOne2(question1);
        int[] answay3 = plusOne3(question3);
        */

        // 使用副本來避免數據被修改
        int[] answay1 = plusOne(Arrays.copyOf(question1, question1.length));
        int[] answay2 = plusOne2(Arrays.copyOf(question1, question1.length));
        int[] answay3 = plusOne3(Arrays.copyOf(question1, question1.length));

        // 1.使用 Arrays.toString 打印數組
        System.out.println(Arrays.toString(answay1));//question1答案
        //System.out.println(Arrays.toString(ans2));//question2答案
        System.out.println(Arrays.toString(answay2));//question1答案
        System.out.println(Arrays.toString(answay3));//question1答案
        //System.out.println(ans);
        /* 
        // 2.一個一個打印數組
        for(int i :ans2){
            System.out.println(i);
        }
        */
    } 
    //    
    public static int[] plusOne(int[] digits) {
        //設定目標數字tg
        int tg = digits.length -1;
        //1.位置"-1"跳出迴圈 2.不用進位結束
        while (true) {
            //取得目標數字
            int a = digits[tg];
            //如果是9則進位
            if(a!=9){
                //讓迴圈數+1 不用進位結束
                digits[tg]=a+1;
                break;
            }else{
                digits[tg]=0;//如過是9則該位置數值變為0
                tg=tg-1;//索引往前
            }
            if(tg<0){
                break;//tg=-1,表示數列頭為9
            }
        }
        //離開while:1.算完回傳;2.tg<0,表示需要新建一個array解決
        if(tg>=0){
            return digits;
        }else{
            int[] rtn = new int[digits.length +1];//成立新的array
            rtn[0]=1;
            for(int i=0; i<digits.length;i++){
                rtn[i+1] = digits[i];
            }
            return rtn;
        }
    }     

    /* 
    public static int[] plusOne(int[] digits) {
        //case3無法解決,也無法持續檢查進位問題
        //取得個位數        
        //int a = digits[digits.length -1];//值
        //如果是9則進位
        if(a!=9){
            //若個位數<9
            digits[digits.length -1] = a+1;
        }else{
            //有進位數字0
            if(digits.length-2>0){
                digits[digits.length -2] = digits[digits.length -2]+1;//前一個位置+1
            }else{
                //沒有進位數字0
                int[] rtn = new int[digits.length +1];//成立新的array
                rtn[0]=1;
                for(int i=0; i<digits.length;i++){
                    rtn[i+1]=digits[i];
                }
            }
            
        }
        return digits;
    }
    */
    //第二種運算方法
    //1. array轉整數 int
    //2. 加1
    //3. 轉字串String
    //4. 切字串並逐一放入array
    public static int[] plusOne2(int[] digits) {
        int l = digits.length -1;//questiion=10長度但0~9
        int sum = 0 ;
        //遍歷陣列從後到前的位置
        for(int i=l-1; i>=0 ; i--){
            //位數 要乘多少 10的?次方
            //個位數 0    10^0 = 1
            //十位數 1    10^1 = 10
            double pow = Math.pow(10, (l-1)-i);
            //double to integer ;(int);
            int powi= (int)pow;//強制轉型 1.5是無條件轉換?四捨五入?//int powi = 
            //digits[?] {1,2,3} digits[0]*10^2 + digits[1]*10^1 + digits[2]*10^0
            //總長度
            sum = sum + digits[i]*powi;
            //int to string
            String s = String.valueOf(sum);
            //substring* 取得子字串 124 1, 2, 4
        }
        sum = sum +1;
        return digits;
    }
    /*
    public static int[] plusOne3(int[] digits) {
        int l = digits.length -1;
        BigInteger sum = new BigInteger("0");//吃string
        //{3,2,1,1} 3*1000 + 2*100 + 1*10 + 1*1
        //sum=0 ; sum=0+3000 =>sum=3000+200..
        for(int i=0; i<l ; i++){
            //數學次方數:java中^ = XOR 次方: Math.pow
            String pow ="1";
            for(int j=0; j<l-1-i ; j++){
                pow  =pow +"0";
            }
            BigInteger pow1 = new BigInteger(pow);
            //轉文字
            //String sss = String.valueOf(digits[i]);
            //轉大數
            //BigInteger bsss = new BigInteger(sss);
            //mutiply 乘上 位數(pow1)
            //加總.add
            sum = sum.add(pow1.multiply(new BigInteger(String.valueOf(digits[i]))));//接收數字->轉字串文字->轉大數(BigInteger) 乘上次方位數(pow1)->相總
        }
        //加1
        sum = sum.add(new BigInteger("1"));
        String s = sum.toString();//結果接起來遍字串
        int slen = s.length();//字串長度
        int[] rtn = new int[slen];//儲存數字空間
        for(int i=0; i<slen;i++){
            rtn[i] = Integer.valueOf(s.substring(i, i+1));//文字轉述數字//substring(i, i+1)0~1;1~2;2~3回傳string
        }
        return rtn;
    }
    */
    public static int[] plusOne3(int[] digits) {
        int l = digits.length;
        
        BigInteger sum = new BigInteger("0");
        // {3,2,4,1}  3 * 1000   + 2  * 100  + 4 * 10  + 1 * 1
        // sum =0  =>   sum = 0 + 3* 1000 => sum = 3000 + 2 *100 + ...
        //加總 各個位數
        for(int i=0;i<l;i++){
            //java 中 ^ = XOR 次方: Math.pow
            String pow="1";
            for(int j=0;j<l-1-i;j++){
                pow=pow+"0";
            }
            //BigInteger 不限位數的整數類別
            //pow = 1000 {2,3,2,1,1,................,3}
            BigInteger pow1 = new BigInteger(pow);
            //2 轉文字
            //String sss = String.valueOf(digits[i]);
            //2 轉大數
            //BigInteger bsss = new BigInteger(sss);
            //2 .multiply 乘上 位數(pow1)
            //加入總和內 .add
            sum = sum.add(pow1.multiply(new BigInteger(String.valueOf(digits[i]))));
        }
        //加1
        sum = sum.add(new BigInteger("1")) ;
        //System.out.println(sum);
        //1235 "Hello"
        String s = sum.toString();
        int slen = s.length();
        int[] rtn1=new int[slen];
        for(int i=0;i<slen;i++){
            rtn1[i] = Integer.valueOf(s.substring(i,i+1));
        }
        return rtn1;
    }
}

//其他演算法發想
/*
1.plusOne()原先的數列用不同程式碼展現
想分享:
發現可以用for迴圈從數列最後一個依序往前找 
若=9 則該位置直接替換為0;若<9則直接加1
特例情況:發現原先數列最前一個位置已經被換成0，則新建一個array將最前一個數值設定為1
*/
/*
 * 2.將數列轉換為千百個位數再回傳回數列
 * *使用substring
 * public class Main {
  public static void main(String[] args) {
    String myStr = "Hello, World!";
    System.out.println(myStr.substring(0, 5));//0~1='H';4~5='o'
  }
}
 */
