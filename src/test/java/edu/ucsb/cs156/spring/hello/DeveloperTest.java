package edu.ucsb.cs156.spring.hello;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Wendy Song", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Wendy192837", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team_name() {
        Team team = Developer.getTeam();

        assertEquals("staff", team.getName());
    }

    @Test
    public void getTeam_returns_correct_members() {
        Team team = Developer.getTeam();

        List<String> expectedMembers = List.of(
                "Derek",
                "Wendy Song",
                "Keigo",
                "Victor",
                "Phill",
                "Daniel"
        );

        assertEquals(expectedMembers, team.getMembers());
    }
}