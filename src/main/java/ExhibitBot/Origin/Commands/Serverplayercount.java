package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Minecraft.minecraftServerInfo;
import ExhibitBot.Origin.channelUpdater.numPlayers;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Timer;

import static ExhibitBot.Origin.Other.Global_Variables.*;

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
            if (allAceGuild == null){
                allAceGuild = e.getGuild();
                Timer taskNum = new Timer();
                taskNum.scheduleAtFixedRate(new numPlayers(e.getGuild()),1000, 300000);
            }
            if (onlinePlayers == null){
                e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " The server is currently down or restarting, please try again later.").queue();
                return;
            }
            e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " There are currently " +
                    onlinePlayers + "/" + minecraftServerInfo.getMaxPlayers() +  " players online on " + SERVER_IP).queue();
        }
    }
}