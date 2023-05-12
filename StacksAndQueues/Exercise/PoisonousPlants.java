package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plantsStack = getPlants(scanner.nextLine(), n);
        ArrayDeque<Integer> container = new ArrayDeque<>();

        int dayCounter = 0;
        while (true) {
            int sizeBeforeCalc = plantsStack.size();

            while (!plantsStack.isEmpty()) {
                int currentPlant = plantsStack.pop();
                if (plantsStack.size() >= 1) {
                    int plantOnLeft = plantsStack.peek();
                    if (!(currentPlant > plantOnLeft)) {
                        container.push(currentPlant);
                }

                } else {
                    container.push(currentPlant);
                }

            }

            moveBackRemainingPlants(plantsStack, container);
            int sizeAfterCalc = plantsStack.size();

            if (sizeBeforeCalc == sizeAfterCalc) {
                break;
            }
            dayCounter++;
        }

        System.out.println(dayCounter);

    }

    private static void moveBackRemainingPlants(ArrayDeque<Integer> plantsStack, ArrayDeque<Integer> container) {
        while (!container.isEmpty()) {
            plantsStack.push(container.pop());
        }
    }

    private static ArrayDeque<Integer> getPlants(String nextLine, int n) {
        ArrayDeque<Integer> temporary = new ArrayDeque<>();
        int[] pesticide = Arrays.stream(nextLine.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {
            temporary.push(pesticide[i - 1]);
        }
        return temporary;
    }
}
