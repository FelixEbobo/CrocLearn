package lesson3;

import java.io.*;
import java.nio.file.Path;

public class Main {

    /**
     * Insert a first argument a true/false statement
     * If true, filePath will be relative(inside a project folder), otherwise absolute
     * A second argument is filePath/fileName
     * @param args
     */
    public static void main(String[] args) {
        boolean relativeOrNot = false;
        String filePath;
        // Parsing first argument: is path relative?

        try {
            filePath = args[1];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Не задан путь к файлу!");
        }

        try {
            if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                relativeOrNot = Boolean.parseBoolean(args[0]);
            } else {
                throw new IllegalArgumentException("First argument must be true or false!");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }

        var relativePath = new File("").getAbsolutePath() + "/CrocLearn/";

        if (relativeOrNot) {
            filePath = relativePath + args[1];
        }

        try {
            fileLoading(filePath);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private static int countWords(String text) {
        int count = 0;
        text = text.replaceAll("\\s+", " ");
        // Delete all unnecessary symbols
        text = text.replaceAll("[\\,\\.\\!\\?\\:\\;\\-]", "");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        count++;
//        System.out.println(text);
        return count;
    }

    private static void fileLoading(String filePath) {
        try (var file = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File successfully opened!");
            int i = file.read();
            if (i == -1) {
                throw new NullPointerException("File is empty. And what should I count, nulls?");
            }
            String inputText = "";
            while (i != -1) {
                inputText += (char) i;
//                System.out.print((char) i);
                i = file.read();
            }
//            System.out.println();
            System.out.println(countWords(inputText));

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("File does not exists!");
        }
    }
}
