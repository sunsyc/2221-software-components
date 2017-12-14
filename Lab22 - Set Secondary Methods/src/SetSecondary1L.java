import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";
        Set<T> removed = new Set1L<>();
        for (T element : s) {
            if (this.contains(element)) {
                T removedElement = this.remove(element);
                removed.add(removedElement);
            }
        }
        return removed;
    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";
        Set<T> removed = new Set1L<>();
        for (T element : s) {
            if (!this.contains(element)) {
                this.add(element);
                removed.add(element);
            }
        }
        s.remove(removed);
    }
}