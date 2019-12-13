package group.Macsed.TankBattle.Model.Credits;

import group.Macsed.TankBattle.Model.Rank.RankUtils;

import java.io.IOException;
import java.util.Date;

public class Credits {
    private Integer credits;

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void incrementCredits(Integer credits) {
        this.credits += credits;
    }

    public void save(String username) throws ClassNotFoundException, IOException {
        RankUtils rankUtils = new RankUtils();
        rankUtils.insertRankList(username, this.credits, new Date());
    }
}
