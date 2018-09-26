package patterns.visitor;

interface Visitable {
    double accept(Visitor visitor);
}
