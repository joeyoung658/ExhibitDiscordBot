package ExhibitBot.Origin.GuildMembers;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by josep on 14/06/2017.
 */
public class GuildLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent e){
        Logging.DataLog( e.getGuild().getName(), e.getMember().getUser().getName() , "left the discord server! Total members - " +
                e.getGuild().getMembers().size(), true, e.getGuild());
    }
}
