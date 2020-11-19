package ExhibitBot.Origin.GuildVoice;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



/**
 * Created by josep on 13/06/2017.
 */
public class VoiceJoin extends ListenerAdapter {
    public void onGuildVoiceJoin(GuildVoiceJoinEvent e){
        Logging.DataLog( e.getGuild().getName(), e.getMember().getUser().getName() , "joined the channel " + e.getChannelJoined().getName());
    }
}