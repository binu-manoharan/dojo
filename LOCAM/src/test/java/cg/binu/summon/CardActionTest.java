package cg.binu.summon;

import cg.binu.actions.Action;
import cg.binu.actions.AttackAction;
import cg.binu.actions.CardAction;
import cg.binu.actions.SummonAction;
import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CardActionTest {
    @Test
    public void should_summon_slimer() throws Exception {
        final Card card = CardFactory.get(1);
        final CardAction cardAction = new SummonAction(card);
        assertThat("Should print the correct action.", cardAction.toString(), is("SUMMON " + card.getInstanceId() + ";"));
    }

    @Test
    public void should_attack_scuttler_with_slimer() throws Exception {
        final Card myCard = CardFactory.get(1);
        final Card opponentCard = CardFactory.get(2);
        final CardAction cardAction = new AttackAction(myCard, opponentCard);
        assertThat(
                "Should print the correct action.",
                cardAction.toString(),
                is("ATTACK " + myCard.getInstanceId() + " " + opponentCard.getInstanceId() + ";")
        );
    }
}
