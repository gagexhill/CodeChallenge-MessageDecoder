import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PyramidMessageDecoder {
    public Map<Integer, String> readFile(String filename) throws FileNotFoundException {
        Map<Integer, String> numberWords = new HashMap<>();

        Scanner fileReader = new Scanner(new File(filename));
        while (fileReader.hasNextLine()) {
            String[] parts = fileReader.nextLine().split(" ");
            numberWords.put(Integer.parseInt(parts[0]), parts[1]);
        }
        fileReader.close();

        return numberWords;
    }

    public void buildPyramid(Map<Integer, String> numberWords) {
        int currentNumber = 1;
        int numbersInRow = 1;
        String message = "";
        String lastWord = "";

        for (int i = 1; i <= numberWords.size(); i++) {
            currentNumber++;
            numbersInRow--;

            if (numbersInRow == 0) {
                String word = numberWords.get(currentNumber - 1).toLowerCase().trim();
                message += word + " ";
                numbersInRow = i + 1;
            }

            lastWord = numberWords.get(currentNumber - 1).toLowerCase().trim();
        }

        System.out.println(message + lastWord);
    }

    public static void main(String[] args) throws FileNotFoundException {
        PyramidMessageDecoder decoder = new PyramidMessageDecoder();
        decoder.buildPyramid(decoder.readFile("coding_qual_input.txt"));
    }
}