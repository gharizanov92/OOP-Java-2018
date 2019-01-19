public interface Callback<T extends Comparable<? super T>> {
    void action(T arg);
}
