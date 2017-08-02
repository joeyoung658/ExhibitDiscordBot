package ExhibitBot.Origin.GuildMembers;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by josep on 14/06/2017.
 */
public class NickChange extends ListenerAdapter {
    @Override
    public void onGuildMemberNickChange(GuildMemberNickChangeEvent e){
        String newnick = e.getNewNick();
        String oldnick = e.getPrevNick();

        if (oldnick == null) {
            oldnick = e.getMember().getUser().getName();
        }

        if (newnick == null) {
            Logging.DataLog(e.getGuild().getName(),  e.getMember().getUser().getName()   , " Removed nick: Old -  " + oldnick, true, e.getGuild() );
        } else {
            Logging.DataLog(e.getGuild().getName(),  e.getMember().getUser().getName()   , " Changed nick: New -  " + newnick
                    + " Old -  "  + oldnick, true, e.getGuild());
        }

    }
}
