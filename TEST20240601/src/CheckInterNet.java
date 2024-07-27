//chatGPT 網路連線程式碼嘗試
/* 
//try1:URL url = new URL(urlString);//為舊式java寫法
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckInterNet {
    public static void main(String[] args) {
        String url = "http://www.google.com"; // 要檢查連接的URL

        if (isConnected(url)) {
            System.out.println("Internet connection is available.");
        } else {
            System.out.println("No internet connection.");
        }
    }
    
    public static boolean isConnected(String urlString) {
        HttpURLConnection urlConnect = null;
        try {
            URL url = new URL(urlString); // 創建 URL 對象
            urlConnect = (HttpURLConnection) url.openConnection(); // 打開與該 URL 的連接
            urlConnect.setConnectTimeout(5000); // 設置連接超時為 5 秒
            urlConnect.connect(); // 嘗試連接
            
            // 檢查 HTTP 響應碼，200 表示成功
            if (urlConnect.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            if (urlConnect != null) {
                urlConnect.disconnect(); // 斷開連接
            }
        }
        return false;
    }
}
*/


//try2:成功重新生成新的程式 (更改舊的java碼)

import java.io.IOException;//用於處理 I/O 操作中的異常
import java.net.HttpURLConnection;//用於建立 HTTP 連接
import java.net.URI;//用於處理統一資源標識符 (URI)
import java.net.URISyntaxException;//處理 URI 語法錯誤的異常
import java.net.URL;//用於表示統一資源定位符 (URL)

public class CheckInterNet {
    public static void main(String[] args) {
        String urlString = "http://www.google.com"; // 要檢查連接的URL

        try {
            URI uri = new URI(urlString);
            //使用 URI 類來解析 URL 字串。這比直接使用 new URL(urlString) 更加靈活和安全
            //從 URI 生成 URL 對象
            if (isConnected(uri.toURL())) {
                //調用 isConnected 方法，檢查連接是否成功。
                System.out.println("Internet connection is available.");
            } else {
                //如果連接失敗，則輸出..
                System.out.println("No internet connection.");
            }
        } catch (URISyntaxException e) {
            //捕獲 URI 語法錯誤的異常
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            //捕獲 I/O 操作中的異常
            System.out.println("IOException: " + e.getMessage());
        }
    }
    //定義了一個靜態方法，接受一個 URL 對象，返回一個布爾值表示連接狀況
    public static boolean isConnected(URL url) {
        //初始化 HttpURLConnection 對象
        HttpURLConnection urlConnect = null;
        try {
            //使用 URL 的 openConnection() 方法打開連接，並將其轉換為 HttpURLConnection。
            urlConnect = (HttpURLConnection) url.openConnection(); // 打開與該 URL 的連接
            //設置連接超時時間為 5 秒
            urlConnect.setConnectTimeout(5000); // 設置連接超時為 5 秒
            //發起連接
            urlConnect.connect(); // 嘗試連接
            
            // 檢查 HTTP 響應碼，200 表示成功
            if (urlConnect.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;//如果響應碼為 200，返回 true 表示連接成功
            }
            //'catch (IOException e)'捕獲 I/O 操作中的異常，並打印異常消息
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            //'finally'無論是否拋出異常，finally 區塊中的代碼都會執行
        } finally {
            if (urlConnect != null) {
                urlConnect.disconnect(); // 斷開連接
            }
        }
        return false;
    }
}


