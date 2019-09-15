package cg.binu.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CardFactoryTest {
    @Test
    public void should_get_cards_for_expected_creatures() throws Exception {
        final Card slimer = CardFactory.get(1);
        assertThat("Card cost is correct.", slimer.getCost(), is(1));

        final Card beavrat = CardFactory.get(3); // 1 cost 2/2 creature
        assertThat("Card cost is correct.", beavrat.getCost(), is(1));

        final Card minorLifeStealPotion = CardFactory.get(160);
        assertThat("Card cost is correct.", minorLifeStealPotion.getCost(), is(2));
    }
}
