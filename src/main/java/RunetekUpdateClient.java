import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @since 11/21/2017
 */
class RunetekUpdateClient extends WebSocketClient {
    private final OldSchoolRelease release;

    RunetekUpdateClient(final OldSchoolRelease release) {
        super(URI.create(ExampleListener.WEBSOCKET_ENDPOINT));
        this.release = release;
    }

    public void onOpen(final ServerHandshake serverHandshake) {
        System.out.println("CONNECTED");
    }

    public void onMessage(final String s) {
        final int rev = Integer.parseInt(s);
        release.setCurrent(rev);
    }

    public void onClose(final int i, final String s, final boolean b) {
        System.out.println("CLOSED");
    }

    public void onError(final Exception e) {
        System.err.println("ERROR!");
        System.err.println(e.getMessage());
        e.printStackTrace();
    }
}
