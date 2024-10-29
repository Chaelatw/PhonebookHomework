package homework;
import java.util.*;

public class Phonebook {
    private final Map<String, List<String>> phonebook;

    public Phonebook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public Phonebook() {
        this(new HashMap<>());
    }

    public void add(String name, String phoneNumber) {
        List<String> nums = new ArrayList<>();
        nums.add(phoneNumber);
        phonebook.put(name, nums);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return phoneNumber;
    }

    public List<String> getAllContactNames() {
        for (List String : phonebook.values()) {
        }
        return getAllContactNames();
    }

    public Map<String, List<String>> getMap() {

        return null;
    }

    public Map<String, List<String>> getPhonebook() {
        return phonebook;
    }
}
