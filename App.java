
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static String input;

    public void App() {
    }
    // Help guidelines
    public void printHelp()
    {
        System.out.println("|");
        System.out.println("PARAMETER HOW-TO, please enter:");
        System.out.println("1. A search key -then 2. An optional part of speech -then");
        System.out.println("3. An optional 'distinct' -then 4. An optional 'reverse'");
    }
      // Method to handle user search
    public void handleSearch(String input, DictionaryMap dictionaryMap)
    {
        String[] parts = input.split("\\s+");
        //Switch statement to handle different inputs
        switch (input.toLowerCase()) {
            case "!help":
                printHelp();
                return;
            case "!q":
                System.out.println("\n-----THANK YOU-----");
                return;
            case "":
                printHelp();
                return;
            default:
                if (parts.length < 1)
                {
                    printHelp();
                    break;
                }

                String keyword = parts[0].toLowerCase();
                String partOfSpeech = null;
                boolean distinct = false;
                boolean reverse = false;
                boolean isPartsOfSpeech = false;
                boolean isDistinct = false;
                boolean isReverse = false;

                 //Iterate over individual search parameters
                for (int i = 1; i < parts.length; i++)
                {
                    String store = parts[i].toLowerCase();

                    if (parts.length > 4) {
                        printHelp();
                        return;
                    }

                    // Check if it's a valid part of speech
                    if (isValidParameter(store, "partOfSpeech", i))
                    {
                        isPartsOfSpeech = true;
                        if (partOfSpeech == null)
                        {
                            partOfSpeech = store;
                        }
                        else
                        {
                            System.out.println("<The entered 2nd parameter '" + store + "' is NOT a part of speech.>");
                        }
                    }
                    else if (isValidParameter(store, "distinct", i)) // Check if it's 'distinct'
                    {
                        isDistinct = true;
                        if (!distinct)
                        {
                            distinct = true;
                        }
                        else
                        {
                            System.out.println("<The entered 3rd parameter '" + store + "' is NOT 'distinct'.>");
                        }
                    }
                    else if (isValidParameter(store, "reverse", i)) // Check if it's 'reverse'
                    {
                        if (i+1 == 4)
                        {
                            isReverse = true;
                        }
                        if (!reverse)
                        {
                            reverse = true;
                        }
                        else
                        {
                            System.out.println("<The entered 4th parameter '" + store + "' is NOT 'reverse'.>");
                        }
                    }
                    else
                    {
                        String paraNum = getParamNum(i+1); // To get the parameter number
                        System.out.println("|");
                        if ( isPartsOfSpeech == false && i+1 <= 2) {
                            System.out.println("<The entered " + paraNum + " parameter '" + store + "' is NOT a part of speech.>");
                        }

                        if ( isDistinct == false && i+1 <= 3) {
                            System.out.println("<The entered " + paraNum + " parameter '" + store + "' is NOT 'distinct'.>");
                        }

                        if ( isReverse == false && i+1 <= 4) {
                            System.out.println("<The entered " + paraNum + " parameter '" + store + "' is NOT 'reverse'.>");
                        }

                        System.out.println("<The entered " + paraNum + " parameter '" + store + "' was disregarded.>");

                        if (i+1 == 2 && isPartsOfSpeech == false && isDistinct == false && isReverse == false) {
                            System.out.println("<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                            isPartsOfSpeech = true;
                        }

                        if (i+1 == 3 && isDistinct == false && isReverse == false) {
                            System.out.println("<The 3rd parameter should be 'distinct' or 'reverse'.>");
                            isDistinct = true;
                        }

                        if (i+1 == 4 && isReverse == false) {
                            System.out.println("<The 4th parameter should be 'reverse'.>");
                            isReverse = true;
                        }

                        System.out.println("|");
                        System.out.println("|");
                    }
                }
                List<Record> results = dictionaryMap.search(keyword, partOfSpeech, distinct, reverse);// Performs search dictionaryMap and prints the result
                if (results.isEmpty())
                {
                    System.out.println("|");
                    System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
                    System.out.println("|");
                    System.out.println("|");
                    printHelp();
                    System.out.println("|");
                }
                else
                {
                    printResults(results);
                }
        }
    }

    //Helper method to validate parameters.
    private static boolean isValidParameter(String param, String context, int i)
    {
        switch (context) {
            case "partOfSpeech":
                if (i == 1) {
                    return Arrays.asList("noun", "verb", "adjective", "interjection", "preposition", "pronoun", "conjunction", "adverb").contains(param.toLowerCase());
                }
                else {
                    return false;
                }
            case "distinct":
                if (i == 2 || i == 1) {
                    return param.equals(context);
                }
                else {
                    return false;
                }
            case "reverse":
                if (i == 3 || i == 2 || i == 1) {
                    return param.equals(context);
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }

    //helper method to print results
    private static void printResults(List<Record> definitions) {
        for (Record def : definitions) {
            System.out.println("|");
            System.out.println(def.getKeyword() + " [" + def.getPartOfSpeech() + "] : " + def.getDefinition());
        }
    }
// Method to get parameter number
    private String getParamNum(int i) {
        switch (i) {
            case 1:
                return "1st";
            case 2:
                return "2nd";
            case 3:
                return "3rd";
            default:
                return String.valueOf(i) + "th";
        }
    }
}