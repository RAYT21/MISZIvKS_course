import java.io.IOException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) throws IOException {


        System.out.println("Добро пожаловать в программу проверки компьютерной безопасности!\n");
        System.out.println("Проверка межсетевого экрана\n" +
                        "######################################################\n" +
                        "1) Проверка доступа к интернету\n" +
                        "2) Проверка наличеия установленного межсетевого экрана\n" +
                        "3) Провека работоспособности межсетевого экрана\n" +
                        "######################################################\n" +
                        "Проверка антивирусного ПО\n" +
                        "######################################################\n" +
                        "4) Проверка наличеия установленного антивируса\n"+
                        "5) Проверка работоспособности антивирусного ПО\n"+
                        "######################################################\n"+
                        "6) Вывести результаты\n"+
                        "7) Сохранить результаты в файл\n"+
                        "8) Выйти"

        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер пункта который хотите выполнить: ");
        while(true){
            System.out.print("> ");
            switch (Integer.parseInt(scanner.next())){
                case 1:
                    InternetWorker.getInstance().checkInternetConnection();
                    ResultEditor.getInstance().setInternetStatus(
                            InternetWorker.getInstance().resultOfInternetConnectionTest()
                    );
                    break;
                case 2:
                    FireWall.getInstance().checkExist();
                    ResultEditor.getInstance().setFirewallPlace(
                            FireWall.getInstance().isExist()
                    );
                    break;
                case 3:
                    if (ResultEditor.getInstance().isFirewallPlace() == null){
                        System.out.println("Сначала выполните пункт 2");
                        break;
                    }
                    FireWall.getInstance().checkStatus();
                    ResultEditor.getInstance().setFirewallStatus(
                            FireWall.getInstance().isStatus()
                    );
                    break;
                case 4:
                    Antivirus.getInstance().checkExist();
                    ResultEditor.getInstance().setAntivirusExist(
                            Antivirus.getInstance().isExist()
                    );
                    break;
                case 5:
                    if (ResultEditor.getInstance().isAntivirusExist() == null){
                        System.out.println("Сначала выполните пункт 4");
                        break;
                    }
                    Antivirus.getInstance().checkStatus();
                    ResultEditor.getInstance().setAntivirusStatus(
                            Antivirus.getInstance().isStatus()
                    );
                    break;
                case 6:
                    System.out.println(ResultEditor.getInstance());
                    break;
                case 7:
                    ResultEditor.getInstance().fileOutPut();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Введена неверная позиция");
            }

        }
    }
}