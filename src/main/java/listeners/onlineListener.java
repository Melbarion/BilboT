package listeners;

import core.messageActions;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import util.CHANNEL;
import util.SET_CHANNEL;

public class onlineListener extends ListenerAdapter {
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {

        SET_CHANNEL set_channel = CHANNEL.getSetChannel("log", event.getGuild().getId());
        if (set_channel.getMsg()) {
            messageActions.neededChannel(event, "log");
        } else {
            TextChannel log = event.getGuild().getTextChannelById(set_channel.getChannel());

            assert log != null;
            log.sendMessage(messageActions.getLocalizedString("log_user_changed_status", "server", event.getGuild().getId())
                    .replace("[USER]", event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator())
                    .replace("[OLD-STATUS]", event.getOldOnlineStatus().getKey()).replace("[NEW-STATUS]", event.getNewOnlineStatus().getKey())).queue();
        }
    }
}



