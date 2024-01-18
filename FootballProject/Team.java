package football_project;

import java.util.ArrayList;
import java.util.List;


record Affiliation(String manager , String stadium, int year){
    @Override
    public String toString(){
        return "Manager : "+manager+"\nStadium: "+stadium+"\nYear: "+year;
    }
}
public class Team <T extends league, S>{
    private int total_points;
    private String league_name;
    private S  affiliation;
    public Team(){}
    public Team(String league_name){
        this.league_name = league_name;
    }
    public Team (String league_name, S affiliation){
        this.league_name = league_name;
        this.affiliation = affiliation;
    }
    private List <T> members = new ArrayList<>();
    public void serch_team(String element){
        boolean is_found = false;
        for (var n : members){
            if (n.toString().contains(element)){
                System.out.println(n.name());
                System.out.println(n.affiliation());
                is_found =true;
            }
        }
        if (!is_found){
            System.out.println( "\""+element +"\" team is not in EPL");
        }
    }
    public void add_team (T team){
        if (!members.contains(team)){
            members.add(team);
        }
        else {
            System.out.println("EXISTS!");
        }
    }
    public void remove_team (T name){

        if (members.contains(name)){
            members.remove(name);
            System.out.println(name.name() + " is removed from the list");
        }
    }
    public void list_teams(){
        for (var n : members){
            System.out.println(n.name());
        }
    }
    public int points(int first, int second) {
        if (first > second) {
            total_points = 3;
        } else if (first == second) {
            total_points = 1;
        } else {
            total_points = 0;
        }
        return total_points;
    }

    public void counting_points(T first_team, int first_score,
                                T second_team, int second_score){
        System.out.println(first_team.name() + ": score = "+points(first_score,second_score));
        System.out.println(second_team.name() + ": score = "+points(second_score,first_score));
    }

}
