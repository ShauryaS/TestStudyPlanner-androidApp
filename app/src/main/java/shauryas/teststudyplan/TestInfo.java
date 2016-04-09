package shauryas.teststudyplan;

/**
 * Created by shaur_000 on 10/24/2015.
 */
public class TestInfo {

    private String name;
    private String problemsWrong;
    private String daysTillTest;
    private String hrsPerDay;

    public TestInfo(String _name, String _problemsWrong, String _daysTillTest, String _hrsPerDay){
        name = _name;
        problemsWrong = _problemsWrong;
        daysTillTest = _daysTillTest;
        hrsPerDay = _hrsPerDay;
    }

    public String getName(){
        return name;
    }

    public String getProblemsWrong(){
        return problemsWrong;
    }

    public String getDaysTillTest(){
        return daysTillTest;
    }

    public String getHrsPerDay(){
        return hrsPerDay;
    }

}
