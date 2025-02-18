public class TennisGame implements TennisGame {

    private int m_score1;
    private int m_score2;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        m_score1 = 0;
        m_score2 = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getScoreForTie();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreForAdvantageOrWin();
        } else {
            return getScoreForRegularGame();
        }
    }

    private String getScoreForTie() {
        String score;
        switch (m_score1) {
            case 0: score = "Love-All"; break;
            case 1: score = "Fifteen-All"; break;
            case 2: score = "Thirty-All"; break;
            default: score = "Deuce"; break;
        }
        return score;
    }

    private String getScoreForAdvantageOrWin() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String getScoreForRegularGame() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                score += "-";
                tempScore = m_score2;
            }
            score += getScoreForRegularPoint(tempScore);
        }
        return score;
    }

    private String getScoreForRegularPoint(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }
}