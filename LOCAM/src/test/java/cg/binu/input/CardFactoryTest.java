package cg.binu.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CardFactoryTest {
    @Test
    public void should_get_cards_for_expected_creatures() throws Exception {
        final Card slimer = CardFactory.get(1);
        assertThat("Card name is correct.", slimer.getName(), is("Slimer"));

        final Card beavrat = CardFactory.get(3); // 1 cost 2/2 creature
        assertThat("Card name is correct.", beavrat.getName(), is("Beavrat"));

        final Card minorLifeStealPotion = CardFactory.get(160);
        assertThat("Card name is correct.", minorLifeStealPotion.getName(), is("MinorLifeStealPotion"));
    }
}
