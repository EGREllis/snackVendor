package net.games.snack.util;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Util {
    public static String getMyHostName() {
        String hostname = null;
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            hostname = socket.getLocalAddress().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hostname;
    }
}
