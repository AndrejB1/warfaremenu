import javax.swing.*;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        DBHandler dbHandler = DBHandler.getInstance();
        // If database 'inventory.db' does not exist, create it, along with its tables.
        dbHandler.connectToDatabase();

        // Initialize the main window
        InputWindow window = new InputWindow(dbHandler);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(600, 710);
        window.setVisible(true);

    }
}
