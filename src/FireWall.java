import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FireWall {

    private boolean status = false;
    private boolean exist = false;


    private static FireWall INSTANCE;

    private FireWall() {}

    public static FireWall getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FireWall();
        }
        return INSTANCE;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isExist() {
        return exist;
    }

    public void checkStatus()  {
        String[] cmd = {"/bin/bash","-c","echo 0102| sudo -S firewall-cmd --status"};
        Process pb = null;
        try{

            pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                if (line.equals("running")){
                    status = true;
                    System.out.println("Межсетевой экран функционирует правильно!");
                }
            }
            input.close();

        }
        catch (IOException e){
            System.out.println("Межсетевой экран функционирует неверно, или не функционирует вовсе!");
        }

    }

    public void checkExist(){
        String[] cmd = {"whereis","firewalld"};
        Process pb = null;
        try {
            pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (line.split(" ").length > 1){
                    exist = true;
                    System.out.println("Межсетевой экран firewalld установлен!");
                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Межсетевой экран firewalld неустановлен!");
        }
    }
}
