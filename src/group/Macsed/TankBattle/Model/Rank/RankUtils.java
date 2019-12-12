package group.Macsed.TankBattle.Model.Rank;

import java.io.*;
import java.util.List;

public class RankUtils {
    private RankList rankList;

    public RankUtils() {
        this.rankList = new RankList();
    }

    public List<RankItem> getRankList() {
        return rankList.getRankList();
    }

    public void setRankList(List<RankItem> rankList) {
        this.rankList.setRankList(rankList);
    }

    public void readRankList() throws ClassNotFoundException {
        try {
            InputStream inputStream = new FileInputStream("./rank_list.rabbit");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            this.rankList = (RankList) objectInputStream.readObject();
        } catch (IOException exception ) {
            this.rankList = new RankList();
        }
    }

    public void saveRankList() throws IOException {
        OutputStream outputStream = new FileOutputStream("./rank_list.rabbit");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.rankList);
    }
}
