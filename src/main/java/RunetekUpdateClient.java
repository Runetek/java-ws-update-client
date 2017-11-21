import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @since 11/21/2017
 */
class RunetekUpdateClient extends WebSocketClient {
    private static final String WEBSOCKET_ENDPOINT = "wss://updates.runetek.io";

    public interface Listener {
        void onReleaseChanged(int release);
    }

    private final Listener listener;

    private int current = -1;

    RunetekUpdateClient(final Listener listener) {
        super(URI.create(WEBSOCKET_ENDPOINT));
        this.listener = listener;
    }

    public void onOpen(final ServerHandshake serverHandshake) {
        System.out.println("CONNECTED");
    }

    public void onMessage(final String s) {
        final int rev = Integer.parseInt(s);
        if (rev > current) {
            current = rev;
            dispatch();
        }
    }

    private void dispatch() {
        listener.onReleaseChanged(current);
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
