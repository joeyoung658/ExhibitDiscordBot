package ExhibitBot.Origin.channelUpdater;

import ExhibitBot.Origin.Minecraft.minecraftServerInfo;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.managers.ChannelManager;

import java.util.TimerTask;

import static ExhibitBot.Origin.Other.Global_Variables.SERVER_IP;


public class numPlayers extends TimerTask {

    private Guild guild;
    public numPlayers(Guild guild){
        this.guild = guild;
    }

    @Override
    public void run() {
        GuildChannel guildChannel = this.guild.getGuildChannelById ("790606246797377596");
        ChannelManager channelManager = guildChannel.getManager();
        minecraftServerInfo mcpc = new minecraftServerInfo(SERVER_IP,25565);
        String channelName = "AA Online Players: " + mcpc.getOnlinePlayers();
        channelManager.setName (channelName);
        channelManager.queue();
        System.out.println("Server player count updated to " + channelName);
    }

    public Guild getGuild(){
        return this.guild;
    }
}
