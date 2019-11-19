package group.Macsed.TankBattle.rank;

import java.io.Serializable;
import java.util.Date;

public class RankItem implements Serializable {
    private static final long serialVersionUID = 7247714666080613254L;

    private String username;
    private Integer score;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
