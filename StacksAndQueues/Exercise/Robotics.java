package Advance.StacksAndQueues.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Robot[] robots = createRobots(input);

        input = bufferedReader.readLine();

        int time = getStarTime(input);

        ArrayDeque<String> itemsQueue = createItemsQueue(bufferedReader);


        while (!itemsQueue.isEmpty()) {
            String item = itemsQueue.removeFirst();
            boolean isItemProcessed = false;
            time++;
            for (int i = 0; i < robots.length; i++) {

                if (!robots[i].isWorking) {
                    robots[i].isWorking = true;
                    System.out.println(String.format("%s - %s [%s]", robots[i].name, item, calculateTime(time)));
                    isItemProcessed = true;
                    break;
                }

            }

            if (!isItemProcessed) {
                itemsQueue.addLast(item);
            }
            allRobotsWork(robots);

        }
    }

    private static void allRobotsWork(Robot[] robots) {
        for (Robot robot : robots) {
            robot.work();
        }
    }

    private static ArrayDeque<String> createItemsQueue(BufferedReader bufferedReader) throws IOException {
        ArrayDeque<String> items = new ArrayDeque<>();

        String item = bufferedReader.readLine();

        while (!item.equals("End")) {
            items.addLast(item);
            item = bufferedReader.readLine();
        }

        return items;
    }


    private static Long createTime(String input) {
        Integer[] timeInput = Arrays.stream(input.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        Long totalTime = 0L;
        totalTime += timeInput[0] * 3600;
        totalTime += timeInput[1] * 60;
        totalTime += timeInput[2];

        return totalTime;
    }

    private static int getStarTime(String line) throws IOException {
        String[] tokens = line.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);
        seconds += (minutes * 60);
        seconds += (hours * 3600);
        return seconds;
    }


    private static Robot[] createRobots(String input) {
        String[] robotsInfo = input.split(";");
        Robot[] robots = new Robot[robotsInfo.length];
        for (int i = 0; i < robotsInfo.length; i++) {
            String[] currentRobotInfo = robotsInfo[i].split("-");
            String robotName = currentRobotInfo[0];
            Long robotProcessingTime = Long.parseLong(currentRobotInfo[1]);
            robots[i] = new Robot(robotName, robotProcessingTime);
        }
        return robots;
    }

    private static class Robot {
        private String name;
        private Long processingTime;
        private Long currentProcessingTime;
        private boolean isWorking;

        public Robot(String name, Long processingTime) {
            this.name = name;
            this.processingTime = processingTime;
            this.currentProcessingTime = 0L;
            this.isWorking = false;
        }

        public void work() {
            if (isWorking) {
                this.currentProcessingTime++;
                if (currentProcessingTime >= this.processingTime) {
                    this.isWorking = false;
                    this.currentProcessingTime = 0L;
                }
            }
        }
    }
    private static String calculateTime(int time) {
        int hours = (time / 3600) % 24;
        int timeLeft = time % 3600;
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}