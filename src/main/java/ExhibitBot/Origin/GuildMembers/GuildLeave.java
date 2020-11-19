package ExhibitBot.Origin.GuildMembers;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Global_Variables.USER_BANS;

/**
 * Created by josep on 14/06/2017.
 */
public class GuildLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent e){
        User user = e.getUser();
        Guild guild = e.getGuild();


        try {



            if (USER_BANS.contains(user)){
                USER_BANS.remove(user);
                Logging.DataLog(guild.getName(), user.getName(), "has been banned from the discord server! Total members now - "
                        + guild.getMembers().size(), true,guild);
                return;
            }

            Logging.DataLog( guild.getName(), user.getName() , "left the discord server! Total members now - " +
                guild.getMembers().size(), true, guild);


        }catch (PermissionException er){}
    }
}
