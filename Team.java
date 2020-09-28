// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern


import java.util.ArrayList;

public class Team {
    private Manager manager;
    private String jerseyColor;
    private ArrayList<Player> players;

    public Team(String jerseyColor)
    {
        this.jerseyColor = jerseyColor;
        manager = null;
        players = new ArrayList<>();
    }

    public Team(Manager manager, String jerseyColor)
    {
        this.manager = manager;
        this.jerseyColor = jerseyColor;
        players = new ArrayList<>();
    }

    public Manager getManager()
    {
        return manager;
    }

    public void setManager(Manager manager)
    {
        this.manager = manager;
    }

    public String getJerseyColor()
    {
        return jerseyColor;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public boolean removePlayer(Player player)
    {
        if(players.contains(player))
        {
            players.remove(player);
            return true;
        }

        return false;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public String toString()
    {
        String str = "Jersey Color: "+getJerseyColor()+"\n";
        str += "**Manager**\n" + manager.toString();
        str += "**Players**\n";
        for(int i=0;i<players.size();i++)
        {
            str += players.get(i).toString()+"\n";
        }

        return str;
    }
}
