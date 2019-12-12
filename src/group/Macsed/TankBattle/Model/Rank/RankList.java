package group.Macsed.TankBattle.Model.Rank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RankList implements Serializable {
    private static final long serialVersionUID = 7247714666080613254L;

    private List<RankItem> rankItemList;

    public RankList() {
        this.rankItemList = new ArrayList<>();
    }

    public List<RankItem> getRankList() {
        return rankItemList;
    }

    public void setRankList(List<RankItem> rankItemList) {
        this.rankItemList = rankItemList;
    }
}
