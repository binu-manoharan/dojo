package cg.binu.actions;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CardActions {
    public static String getCardActionStrings(List<CardAction> cardActions) {
        AtomicReference<String> cardActionString = new AtomicReference<>();
        cardActionString.set("");

        cardActions.stream()
                .map(CardAction::toString)
                .forEach(actionString -> cardActionString.set(cardActionString.get() + actionString));
        return cardActionString.get();
    }
}
