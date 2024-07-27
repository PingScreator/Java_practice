//20240706_TC_JAVA視窗使用教學
import javax.swing.*;//swing.*:這一包裡面有許多的class,全部import進來
import java.awt.*;
import java.awt.event.*;
//"extends":繼承、延伸
class MyFrame extends JFrame {
  //Button
  private JButton btnTutup  = new JButton("Tutup");
  private JButton btnTambah = new JButton("Tambah");
  //文字輸入框
  private JTextField txtA = new JTextField();
  private JTextField txtB = new JTextField();
  private JTextField txtC = new JTextField();
  //標籤
  private JLabel lblA = new JLabel("A :");
  private JLabel lblB = new JLabel("B :");
  private JLabel lblC = new JLabel("C :");

  //程式進入點:不需要回傳值void (int/float/String...
  public MyFrame(){
    setTitle("My Program");
    setSize(400,200);//視窗大小
    setLocation(new Point(300,200));//螢幕左上角(0, 0);螢幕往右為x;螢幕往下為y
    setLayout(null);    
    setResizable(false);//不可以改視窗大小

    initComponent();    
    initEvent();    
  }

  //初始化東西擺放方式
  private void initComponent(){
    btnTutup.setBounds(300,130, 80,25);
    btnTambah.setBounds(300,100, 80,25);

    txtA.setBounds(100,10,100,20);
    txtB.setBounds(100,35,100,20);
    txtC.setBounds(100,65,100,20);

    lblA.setBounds(20,10,100,20);
    lblB.setBounds(20,35,100,20);
    lblC.setBounds(20,65,100,20);

    //建立關聯
    add(btnTutup);
    add(btnTambah);

    add(lblA);
    add(lblB);
    add(lblC);

    add(txtA);
    add(txtB);
    add(txtC);
  }

  //初始化事件發生
  private void initEvent(){
    //要求window幫忙聆聽
    //因為已經extent JFrame所以下面的功用都能用
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e){
          System.exit(1);//關掉這支程式(只有這行自己寫的動作)
        }
      }
    );

    //在button上的事件
    btnTutup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTutupClick(e);//點擊button才有反應
      }
    });

    btnTambah.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTambahClick(e);
      }
    });
  }
  
  private void btnTutupClick(ActionEvent evt){
    System.exit(0);//定義點擊此button 則關閉視窗
  }
  
  private void btnTambahClick(ActionEvent evt){
    Integer x,y,z;//共同宣告
    //try{}:防爆箱作用，可以幫所有程式碼，包含可能有問題的程式碼
    //catch(){}:抓到有問題的程式碼並顯示錯誤視窗
    //showMessageDialog(掛在誰的視窗下, 錯誤訊息存入e, 視窗標題, messageType)
    //可以使用while(true){包入try{}catch(){}}表示一直試到成功為止
    try{
      x = Integer.parseInt(txtA.getText());
      y = Integer.parseInt(txtB.getText());
      z = x + y;
      txtC.setText(z.toString());

    }catch(Exception e){
      System.out.println(e);
      JOptionPane.showMessageDialog(null, 
          e.toString(),
          "Error", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
}