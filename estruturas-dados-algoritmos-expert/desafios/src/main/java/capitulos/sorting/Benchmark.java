package capitulos.sorting;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Benchmark {

    public static Long getTimeQuickSort(String[] words) {
        long time = System.currentTimeMillis();
        String[] sortedWords = getSortedByQuickSort(words);
        return System.currentTimeMillis() - time;
    }

    public static Long getTimeBubbleSort(String[] words) {
        String[] wordsBackup = words.clone();
        long time = System.currentTimeMillis();
        String[] sortedWords = getSortedByBubbleSort(wordsBackup);
        return System.currentTimeMillis() - time;
    }

    public static Long getTimeInsertionSort(String[] words) {
        String[] wordsBackup = words.clone();
        long time = System.currentTimeMillis();
        sortInsertioning(wordsBackup);
        return System.currentTimeMillis() - time;
    }

    private static void sortInsertioning(String [] words) {
        int t = words.length;
        for (int k = 1; k < t; k++) {
            String word = words[k];
            int p = k - 1;
            while (p >= 0 && words[p].compareToIgnoreCase(word) > 0) {
                words[p + 1] = words[p];
                p--;
            }
            words[p + 1] = word;
        }
    }

    private static String[] getSortedByBubbleSort(String[] words) {
        int t = words.length;
        for (int i = 0; i < t - 1; i++) {
            for (int j = i+1; j < t; j++) {
                if (words[i].compareToIgnoreCase(words[j]) > 0) {
                    swapBothIn(words, i, j);
                }
            }
        }
        return words;
    }

    private static void swapBothIn(String[] words, int i, int j) {
        if (words != null && words.length >= 2) {
            String aux = words[i];
            words[i] = words[j];
            words[j] = aux;
        }
    }

    private static String[] getSortedByQuickSort(String[] words) {
        if (words.length < 2) {
            return words;
        }
        else if (words.length == 2) {
            if (words[0].compareToIgnoreCase(words[1]) > 0) {
                swapBothIn(words, 0, 1);
                return words;
            }
            return words;
        }

        int indexPivot = words.length / 2;

        String pivot = words[indexPivot];

        List<String> leftArrayList = new ArrayList<>();
        List<String> rightArrayList = new ArrayList<>();

        for (String word : words) {
            if (word.compareToIgnoreCase(pivot) < 0) leftArrayList.add(word);
            else if (word.compareToIgnoreCase(pivot) > 0) rightArrayList.add(word);
        }

        String[] leftArray = leftArrayList.toArray(new String[0]);
        String[] rightArray = rightArrayList.toArray(new String[0]);

        List<String> newArrayList = new ArrayList<>(Arrays.asList(getSortedByQuickSort(leftArray)));
        newArrayList.add(pivot);
        newArrayList.addAll(Arrays.asList(getSortedByQuickSort(rightArray)));
        return newArrayList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String filePath = getFilePath("input.json");
        String[] words = null;

        try {
            String content = getContent(filePath);
            words = content.split(",");

        } catch (Exception e) {
            System.err.println("Erro ao tentar ler o arquivo JSON: " + e.getMessage());
        }

        if (words != null) {
            System.out.println("Insert sort: " + getTimeInsertionSort(words) + "ms");
            System.out.println("Bubble sort: " + getTimeBubbleSort(words) + "ms");
            System.out.println("Quick sort: " + getTimeQuickSort(words) + "ms");
        }
    }

    private static String getFilePath(String fileName) {
        String javaSourceDirectory =  "/src/main/java/";
        String packagePath = Benchmark.class.getPackageName().replace(".", "/");
        String projectDirectory = System.getProperty("user.dir");
        String packageDirectory = javaSourceDirectory + packagePath;
        return projectDirectory + packageDirectory + "/" + fileName;
    }

    private static String getContent(String filePath) throws IOException {

        File sourceFile = getSourceFile(filePath);

        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line.trim());
            }
        }

        return jsonContent.toString().replace("[", "").replace("]", "").replace("\"", "");
    }

    private static File getSourceFile(String filePath) throws FileNotFoundException {
        String newFilePath = filePath.replace("/src/main/java/", "/");
        File sourceFile = new File(filePath);
        if (sourceFile.exists()) return sourceFile;
        sourceFile = new File(newFilePath);
        if (sourceFile.exists()) return sourceFile;
        throw new FileNotFoundException("O arquivo não foi encontrado");
    }

}
