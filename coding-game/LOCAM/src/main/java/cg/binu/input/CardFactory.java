package cg.binu.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a card given a card number.
 */
public class CardFactory {
    private static List<Card> cards = new ArrayList<>();

    static {
        cards.add(new Card(1, 0, 0, CardType.CREATURES, 1, 2, 1, "------", 1, 0, 0));
        cards.add(new Card(2, 0, 0, CardType.CREATURES, 1, 1, 2, "------", 0, -1, 0));
        cards.add(new Card(3, 0, 0, CardType.CREATURES, 1, 2, 2, "------", 0, 0, 0));
        cards.add(new Card(4, 0, 0, CardType.CREATURES, 2, 1, 5, "------", 0, 0, 0));
        cards.add(new Card(5, 0, 0, CardType.CREATURES, 2, 4, 1, "------", 0, 0, 0));
        cards.add(new Card(6, 0, 0, CardType.CREATURES, 2, 3, 2, "------", 0, 0, 0));
        cards.add(new Card(7, 0, 0, CardType.CREATURES, 2, 2, 2, "-----W", 0, 0, 0));
        cards.add(new Card(8, 0, 0, CardType.CREATURES, 2, 2, 3, "------", 0, 0, 0));
        cards.add(new Card(9, 0, 0, CardType.CREATURES, 3, 3, 4, "------", 0, 0, 0));
        cards.add(new Card(10, 0, 0, CardType.CREATURES, 3, 3, 1, "--D---", 0, 0, 0));
        cards.add(new Card(11, 0, 0, CardType.CREATURES, 3, 5, 2, "------", 0, 0, 0));
        cards.add(new Card(12, 0, 0, CardType.CREATURES, 3, 2, 5, "------", 0, 0, 0));
        cards.add(new Card(13, 0, 0, CardType.CREATURES, 4, 5, 3, "------", 1, -1, 0));
        cards.add(new Card(14, 0, 0, CardType.CREATURES, 4, 9, 1, "------", 0, 0, 0));
        cards.add(new Card(15, 0, 0, CardType.CREATURES, 4, 4, 5, "------", 0, 0, 0));
        cards.add(new Card(16, 0, 0, CardType.CREATURES, 4, 6, 2, "------", 0, 0, 0));
        cards.add(new Card(17, 0, 0, CardType.CREATURES, 4, 4, 5, "------", 0, 0, 0));
        cards.add(new Card(18, 0, 0, CardType.CREATURES, 4, 7, 4, "------", 0, 0, 0));
        cards.add(new Card(19, 0, 0, CardType.CREATURES, 5, 5, 6, "------", 0, 0, 0));
        cards.add(new Card(20, 0, 0, CardType.CREATURES, 5, 8, 2, "------", 0, 0, 0));
        cards.add(new Card(21, 0, 0, CardType.CREATURES, 5, 6, 5, "------", 0, 0, 0));
        cards.add(new Card(22, 0, 0, CardType.CREATURES, 6, 7, 5, "------", 0, 0, 0));
        cards.add(new Card(23, 0, 0, CardType.CREATURES, 7, 8, 8, "------", 0, 0, 0));
        cards.add(new Card(24, 0, 0, CardType.CREATURES, 1, 1, 1, "------", 0, -1, 0));
        cards.add(new Card(25, 0, 0, CardType.CREATURES, 2, 3, 1, "------", -2, -2, 0));
        cards.add(new Card(26, 0, 0, CardType.CREATURES, 2, 3, 2, "------", 0, -1, 0));
        cards.add(new Card(27, 0, 0, CardType.CREATURES, 2, 2, 2, "------", 2, 0, 0));
        cards.add(new Card(28, 0, 0, CardType.CREATURES, 2, 1, 2, "------", 0, 0, 1));
        cards.add(new Card(29, 0, 0, CardType.CREATURES, 2, 2, 1, "------", 0, 0, 1));
        cards.add(new Card(30, 0, 0, CardType.CREATURES, 3, 4, 2, "------", 0, -2, 0));
        cards.add(new Card(31, 0, 0, CardType.CREATURES, 3, 3, 1, "------", 0, -1, 0));
        cards.add(new Card(32, 0, 0, CardType.CREATURES, 3, 3, 2, "------", 0, 0, 1));
        cards.add(new Card(33, 0, 0, CardType.CREATURES, 4, 4, 3, "------", 0, 0, 1));
        cards.add(new Card(34, 0, 0, CardType.CREATURES, 5, 3, 5, "------", 0, 0, 1));
        cards.add(new Card(35, 0, 0, CardType.CREATURES, 6, 5, 2, "B-----", 0, 0, 1));
        cards.add(new Card(36, 0, 0, CardType.CREATURES, 6, 4, 4, "------", 0, 0, 2));
        cards.add(new Card(37, 0, 0, CardType.CREATURES, 6, 5, 7, "------", 0, 0, 1));
        cards.add(new Card(38, 0, 0, CardType.CREATURES, 1, 1, 3, "--D---", 0, 0, 0));
        cards.add(new Card(39, 0, 0, CardType.CREATURES, 1, 2, 1, "--D---", 0, 0, 0));
        cards.add(new Card(40, 0, 0, CardType.CREATURES, 3, 2, 3, "--DG--", 0, 0, 0));
        cards.add(new Card(41, 0, 0, CardType.CREATURES, 3, 2, 2, "-CD---", 0, 0, 0));
        cards.add(new Card(42, 0, 0, CardType.CREATURES, 4, 4, 2, "--D---", 0, 0, 0));
        cards.add(new Card(43, 0, 0, CardType.CREATURES, 6, 5, 5, "--D---", 0, 0, 0));
        cards.add(new Card(44, 0, 0, CardType.CREATURES, 6, 3, 7, "--D-L-", 0, 0, 0));
        cards.add(new Card(45, 0, 0, CardType.CREATURES, 6, 6, 5, "B-D---", -3, 0, 0));
        cards.add(new Card(46, 0, 0, CardType.CREATURES, 9, 7, 7, "--D---", 0, 0, 0));
        cards.add(new Card(47, 0, 0, CardType.CREATURES, 2, 1, 5, "--D---", 0, 0, 0));
        cards.add(new Card(48, 0, 0, CardType.CREATURES, 1, 1, 1, "----L-", 0, 0, 0));
        cards.add(new Card(49, 0, 0, CardType.CREATURES, 2, 1, 2, "---GL-", 0, 0, 0));
        cards.add(new Card(50, 0, 0, CardType.CREATURES, 3, 3, 2, "----L-", 0, 0, 0));
        cards.add(new Card(51, 0, 0, CardType.CREATURES, 4, 3, 5, "----L-", 0, 0, 0));
        cards.add(new Card(52, 0, 0, CardType.CREATURES, 4, 2, 4, "----L-", 0, 0, 0));
        cards.add(new Card(53, 0, 0, CardType.CREATURES, 4, 1, 1, "-C--L-", 0, 0, 0));
        cards.add(new Card(54, 0, 0, CardType.CREATURES, 3, 2, 2, "----L-", 0, 0, 0));
        cards.add(new Card(55, 0, 0, CardType.CREATURES, 2, 0, 5, "---G--", 0, 0, 0));
        cards.add(new Card(56, 0, 0, CardType.CREATURES, 4, 2, 7, "------", 0, 0, 0));
        cards.add(new Card(57, 0, 0, CardType.CREATURES, 4, 1, 8, "------", 0, 0, 0));
        cards.add(new Card(58, 0, 0, CardType.CREATURES, 6, 5, 6, "B-----", 0, 0, 0));
        cards.add(new Card(59, 0, 0, CardType.CREATURES, 7, 7, 7, "------", 1, -1, 0));
        cards.add(new Card(60, 0, 0, CardType.CREATURES, 7, 4, 8, "------", 0, 0, 0));
        cards.add(new Card(61, 0, 0, CardType.CREATURES, 9, 10, 10, "------", 0, 0, 0));
        cards.add(new Card(62, 0, 0, CardType.CREATURES, 12, 12, 12, "B--G--", 0, 0, 0));
        cards.add(new Card(63, 0, 0, CardType.CREATURES, 2, 0, 4, "---G-W", 0, 0, 0));
        cards.add(new Card(64, 0, 0, CardType.CREATURES, 2, 1, 1, "---G-W", 0, 0, 0));
        cards.add(new Card(65, 0, 0, CardType.CREATURES, 2, 2, 2, "-----W", 0, 0, 0));
        cards.add(new Card(66, 0, 0, CardType.CREATURES, 5, 5, 1, "-----W", 0, 0, 0));
        cards.add(new Card(67, 0, 0, CardType.CREATURES, 6, 5, 5, "-----W", 0, -2, 0));
        cards.add(new Card(68, 0, 0, CardType.CREATURES, 6, 7, 5, "-----W", 0, 0, 0));
        cards.add(new Card(69, 0, 0, CardType.CREATURES, 3, 4, 4, "B-----", 0, 0, 0));
        cards.add(new Card(70, 0, 0, CardType.CREATURES, 4, 6, 3, "B-----", 0, 0, 0));
        cards.add(new Card(71, 0, 0, CardType.CREATURES, 4, 3, 2, "BC----", 0, 0, 0));
        cards.add(new Card(72, 0, 0, CardType.CREATURES, 4, 5, 3, "B-----", 0, 0, 0));
        cards.add(new Card(73, 0, 0, CardType.CREATURES, 4, 4, 4, "B-----", 4, 0, 0));
        cards.add(new Card(74, 0, 0, CardType.CREATURES, 5, 5, 4, "B--G--", 0, 0, 0));
        cards.add(new Card(75, 0, 0, CardType.CREATURES, 5, 6, 5, "B-----", 0, 0, 0));
        cards.add(new Card(76, 0, 0, CardType.CREATURES, 6, 5, 5, "B-D---", 0, 0, 0));
        cards.add(new Card(77, 0, 0, CardType.CREATURES, 7, 7, 7, "B-----", 0, 0, 0));
        cards.add(new Card(78, 0, 0, CardType.CREATURES, 8, 5, 5, "B-----", 0, -5, 0));
        cards.add(new Card(79, 0, 0, CardType.CREATURES, 8, 8, 8, "B-----", 0, 0, 0));
        cards.add(new Card(80, 0, 0, CardType.CREATURES, 8, 8, 8, "B--G--", 0, 0, 1));
        cards.add(new Card(81, 0, 0, CardType.CREATURES, 9, 6, 6, "BC----", 0, 0, 0));
        cards.add(new Card(82, 0, 0, CardType.CREATURES, 7, 5, 5, "B-D--W", 0, 0, 0));
        cards.add(new Card(83, 0, 0, CardType.CREATURES, 0, 1, 1, "-C----", 0, 0, 0));
        cards.add(new Card(84, 0, 0, CardType.CREATURES, 2, 1, 1, "-CD--W", 0, 0, 0));
        cards.add(new Card(85, 0, 0, CardType.CREATURES, 3, 2, 3, "-C----", 0, 0, 0));
        cards.add(new Card(86, 0, 0, CardType.CREATURES, 3, 1, 5, "-C----", 0, 0, 0));
        cards.add(new Card(87, 0, 0, CardType.CREATURES, 4, 2, 5, "-C-G--", 0, 0, 0));
        cards.add(new Card(88, 0, 0, CardType.CREATURES, 5, 4, 4, "-C----", 0, 0, 0));
        cards.add(new Card(89, 0, 0, CardType.CREATURES, 5, 4, 1, "-C----", 2, 0, 0));
        cards.add(new Card(90, 0, 0, CardType.CREATURES, 8, 5, 5, "-C----", 0, 0, 0));
        cards.add(new Card(91, 0, 0, CardType.CREATURES, 0, 1, 2, "---G--", 0, 1, 0));
        cards.add(new Card(92, 0, 0, CardType.CREATURES, 1, 0, 1, "---G--", 2, 0, 0));
        cards.add(new Card(93, 0, 0, CardType.CREATURES, 1, 2, 1, "---G--", 0, 0, 0));
        cards.add(new Card(94, 0, 0, CardType.CREATURES, 2, 1, 4, "---G--", 0, 0, 0));
        cards.add(new Card(95, 0, 0, CardType.CREATURES, 2, 2, 3, "---G--", 0, 0, 0));
        cards.add(new Card(96, 0, 0, CardType.CREATURES, 2, 3, 2, "---G--", 0, 0, 0));
        cards.add(new Card(97, 0, 0, CardType.CREATURES, 3, 3, 3, "---G--", 0, 0, 0));
        cards.add(new Card(98, 0, 0, CardType.CREATURES, 3, 2, 4, "---G--", 0, 0, 0));
        cards.add(new Card(99, 0, 0, CardType.CREATURES, 3, 2, 5, "---G--", 0, 0, 0));
        cards.add(new Card(100, 0, 0, CardType.CREATURES, 3, 1, 6, "---G--", 0, 0, 0));
        cards.add(new Card(101, 0, 0, CardType.CREATURES, 4, 3, 4, "---G--", 0, 0, 0));
        cards.add(new Card(102, 0, 0, CardType.CREATURES, 4, 3, 3, "---G--", 0, -1, 0));
        cards.add(new Card(103, 0, 0, CardType.CREATURES, 4, 3, 6, "---G--", 0, 0, 0));
        cards.add(new Card(104, 0, 0, CardType.CREATURES, 4, 4, 4, "---G--", 0, 0, 0));
        cards.add(new Card(105, 0, 0, CardType.CREATURES, 5, 4, 6, "---G--", 0, 0, 0));
        cards.add(new Card(106, 0, 0, CardType.CREATURES, 5, 5, 5, "---G--", 0, 0, 0));
        cards.add(new Card(107, 0, 0, CardType.CREATURES, 5, 3, 3, "---G--", 3, 0, 0));
        cards.add(new Card(108, 0, 0, CardType.CREATURES, 5, 2, 6, "---G--", 0, 0, 0));
        cards.add(new Card(109, 0, 0, CardType.CREATURES, 5, 5, 6, "------", 0, 0, 0));
        cards.add(new Card(110, 0, 0, CardType.CREATURES, 5, 0, 9, "---G--", 0, 0, 0));
        cards.add(new Card(111, 0, 0, CardType.CREATURES, 6, 6, 6, "---G--", 0, 0, 0));
        cards.add(new Card(112, 0, 0, CardType.CREATURES, 6, 4, 7, "---G--", 0, 0, 0));
        cards.add(new Card(113, 0, 0, CardType.CREATURES, 6, 2, 4, "---G--", 4, 0, 0));
        cards.add(new Card(114, 0, 0, CardType.CREATURES, 7, 7, 7, "---G--", 0, 0, 0));
        cards.add(new Card(115, 0, 0, CardType.CREATURES, 8, 5, 5, "---G-W", 0, 0, 0));
        cards.add(new Card(116, 0, 0, CardType.CREATURES, 12, 8, 8, "BCDGLW", 0, 0, 0));
        cards.add(new Card(117, 0, 0, CardType.ITEM_GREEN, 1, 1, 1, "B-----", 0, 0, 0));
        cards.add(new Card(118, 0, 0, CardType.ITEM_GREEN, 0, 0, 3, "------", 0, 0, 0));
        cards.add(new Card(119, 0, 0, CardType.ITEM_GREEN, 1, 1, 2, "------", 0, 0, 0));
        cards.add(new Card(120, 0, 0, CardType.ITEM_GREEN, 2, 1, 0, "----L-", 0, 0, 0));
        cards.add(new Card(121, 0, 0, CardType.ITEM_GREEN, 2, 0, 3, "------", 0, 0, 1));
        cards.add(new Card(122, 0, 0, CardType.ITEM_GREEN, 2, 1, 3, "---G--", 0, 0, 0));
        cards.add(new Card(123, 0, 0, CardType.ITEM_GREEN, 2, 4, 0, "------", 0, 0, 0));
        cards.add(new Card(124, 0, 0, CardType.ITEM_GREEN, 3, 2, 1, "--D---", 0, 0, 0));
        cards.add(new Card(125, 0, 0, CardType.ITEM_GREEN, 3, 1, 4, "------", 0, 0, 0));
        cards.add(new Card(126, 0, 0, CardType.ITEM_GREEN, 3, 2, 3, "------", 0, 0, 0));
        cards.add(new Card(127, 0, 0, CardType.ITEM_GREEN, 3, 0, 6, "------", 0, 0, 0));
        cards.add(new Card(128, 0, 0, CardType.ITEM_GREEN, 4, 4, 3, "------", 0, 0, 0));
        cards.add(new Card(129, 0, 0, CardType.ITEM_GREEN, 4, 2, 5, "------", 0, 0, 0));
        cards.add(new Card(130, 0, 0, CardType.ITEM_GREEN, 4, 0, 6, "------", 4, 0, 0));
        cards.add(new Card(131, 0, 0, CardType.ITEM_GREEN, 4, 4, 1, "------", 0, 0, 0));
        cards.add(new Card(132, 0, 0, CardType.ITEM_GREEN, 5, 3, 3, "B-----", 0, 0, 0));
        cards.add(new Card(133, 0, 0, CardType.ITEM_GREEN, 5, 4, 0, "-----W", 0, 0, 0));
        cards.add(new Card(134, 0, 0, CardType.ITEM_GREEN, 4, 2, 2, "------", 0, 0, 1));
        cards.add(new Card(135, 0, 0, CardType.ITEM_GREEN, 6, 5, 5, "------", 0, 0, 0));
        cards.add(new Card(136, 0, 0, CardType.ITEM_GREEN, 0, 1, 1, "------", 0, 0, 0));
        cards.add(new Card(137, 0, 0, CardType.ITEM_GREEN, 2, 0, 0, "-----W", 0, 0, 0));
        cards.add(new Card(138, 0, 0, CardType.ITEM_GREEN, 2, 0, 0, "---G--", 0, 0, 1));
        cards.add(new Card(139, 0, 0, CardType.ITEM_GREEN, 4, 0, 0, "----LW", 0, 0, 0));
        cards.add(new Card(140, 0, 0, CardType.ITEM_GREEN, 2, 0, 0, "-C----", 0, 0, 0));
        cards.add(new Card(141, 0, 0, CardType.ITEM_RED, 0, -1, -1, "------", 0, 0, 0));
        cards.add(new Card(142, 0, 0, CardType.ITEM_RED, 0, 0, 0, "BCDGLW", 0, 0, 0));
        cards.add(new Card(143, 0, 0, CardType.ITEM_RED, 0, 0, 0, "---G--", 0, 0, 0));
        cards.add(new Card(144, 0, 0, CardType.ITEM_RED, 1, 0, -2, "------", 0, 0, 0));
        cards.add(new Card(145, 0, 0, CardType.ITEM_RED, 3, -2, -2, "------", 0, 0, 0));
        cards.add(new Card(146, 0, 0, CardType.ITEM_RED, 4, -2, -2, "------", 0, -2, 0));
        cards.add(new Card(147, 0, 0, CardType.ITEM_RED, 2, 0, -1, "------", 0, 0, 1));
        cards.add(new Card(148, 0, 0, CardType.ITEM_RED, 2, 0, -2, "BCDGLW", 0, 0, 0));
        cards.add(new Card(149, 0, 0, CardType.ITEM_RED, 3, 0, 0, "BCDGLW", 0, 0, 1));
        cards.add(new Card(150, 0, 0, CardType.ITEM_RED, 2, 0, -3, "------", 0, 0, 0));
        cards.add(new Card(151, 0, 0, CardType.ITEM_RED, 5, 0, -99, "BCDGLW", 0, 0, 0));
        cards.add(new Card(152, 0, 0, CardType.ITEM_RED, 7, 0, -7, "------", 0, 0, 1));
        cards.add(new Card(153, 0, 0, CardType.ITEM_BLUE, 2, 0, 0, "------", 5, 0, 0));
        cards.add(new Card(154, 0, 0, CardType.ITEM_BLUE, 2, 0, 0, "------", 0, -2, 1));
        cards.add(new Card(155, 0, 0, CardType.ITEM_BLUE, 3, 0, -3, "------", 0, -1, 0));
        cards.add(new Card(156, 0, 0, CardType.ITEM_BLUE, 3, 0, 0, "------", 3, -3, 0));
        cards.add(new Card(157, 0, 0, CardType.ITEM_BLUE, 3, 0, -1, "------", 1, 0, 1));
        cards.add(new Card(158, 0, 0, CardType.ITEM_BLUE, 3, 0, -4, "------", 0, 0, 0));
        cards.add(new Card(159, 0, 0, CardType.ITEM_BLUE, 4, 0, -3, "------", 3, 0, 0));
        cards.add(new Card(160, 0, 0, CardType.ITEM_BLUE, 2, 0, 0, "------", 2, -2, 0));
    }

    public static Card get(int cardNumber) {
        if (cardNumber > 0 && cardNumber <= 160) {
            return cards.get(cardNumber - 1);
        }

        throw new UnsupportedOperationException("Card with this id does not exist.");
    }

    public static Card getWithInstanceId(int cardNumber, int instanceId) {
        final Card card = get(cardNumber);
        card.setInstanceId(instanceId);

        return card;
    }
}
