//20240629--leetcode Solution----26. Remove Duplicates from Sorted Array
//重要的指標問題!!!需要理解
/*
 * 解題思路
1. 修改 nums 成為不重複的數列
2. 利用變數當指標 更新nums 把不重複的數往前排 (參考)
3. return k; (k是不重複的數字的數量)
 */
public class Solution20240629 {
    public static void main(String[] args) throws Exception {
        //方法1
        int[] num1 = {0,0,1,1,1,2,2,3,3,4};
        int[] num_my = {0,0,1,1,1,2,2,3,3,4};//若不

        int ans = removeDuplicates_TC(num1);
        System.out.println(ans);//正解為5
        int ans_my = removeElement(num_my);
        System.out.println(ans_my);//正解為5

        //方法2(false)
        //複製一份num1給removeDuplicates_TC使用
        int[] num1_TC = num1.clone();
        int[] num_MY = num1.clone();
        int ansTC = removeDuplicates_TC(num1_TC);
        System.out.println(ansTC);//正解為5
        int ansMY = removeElement(num_MY);
        System.out.println(ansMY);//正解為5        
    }
    //My Code
    public static int removeElement(int[] nums) {
        int pointer = 0;
        //讀取陣列大小並遍歷，若是出現val值則刪除陣列裡的數值
        //pointer為刪除後剩下多少個數字
        // nums[i]為當前位置中的元素，eg.nums[i] 表示 nums 在索引 0 處的值, 打印出來即是num1 = {1,1,4,2,2,3,3,3};中的"1"
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                pointer++;//第一個位置不處理
            } else{ //第二個位置開始
                if (nums[i] != nums[i-1] ) {
                    //數值保留並存於新的陣列裡
                    nums[pointer] = nums[i];//直接覆蓋值到原來的陣列中
                    pointer++;
                }             

            }

        }
        return pointer;

    }

    //TeacherCode
    public static int removeDuplicates_TC(int[] nums) {
        int k =0;//計數 指標
        int r = 0;//暫存上一次的答案
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            if(i==0){
                k++;//nums的第一個位置開始遍歷//第一個數據不需要判斷
            } else{
                if(a!=r){
                    nums[k] = a;//抓非第一個位置的地方的變化數值eg. 0,1
                    k++;
                }else{
                    //重複不處理
                }
            }
            r=a;//紀錄r會等於上一個a
        }
        return k;//k為不重複數
    }

}
