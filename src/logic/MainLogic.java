package logic;

import entity.Factory;
import entity.Timekeeping;
import entity.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainLogic {
    private  FactoryLogic factoryLogic;
    private WorkerLogic workerLogic;
    private TimekeepingLogic timekeepingLogic;

    public MainLogic() {
        List<Factory> factories = new ArrayList<>();
        factoryLogic=new FactoryLogic(factories);
        List<Worker> workers = new ArrayList<>();
        workerLogic=new WorkerLogic(workers);
        List<Timekeeping> timekeeping = new ArrayList<>();
        timekeepingLogic = new TimekeepingLogic(workerLogic, factoryLogic,timekeeping);
    }

    public void menu() {

       while (true){
           showMenu();
           int choose = chooseFunction();
           switch (choose){
               case 1:
                   workerLogic.addNewWorker();
                   workerLogic.showWorker();
                   break;
               case 2:
                   factoryLogic.addNewFactory();
                   factoryLogic.showFactory();
                   break;
               case 3:
                   timekeepingLogic.setTimekeeping();
                   break;
               case 4:
                   timekeepingLogic.sortByName();
                   break;
               case 5:
                   timekeepingLogic.sortByIdFac();
                   break;
               case 6:
                   timekeepingLogic.salary();
                   break;
               case 7:
                   return;
           }
       }

    }
    private int chooseFunction() {
        int choice = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 7) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private void showMenu() {
        System.out.println("=============PHẦN MỀM LẬP DANH SÁCH PHÂN CÔNG============");
        System.out.println("1. Thêm danh sách công nhân mới và in ra.");
        System.out.println("2. Thêm danh sách xưởng mới và in ra.");
        System.out.println("3. Lập danh sách phân công và in ra");
        System.out.println("4. Sắp xếp danh sách hóa đơn theo tên công nhân");
        System.out.println("5. Sắp xếp danh sách hóa đơn theo xưởng");
        System.out.println("6. Lập bảng thống kê thu nhập cho mỗi công nhân");
        System.out.println("7. Thoát");
    }
}
