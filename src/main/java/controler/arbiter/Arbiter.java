package controler.arbiter;

import model.board.Board;
import model.field.Field;
import model.field.Sign;
import util.Sequence;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lucz on 29.06.16.
 */
public class Arbiter {

    Board board;
    List<Sequence> sequences;

    public Arbiter(Board board) {
        this.board = board;
        this.sequences = new LinkedList<>();
    }

    public Boolean wasThisMoveVictorious(Field field) {



        return Boolean.TRUE;
    }

    public String announceWinner(String playerName, Sign sign) {
        return new StringBuilder().append(playerName).append(" (").append(sign.toString()).append(")").append(" in a winner").toString();
    }
}
