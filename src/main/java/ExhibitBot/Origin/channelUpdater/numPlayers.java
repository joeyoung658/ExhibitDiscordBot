package ExhibitBot.Origin.channelUpdater;

import ExhibitBot.Origin.Minecraft.minecraftServerInfo;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.managers.ChannelManager;

import java.util.TimerTask;

import static ExhibitBot.Origin.Other.Global_Variables.SERVER_IP;

public class numPlayers extends TimerTask {
    @Override
    public void run() {

// Created by BQ on 29/07/2017.



        AuditLogEntry e = null;
        GuildChannel guildChannel = e.getGuild().getGuildChannelById ("789203860836581416");
        ChannelManager channelManager = guildChannel.getManager();
        minecraftServerInfo mcpc = new minecraftServerInfo(SERVER_IP,25565);
        channelManager.setName ("Online Players: " + mcpc.getOnlinePlayers());
        channelManager.queue();
        
    }



}
