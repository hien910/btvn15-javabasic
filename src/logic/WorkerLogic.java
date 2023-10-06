package logic;

import entity.Factory;
import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WorkerLogic {
    private List<Worker> workers = new ArrayList<>();

    public List<Worker> getWorkers() {
        return workers;
    }

    public WorkerLogic(List<Worker> worker1) {
        this.workers = worker1;
    }


    public void addNewWorker(){
        System.out.print("Nhập số lượng công nhân thêm vào: ");
        int numWorker ;
        do {
            try {
                numWorker = new Scanner(System.in).nextInt();
                if (numWorker>0){
                    break;
                }
                System.out.println("số lượng thêm vào phải là 1 số >0, nhập lại");
            } catch (InputMismatchException e1){
                System.out.println("dữ liệu không đúng, nhập lại");
            }
        }while (true);
        for (int i = 0; i < numWorker; i++) {
            System.out.println("Nhập thông tin cho công nhân thứ "+(i+1));
            Worker worker = new Worker();
            worker.inputInfo();
            saveWorker(worker);
        }
    }

    private void saveWorker(Worker worker) {
        if (worker ==null){
        }
        workers.add(worker);
//        for (int i = 0; i < workers.size(); i++) {
//            workers.add(worker);
//        }
    }
    public void showWorker(){
        for (int i = 0; i < workers.size(); i++) {
            System.out.println(workers.get(i));
        }
    }
    public Worker searchByIdWorker(int id){
        Worker worker = new Worker();
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId()==id && workers.get(i)!= null){
                worker =workers.get(i);
                break;
            }
        }
        return worker;
    }
}
