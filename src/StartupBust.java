import java.util.ArrayList;

public class StartupBust {
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();

    private void setupGame() {
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");

        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            CheckUserGuess(userGuess);
        }
        finishGame();
    }

    private void CheckUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";

        for (Startup startupTotest : startups) {
            result = startupTotest.checkYourSelf(userGuess);
            if (result.equals("Hit")) {
                break;
            }
            if (result.equals("Kill")) {
                startups.remove(startupTotest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
        System.out.println("All startups sank");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("great work you still have a lot of stock");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Bad performance, you took too much time and stocks");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setupGame();
        game.startPlaying();
    }
}