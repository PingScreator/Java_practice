//20240629---Class 應用(隨機碼)+其他同學的code
/*
 *        //隨機取得位置 (0~9)提示
        int a = (int)(Math.random()*10);
        {0,1,2,3,4,5,6,7,8,9};
        a=4;
        //提取目標位置數字,並隊伍向前補齊
        {0,1,2,3,5,6,7,8,9,_};
        //隨機取得位置 (0~8)
        int a = (int)(Math.random()*9);
        //提取目標位置數字,並隊伍向前補齊
        a=5;
        {0,1,2,3,5,7,8,9,_,_};
        //隨機取得位置 (0~7)
        int a = (int)(Math.random()*8);
        a=5;
        //提取目標位置數字,並隊伍向前補齊
        {0,1,2,3,5,8,9,_,_,_}
        int a = (int)(Math.random()*7);
        //隨機取得位置 (0~6)
        a=1;
        {0,2,3,5,8,9,_,_,_,_};
 */
import java.util.Arrays;

public class MyRandom {
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
    }
}


/* 皓群
        Random random = new Random();
        int[] result = new int[4];
        List<Integer> list = new ArrayList<>();
        //列出數列
        for(int i = 0;i<10;i++){
            list.add(i);
        }
        for(int i = 0;i<4;i++){
            int j = list.size();
            result[i] = list.remove(random.nextInt(j));
            j--;
        }
        System.out.println(list);
        */
/* 鼎富
        int[] init = new int[10];
        for(int i=0;i<10;i++){
            init[i]=i;
        }
        int[] aa=new int[4];
        for (int i=0;i<4;i++){
            int a = (int)(Math.random()*(10-i));
            aa[i]=init[a];
            
            //init資料往前移
            for (int j=a;j<init.length-i-1;j++){ 
                init[j]=init[j+1];
            }
            
        }   
        
        for(int k=0;k<10;k++){
            System.out.println(aa[k]);
            
        }
        */
/* 奕辰
        // 目標 隨機產生4個不重複的數字
        // 先產生一個不重複的陣列
        String[] ans =new String[4];
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add(i);
        }
        // 隨機取得位置
        for (int i = 0; i < 4; i++) {
            int a = (int) (Math.random() * (10 - i));
            // 將該位置的數字設定到答案上
            ans[i] = String.valueOf(numList.get(a));
            // 移除該位置的數字
            numList.remove(a);
        }
        */
/* 文盈
        //目標 隨機產生4個不重複的數字
        //產生不重複隊列 0~9
        int[] init = new int[10];
        for(int i=0;i<10;i++){
            init[i]=i;
        }
        int[] temp = new int[4];
        //隨機取得位置 (0~9)
        for(int j=0;j<5;j++){
            int a = (int)(Math.random()*10)-j;
            temp[j]=init[a];
            Solution removed =new Solution();
            int len = removed.removeElement(init, init[a]);
        }
        */
/* 鈞翔
        Set<Integer> ran = new HashSet<>();
        Random random = new Random();
        
        while (ran.size() < 10) {
            ran.add(random.nextInt(10));
        }
        ArrayList<Integer> rannn = new ArrayList<>(ran);
        ArrayList<Integer> rann = new ArrayList<>();
        int kk = 0;
        while (kk < 4) {
            int nn = random.nextInt(rannn.size());
            rann.add(rannn.get(nn));
            rannn.remove(nn); //加這行就不會重複了
            kk++;
        }
        System.out.println(rann);
        */