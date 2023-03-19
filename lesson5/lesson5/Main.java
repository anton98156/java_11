package lesson5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = null;
        RobotMap map_2 = GamePlay.mapCreation(map);

        System.out.println("ИГРАЕМ...");

        System.out.println("Введите команду:");
        RobotMap.Robot robot = GamePlay.robotCreation(map_2);

        System.out.println("Введите команду:");
        RobotMap.Robot robot_2 = GamePlay.robotCreation(map_2);
        
        System.out.println("Положения роботов: ");
        System.out.println(robot);
        System.out.println(robot_2);

        // if (robot_2 != null) {
        //     try {
        //         robot_2.move();
        //     } catch (PositionException e) {
        //         System.out.println("Не удалось переместить робота: " + e.getMessage());
        //     }
        // }

        // System.out.println("Положения роботов: ");
        // System.out.println(robot);
        // System.out.println(robot_2);

        sc.close();
    }
}
