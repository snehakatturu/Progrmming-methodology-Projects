
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryMap {
    //creating hashmap object
    HashMap<String, ArrayList<Record>> dict = new HashMap<>();

    // Method to load Dictionary of words.
    public void loadDictionary()
    {
        System.out.println("! Loading data...");

        // iterating through each record and adding the info to hashmap
        for (Record word : Record.values())
        {
            if (dict.containsKey(word.getKeyword())) {
                dict.get(word.getKeyword()).add(word);
            }
            else
            {
                dict.put(word.getKeyword(), new ArrayList<Record>());
                dict.get(word.getKeyword()).add(word);
            }
        }
        System.out.println("! Loading completed...\n");
        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + getKeywordCount());
        System.out.println("----- Definitions: " + getDefinitionCount() + "\n");
    }
    //Method to search input based on keyword, parts of speech, distinct, reverse
    public List<Record> search(String keyword, String partOfSpeech, boolean distinct, boolean reverse) {

        List<Record> results = new ArrayList<Record>();

        // Iterating through each record and finding the records with keywords that match the user input keyword.
        for(ArrayList<Record> recordList : dict.values())
        {
            for (Record word : recordList)
            {
                if (word.getKeyword().equalsIgnoreCase(keyword.toLowerCase()))
                {
                    results.add(word);
                }
            }
        }

        // If user input contains a parts of speech, then Iterate through each record from above results
        // and find the records that has matching parts of speech.
        if (partOfSpeech != null) {
            List<Record> resultsFiltered = new ArrayList<Record>();
            for (Record result : results) {
                if (result.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                    resultsFiltered.add(result);
                }
            }
            results = resultsFiltered;
        }

        // If user input contains distinct word, then iterate through records to filter out distinct records.
        if (distinct) {
            HashMap<String, Record> tmp = new HashMap<>();
            List<Record> resultsFiltered = new ArrayList<Record>();
            for (Record result: results) {
                String str = result.getKeyword() + result.getPartOfSpeech() + result.getDefinition();
                Record value = tmp.get(str);
                if (value == null) {
                    tmp.put(result.getKeyword() + result.getPartOfSpeech() + result.getDefinition(), result);
                    resultsFiltered.add(result);
                }
            }
            results = resultsFiltered;
        }

        // If user input has reverse then reverse the results.
        if (reverse) {
            Collections.reverse(results);
        }

        return results;
    }

    // Helper method to get keyword count
    public int getKeywordCount() {
        return dict.keySet().size();
    }

    // Helper method to get definition count
    public int getDefinitionCount() {
        return dict.values().stream().mapToInt(List::size).sum();
    }
}