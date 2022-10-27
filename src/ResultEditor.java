import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ResultEditor {

    private Boolean internetStatus;
    private Boolean firewallPlace;
    private Boolean firewallStatus;
    private Boolean antivirusExist;
    private Boolean antivirusStatus;

    private static ResultEditor INSTANCE;

    private ResultEditor() {}

    public static ResultEditor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultEditor();
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Результат тестирования ПК:\n" +
                internetOutPrint()+
                fireWallOutPrint()+
                antivirusOutPrint();

    }

    private String fireWallOutPrint(){
        return "Межсетевой экран: " + (firewallPlace == null ? "Тестирование не выполнялось\n" :
                ((firewallPlace ?
                        ("Установлен, " +
                                (firewallStatus == null ? "но тестирование на работоспособность не выполнялось\n"
                                        : (firewallStatus ? "верно функционирует\n" : "функционирует не верно или вовсе не функционирует\n" )))
                        : "Не установлен\n")));
    }

    private String antivirusOutPrint(){
        return "Антивирус: " + (antivirusExist == null ? "Тестирование не выполнялось" :
                ((antivirusExist ?
                        ("Установлен, " +
                                (antivirusStatus == null ? "но тестирование на работоспособность не выполнялось"
                                        : (antivirusStatus ? "работает" : "не работает" )))
                        : "Не установлен")));
    }

    private String internetOutPrint(){
        return "Подключение к интернету: " + (internetStatus == null ? "Тестирование не выполнялось\n" :
                (internetStatus ? "пирсутствует\n" : "отсутсвует\n"));
    }

    public void fileOutPut(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла > ");
        try(FileWriter writer = new FileWriter(scanner.next(), false))
        {
            writer.write(ResultEditor.getInstance().toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("Не удалось записать результат в файл в связи с: \n"+ex.getMessage());
        }
    }


    public Boolean isInternetStatus() {
        return internetStatus;
    }

    public void setInternetStatus(boolean internetStatus) {
        this.internetStatus = internetStatus;
    }

    public Boolean isFirewallPlace() {
        return firewallPlace;
    }

    public void setFirewallPlace(boolean firewallPlace) {
        this.firewallPlace = firewallPlace;
    }

    public Boolean isFirewallStatus() {
        return firewallStatus;
    }

    public void setFirewallStatus(boolean firewallStatus) {
        this.firewallStatus = firewallStatus;
    }

    public Boolean isAntivirusExist() {
        return antivirusExist;
    }

    public void setAntivirusExist(boolean antivirusExist) {
        this.antivirusExist = antivirusExist;
    }

    public Boolean isAntivirusStatus() {
        return antivirusStatus;
    }

    public void setAntivirusStatus(boolean antivirusStatus) {
        this.antivirusStatus = antivirusStatus;
    }
}
