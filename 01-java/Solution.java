import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Solution {
    static List<Integer> mesures = new ArrayList<Integer>();
    static List<Integer> mesuresWindow = new ArrayList<Integer>();
    static int increasedNumber = 0;

    private static void readFile(String file) {
        try {
            File fileInput = new File(file);
            Scanner fileReader = new Scanner(fileInput);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                mesures.add(Integer.parseInt(data));
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("An error occured.");
            e.printStackTrace();
        }
    }

    private static void checkIncreased(List<Integer> arrList) {
        for (int i = 1; i < arrList.size(); i++) {
            int current = arrList.get(i);
            if (arrList.get(i - 1) < current) {
                increasedNumber += 1;
            }
        }
    }

    private static void runPart1(String input) {
        readFile(input);
        int result = 0;

        checkIncreased(mesures);
        System.out.println(result);
    }

    private static void run(String input) {
        readFile(input);

        for (int i = 2; i < mesures.size(); i++) {
            int current = mesures.get(i);
            int currentPlus = current + mesures.get(i - 1);
            int mesureWindowSum = currentPlus + mesures.get(i - 2);
            mesuresWindow.add(mesureWindowSum);
        }

        checkIncreased(mesuresWindow);
        System.out.println(increasedNumber);
    }

    public static void main(String[] args) {
        run(args[0]);
    }
}
