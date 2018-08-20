package cg.binu.attack;

import cg.binu.actions.AttackAction;
import cg.binu.actions.CardAction;
import cg.binu.input.Card;
import cg.binu.input.CardFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static cg.binu.actions.CardActions.getCardActionStrings;
import static java.util.Collections.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuardAndFaceAttackerTest {
    @Test
    public void should_attack_face_with_slimer() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card slimer = CardFactory.getWithInstanceId(1, 1);
        final List<Card> myCardsOnBoard = singletonList(slimer);
        final List<Card> opponentCardsOnBoard = emptyList();

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be one attack", attacks.size(), is(1));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(slimer, null))))
        );
    }

    @Test
    public void should_attack_guard_mob_with_slimer() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card slimer = CardFactory.getWithInstanceId(1, 1);
        final List<Card> myCardsOnBoard = singletonList(slimer);

        final Card shinyProwler = CardFactory.getWithInstanceId(49, 2);
        final List<Card> opponentCardsOnBoard = singletonList(shinyProwler);

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be one attack", attacks.size(), is(1));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(slimer, shinyProwler))))
        );
    }

    @Test
    public void should_attack_guard_mob_with_slimer_and_face_with_bite_spitter() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card slimer = CardFactory.getWithInstanceId(1, 1);
        final Card biteSpitter = CardFactory.getWithInstanceId(52, 3);

        final List<Card> myCardsOnBoard = Arrays.asList(slimer, biteSpitter);

        final Card shinyProwler = CardFactory.getWithInstanceId(49, 2);
        final List<Card> opponentCardsOnBoard = singletonList(shinyProwler);

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be one attack", attacks.size(), is(2));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(slimer, shinyProwler))))
        );
        assertThat(
                "The action is to attack face.",
                attacks.get(1).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(biteSpitter, null))))
        );
    }

    @Test
    public void should_attack_guard_mob_with_charging_boardhound_and_face_with_slimer() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card slimer = CardFactory.getWithInstanceId(1, 1);
        final Card chargingBoarhound = CardFactory.getWithInstanceId(69, 3);

        final List<Card> myCardsOnBoard = Arrays.asList(slimer, chargingBoarhound);

        final Card rockGobbler = CardFactory.getWithInstanceId(40, 2);
        final List<Card> opponentCardsOnBoard = singletonList(rockGobbler);

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be two attacks", attacks.size(), is(2));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(chargingBoarhound, rockGobbler))))
        );
        assertThat(
                "The action is to attack face.",
                attacks.get(1).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(slimer, null))))
        );
    }

    @Test
    public void should_attack_turta_guard_mob_with_murglord() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card murglord = CardFactory.getWithInstanceId(70, 1);
        final List<Card> myCardsOnBoard = singletonList(murglord);

        final Card turta = CardFactory.getWithInstanceId(97, 2);
        final Card caveCrab = CardFactory.getWithInstanceId(99, 2);
        final List<Card> opponentCardsOnBoard = Arrays.asList(turta, caveCrab);

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be one attack", attacks.size(), is(1));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(murglord, turta))))
        );
    }

    @Test
    public void should_attack_gargantua_guard_mob_with_murglord_even_if_unable_to_kill_it() throws Exception {
        final Attacker guardAndFaceAttacker = new GuardAndFaceAttacker();
        final Card murglord = CardFactory.getWithInstanceId(70, 1);
        final List<Card> myCardsOnBoard = singletonList(murglord);

        final Card gargantua = CardFactory.getWithInstanceId(114, 2);
        final List<Card> opponentCardsOnBoard = singletonList(gargantua);

        final List<CardAction> attacks = guardAndFaceAttacker.getAttacks(myCardsOnBoard, opponentCardsOnBoard);
        assertThat("There should be one attack", attacks.size(), is(1));
        assertThat(
                "The action is to attack face.",
                attacks.get(0).toString(),
                is(getCardActionStrings(singletonList(new AttackAction(murglord, gargantua))))
        );
    }
}
