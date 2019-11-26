package group.Macsed.TankBattle;

import group.Macsed.TankBattle.Rank.RankItem;
import group.Macsed.TankBattle.Rank.RankUtils;

import java.io.IOException;
import java.util.Date;

public class rank_example {
    public void example() throws IOException, ClassNotFoundException {
        RankUtils rankUtils = new RankUtils();
        rankUtils.readRankList();
        RankItem rankItem = new RankItem();

        rankItem.setDate(new Date());
        rankItem.setUsername("hzytql");
        rankItem.setScore(100);

        rankUtils.getRankList().add(rankItem);
        rankUtils.saveRankList();
    }
}
