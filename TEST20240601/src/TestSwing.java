//20240706_TC_JAVA視窗使用教學
//搭載MyFrame,TestFrameFalse這兩個得結果
public class TestSwing {
    public static void main(String[] args) throws Exception {
        MyFrame f = new MyFrame();//可以run程式(工作管理員可見!但不代表視窗可見)
        f.setVisible(true);//顯示
        //TestFrameFalse test = new TestFrameFalse();
        //test.setVisible(true);(只有視窗放大和縮小功能而已)
    }
}
