package controler.arbiter;

import model.board.impl.Board;
import model.field.Sign;

/**
 * Created by lucz on 29.06.16.
 */
public class Arbiter {

    private ArbiterDecisionEngine arbiterDecisionEngine;

    public Arbiter() {
        this.arbiterDecisionEngine = new ArbiterDecisionEngine();
    }

    public Boolean wasThisMoveVictorious(Board board) {
        return arbiterDecisionEngine.isBoardContainsWinningSequence(board);
    }

    public String announceWinner(String playerName, Sign sign) {
        return new StringBuilder().append(playerName).append(" (").append(sign.toString()).append(")").append(" in a winner").toString();
    }
}
