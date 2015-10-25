package shauryas.teststudyplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MakeTestPlan extends AppCompatActivity {

    private EditText getName;
    private EditText getProblemsWrongPerHW;
    private EditText getDaysTillTest;
    private EditText getHoursDedicatedPerDay;

    private String name;
    private String problemsWrong;
    private String daysTillTest;
    private String hrsPerDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_test_plan);
        getName = (EditText) findViewById(R.id.editText);
        getProblemsWrongPerHW = (EditText) findViewById(R.id.editText2);
        getDaysTillTest = (EditText) findViewById(R.id.editText3);
        getHoursDedicatedPerDay = (EditText) findViewById(R.id.editText4);
        getInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_make_test_plan, menu);
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

    public void getInfo(){
        name = getName.getText().toString();
        problemsWrong = getProblemsWrongPerHW.getText().toString();
        daysTillTest = getDaysTillTest.getText().toString();
        hrsPerDay = getHoursDedicatedPerDay.getText().toString();
    }

    public void makeTestInfo(View view){
        getInfo();
        Params.testinfos.add(new TestInfo(name, problemsWrong, daysTillTest, hrsPerDay));
        startActivity(new Intent(this, DisplayTestPlan.class));
    }

}
