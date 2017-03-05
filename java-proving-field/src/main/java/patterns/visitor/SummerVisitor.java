package patterns.visitor;

import static java.lang.Double.*;

class SummerVisitor implements Visitor {

    private static final double HOT_CHOCOLATE_SUMMER_RATE_MODIFIER = 0.75;
    private static final int PEPSI_SUMMER_RATE_MODIFIER = 2;

    @Override
    public double visit(Pepsi pepsi) {
        return parseDouble(decimalFormat.format(pepsi.getPrice() * PEPSI_SUMMER_RATE_MODIFIER));
    }

    @Override
    public double visit(HotChocolate hotChocolate) {
        return parseDouble(decimalFormat.format(hotChocolate.getPrice() * HOT_CHOCOLATE_SUMMER_RATE_MODIFIER));
    }
}
