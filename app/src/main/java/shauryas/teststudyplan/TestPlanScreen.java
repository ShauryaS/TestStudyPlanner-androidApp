package shauryas.teststudyplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TestPlanScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_plan_screen);
        populateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_plan_screen, menu);
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

    public void makeTestPlan(View view){
        startActivity(new Intent(this.getApplicationContext(), MakeTestPlan.class));
    }

    public void accessSettings(View view){
        startActivity(new Intent(this.getApplicationContext(), Settings.class));
    }

    public void populateList(){
        ArrayList<String> names = new ArrayList<>();
        for(int i=0; i<Params.testinfos.size(); i++){
            names.add(Params.testinfos.get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_buttons, names);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

}
