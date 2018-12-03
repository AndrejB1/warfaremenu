import java.net.UnknownHostException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBHandler {
    private static DBHandler ourInstance = new DBHandler();

    public static DBHandler getInstance() {
        return ourInstance;
    }

    public MongoCollection<Document> collection;

    private DBHandler() {
    }

    public void connectToDatabase() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI("mongodb://AndrejB1:Jingophyung92@ds040837.mlab.com:40837/map_project"));
        MongoDatabase db = mongoClient.getDatabase("warfaremenu");
        collection = db.getCollection("warfaremenu");

    }
}
