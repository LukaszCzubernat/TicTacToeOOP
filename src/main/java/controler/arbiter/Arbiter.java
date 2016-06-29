package controler.arbiter;

import model.field.Field;
import model.field.Sign;

/**
 * Created by lucz on 29.06.16.
 */
public class Arbiter {

    public Boolean wasThisMoveVictorious(Field field) {
        return Boolean.TRUE;
    }

    public String announceWinner(String playerName, Sign sign) {
        return new StringBuilder().append(playerName).append(" (").append(sign.toString()).append(")").append(" in a winner").toString();
    }
}
