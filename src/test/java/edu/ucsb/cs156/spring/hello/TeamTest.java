package edu.ucsb.cs156.spring.hello;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    
    @Test
    public void default_constructor_has_empty_name() {
        Team t = new Team();
        assertEquals("", t.getName());
    }

    @Test
    public void default_constructor_has_empty_members() {
        Team t = new Team();
        assertEquals(new ArrayList<String>(), t.getMembers());
    }

    @Test
    public void addMember_adds_member() {
        team.addMember("Wendy");
        assertEquals(1, team.getMembers().size());
        assertEquals("Wendy", team.getMembers().get(0));
    }

    @Test
    public void setName_changes_name() {
        team.setName("new-name");
        assertEquals("new-name", team.getName());
    }

    @Test
    public void setMembers_changes_members() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Wendy");
        members.add("Derek");

        team.setMembers(members);

        assertEquals(members, team.getMembers());
    }

    @Test
    public void equals_same_object_is_true() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_non_team_is_false() {
        assertFalse(team.equals("hello"));
    }

    @Test
    public void equals_null_is_false() {
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_same_name_and_members_is_true() {
        team.addMember("Wendy");

        Team other = new Team("test-team");
        other.addMember("Wendy");

        assertTrue(team.equals(other));
    }

    @Test
    public void equals_different_name_is_false() {
        Team other = new Team("different-team");

        assertFalse(team.equals(other));
    }

    @Test
    public void equals_different_members_is_false() {
        team.addMember("Wendy");

        Team other = new Team("test-team");
        other.addMember("Derek");

        assertFalse(team.equals(other));
    }

    @Test
    public void toString_returns_correct_string() {
        team.addMember("Wendy");

        assertEquals(
            "Team(name=test-team, members=[Wendy])",
            team.toString()
        );
    }

    @Test
    public void hashCode_returns_expected_value() {
        team.addMember("Wendy");

        int expected =
            team.getName().hashCode() |
            team.getMembers().hashCode();

        assertEquals(expected, team.hashCode());
    }
}