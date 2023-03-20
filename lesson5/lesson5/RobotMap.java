package lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RobotMap {

    protected final int n;
    protected final int m;

    public static Map<UUID, Robot> robots;

    public RobotMap(int n, int m) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("\nНедопустимые значения размера карты!");
        }
        this.n = n;
        this.m = m;
        RobotMap.robots = new HashMap<>();
    }

    public Robot createRobot(Point position) throws PositionException {
        checkPosition(position);

        Robot robot = new Robot(position);
        robots.put(robot.id, robot);
        return robot;
    }

    private void checkPosition(Point position) throws PositionException {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > n || position.getY() > m) {
            throw new PositionException("\nНекорректное значение точки: " + position);
        }
        if (!isFree(position)) {
            throw new PositionException("\nТочка " + position + " занята!");
        }
    }

    private boolean isFree(Point position) {
        return robots.values().stream()
                .map(Robot::getPosition)
                .noneMatch(position::equals);
    }

    public class Robot {

        protected UUID id;
        protected Point position;
        protected Direction direction;

        public Robot(Point position) {
            this.id = UUID.randomUUID();
            this.position = position;
            this.direction = Direction.TOP;
        }

        public UUID getId() {
            return id;
        }

        public Point getPosition() {
            return position;
        }

        public void move(Direction direction) throws PositionException {
            Point newPosition = switch (direction) {
                case TOP -> new Point(position.getX() - 1, position.getY());
                case RIGHT -> new Point(position.getX(), position.getY() + 1);
                case BOTTOM -> new Point(position.getX() + 1, position.getY());
                case LEFT -> new Point(position.getX(), position.getY() - 1);
            };
            checkPosition(newPosition);
            position = newPosition;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s\n", id, position.toString());
        }
    }

    public enum Direction {

        TOP, RIGHT, BOTTOM, LEFT

    }

}
