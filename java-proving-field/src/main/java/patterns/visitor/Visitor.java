package patterns.visitor;

import java.text.DecimalFormat;

interface Visitor {

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    double visit(Pepsi pepsi);

    double visit(HotChocolate hotChocolate);
}
