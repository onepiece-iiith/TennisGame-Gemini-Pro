public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else if (playerName.equals(player2.getName())) {
            player2.wonPoint();
        } else {
            throw new IllegalArgumentException("Invalid player name");
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = getScoreForTie(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreForAdvantageOrWin(m_score1, m_score2);
        } else {
            score = getScoreForNormalScores(m_score1, m_score2);
        }
        return score;
    }

    private String getScoreForTie(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreForAdvantageOrWin(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getScoreForNormalScores(int score1, int score2) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                score += "-";
                tempScore = score2;
            }
            score += getScoreForPoint(tempScore);
        }
        return score;
    }

    private String getScoreForPoint(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    // Inner class for Player, encapsulating score and name
    private static class Player {
        private String name;
        private int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() { return name; }

        public void wonPoint() { this.score++; }

        public int getScore() { return score; }
    }
}