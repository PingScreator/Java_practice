//20240620_Solution_66.PlusOne[TeacherCode完整版本]
import java.math.BigInteger;
import java.util.HashMap;

public class Solution_T {
    //加1 66題 使用 biginteger
    public static int[] plusOne2(int[] digits) {
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
        int[] rtn=new int[slen];
        for(int i=0;i<slen;i++){
            rtn[i] = Integer.valueOf(s.substring(i,i+1));
        }
        return rtn;
    }
    //加1 66題 使用 while
    public static int[] plusOne(int[] digits) {
        /*
        //練習演算法說明
        //1. array轉整數 int
        //2. 加1
        //3. 轉字串String
        //4. 切字串並逐一放入array
        int l = digits.length;
        int sum = 0;
        for(int i=l-1;i>=0;i--){
            //位數 乘多少 10的?次方
            double pow = Math.pow(10,l-1-i);
            //double to int  (int)
            int powi = (int)pow;
            //digits[?] * 10^?   {1,2,3} digits[0]*10^2 + digits[1] *10^1 + digits[2] * 10^0
            sum = sum + digits[i]*powi;
            //int => String
            String s = String.valueOf(sum);
            // substring 取得子字串 124   1 , 2, 4
        }
        sum =sum+1;
        return digits;
        */
        
        //設定目標位置 tg
        int tg = digits.length-1;
        while(true){
            //取得目標數字
            int a = digits[tg];
            //如果是9則進位
            if(a!=9){
            //讓個位數+1 不用進位結束
                digits[tg]=a+1;
                break;
            }
            else
            {   //變0並進位 tg鎖定下一位數
                digits[tg]=0;
                tg=tg-1;
            }
            if(tg<0){ //無法再進位時離開迴圈
                break;
            }
        }
        
        if(tg>=0){
            return digits;
        }else
        {
            int[] rtn=new int[digits.length+1];
            rtn[0]=1;
            for(int i=0;i<digits.length;i++){
                rtn[i+1]=digits[i];                    
            }
            return rtn;
        }
    }

    
    public static void main(String[] args) throws Exception {
        //* plusOne呼叫
        int[] question = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] rtn = plusOne2(question);
        for(int i :rtn){
            System.out.println(i);
        }
        //*/

        //IV:4,IX:9,XL:40,XC:90,CD:400,CM:900
        //String q = "MDCLIV";
        //int ans = romanToInt(q);
        //System.out.println(ans);
    }

    //羅馬數字查詢容器
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    //羅馬數字轉阿拉伯數字
    public static int romanToInt(String s) {
        hm.put("I",1); 
        hm.put("V",5);
        hm.put("X",10);
        hm.put("L",50);
        hm.put("C",100);
        hm.put("D",500);
        hm.put("M",1000);
        int ans = 0;
        int last =0;
        //遍歷s
        char[] car = s.toCharArray();
        for (char c : car ){
            //計算
            String cc= String.valueOf(c);
            ans = ans+ hm.get(cc);
            if(hm.get(cc)>last){
                ans = ans - 2*last;
            }
            last = hm.get(cc);
            //System.out.println(hm.get(cc)); 
        }
        return ans;
    }

    
}
//資料型態 char int float boolean String
//容器:Array 排隊  {1,3,4,5}  {"SBAM","123","1bac"}
//int[] iar = {1,2} ; String[] sar = {} ; char[] car ; float[] far ; 
//int ccc = Integer.valueOf("32");
//int ccc = (int)c;
        