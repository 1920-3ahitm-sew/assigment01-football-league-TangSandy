package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collections;


import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        League league = new League();

        Path file = Paths.get("bundesliga-1819.csv");

        try{
            List<String> lines = Files.readAllLines( file,UTF_8);

            String date,homeTeam,guestTeam;
            int homeGoals,guestGoals;
            String[] parts = new String[5];
            date = parts[0];
            homeTeam = parts[1];
            guestTeam = parts[2];
            homeGoals = Integer.parseInt(parts[3]);
            guestGoals = Integer.parseInt(parts[4]);

            Match match = new Match(homeTeam,guestTeam,homeGoals,guestGoals);
            league.addMatchResult(match);

            printTable(league.getTable());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printTable(List<Team> teams) {
        System.out.println("Team          Pts      W          D        L        GF          GA          GD");

        for (Team team : teams) {
            System.out.print(team.getName() + "         " +  team.getPoints()+"         "+  team.getWins()+ "          " + team.getDraws() +"        "+ team.getDefeats()+ "       "+
                     "         " +team.getGoalsShot()+ "         " +team.getGoalsReceived()+ "         " +team.getGoalDifference());
        }
    }
}