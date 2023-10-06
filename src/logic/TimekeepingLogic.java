package logic;

import entity.Detail;
import entity.Factory;
import entity.Timekeeping;
import entity.Worker;

import java.util.*;

public class TimekeepingLogic {
    private FactoryLogic factoryLogic;
    private WorkerLogic workerLogic;

    private List<Timekeeping> timekeepingLists = new ArrayList<>();

    public TimekeepingLogic() {
    }

    public TimekeepingLogic(WorkerLogic workerLogic, FactoryLogic factoryLogic, List<Timekeeping> timekeepingLists1) {
        this.factoryLogic = factoryLogic;
        this.workerLogic = workerLogic;
        this.timekeepingLists = timekeepingLists1;
    }


    public void setTimekeeping() {
        if (!isEmpty()) {
            System.out.println("chưa có dữ liệu vào");
            return;
        }
        System.out.println("Bạn muốn lập danh sách chấm công cho bao nhiêu người: ");
        int numWorker;
        do {
            try {
                numWorker = new Scanner(System.in).nextInt();
                if (numWorker > 0) {
                    break;
                }
                System.out.println("số lượng phải lớn hơn 0,  nhập lại");
            } catch (InputMismatchException e1) {
                System.out.println("dữ liệu không đúng: nhập lại");
            }
        } while (true);


        for (int i = 0; i < numWorker; i++) {
            System.out.println("công nhân thứ " + (i + 1) + " có id là: ");
            Worker worker = inputWorker();

            System.out.println("Công nhân làm ở bao nhiêu xưởng");
            int numFac;
            do {
                try {
                    numFac = new Scanner(System.in).nextInt();
                    if (numFac > 0) {
                        break;
                    }
                    System.out.println("phải là 1 số > 0, nhập lại");
                } catch (InputMismatchException e3) {
                    System.out.print("dữ liệu nhập vào không đúng, nhập lại:");
                }
            } while (true);
            Factory factory = new Factory();
            int numWorkDay = 0;
            int totalDay = 0;
            List<Detail> detailList = new ArrayList<>();
            for (int j = 0; j < numFac; j++) {
                System.out.print("xưởng thứ " + (j + 1) + " có mã ID là: ");
                factory = inputFactory();
                System.out.print("số ngày làm việc tại xưởng này: ");
                do {
                    try {
                        numWorkDay = new Scanner(System.in).nextInt();
                        if (numWorkDay > 0 && numWorkDay + totalDay < 30) {
                            break;
                        }
                        System.out.println("Số lượng phải lớn hơn 0 ,vui lòng nhập lại: ");
                    } catch (InputMismatchException e2) {
                        System.out.println("dữ liệu không đúng, nhập lại ");
                    }
                } while (true);

                Detail detail = new Detail(factory, numWorkDay);

                detailList.add(detail);
                totalDay += numWorkDay;
            }
            timekeepingLists.add(new Timekeeping(worker, detailList, totalDay));
//            System.out.println("Nhập số ngày công: ");
//            int numDay ;
//            do {
//                try {
//                    numDay = new Scanner(System.in).nextInt();
//                    if (numDay > 0 && numDay <31) {
//                        break;
//                    }
//                    System.out.println("Số lượng phải lớn hơn 0 và không vượt quá 30 ,vui lòng nhập lại: ");
//                }catch (InputMismatchException e2){
//                    System.out.println("dữ liệu không đúng, nhập lại ");
//                }
//            } while (true);

//            timekeepingLists.add( new Timekeeping(worker,factories,numDay));
        }
        showTimekeeping();
    }

    private void showTimekeeping() {
        for (int i = 0; i < timekeepingLists.size(); i++) {
            System.out.println(timekeepingLists.get(i));
        }
    }


    public void sortByName() {
        if (timekeepingLists == null) {
            System.out.println("chưa lập danh sách");
        }
//        for (int i = 0; i < timekeepingLists.size(); i++) {
//            if (timekeepingLists.get(i).getWorker().getName().compareToIgnoreCase(timekeepingLists.get(i+1).getWorker().getName())>0){
//            }
//        }
        timekeepingLists.sort(new Comparator<Timekeeping>() {
            @Override
            public int compare(Timekeeping o1, Timekeeping o2) {
                return o1.getWorker().getName().compareToIgnoreCase(o2.getWorker().getName());
            }
        });
        showTimekeeping();
    }

    public void sortByIdFac() {
        if (timekeepingLists == null) {
            System.out.println("chưa lập danh sách");
        }
        Collections.sort(timekeepingLists, new Comparator<Timekeeping>() {
            @Override
            public int compare(Timekeeping o1, Timekeeping o2) {
                return o1.getIdMin() - o2.getIdMin();
            }
        });
        showTimekeeping();
    }

    public void salary() {
        if (timekeepingLists == null) {
            System.out.println("chưa lap danh sách");
            return;
        }
        double a = 450000;
        for (int i = 0; i < timekeepingLists.size(); i++) {
            double sum = 0;
            Timekeeping timekeeping = timekeepingLists.get(i);
            List<Detail> detailList = timekeeping.getDetail();
            for (int j = 0; j < detailList.size(); j++) {
                sum = sum+ detailList.get(j).getFactory().getCoefficient();
            }
            sum = a * sum * (double) timekeeping.getTotalWorkDay()/22.0
                    * timekeeping.getWorker().getHeSoBac() ;
            System.out.println("lương tháng của công nhân có id: "+timekeeping.getWorker().getId()+" là: "+ sum);
        }
    }
    private Factory inputFactory() {
        int idFac;
        Factory factory;

        do {
            try {
                idFac = new Scanner(System.in).nextInt();
                factory = factoryLogic.searchByIdFactory(idFac);
                if (factory != null) {
                    break;
                }
            } catch (InputMismatchException e2) {
                System.out.println("dữ liệu không đúng, nhập lại");
            }
        } while (true);
        return factory;
    }

    private Worker inputWorker() {
        int idWorker;
        Worker worker;

        do {
            try {
                idWorker = new Scanner(System.in).nextInt();
                worker = workerLogic.searchByIdWorker(idWorker);
                if (worker != null) {
                    break;
                }

            } catch (InputMismatchException e2) {
                System.out.println("dữ liệu không đúng, nhập lại");
            }
        } while (true);
        return worker;
    }

    public boolean isEmpty() {
        if (workerLogic.getWorkers().isEmpty() || factoryLogic.getFactories().isEmpty()) {
            return false;
        }
        return true;
    }


}
