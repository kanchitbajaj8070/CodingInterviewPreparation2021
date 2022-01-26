package VaccumLabsTest;

import java.io.*;
import java.util.*;

public class CheckSynonyms {
    public static void main(String[] args) {
        Scanner scanner = parseInputFileToAScannerStream();
        int noOfTestCases = scanner.nextInt();
        scanner.nextLine();
        List<String> results = new ArrayList<>();
        while (noOfTestCases > 0) {
            Map<String, HashSet<String>> synonymsDictionary = createSynonymsGraph(scanner);
            int noOfQueries = scanner.nextInt();
            scanner.nextLine();
            for (int q = 1; q <= noOfQueries; q++) {
                String[] pairOfQueries = scanner.nextLine().split("\\s+");
                boolean areSynonyms = areTwoWordsSynonyms(synonymsDictionary, pairOfQueries[0].toLowerCase(), pairOfQueries[1].toLowerCase());
                if (areSynonyms)
                    results.add("synonyms");
                else
                    results.add("different");
            }
            noOfTestCases--;
        }
        createOutputFile(results);
        System.out.println(results);
    }

    private static boolean areTwoWordsSynonyms(Map<String, HashSet<String>> synonymsDictionary, String firstWord, String secondWord) {
        if (!synonymsDictionary.containsKey(firstWord) && !synonymsDictionary.containsKey(secondWord)) {
            return firstWord.equals(secondWord);

        } else if (synonymsDictionary.containsKey(firstWord) && synonymsDictionary.containsKey(secondWord)) {
            if (firstWord.equals(secondWord)) {
                return true;
            } else {
                return searchInSynonymsGraph(synonymsDictionary, secondWord, firstWord, new HashSet<>());
            }
        } else {
            return false;
        }
    }

    private static Scanner parseInputFileToAScannerStream() {
        Scanner scanner = null;
        try {
            File inputFile = new File("src\\VaccumLabsTest\\example.in");
            scanner = new Scanner(new FileReader(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scanner;
    }

    private static Map<String, HashSet<String>> createSynonymsGraph(Scanner scanner) {
        Map<String, HashSet<String>> synonymsDictionary = new HashMap<>();
        int noOfSynonyms = scanner.nextInt();
        scanner.nextLine();
        for (int s = 1; s <= noOfSynonyms; s++) {
            String[] pairOfSynonyms = scanner.nextLine().split("\\s+");
            String firstWord = pairOfSynonyms[0].toLowerCase();
            String secondWord = pairOfSynonyms[1].toLowerCase();
            if (!synonymsDictionary.containsKey(firstWord)) {
                synonymsDictionary.put(firstWord.toLowerCase(), new HashSet<>());
            }
            if (!synonymsDictionary.containsKey(secondWord)) {
                synonymsDictionary.put(secondWord.toLowerCase(), new HashSet<>());
            }
            synonymsDictionary.get(firstWord).add(secondWord);
            synonymsDictionary.get(secondWord).add(firstWord);
        }
        return synonymsDictionary;
    }

    private static boolean searchInSynonymsGraph(Map<String, HashSet<String>> graph, String key, String start, HashSet<String> visited) {
        if (start.equalsIgnoreCase(key))
            return true;
        if (!graph.containsKey(start))
            return false;
        visited.add(start);
        boolean ans = false;
        for (String nbr : graph.get(start)) {
            if (!visited.contains(nbr)) {
                ans = ans || searchInSynonymsGraph(graph, key, nbr, visited);
            }
        }
        return ans;
    }

    private static void createOutputFile(List<String> content) {
        File file = new File("src\\VaccumLabsTest\\example.out");
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter("src\\VaccumLabsTest\\example.out");
            for (String line : content)
                fileWriter.write(line + "\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

