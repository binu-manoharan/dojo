package old.prototype;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SummonCreatures implements Action {
    @Override
    public String generateMovesForThisTurn(List<Card> cards, int maxMana) {
        final Random random = new Random();
        final List<Card> opponentGuard = cards.stream().filter(card -> card.getLocation() == -1).collect(Collectors.toList());
        final List<Card> cardsInHand = cards.stream().filter(card -> card.getLocation() == 0).collect(Collectors.toList());
        final List<Card> cardInPlay = cards.stream().filter(card -> card.getLocation() == 1).collect(Collectors.toList());

        StringBuffer sb = new StringBuffer();

        for (Card card : cardInPlay) {
            sb.append("ATTACK ");
            sb.append(card.getInstanceId());
            sb.append(" ");
            if (!opponentGuard.isEmpty()) {
                final int targetIndex = random.nextInt(opponentGuard.size());
                sb.append(opponentGuard.get(targetIndex).getInstanceId());
            } else {
                sb.append("-1");
            }
            sb.append(";");
        }
        cardsInHand.sort((o1, o2) -> o1.getCost() - o2.getCost());

        final List<Card> cardsWithinMana = cardsInHand.stream().filter(c -> c.getCost() < maxMana).collect(Collectors.toList());
        if (cardsWithinMana.isEmpty()) {
            final Card card = cardsWithinMana.get(0);
            sb.append("SUMMON ");
            sb.append(card.getInstanceId());
            sb.append(";");
        }

        if (sb.toString().equals("")) {
            return "PASS";
        }
        return sb.toString();
    }
}
