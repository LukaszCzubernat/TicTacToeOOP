package controler.arbiter.impl;

import controler.arbiter.GameArbiter;
import controler.board.GameBoardController;
import model.field.impl.Sign;

/**
 * Created by lucz on 29.06.16.
 */
public class Arbiter implements GameArbiter {

    private ArbiterDecisionEngine arbiterDecisionEngine;

    public Arbiter() {
        this.arbiterDecisionEngine = new ArbiterDecisionEngine();
    }

    public Boolean wasThisMoveVictorious(GameBoardController boardController) {
        return arbiterDecisionEngine.isBoardContainsWinningSequence(boardController);
    }

    @Override
    public String announceWinner(String playerName, Sign sign) {
        return new StringBuilder().append(playerName).append(" (").append(sign.toString()).append(")").append(" in a winner").toString();
    }
}
