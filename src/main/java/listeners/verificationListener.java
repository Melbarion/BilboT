package listeners;

import core.databaseHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.Objects;

public class verificationListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (Objects.equals(event.getGuild().getDefaultChannel(), event.getChannel())) {
            Message msg;
            msg = event.getGuild().getDefaultChannel().retrieveMessageById(event.getMessageId()).complete();
            if (event.getChannel().getName().toLowerCase().contains("willkommen") && msg.getContentRaw().contains(Objects.requireNonNull(event.getUser()).getAsMention()) && event.getReactionEmote().equals(MessageReaction.ReactionEmote.fromUnicode("\u2705", event.getJDA()))) {
                try {
                    databaseHandler.database("usersettings", "update users set verified = TRUE where id = '" + event.getUserId() + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                for (Guild guild : event.getUser().getMutualGuilds()) {
                    try {
                        databaseHandler.database(guild.getId(), "update users set verifystatus = TRUE where id = '" + event.getUserId() + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (!Objects.requireNonNull(guild.getMember(event.getUser())).getRoles().contains(guild.getRolesByName("exil", true).get(0))) {
                        try {
                            guild.addRoleToMember(Objects.requireNonNull(guild.getMemberById(event.getUserId())), guild.getRolesByName("verified", true).get(0)).queue();
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
    }
}
