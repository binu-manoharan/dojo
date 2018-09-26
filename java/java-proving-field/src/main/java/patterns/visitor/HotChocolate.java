package patterns.visitor;

class HotChocolate implements Visitable {
    private double price;

    HotChocolate(double price) {
        this.price = price;
    }

    double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
