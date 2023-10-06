package logic;

import entity.Factory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FactoryLogic {
    private List<Factory> factories = new ArrayList<>();

    public FactoryLogic(List<Factory> factories1) {
        this.factories = factories1;
    }

    public List<Factory> getFactories() {
        return factories;
    }

    public void addNewFactory() {
        System.out.print("Nhập số lượng xưởng thêm vào: ");
        int numFactory;
        do {
            try {
                numFactory = new Scanner(System.in).nextInt();
                if (numFactory > 0) {
                    break;
                }
                System.out.println("số lượng thêm vào phải là 1 số >0, nhập lại");
            } catch (InputMismatchException e1) {
                System.out.println("dữ liệu không đúng, nhập lại");
            }
        } while (true);
        for (int i = 0; i < numFactory; i++) {
            System.out.println("Nhập thông tin cho xưởng thứ " + (i + 1));
            Factory factory = new Factory();
            factory.inputInfo();
            saveFactory(factory);
        }
    }

    private void saveFactory(Factory factory) {
        if (factory == null) {
        }
        factories.add(factory);
//        for (int i = 0; i < factories.size(); i++) {
//            factories.add(factory);
//        }
    }

    public void showFactory() {
        for (int i = 0; i < factories.size(); i++) {
            System.out.println(factories.get(i));
        }
    }

    public Factory searchByIdFactory(int id) {

        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getId() == id && factories.get(i)!=null) {
                return factories.get(i);
            }
        }
        return null;
    }
}
