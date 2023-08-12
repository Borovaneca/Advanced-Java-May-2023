import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DeliveryBoy {

    private static final char PIZZA_BOY = 'B';
    private static final char COLLECTED_PIZZA = 'R';
    private static final char ADDRESS_TO_ARRIVE = 'A';
    private static final char OBSTACLE = '*';
    private static final char PIZZA_RESTAURANT = 'P';
    private static final char ROAD = '-';
    private static final char PATH = '.';

    private static final String PIZZA_IS_COLLECTED = "Pizza is collected. 10 minutes for delivery.";
    private static final String ORDER_CANCELED = "The delivery is late. Order is canceled.";
    private static final String DELIVERED_ON_TIME = "Pizza is delivered on time! Next order...";


    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        char[][] neighborhood = new char[size[0]][];

        for (int row = 0; row < neighborhood.length; row++) {
            neighborhood[row] = reader.readLine().toCharArray();
        }

        int[] currentPosition = getCurrentPosition(neighborhood);

        boolean isDelivered = false;
        boolean isCollected = false;
        String command = reader.readLine();
        boolean isOutSide = isGoingOutsideNeighborhood(neighborhood, currentPosition, command);
        while (!isDelivered) {
            isOutSide = isGoingOutsideNeighborhood(neighborhood, currentPosition, command);
            if (isOutSide) {
                if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY &&
                        neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA) {
                    neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                }
                break;
            }
            switch (command) {
                case UP:
                    if (neighborhood[currentPosition[0] -1][currentPosition[1]] != OBSTACLE) {
                        if (neighborhood[currentPosition[0] - 1][currentPosition[1]] == ROAD) {
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[0] = currentPosition[0] - 1;
                        } else if (neighborhood[currentPosition[0] - 1][currentPosition[1]] == PIZZA_RESTAURANT ) {
                            isCollected = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[0] = currentPosition[0] - 1;
                            neighborhood[currentPosition[0]][currentPosition[1]] = COLLECTED_PIZZA;
                        } else if (neighborhood[currentPosition[0] - 1][currentPosition[1]] == ADDRESS_TO_ARRIVE) {
                            if (!isCollected) {
                                break;
                            }
                            isDelivered = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA &&
                            neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            neighborhood[currentPosition[0] - 1][currentPosition[1]] = PIZZA_RESTAURANT;
                        } else if (neighborhood[currentPosition[0] - 1][currentPosition[1]] == PATH ||
                                neighborhood[currentPosition[0] - 1][currentPosition[1]] == PIZZA_BOY) {
                            currentPosition[0] = currentPosition[0] - 1;
                        }
                    }
                    break;
                case DOWN:
                    if (neighborhood[currentPosition[0] + 1][currentPosition[1]] != OBSTACLE) {
                        if (neighborhood[currentPosition[0] + 1][currentPosition[1]] == ROAD) {
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[0] = currentPosition[0] + 1;
                        } else if (neighborhood[currentPosition[0] + 1][currentPosition[1]] == PIZZA_RESTAURANT) {
                            isCollected = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[0] = currentPosition[0] + 1;
                            neighborhood[currentPosition[0]][currentPosition[1]] = COLLECTED_PIZZA;
                        } else if (neighborhood[currentPosition[0] + 1][currentPosition[1]] == ADDRESS_TO_ARRIVE) {
                            if (!isCollected) {
                                break;
                            }
                            isDelivered = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            neighborhood[currentPosition[0] + 1][currentPosition[1]] = PIZZA_RESTAURANT;
                        } else if (neighborhood[currentPosition[0] + 1][currentPosition[1]] == PATH ||
                                neighborhood[currentPosition[0] + 1][currentPosition[1]] == PIZZA_BOY) {
                            currentPosition[0] = currentPosition[0] + 1;
                        }
                    }
                    break;
                case LEFT:
                    if (neighborhood[currentPosition[0]][currentPosition[1] - 1] != OBSTACLE) {
                        if (neighborhood[currentPosition[0]][currentPosition[1] - 1] == ROAD) {
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[1] = currentPosition[1] - 1;
                        } else if (neighborhood[currentPosition[0]][currentPosition[1] - 1] == PIZZA_RESTAURANT) {
                            isCollected = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[1] = currentPosition[1] - 1;
                            neighborhood[currentPosition[0]][currentPosition[1]] = COLLECTED_PIZZA;
                        } else if (neighborhood[currentPosition[0]][currentPosition[1] - 1] == ADDRESS_TO_ARRIVE) {
                            if (!isCollected) {
                                break;
                            }
                            isDelivered = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            neighborhood[currentPosition[0]][currentPosition[1] - 1] = PIZZA_RESTAURANT;
                        } else if (neighborhood[currentPosition[0]][currentPosition[1] - 1] == PATH ||
                                neighborhood[currentPosition[0]][currentPosition[1] - 1] == PIZZA_BOY) {
                            currentPosition[1] = currentPosition[1] - 1;
                        }
                    }
                    break;
                case RIGHT:
                    if (neighborhood[currentPosition[0]][currentPosition[1] + 1] != OBSTACLE) {
                        if (neighborhood[currentPosition[0]][currentPosition[1] + 1] == ROAD) {
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[1] = currentPosition[1] + 1;
                        } else if (neighborhood[currentPosition[0]][currentPosition[1] + 1] == PIZZA_RESTAURANT) {
                            isCollected = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            currentPosition[1] = currentPosition[1] + 1;
                            neighborhood[currentPosition[0]][currentPosition[1]] = COLLECTED_PIZZA;
                        } else if (neighborhood[currentPosition[0]][currentPosition[1] + 1] == ADDRESS_TO_ARRIVE) {
                            if (!isCollected) {
                                break;
                            }
                            isDelivered = true;
                            if (neighborhood[currentPosition[0]][currentPosition[1]] != COLLECTED_PIZZA &&
                                    neighborhood[currentPosition[0]][currentPosition[1]] != PIZZA_BOY) {
                                neighborhood[currentPosition[0]][currentPosition[1]] = PATH;
                            }
                            neighborhood[currentPosition[0]][currentPosition[1] + 1] = PIZZA_RESTAURANT;
                        }else if (neighborhood[currentPosition[0]][currentPosition[1] + 1] == PATH ||
                                neighborhood[currentPosition[0]][currentPosition[1] + 1] == PIZZA_BOY) {
                            currentPosition[1] = currentPosition[1] + 1;
                        }
                    }
                    break;
            }
            if (!isDelivered) {
                command = reader.readLine();
            }
        }

        if (isCollected) {
            System.out.println(PIZZA_IS_COLLECTED);
        }

        if (isDelivered) {
            System.out.println(DELIVERED_ON_TIME);
            printNeighborhood(neighborhood);
        } else {
            System.out.println(ORDER_CANCELED);
            printWithoutBoy(neighborhood);
        }

    }

    private static void printWithoutBoy(char[][] neighborhood) {
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col] == PIZZA_BOY) {
                    System.out.print(" ");
                } else {
                    System.out.print(neighborhood[row][col]);
                }
            }
            System.out.println();
        }
    }

    private static void printNeighborhood(char[][] neighborhood) {
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                System.out.print(neighborhood[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isGoingOutsideNeighborhood(char[][] neighborhood,int[] currentPosition, String command) {
        switch (command) {
            case UP:
                if (currentPosition[0] - 1 < 0) {
                    return true;
                }
                break;
            case DOWN:
                if (currentPosition[0] + 1 > neighborhood.length - 1){
                    return true;
                }
                break;
            case LEFT:
                if (currentPosition[1] - 1 < 0){
                    return true;
                }
                break;
            case RIGHT:
                if (currentPosition[1] + 1 > neighborhood[0].length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static int[] getCurrentPosition(char[][] neighborhood) {
        int[] currentPosition = new int[2];
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col] == PIZZA_BOY) {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                    return new int[] {row, col};
                }
            }

        }
        return currentPosition;
    }
}
