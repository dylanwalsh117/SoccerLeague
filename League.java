// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class League {
    private ArrayList<Team> teams;

    public League()
    {
        teams = new ArrayList<>();
    }

    public void addTeam(Team team)
    {
        teams.add(team);
    }

    public boolean removeTeam(String jerseyColor)
    {
        for(int i=0;i<teams.size();i++)
        {
            if(teams.get(i).getJerseyColor().equals(jerseyColor))
            {
                teams.remove(i);
                return true;
            }
        }

        return false;
    }

    public void writeToFile(PrintWriter writer)
    {
        for(int i=0;i<teams.size();i++)
        {
            writer.print(teams.get(i).getJerseyColor()+"|");
            Manager manager = teams.get(i).getManager();
            writer.print(manager.getName().getFirstName()+"|");
            writer.print(manager.getName().getMiddleName()+"|");
            writer.print(manager.getName().getLastName()+"|");
            writer.print(manager.getPhone()+"|");
            writer.print(manager.getEmail()+"|");
            writer.print(manager.getDateOfBirth()+"|");
            writer.print(manager.getRating()+"|");
            writer.print("{");
            for(int j=0;j<teams.get(i).getPlayers().size();j++)
            {
                Player player = teams.get(i).getPlayers().get(j);
                writer.print(player.getName().getFirstName()+"|");
                writer.print(player.getName().getMiddleName()+"|");
                writer.print(player.getName().getLastName()+"|");
                writer.print(player.getPhone()+"|");
                writer.print(player.getEmail()+"|");
                writer.print(player.getGoals()+"|");
                if(j == teams.get(i).getPlayers().size()-1)
                {
                    writer.print(player.getGoali());
                }
                else
                {
                    writer.print(player.getGoali()+",");
                }
            }
            writer.println("}");
        }
        writer.flush();
    }

    public String toString()
    {
        String str = "League:\n";
        for(int i=0;i<teams.size();i++)
        {
            str += "Team "+(i+1)+":\n";
            str += teams.get(i).toString()+"\n";
        }

        return str;
    }
}
