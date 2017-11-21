/**
 * @since 11/21/2017
 */
public class ExampleListener {
    public static final String WEBSOCKET_ENDPOINT = "wss://updates.runetek.io";

    public static void main(String[] args) {
        final OldSchoolRelease release = new OldSchoolRelease();
        release.addObserver((o, arg) -> {
            if (release.equals(o) && arg instanceof Integer) {
                System.out.printf("New release: %d\n", (Integer) arg);
            }
        });

        final RunetekUpdateClient client = new RunetekUpdateClient(release);
        client.run();
    }
}
