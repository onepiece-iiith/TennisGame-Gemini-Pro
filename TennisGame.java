import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private Map<Integer, String> scoreMap = new HashMap<>();

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        scoreMap.put(0, "Love");
        scoreMap.put(1, "Fifteen");
        scoreMap.put(2, "Thirty");
        scoreMap.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getEqualScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getAdvantageOrWinScore();
        } else {
            return getRunningScore();
        }
    }

    private String getEqualScore() {
        if (m_score1 < 3) {
            return scoreMap.get(m_score1) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String getAdvantageOrWinScore() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getRunningScore() {
        return scoreMap.get(m_score1) + "-" + scoreMap.get(m_score2);

    }
}