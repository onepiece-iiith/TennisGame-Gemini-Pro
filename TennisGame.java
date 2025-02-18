public class TennisGame1 implements TennisGame {

    private Score score;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.score = new Score();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            score.incrementPlayer1Score();
        } else {
            score.incrementPlayer2Score();
        }
    }

    public String getScore() {
        return score.getScore();
    }

    // Inner class to encapsulate score data
    private class Score {
        private int player1Score;
        private int player2Score;

        public Score() {
            player1Score = 0;
            player2Score = 0;
        }

        public void incrementPlayer1Score() {
            player1Score++;
        }

        public void incrementPlayer2Score() {
            player2Score++;
        }

        public String getScore() {
            if (player1Score == player2Score) {
                return getEqualScore(player1Score);
            } else if (player1Score >= 4 || player2Score >= 4) {
                return getSetScore(player1Score, player2Score);
            } else {
                return getRegularScore(player1Score, player2Score);
            }
        }

        // Helper methods to encapsulate score logic 
        private String getEqualScore(int score) {
            switch (score) {
                case 0: return "Love-All";
                case 1: return "Fifteen-All";
                case 2: return "Thirty-All";
                default: return "Deuce";
            }
        }
        private String getSetScore(int score1, int score2) {
            int minusResult = score1 - score2;
            if (minusResult == 1) return "Advantage player1";
            else if (minusResult == -1) return "Advantage player2";
            else if (minusResult >= 2) return "Win for player1";
            else return "Win for player2";
        }
        private String getRegularScore(int score1, int score2) {
            String score = "";
            for (int i = 0; i < 2; i++) {
                int tempScore = (i == 0) ? score1 : score2;
                switch (tempScore) {
                    case 0: score += "Love"; break;
                    case 1: score += "Fifteen"; break;
                    case 2: score += "Thirty"; break;
                    case 3: score += "Forty"; break;
                }
                if (i == 0) score += "-";
            }
            return score;
        }
    }
}