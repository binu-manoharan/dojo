public class PlayWithGenerics<T> {
    public static void main(String[] args) {
        PlayWithGenerics game = new PlayWithGenerics();
        System.out.println(game.print(new Integer(10)));
        System.out.println(game.print(new Boolean(true)));
    }

    T print(T t) {
        return t;
    }
}
