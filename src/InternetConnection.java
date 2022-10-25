import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class InternetWorker {
    private boolean internetConnection;
    private boolean firewallTest;

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

    public boolean resultOfFirewallTest() {
        return firewallTest;
    }

    public void testFirewall(){
        try {
            URL url = new URL("https://www.google.ru/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            firewallTest = true;
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
            firewallTest = false;

        } catch (IOException e) {
            System.out.println("Internet is not connected");
            firewallTest = false;
        }
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
            }
        } catch (Exception e) {
            internetConnection = false;

        }
    }
}
