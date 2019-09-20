package at.htl.football;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

public class LeagueTest {
    @Test
    public void no_existing_team() {
        League league = new League();

        league.addMatchResult(new Match("Dortmund", "Leipzig", 4, 1));

        assertThat(league.getTable().get(0).getPoints(), is(3));
        assertThat(league.getTable().get(1).getPoints(), is(0));
    }

    private void assertThat(int points, Matcher<Integer> integerMatcher) {
    }

    @Test
    public void existing_team() {
        League league = new League();

        league.addMatchResult(new Match("Dortmund", "Leipzig", 4, 1));
        league.addMatchResult(new Match("Dortmund", "Leipzig", 2, 2));

        assertThat(league.getTable().get(0).getPoints(), is(4));
        assertThat(league.getTable().get(1).getPoints(), is(1));
    }
}