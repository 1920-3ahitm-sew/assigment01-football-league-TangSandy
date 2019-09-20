package at.htl.football;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;


import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        League league = new League();


        String line;
        try(Scanner scanner = new Scanner(new FileReader("bundesliga-1819.csv"))){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                line = scanner.nextLine();

                String[] parts = line.split(";");

                String homeTeam = parts[1];
                String guestTeam = parts[2];
                int homeGoals = Integer.parseInt(parts[3]);
                int guestGoals = Integer.parseInt(parts[4]);

                Match match = new Match(homeTeam,guestTeam,homeGoals,guestGoals);
                league.addMatchResult(match);


            }

        }catch (IOException e){
            e.printStackTrace();
        }

        printTable(league.getTable());

    }

    private static void printTable(List<Team> teams) {
        System.out.println("Team          Pts      W          D        L        GF          GA          GD");

        for (Team team : teams) {
            System.out.printf(team.getName() + "         " +  team.getPoints()+"         "+  team.getWins()+ "          " + team.getDraws() +"        "+ team.getDefeats()+ "       "+
                     "         " +team.getGoalsShot()+ "         " +team.getGoalsReceived()+ "         " +team.getGoalDifference()+"%n");
        }
    }
}