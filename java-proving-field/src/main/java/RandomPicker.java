import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Randomly pick an activity
 *
 * jar cfe random-pick.jar RandomPicker Activities.class RandomPicker.class
 */
public class RandomPicker {
    private Activities activities = new Activities();
    private boolean includeLanguages = true;
    private boolean includeProgramming = true;
    private boolean includeMusic = true;

    public static void main(String[] clArgs) {
        final RandomPicker randomPicker = new RandomPicker();
        if (clArgs.length > 0) {
            randomPicker.includeLanguages = randomPicker.includeMusic
                    = randomPicker.includeProgramming = false;
            parseCommandLineArguments(clArgs, randomPicker);
        }

        final ArrayList<String> allActivities = randomPicker.getAllActivities(randomPicker);
        final String selectedActivity = randomPicker.pick(allActivities);
        System.out.println("Randomly picked activity is: " + selectedActivity);
    }

    private String pick(ArrayList<String> allActivities) {
        final int numberOfActivities = allActivities.size();
        final int index = new Random().nextInt(numberOfActivities);
        return allActivities.get(index);
    }

    private ArrayList<String> getAllActivities(RandomPicker randomPicker) {
        final ArrayList<String> allActivities = new ArrayList<>();
        final HashMap<String, List<String>> activities = randomPicker.activities.getActivities();

        if (randomPicker.includeProgramming) {
            allActivities.addAll(activities.get(Activities.PROGRAMMING));
        }

        if (randomPicker.includeMusic) {
            allActivities.addAll(activities.get(Activities.MUSIC));
        }

        if (randomPicker.includeLanguages) {
            allActivities.addAll(activities.get(Activities.LANGUAGES));
        }

        return allActivities;
    }

    private static void parseCommandLineArguments(String[] clArgs, RandomPicker randomPicker) {
        for (String arg : clArgs) {
            System.out.println(arg);
            switch (arg) {
                case "l":
                    randomPicker.includeLanguages = true;
                    break;
                case "m":
                    randomPicker.includeMusic = true;
                    break;
                case "p":
                    randomPicker.includeProgramming = true;
                    break;
                default:
                    System.out.println("Invalid arguments");
                    break;
            }
        }
    }
}

class Activities {
    static final String PROGRAMMING = "Programming";
    static final String MUSIC = "Music";
    static final String LANGUAGES = "Languages";

    private final HashMap<String, List<String>> activities = new HashMap<>();

    Activities() {
        final ArrayList<String> programmingActivities = getProgrammingActivities();
        final ArrayList<String> musicRelatedActivities = getMusicActivities();
        final ArrayList<String> languageRelatedActivities = getLanguageRelatedActivities();

        activities.put(PROGRAMMING, programmingActivities);
        activities.put(MUSIC, musicRelatedActivities);
        activities.put(LANGUAGES, languageRelatedActivities);
    }

    private ArrayList<String> getMusicActivities() {
        final ArrayList<String> musicRelatedActivities = new ArrayList<>();
        musicRelatedActivities.add("Violin");
        musicRelatedActivities.add("Music theory");
        return musicRelatedActivities;
    }

    private ArrayList<String> getLanguageRelatedActivities() {
        final ArrayList<String> languageRelatedActivities = new ArrayList<>();
        languageRelatedActivities.add("Bulgarian");
        languageRelatedActivities.add("Japanese");
        return languageRelatedActivities;
    }

    private ArrayList<String> getProgrammingActivities() {
        final ArrayList<String> programmingActivities = new ArrayList<>();
        programmingActivities.add("Haskell");
        programmingActivities.add("Java");
        programmingActivities.add("Design Patterns");
        programmingActivities.add("Hibernate");
        return programmingActivities;
    }

    HashMap<String, List<String>> getActivities() {
        return activities;
    }
}
