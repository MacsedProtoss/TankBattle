package group.Macsed.TankBattle.Model.Rank;

import java.io.*;
import java.util.Date;
import java.util.List;

public class RankUtils {
    private RankList rankList;
    private final Object rankListLock = new Object();

    public RankUtils() {
        this.rankList = new RankList();
    }

    public List<RankItem> getRankList() {
        return rankList.getRankList();
    }

    public void setRankList(List<RankItem> rankList) {
        this.rankList.setRankList(rankList);
    }

    public void insertRankList(String username, Integer credits, Date date) throws ClassNotFoundException, IOException {
        synchronized (rankListLock) {
            this.readRankList();

            RankItem rankItem = new RankItem();
            rankItem.setUsername(username);
            rankItem.setScore(credits);
            rankItem.setDate(date);

            this.getRankList().add(rankItem);
            this.saveRankList();
        }
    }

    public void readRankList() throws ClassNotFoundException {
        try {
            InputStream inputStream = new FileInputStream("./rank_list.rabbit");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            this.rankList = (RankList) objectInputStream.readObject();
        } catch (IOException exception) {
            this.rankList = new RankList();
        }
    }

    public void saveRankList() throws IOException {
        OutputStream outputStream = new FileOutputStream("./rank_list.rabbit");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.rankList);
    }
}
