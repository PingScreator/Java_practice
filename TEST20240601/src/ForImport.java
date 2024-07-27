//20240622
//應用class複習
/* 
public class ForImport {
    //public ForImport(){}//預設存在的
    public int add(int a, int b){
        return a+b;
    }
    
    //不用new即可使用
    public static int addd(int a, int b){
        return a+b;
    }
}
*/
public class ForImport {
    //Situation 1
    public ForImport(){}
    String name ="";
    public ForImport(String n){
        name = n;
    }
    public String nameis(){return name;}
    public int add(int a, int b){
        return a+b;
    }
    static String name2="ME";

    //Situation 2
    public static String nameiss(){return name2;}
    public static int addd(int a, int b){
        return a+b;
    }
    //進階用法
    public static ForImport valueOf(String n){
        return new ForImport();
    }
}

/*
//課堂最後
 * public class forimport {
    public forimport(){}
    private String name ="";
    public forimport(String n){
        name = n;
    }
    //public void changename(String n){name =n;}
    public String nameis(){return name;}
    public int add(int a, int b){
        return a+b;
    }
    private static String name2="ME";
    public static String nameiss(){return name2;}
    public static int addd(int a, int b){
        return a+b;
    }
    public static forimport valueOf(String n){
        return new forimport(n);
    } 
}
 */
