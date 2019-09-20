package at.htl.football;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class MatchTest {
    @Test
    public void hometeam_win() {


        Match match = new Match("Augsburg", "Stuttgart", 3, 1);

        assertThat(match.getHomePoints(), is(3));
        assertThat(match.getGuestPoints(), is(0));
    }
    @Test
    public void guestteam_win() {
        Match match = new Match("Augsburg", "Stuttgart", 1, 3);

        assertThat(match.getHomePoints(), is(0));
        assertThat(match.getGuestPoints(), is(3));
    }

    @Test
    public void draw() {
        Match match = new Match("Augsburg", "Stuttgart", 1, 1);

        assertThat(match.getHomePoints(), is(1));
        assertThat(match.getGuestPoints(), is(1));
    }
}