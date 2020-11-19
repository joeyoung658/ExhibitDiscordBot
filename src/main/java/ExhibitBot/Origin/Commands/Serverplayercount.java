package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;
import static ExhibitBot.Origin.Other.Global_Variables.SERVER_IP;

/**
 * Created by josep on 12/06/2017.
 */

//todo this is broken
public class Serverplayercount extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String message = e.getMessage().getContentRaw();

        if (message.equalsIgnoreCase(COMMAND_PREFIX + "playercount") && !(e.getAuthor().isBot())) {

            try {
                Socket sock = new Socket(SERVER_IP, 25565);

                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                DataInputStream in = new DataInputStream(sock.getInputStream());

                out.write(0xFE);

                int b;
                StringBuffer str = new StringBuffer();
                while ((b = in.read()) != -1) {
                   if (b > 1) {
                        str.append((char) b);
                  //      System.out.println((char)b);
                   }
                }

                String[] data = str.toString().split("§");

                //System.out.println(str);


                String onlinePlayers = (data[1]);
                String maxPlayers = (data[2]);

                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " There are currently " +
                        onlinePlayers + "/" + maxPlayers +  " players online on the Minecraft Server!").queue();
                try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}


            } catch (UnknownHostException ev) {
               ev.printStackTrace();
            } catch (IOException ev) {
                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " The server is currently down or restarting, please try again later.").queue();
            }
        }
    }
}