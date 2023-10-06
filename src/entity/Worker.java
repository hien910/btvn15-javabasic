package entity;

import constant.Level;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person {
    private int id;
    private int heSoBac ;
    private static int id_auto = 1000;
    private Level level;

    public int getHeSoBac() {
        return heSoBac;
    }

    public void setHeSoBac(int heSo) {
        this.heSoBac = heSo;
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
        Worker.id_auto = id_auto;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Worker() {
        this.id = id_auto;
        id_auto++;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +'\''+
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public void inputInfo(){
        super.inputInfo();
        System.out.println("Nhập cấp bậc, vui lòng chọn 1 trong những lưạ chọn sau: ");
        System.out.println("1. Bậc 1");
        System.out.println("2. Bậc 2");
        System.out.println("3. Bậc 3");
        System.out.println("4. Bậc 4");
        System.out.println("5. Bậc 5");
        System.out.println("6. Bậc 6");
        System.out.println("7. Bậc 7");
        Integer n ;
        do {
            try {
                n = new Scanner(System.in).nextInt();
                if (n>0&&n<8) {
                    break;
                }
                System.out.println("nhập lại");
            }catch (InputMismatchException e1){
                System.out.println("dữ liệu không hợp lệ, nhập lại");
            }
        }while (true);
        setHeSoBac(n);
        switch (n){
            case 1:
                this.setLevel(Level.BAC_1);
                break;
            case 2:
                this.setLevel(Level.BAC_2);
                break;
            case 3:
                this.setLevel(Level.BAC_3);
                break;
            case 4:
                this.setLevel(Level.BAC_4);
                break;
            case 5:
                this.setLevel(Level.BAC_5);
                break;
            case 6:
                this.setLevel(Level.BAC_6);
                break;
            case 7:
                this.setLevel(Level.BAC_7);
                break;


        }
    }
}
