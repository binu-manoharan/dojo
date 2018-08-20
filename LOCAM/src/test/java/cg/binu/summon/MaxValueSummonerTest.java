package cg.binu.summon;

import cg.binu.actions.Action;
import cg.binu.actions.CardAction;
import cg.binu.actions.SummonAction;
import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cg.binu.actions.CardActions.getCardActionStrings;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxValueSummonerTest {

    private static final int MANA_1 = 1;
    private static final int MANA_0 = 0;
    private static final int MANA_2 = 2;
    private static final int MANA_3 = 3;

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
        final Card beavrat = CardFactory.getWithInstanceId(3, 3);
        cardsInHand.add(beavrat);

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_1);
        assertThat("There is one action.", cardActions.size(), is(1));
        assertThat(
                "The action is summon 3.",
                cardActions.get(0).toString(),
                is(getCardActionStrings(singletonList(new SummonAction(beavrat))))
        );
    }

    @Test
    public void should_summon_corrupted_beavrat_as_it_has_max_value() throws Exception {
        final Summoner summoner = new MaxValueSummoner();
        final List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.add(CardFactory.getWithInstanceId(3, 1));
        final Card corruptedBeavrat = CardFactory.getWithInstanceId(9, 2);
        cardsInHand.add(corruptedBeavrat);

        final List<CardAction> cardActions = summoner.summon(cardsInHand, MANA_3);
        assertThat("There is one action.", cardActions.size(), is(1));assertThat(
                "The action is summon 2.",
                cardActions.get(0).toString(),
                is(getCardActionStrings(singletonList(new SummonAction(corruptedBeavrat))))
        );
    }
}
