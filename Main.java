
import java.util.*;
import java.util.stream.Collectors;
//Main method
public class Main {
    private static final DictionaryMap dictionaryMap = new DictionaryMap(); //Creating DictionaryMap object

    public static void main(String[] args) { // Main method
        dictionaryMap.loadDictionary();// load dictionary data
        Scanner scanner = new Scanner(System.in);
        int count = 1; // counter to keep track of user search inputsface
        App app = new App();
        while (true)  // when i/p is empty or input keyword is help
        {
            System.out.print("Search [" + count + "]: ");
            String input = scanner.nextLine();
            app.handleSearch(input, dictionaryMap);
            System.out.println("|");
            count = count + 1;
        }
    }
}