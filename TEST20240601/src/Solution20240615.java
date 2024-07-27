//20240615--leetcode solution--13. Roman to Integer (將邏輯具象化為演算法!逆向工程思維!)

//Solution20240615似房火牆
//leetcode不是使用我電腦的功能 因此不需要static
import java.util.HashMap;//映射用

public class Solution20240615 {
    //要被"大家"(對外)看到則要加static才可被看到
    //static只能呼叫到static(在沒有實體化(new)情況下即可以呼叫的函示)
    //羅馬數字的查詢容器
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();//實體化HashMap
    public static void main(String[] args) throws Exception {
        String q = "MDCLIV";//IIIVXLCDM
        int ans = romanToInt(q);//把值放入function經過轉換 回傳的值為答案
        System.out.println(ans);
    }        
    //羅馬數字轉阿拉伯數字
    //IV,IX,XL,XC,CD,CM={4,9,40,90,400,900}

    public static int romanToInt(String s){        
        //寫自己的函示(String s)不必管外面的代名詞(String q)是甚麼[盡量內外代名詞是什麼]        
        //put()塞入值
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);

        int ans = 0;
        int last = 0;

        //使用for-each寫法 遍歷s
        char[] car = s.toCharArray();         
        for (char c : car ){
            //將字串(String s)轉為一個字元並存入char c            
            String cc = String.valueOf(c);//任何型態轉乘字串
            ans = ans + hm.get(cc);

            //檢查遇到4,9,40,90,400,900
            //檢查當前字符的整數值是否大於上一個字符的整數值。
            //例如，當處理 IV 時，第一次迭代處理 I，last 為 1。第二次迭代處理 V，hm.get("V") 為 5，大於 last 的 1。
            if(hm.get(cc)>last){
                ans = ans - 2*last;
                //例如，對於 IV，已經加了 I 和 V，總和為 6，但實際上應該是 4，所以需要減去 2 乘以 1（即 2 * last）。
            }
            //紀錄上一筆
            last = hm.get(cc);//將當前字符的整數值更新到 last，以便下一次迭代使用

            //System.out.println(hm.get(cc));//get()查詢
        }
        return ans;
    }

}


//資料型態
//容器: Array 排隊{1,3,5,7} {"cat","dog","ant"}//也有不管什麼資料型態都放入的情況
//宣告: int[] arr = {1,2}; String[] arr = {};char[] car; float[] far;

//---------------------------------------------------------//
//型別切換
//1.函示轉換
/* 
String cc = String.valueOf(c);//任何型態轉乘字串
int ccc = Integer.valueOf("32"); //           
int ccc = (int)c;//2進位轉乘10進位
*/

