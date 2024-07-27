//20240608練習(以銀行櫃檯比喻)
//standard type
//權限設定:包含public(公開)、private(不公開)、protected（受保護）(公開後有有特定部分不讓外部使用者更動程式)

public class App3 {
    //設定屬性值
    private int money;//prviate不公開給別人用，使用者不會看到，除非設定名稱
    private String name;
    public String note;

    //加入"static"表示在裡面呼叫函式即可使用，不用在外面用instance呼叫他使用
    //public static公開且固定的值,使得呼叫App3能使用
    //main(String[] args)常用設定，包攬範圍較大
    //throws Exception把錯誤拋出來
    public static void main(String[] args) throws Exception {
        //main(String[] args)設定String[] args的原因是大範圍定義參數，這樣{}中定義的數值專為其他形式較為容易
        //main()不設定也可以
    }    

    public void setname(String n){
        this.name = n;//APP櫃台使用setname()來設定資料
        System.out.println("設定完成");
        getMoney(100);
    }
    public String getName(){
        return name;
    }
    //getMoney(int)回傳取出金額，剩餘公司餘額是機密
    private int getMoney(int m){
        if(money > m){
            money = money - m;//剩餘餘額
            return m;
        }
        else{
            return 0;//沒有足夠的錢
        }
        
        //System.out.println("領取" + m +"元成功");
    }
}
//實體化(instance)App
//App3 app1 = new App3();//呼叫App3
//app1.getMoney
//App3.main();

