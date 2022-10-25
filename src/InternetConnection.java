import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class InternetConnection {
    private boolean internetConnection;

    public boolean isInternetConnection() {
        return internetConnection;
    }

    public void checkInternetConnection(){
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            internetConnection = true;
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
            internetConnection = false;

        } catch (IOException e) {
            System.out.println("Internet is not connected");
            internetConnection = false;
        }
    }
}
