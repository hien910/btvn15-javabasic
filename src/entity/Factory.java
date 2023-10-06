package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factory implements Inputable{

    private Integer id;
    private static Integer id_auto=100;
    private String name;
    private String describe;
    private int coefficient;

    public Factory() {
        this.id = id_auto;
        id_auto++;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId_auto() {
        return id_auto;
    }

    public static void setId_auto(int id_auto) {
        Factory.id_auto = id_auto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }

    @Override
    public void inputInfo() {

        System.out.print("Nhập tên xưởng: ");
        setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập mô tả: ");
        setDescribe(new Scanner(System.in).nextLine());
        System.out.print("Nhập hệ số công việc(từ 1 đế 20): ");
        int n;
        do {
            try {
                n=  new Scanner(System.in).nextInt();
                if (n<21 && n>0){
                    break;
                }
                System.out.println("hệ số là 1 số từ 1 đến 20, nhập lại");
            } catch (InputMismatchException e1){
                System.out.println("dữ liệu không đúng, nhập lại");
            }
        }while (true);
        setCoefficient(n);
    }
}
