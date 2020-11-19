package ExhibitBot.Origin.GuildVoice;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



/**
 * Created by josep on 13/06/2017.
 */
public class VoiceLeave extends ListenerAdapter {
    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e){
        Logging.DataLog( e.getGuild().getName(), e.getMember().getUser().getName() , "left the channel " + e.getChannelLeft().getName());
    }
}
