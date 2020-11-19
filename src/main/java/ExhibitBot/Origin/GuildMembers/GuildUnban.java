package ExhibitBot.Origin.GuildMembers;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



/**
 * Created by josep on 11/10/2017.
 */
public class GuildUnban extends ListenerAdapter {
    @Override
    public void onGuildUnban(GuildUnbanEvent e) {
        User user = e.getUser();
        Guild guild = e.getGuild();

        try {
            Logging.DataLog( e.getGuild().getName(), user.getName()
                    , "has been unbanned from the discord server!", true, guild);

        }catch (PermissionException er){}
    }
}
