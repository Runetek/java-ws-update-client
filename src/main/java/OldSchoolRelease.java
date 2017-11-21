import java.util.Observable;

/**
 * @since 11/21/2017
 */
class OldSchoolRelease extends Observable {
    private int current = -1;

    OldSchoolRelease() {}

    public int getCurrent() {
        return current;
    }

    public void setCurrent(final int revision) {
        if (revision < current) {
            throw new IllegalArgumentException(String.format("Trying to set current revision to %d which is less than %d", revision, current));
        }

        current = revision;
        dispatch();
    }

    private void dispatch() {
        setChanged();
        notifyObservers(current);
    }
}
