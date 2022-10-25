import java.io.IOException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) throws IOException {
        boolean internetStatus = false;
        boolean firewallPlace = false;
        boolean firewallStatus = false;
        boolean antivirusStatus = false;
        boolean antivirusWorkPas = false;
        boolean antivirusTest = false;


        System.out.println("Проверка межсетевого экрана\n" +
                        "######################################################\n" +
                        "1) Проверка доступа к интернету\n" +
                        "2) Проверка наличеия установленного межсетевого экрана\n" +
                        "3) Провека работоспособности межсетевого экрана\n" +
                        "######################################################\n\n" +
                        "Проверка антивирусного ПО\n" +
                        "######################################################\n" +
                        "4) Проверка наличеия установленного антивируса\n"+
                        "5) Проверка работоспособности антивирусного ПО\n"+
                        "6) Тестирование антивирусного ПО\n"+
                        "######################################################\n"+
                        "7) Вывести результаты\n"+
                        "8) Сохранить результаты в файл\n"+
                        "9) Выйти"

        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер пункта который хотите выполнить: ");
        while(true){
            System.out.println("> ");
            switch (Integer.parseInt(scanner.next())){
                case 1:
                    InternetWorker internetConnection = InternetWorker.getInstance();
                    internetConnection.checkInternetConnection();
                    if(internetConnection.resultOfInternetConnectionTest()){
                        internetStatus = true;
                    }
                    break;
                case 2:
                    FireWall fireWallExist = FireWall.getInstance();
                    fireWallExist.checkExist();
                    if(fireWallExist.isExist()){
                        firewallPlace = true;
                    }
                    break;
                case 3:
                    FireWall fireWallState = FireWall.getInstance();
                    fireWallState.checkStatus();
                    if(fireWallState.isStatus()){
                        firewallStatus = true;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Введена неверная позиция");
            }

        }
    }
}