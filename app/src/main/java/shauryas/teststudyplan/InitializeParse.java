package shauryas.teststudyplan;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;

public class InitializeParse extends Application{

    public void onCreate(){
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "3gjmCqXvaM7OdP8v8HgKDxqEC9nCHuqi1PHVmIYP", "8UYowjDBQVzMfaa05iKO94XDNS2wdvcWE3b66Yfx");
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
    }

}
