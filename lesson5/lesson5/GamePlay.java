package lesson5;

import java.util.Arrays;
import java.util.Scanner;

import lesson5.RobotMap.Robot;

public class GamePlay {

    public static RobotMap mapCreation(RobotMap map) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); 
                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    return map;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
            sc.close();
        }
    }
    
    public static Robot robotCreation(RobotMap map) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            RobotMap.Robot robot = null;
            String command = sc.nextLine();
            if (command.startsWith("create-robot")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); 
                try {
                    robot = map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                    System.out.println(robot);
                    return robot;
                } catch (PositionException e) {
                    System.out.println("Во время создания робота возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
            sc.close();
        }
    }
}
