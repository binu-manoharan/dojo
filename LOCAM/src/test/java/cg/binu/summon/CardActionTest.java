package cg.binu.summon;

import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CardActionTest {
    @Test
    public void should_summon_slimer() throws Exception {
        final Card card = CardFactory.get(1);
        final CardAction cardAction = new CardAction(card, Action.SUMMON);
        assertThat("Should print the correct summon action.", cardAction.toString(), is("SUMMON " + card.getInstanceId() + ";"));
    }
}
