package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skillsAndLevels) {

        for (int i = 0; i < skillsAndLevels.length; i++) {
            String s = skillsAndLevels[i];

            String skill = s.substring(0, s.indexOf(" ("));
            String levelString = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            int level = Integer.parseInt(levelString);
            skills.add(new Skill(skill, level));
        }
    }

    public int findSkillLevelByName(String name) {

        if (skills.size() == 0) {
            throw new IllegalArgumentException();
        }
        int level = 0;
        for (Skill s : skills) {
            if (s.getName().equals(name)) {
                level = s.getLevel();
            }
        }
        return level;
    }
}
