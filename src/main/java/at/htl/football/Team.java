package at.htl.football;

public class Team implements Comparable<Team>{

    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;
    private int goalDifference;

    public Team(String name) {
        this.name = name;
    }

    public  void addMatch(Match match){
        if(match.getGuestName().equals(name)){

            goalsReceived = goalsReceived + match.getHomeGoals();
            goalsShot = goalsShot + match.getGuestGoals();
            points = points + match.getGuestPoints();

            switch (match.getGuestPoints()){
                case 0: defeats++;
                        break;
                case 1: draws++;
                        break;
                case 2: wins++;
                        break;
            }
        }

        else if(match.getHomeName().equals(name)){
            goalsReceived = goalsReceived + match.getGuestGoals();
            goalsShot = goalsShot + match.getHomeGoals();
            points = points + match.getHomePoints();

            switch (match.getGuestPoints()){
                case 0: defeats++;
                    break;
                case 1: draws++;
                    break;
                case 2: wins++;
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return goalsReceived;
    }

    @Override
    public int compareTo(Team o) {
        if(points < o.points ){
            return -1;
        }else if(points > points){
            return 1;
        }else {
            return 0;
        }
    }
}

