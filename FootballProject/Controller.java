package football_project;
interface league{
    String name();
    Affiliation affiliation();
}

record English_premier_league (String name, Affiliation affiliation) implements league{
}
public class Controller {

    public void total_teams(){
        Team<English_premier_league, Affiliation> EPL = new Team("Enlish Premier League");
        var Arsenal = new English_premier_league("Arsenal",null);
        var Aston_Villa = new English_premier_league("Aston Villa", null);
        var Brentford = new English_premier_league("Brentford", null);
        var Brighton = new English_premier_league("Brighton", null);
        var Burnley = new English_premier_league("Burnley", null);
        var Chelsea = new English_premier_league("Chelsea", null);
        var Crystal_Palace = new English_premier_league("Crystal Palace", null);
        var Everton = new English_premier_league("Everton", null);
        var Fulham = new English_premier_league("Fulham", null);
        var Leeds_United = new English_premier_league("Leeds United", null);
        var Leicester_City = new English_premier_league("Leicester City", null);
        var Liverpool = new English_premier_league("Liverpool", null);
        var Manchester_City = new English_premier_league("Manchester City",null);
        Affiliation united = new Affiliation("Erig Ten Hahg","Old Trafford",1878);
        var Manchester_United = new English_premier_league("Manchester United",united);
        var Newcastle_United = new English_premier_league("Newcastle United", null);

        var Norwich_City = new English_premier_league("Norwich City", null);
        var Southampton = new English_premier_league("Southampton", null);
        var Tottenham_Hotspur = new English_premier_league("Tottenham", null);
        var Watford = new English_premier_league("Watford", null);
        var West_Ham_United = new English_premier_league("West Ham United", null);
        EPL.add_team(Arsenal);
        EPL.add_team(Aston_Villa);
        EPL.add_team(Brentford);
        EPL.add_team(Brighton);
        EPL.add_team(Burnley);
        EPL.add_team(Chelsea);
        EPL.add_team(Crystal_Palace);
        EPL.add_team(Everton);
        EPL.add_team(Fulham);
        EPL.add_team(Leeds_United);
        EPL.add_team(Leicester_City);
        EPL.add_team(Liverpool);
        EPL.add_team(Manchester_City);
        EPL.add_team(Manchester_United);
        EPL.add_team(Newcastle_United);
        EPL.add_team(Norwich_City);
        EPL.add_team(Southampton);
        EPL.add_team(Tottenham_Hotspur);
        EPL.add_team(Watford);
        EPL.add_team(West_Ham_United);

        EPL.serch_team("Manchester United");
        EPL.serch_team("Derby County");

        EPL.counting_points(Manchester_United,5,Manchester_City,3);

        EPL.remove_team(Manchester_United);
        EPL.list_teams();
        EPL.serch_team("Manchester United");
    }

}
