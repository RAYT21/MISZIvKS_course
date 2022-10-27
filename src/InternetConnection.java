import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class InternetWorker {
    private boolean internetConnection;

    private static InternetWorker INSTANCE;

    private InternetWorker() {}

    public static InternetWorker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InternetWorker();
        }
        return INSTANCE;
    }

    public boolean resultOfInternetConnectionTest() {
        return internetConnection;
    }


    public void checkInternetConnection() throws IOException {
        try {
            URL urlObj = new URL("https://www.google.ru/");
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            // Set connection timeout
            con.setConnectTimeout(3000);
            con.connect();

            int code = con.getResponseCode();
            if (code == 200) {
                internetConnection = true;
                System.out.println("Интернет подключен!");
            }
            else System.out.println("Интернет не подключен!");
        } catch (Exception e) {
            internetConnection = false;
            System.out.println("Интернет не подключен!");

        }
    }
}
