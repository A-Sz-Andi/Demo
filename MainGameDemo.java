import java.util.Arrays;
import java.util.Scanner;

public class MainGameDemo {
    static int height = 3;
    static int width = 3;
    static Scanner scanner = new Scanner(System.in);
    static String[][] level = new String[height][width];

    public static void main(String[] args) {


        Arrays.stream(level).forEach(it -> Arrays.fill(it, " "));
        boolean running = true;

        while (running) {
            render(level);
            readInput();
            running = shouldContinueTheGame();
        }

        System.out.println("MMMMMMMMMMMMMMMMMM");
    }

    private static boolean shouldContinueTheGame() {
        //TODO check is anybody win
        return false;
    }

    private static void readInput() {
        boolean shouldReadInput = true;
        String input;
        while (shouldReadInput) {
            input = scanner.nextLine();
            //TODO check input is valid
            shouldReadInput = false;
        }
        //TODO write input to level
        level[0][0] = "X";
    }

    private static void render(String[][] level) {
        for (int rowIndex = 0; rowIndex < level.length; rowIndex++) {
            String[] row = level[rowIndex];
            writeHeaderAndSeparator(row);
            writeBody(row);
            writeFooter(level, rowIndex);
        }
    }

    private static void writeFooter(String[][] level, int rowIndex) {
        if (isLastRow(level, rowIndex)) {
            for (int columnIndex = 0; columnIndex < level.length; columnIndex++) {
                System.out.print("--");
            }
            System.out.println("-");
        }
    }

    private static boolean isLastRow(String[][] level, int rowIndex) {
        return rowIndex + 1 == level.length;
    }

    private static void writeBody(String[] row) {
        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
            System.out.print("|");
            System.out.print(row[columnIndex]);
        }
        System.out.print("|");
        System.out.println();
    }

    private static void writeHeaderAndSeparator(String[] row) {
        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
            System.out.print("--");
        }
        System.out.println("-");
    }

}
