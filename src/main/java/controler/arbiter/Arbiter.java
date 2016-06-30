package controler.arbiter;

import model.board.Board;
import model.field.Sign;

/**
 * Created by lucz on 29.06.16.
 */
public class Arbiter {

    private ArbiterHelper arbiterHelper;

    public Arbiter() {
        this.arbiterHelper = new ArbiterHelper();
    }

    public Boolean wasThisMoveVictorious(Board board) {
        return arbiterHelper.isBoardContainsWinningSequence(board);
    }

    public String announceWinner(String playerName, Sign sign) {
        return new StringBuilder().append(playerName).append(" (").append(sign.toString()).append(")").append(" in a winner").toString();
    }
}
