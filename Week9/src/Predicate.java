import java.util.Objects;

@FunctionalInterface
public interface Predicate<T extends Comparable<? super Number>> {

    boolean test(T x);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }
}
