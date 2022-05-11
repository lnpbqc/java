package learn.InnerOuterHomework;

import java.util.Scanner;


//韩顺平java-->https://www.bilibili.com/video/BV1fh411y7R8?p=440 的作业


/**
 * @author lnpbqc
 * @version 1.0.0
 * time 2022/5/11
 **/
public class home2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("创建的人物名字：");
        String name = in.nextLine();
        System.out.print("你要选择什么工具（船/马）：");
        String vehicle = in.nextLine();
        Person p;
        p=switch (vehicle) {
            case "船" ->  new Person(name, CreateVehicle.getBoat());
            case "马" ->  new Person(name, CreateVehicle.getHorse());
            default -> null;
        };
        if(p!=null)p.move();
        else System.out.println("请输入正确字符");
    }
}
interface Vehicles{
    void work();
}
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("正在🏇......");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("正在坐船......");
    }
}
class CreateVehicle{
    public static Horse getHorse(){
        return new Horse();
    }
    public static Boat getBoat(){
        return new Boat();
    }
}
class Person{
    private String name;
    private Vehicles v;

    public Person(String name,Vehicles v) {
        this.name = name;
        this.v = v;
    }
    public void move(){
//        boolean loop = true;
        int count = 0;
        int choice;
        for(;count<81;){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
//            System.out.print("赶路1还是过河2：");
            choice = (int)(Math.random()*10)%2;
            System.out.print(this.name);
            switch (choice) {
                case 0 -> {
                    System.out.println("前面是平地");
                    if (this.v.getClass().equals(new Horse().getClass())) {
                        System.out.println("有马");
                    } else {
                        System.out.println("拿到马了");
                        this.v = CreateVehicle.getHorse();
                    }
                    this.v.work();
                }
                case 1 -> {
                    System.out.println("前面是河流");
                    if (this.v.getClass().equals(new Boat().getClass())) {
                        System.out.println("有船");
                    } else {
                        System.out.println("拿到船了");
                        this.v = CreateVehicle.getBoat();
                    }
                    this.v.work();
                }
            }
        }
        System.out.println("你好"+this.name+",本次旅程已经结束");
    }
}
