package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private List<Team> teams = new ArrayList<>();

    public  void addMatchResult(Match match){
        Team homeTeam = finOrCreateTeam(match.getHomeName());
        homeTeam.addMatch(match);

        Team guestTeam = finOrCreateTeam(match.getGuestName());
        guestTeam.addMatch(match);
    }

    private  Team finOrCreateTeam(String team){
        for (Team team1: teams){
            if(team1.getName().equals(team)){
                return team1;
            }
        }

        Team team1 = new Team(team);
        teams.add(team1);
        return team1;
    }

    public List<Team> getTable() {
        teams.sort(Collections.reverseOrder());
        return teams;
    }
}