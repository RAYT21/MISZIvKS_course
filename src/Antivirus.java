import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Antivirus {
    private boolean status = false;
    private boolean exist = false;


    private static Antivirus INSTANCE;

    private Antivirus() {}

    public static Antivirus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Antivirus();
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
        String[] cmd = {"ps","-aux"};
        Process pb;
        try{
            pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));

            while ((line = input.readLine()) != null) {
                if(line.contains("drweb-spider")){
                    status = true;
                    System.out.println("Монитор Dr.Web Spider работает!");
                    break;
                }
            }

            input.close();
            if(!status){
                System.out.println("Монитор Dr.Web Spider не работает!");
            }

        }
        catch (IOException e){
            System.out.println("Монитор Dr.Web Spider не работает!");
        }

    }

    public void checkExist(){
        String[] cmd = {"drweb-ctl","-v"};
        Process pb;
        try {
            pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (line.equals("drweb-ctl 11.1.9.2103151924")){
                    exist = true;
                    System.out.println("Антивирус Dr.Web установлен!");
                    break;
                }
            }
            if (!exist){
                System.out.println("Антивирус Dr.Web не установлен!");
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Антивирус Dr.Web  не установлен!");
        }
    }
}
