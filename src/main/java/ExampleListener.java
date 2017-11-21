/**
 * @since 11/21/2017
 */
public class ExampleListener {
    public static void main(String[] args) {
        new RunetekUpdateClient(release -> {
            System.out.println("New Release: " + release);
        }).run();
    }
}
