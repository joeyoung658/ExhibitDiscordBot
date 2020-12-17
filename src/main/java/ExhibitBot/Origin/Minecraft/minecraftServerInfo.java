package ExhibitBot.Origin.Minecraft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Joseph Young on 17/12/2020
 * @github https://github.com/joeyoung658
 */

public class minecraftServerInfo {

    String maxPlayers;
    String onlinePlayers;
    String serverIP;
    int port;
    public minecraftServerInfo(String serverIP, int port){
        this.maxPlayers = "32";
        this.serverIP = serverIP;
        this.port = port;
    }

    public String getServerIP() {
        return serverIP;
    }

    public String getOnlinePlayers() {
        this.onlinePlayers = this.getServerPlayerCount();
        return onlinePlayers;
    }

    public String getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * @author Joseph Young
     * @return Minecraft Server Player Count
     */
    private String getServerPlayerCount(){
        try {
            Socket sock = new Socket(this.serverIP, 25565);

            DataOutputStream out = new DataOutputStream(sock.getOutputStream());
            DataInputStream in = new DataInputStream(sock.getInputStream());

            out.write(0xFE);

            int b;
            StringBuffer str = new StringBuffer();
            while ((b = in.read()) != -1) {
                if (b > 1) {
                    str.append((char) b);
                    //System.out.println((char)b);
                }
            }
            String lastFive = str.toString().substring(str.length()- 5);
            String[] data = lastFive.split("§");
            String onlinePlayers = data[0];

            if (onlinePlayers.isEmpty()){
                onlinePlayers = data[1];
            }
            return onlinePlayers;

        } catch (UnknownHostException ev) {
            ev.printStackTrace();
            return null;
        } catch (IOException ev) {
            return null;
        }

    }
}
