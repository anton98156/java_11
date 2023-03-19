package lesson5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = GamePlay.mapCreation();
        System.out.println("ИГРАЕМ...");

        System.out.println("Введите команду для создания первого робота:");
        RobotMap.Robot robot = GamePlay.robotCreation(map);
        System.out.println("Введите команду для создания второго робота:");
        RobotMap.Robot robot_2 = GamePlay.robotCreation(map);

        int count = 0;
        while (count < 10) {
            // GamePlay.play(map);
            System.out.println("Положения роботов: ");
            System.out.println(robot);
            System.out.println(robot_2);
            count++;
        }

        // if (robot_2 != null) {
        //     try {
        //         robot_2.move();
        //     } catch (PositionException e) {
        //         System.out.println("Не удалось переместить робота: " + e.getMessage());
        //     }
        // }

        sc.close();
    }
}
