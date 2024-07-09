import java.util.ArrayList;
public class Startup {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }
    public void setName(String startupName) {
        name = startupName;
    }

    public String checkYourSelf(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Kill";
                System.out.println("Ouch! You sunk " + name + ": ( ");
            } else {
                result = "Hit";
            }
        }
        return result;
    }
}
