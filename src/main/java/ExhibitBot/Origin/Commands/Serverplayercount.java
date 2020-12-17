package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Minecraft.minecraftServerInfo;
import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

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
            minecraftServerInfo minecraftServerInfo = new minecraftServerInfo(SERVER_IP, 25565);
            String onlinePlayers =  minecraftServerInfo.getOnlinePlayers();
            if (onlinePlayers == null){
                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " The server is currently down or restarting, please try again later.").queue();
                return;
            }
            e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " There are currently " +
                    onlinePlayers + "/" + minecraftServerInfo.getMaxPlayers() +  " players online on " + SERVER_IP).queue();
        }
    }
}


