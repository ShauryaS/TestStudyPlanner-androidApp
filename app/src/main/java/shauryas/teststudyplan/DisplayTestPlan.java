package shauryas.teststudyplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayTestPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_test_plan);
        calculate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_test_plan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate(){
        double totalHours = Integer.parseInt(Params.testinfos.get(Params.testinfos.size()-1).getDaysTillTest())*Integer.parseInt(Params.testinfos.get(Params.testinfos.size() - 1).getHrsPerDay());
        ArrayList<String> numOfWrongProbs = new ArrayList<>();
        int startOfSubstring = 0;
        for(int i=0; i<Params.testinfos.get(Params.testinfos.size()-1).getProblemsWrong().length(); i++){
            if(Params.testinfos.get(Params.testinfos.size()-1).getProblemsWrong().charAt(i)==' '){
                numOfWrongProbs.add(Params.testinfos.get(Params.testinfos.size()-1).getProblemsWrong().substring(startOfSubstring, i));
                startOfSubstring = i+1;
            }
        }
        int sumOfWrongProblems = 0;
        for(int i = 0; i<numOfWrongProbs.size(); i++){
            sumOfWrongProblems += Integer.parseInt(numOfWrongProbs.get(i));
        }
        double propScale = totalHours/sumOfWrongProblems;
        ArrayList<String> timePerSection = new ArrayList<>();
        for(int i=0; i<numOfWrongProbs.size(); i++){
            timePerSection.add("Study section " + (i+1) + " in " + (int)((Integer.parseInt(numOfWrongProbs.get(i))*propScale)*60) + " minutes.");
        }
        populateList(timePerSection);
    }

    public void populateList(ArrayList<String> timePerSection){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_info, timePerSection);
        ListView list = (ListView) findViewById(R.id.listView2);
        list.setAdapter(adapter);
    }

}
