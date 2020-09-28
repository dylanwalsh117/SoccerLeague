// Name:Dylan Walsh ID: R00167406
// Class: SD2-A 
// Lecturer: Dennis Long Labs: Paul Davern

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Part3 {
    private static League readFromFile()
    {
        League league = new League();
        try{
            Scanner reader = new Scanner(new File("test.txt"));
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();

                if(!line.isEmpty())
                {
                    String tokens[] = line.split("\\{");
                    String teamTokens[] = tokens[0].split("\\|");

                    Team team = new Team(teamTokens[0]);
                    Manager manager = new Manager(new Name(teamTokens[1], teamTokens[2], teamTokens[3]), teamTokens[4],
                            teamTokens[5], teamTokens[6], Integer.parseInt(teamTokens[7]));
                    team.setManager(manager);

                    String tokens1[] = tokens[1].replaceAll("}", "").split(",");

                    for(int i=0;i<tokens1.length;i++) {
                        String playerTokens[] = tokens1[i].split("\\|");
                        Player player = new Player(new Name(playerTokens[0], playerTokens[1], playerTokens[2]),
                                playerTokens[3], playerTokens[4], Integer.parseInt(playerTokens[5]), Boolean.parseBoolean(playerTokens[6]));
                        team.addPlayer(player);
                    }

                    league.addTeam(team);
                }
            }
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return league;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();

        League league = new League();

        int choice = 0;
        while(choice != 8)
        {
            System.out.println("1.	Create a new Team, Player or Manager and add Player/Manager to a Team.");
            System.out.println("2.	Remove a Player.");
            System.out.println("3.	Search for a Player by supplying the Player name. Display goals and Manager details.");
            System.out.println("4.  Display all players in a particular Team.");
            System.out.println("5.  Display all Teams in the League.");
            System.out.println("6.  Save all information to a text file.");
            System.out.println("7.  Load information from a text file.");
            System.out.println("8.  Quit");
            System.out.print("Your Choice > ");
            choice = scan.nextInt();
            scan.nextLine();

            if(choice == 1)
            {
                System.out.println("\t1.  Creat Team.");
                System.out.println("\t2.  Creat Player.");
                System.out.println("\t3.  Creat Manager.");
                System.out.println("\t4.  Add Player to Team.");
                System.out.println("\t5.  Add Manager to Team.");
                System.out.println("\tYour Choice: ");
                int choice1 = scan.nextInt();
                scan.nextLine();

                if(choice1 == 1)
                {
                    System.out.print("Enter Jersey Color: ");
                    String color = scan.nextLine();
                    // add to teams
                    teams.add(new Team(color));
                    System.out.print("Team Created!");
                }
                else if(choice1 == 2)
                {
                    System.out.print("Enter First Name: ");
                    String fn = scan.nextLine();
                    System.out.print("Enter Middle Name: ");
                    String mn = scan.nextLine();
                    System.out.print("Enter Last Name: ");
                    String ln = scan.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scan.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scan.nextLine();
                    System.out.print("Enter Number of Goals: ");
                    int goals = scan.nextInt();scan.nextLine();

                    // create player
                    Player player = new Player(new Name(fn, mn, ln), phone, email, goals, true);
                    players.add(player);
                    System.out.print("Player Created!");
                }
                else if(choice1 == 3)
                {
                    System.out.print("Enter First Name: ");
                    String fn = scan.nextLine();
                    System.out.print("Enter Middle Name: ");
                    String mn = scan.nextLine();
                    System.out.print("Enter Last Name: ");
                    String ln = scan.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scan.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scan.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scan.nextLine();
                    System.out.println("Enter Rating: ");
                    int rating = scan.nextInt();scan.nextLine();

                    // create manager
                    Manager manager = new Manager(new Name(fn, mn, ln), phone, email, dob, rating);
                    managers.add(manager);
                    System.out.print("Manager Created!");
                }
                else if(choice1 == 4)
                {
                    System.out.print("Enter Player's First Name: ");
                    String fn = scan.nextLine();

                    Player player = null;
                    for(int i=0;i<players.size();i++)
                    {
                        if(players.get(i).getName().getFirstName().equals(fn))
                        {
                            player = players.get(i);
                        }
                    }

                    if(player == null)
                    {
                        System.out.println("No Player Found");
                    }
                    else {
                        // get team
                        System.out.print("Enter Jersey Color of Team: ");
                        String color = scan.nextLine();

                        // find team
                        int index = -1;
                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getJerseyColor().equals(color)) {
                                index = i;
                            }
                        }

                        if(index == -1)
                        {
                            System.out.println("No Team Found!");
                        }
                        else
                        {
                            teams.get(index).addPlayer(player);
                            System.out.println("Player Added to Team!");
                        }
                    }
                }
                else if(choice1 == 5)
                {
                    System.out.print("Enter Manager's First Name: ");
                    String fn = scan.nextLine();

                    Manager manager = null;
                    for(int i=0;i<managers.size();i++)
                    {
                        if(managers.get(i).getName().getFirstName().equals(fn))
                        {
                            manager = managers.get(i);
                        }
                    }

                    if(manager == null)
                    {
                        System.out.println("No Manager Found");
                    }
                    else {
                        // get team
                        System.out.print("Enter Jersey Color of Team: ");
                        String color = scan.nextLine();

                        // find team
                        int index = -1;
                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getJerseyColor().equals(color)) {
                                index = i;
                            }
                        }

                        if(index == -1)
                        {
                            System.out.println("No Team Found!");
                        }
                        else
                        {
                            teams.get(index).setManager(manager);
                            System.out.println("Manager Added to Team!");
                        }
                    }
                }
            }
            else if(choice == 2)
            {
                System.out.print("Enter Player's First Name: ");
                String fn = scan.nextLine();

                boolean removed = false;
                for(int i=0;i<players.size();i++)
                {
                    if(players.get(i).getName().getFirstName().equals(fn))
                    {
                        players.remove(i);
                        removed = true;
                        break;
                    }
                }

                if(!removed)
                {
                    System.out.println("No Player Found!");
                }
                else
                {
                    System.out.println("Player removed!");
                }
            }
            else if(choice == 3)
            {
                System.out.println("\t1. Player Info.");
                System.out.println("\t2. Manger Info.");
                System.out.print("Choice: ");
                int ch = scan.nextInt();
                scan.nextLine();

                if(ch == 1)
                {
                    System.out.print("Enter Player's First Name: ");
                    String fn = scan.nextLine();

                    for(int i=0;i<players.size();i++)
                    {
                        if(players.get(i).getName().getFirstName().equals(fn))
                        {
                            System.out.println(players.get(i).toString());
                        }
                    }
                }
                else if(ch == 2)
                {
                    System.out.print("Enter Manager's First Name: ");
                    String fn = scan.nextLine();

                    for(int i=0;i<managers.size();i++)
                    {
                        if(managers.get(i).getName().getFirstName().equals(fn))
                        {
                            System.out.println(managers.get(i).toString());
                        }
                    }
                }
            }
            else if(choice == 4)
            {
                System.out.print("Enter Jersey Color: ");
                String color = scan.nextLine();
                for(int i=0;i<teams.size();i++)
                {
                    if (teams.get(i).getJerseyColor().equals(color))
                    {
                        for(int j=0;j<teams.get(i).getPlayers().size();j++)
                        {
                            System.out.println(teams.get(i).getPlayers().get(j).toString());
                        }
                    }
                }
            }
            else if(choice == 5)
            {
                System.out.println(league.toString());
            }
            else if(choice == 6)
            {
                try{
                    PrintWriter writer = new PrintWriter(new File("teams.txt"));
                    league.writeToFile(writer);
                    writer.close();
                }catch (IOException ex)
                {
                    ex.printStackTrace();
                }

                System.out.println("Data written to file 'teams.txt'");
            }
            else if(choice == 7)
            {
                league = readFromFile();
                System.out.println("Data read from file 'teams.txt'");
            }
            else if(choice == 8)
            {
                System.out.println("Bye!!");
                break;
            }
            else
            {
                System.out.println("Invalid Choice");
            }

            System.out.println();
        }
    }
}
