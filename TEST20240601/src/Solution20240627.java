//20240627--leetcode Solution----27.remove Element
/*
 * 題目補充說明
1. nums是一個int陣列 例如: {1,2,3,4}
2. val是一個要排除的int 例如: 2
3. 要把nums裡面的val排除掉
4. 回傳排除後剩下的數字 return k
5. 把nums剩下的數字往前排
 */
public class Solution20240627 {
    public static void main(String[] args) throws Exception {
        int[] num1 = {1,1,4,2,2,3,3,3};
        int remove = 2;
        int ans = removeElement(num1, remove);
        System.out.println(ans);

    }
    public static int removeElement(int[] nums, int val) {
        int pointer = 0;
        //讀取陣列大小並遍歷，若是出現val值則刪除陣列裡的數值
        //pointer為刪除後剩下多少個數字
        // nums[i]為當前位置中的元素，eg.nums[i] 表示 nums 在索引 0 處的值, 打印出來即是num1 = {1,1,4,2,2,3,3,3};中的"1"
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                //數值保留並存於新的陣列裡
                nums[pointer] = nums[i];//直接覆蓋值到原來的陣列中
                pointer++;
            }
        }
        return pointer;

    }
    //TeacherCode
    public static int removeElement_TC(int[] nums, int val) {
        int k = 0;
        int[] rtn = new int[nums.length];//rtn 用來暫存不等於 val 的元素。新的陣列
        // 1,2,3,4 不要 2
        // _,_,_,_
        // 1,_,_,_
        // 1,3,_,_
        // 1,3,4,_ =>　rtn
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                // 如果 nums[i] 等於 val，則不做任何操作，直接跳過
            }else{
                // 如果 nums[i] 不等於 val，則將其放入 rtn 陣列的下一個位置
                rtn[k]=nums[i];
                k++;// k 自增，表示找到了一個不等於 val 的元素
            }
        }
        // 將 rtn 陣列中的前 k 個元素複製回 nums 陣列中(往前排 並且陣列大小相同)
        /*
         * 這種方法的多進行一個迴圈的原因是為了保持數組的穩定性和簡單性。通過使用額外的數組 rtn，
         * 可以避免直接在 nums 上進行多次移動操作，減少錯誤和複雜性。雖然這種方法使用了更多的空間，
         * 但在某些情況下可以使代碼更易於理解和維護。
         */
        for(int j=0;j<k;j++){
            nums[j] = rtn[j];//將不等於 val的值全部存回於nums[j]陣列
        }

        return k;// 返回不等於 val 的元素數量
    }
}


