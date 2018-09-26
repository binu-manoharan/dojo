public class PlayWithGenerics<T> {
    public static void main(String[] args) {
        PlayWithGenerics game = new PlayWithGenerics();
        System.out.println(game.print(10));
        System.out.println(game.print(true));
    }

    T print(T t) {
        return t;
    }
}
