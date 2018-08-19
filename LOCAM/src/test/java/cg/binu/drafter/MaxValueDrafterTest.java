package cg.binu.drafter;

import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxValueDrafterTest {
    @Test
    public void should_draft_beavrat() throws Exception {
        final Card beavrat = CardFactory.get(3); // 1 cost 2/2 creature
        final Card platedToad = CardFactory.get(4); // 2 cost 1/5 creature
        final Card grimeGnasher = CardFactory.get(5); // 2 cost 4/1 creature

        final List<Card> cards = asList(beavrat, platedToad, grimeGnasher);
        final DraftChoice draftChoice = new DraftChoice(cards);

        final Drafter maxValueDrafter = new MaxValueDrafter();
        final int choice = maxValueDrafter.draft(draftChoice);
        assertThat("Beavrat has max value.", choice, is(0));
    }
}
