// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern


public class Player extends Person {
    private int goals;
    private boolean goalie;

    public Player(Name name, String phone, String email, int goals, boolean goalie)
    {
        super(name, phone, email);
        this.goals = goals;
        this.goalie = goalie;
    }

    public void setGoals(int goals)
    {
        this.goals = goals;
    }

    public int getGoals()
    {
        return goals;
    }

    public void setGoalie(boolean goalie)
    {
        this.goalie = goalie;
    }

    public boolean getGoali()
    {
        return goalie;
    }

    public String toString()
    {
        return super.toString()+"" +
                "Goals: " + getGoals()+"\n";
    }
}
