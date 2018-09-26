package patterns.visitor;

class Pepsi implements Visitable {
    private double price;

    Pepsi(double price) {
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
