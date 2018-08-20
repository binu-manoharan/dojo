package cg.binu.summon;

import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxValueSummonerTest {

    private static final int MANA_1 = 1;
    public static final int MANA_0 = 0;
    public static final int MANA_2 = 2;

    @Test
    public void should_not_summon_the_only_creature_as_there_is_not_enough_mana() throws Exception {
        final Summoner summoner = new MaxValueSummoner();
        final List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.add(CardFactory.get(1));

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_0);
        assertThat("There is one action.", cardActions.size(), is(0));
    }

    @Test
    public void should_summon_the_only_1_value_creature() throws Exception {
        final Summoner summoner = new MaxValueSummoner();
        final List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.add(CardFactory.get(1));

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_1);
        assertThat("There is one action.", cardActions.size(), is(1));
    }

    @Test
    public void should_summon_both_creature() throws Exception {
        final Summoner summoner = new MaxValueSummoner();
        final List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.add(CardFactory.get(1));
        cardsInHand.add(CardFactory.get(2));

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_2);
        assertThat("There are two action.", cardActions.size(), is(2));
    }

    @Test
    public void should_summon_beavrat_as_it_has_max_value() throws Exception {
        final Summoner summoner = new MaxValueSummoner();
        final List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.add(CardFactory.getWithInstanceId(1, 1));
        cardsInHand.add(CardFactory.getWithInstanceId(2, 2));
        cardsInHand.add(CardFactory.getWithInstanceId(3, 3));

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_1);
        assertThat("There is one action.", cardActions.size(), is(1));
        assertThat("The action is summon 3.", cardActions.get(0).toString(), is("SUMMON 3;"));
    }
}
