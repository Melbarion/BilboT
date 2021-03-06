package listeners;

import core.channelActions;
import core.databaseHandler;
import core.messageActions;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import util.CHANNEL;
import util.SET_CHANNEL;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.FALSE;


public class joinListener extends ListenerAdapter {
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {


            SET_CHANNEL set_channel = CHANNEL.getSetChannel("log", event.getGuild().getId());
            if (set_channel.getMsg()) {
                messageActions.neededChannel(event, "log");
            } else {
                TextChannel welcome1 = event.getGuild().getDefaultChannel();

                channelActions.getChannel(event, "log").sendMessage(messageActions.getLocalizedString("log_user_join", "server", event.getGuild().getId())
                        .replace("[USER]", event.getUser().getAsTag())).queue();
                if (event.getMember().getUser().isBot() == FALSE) {
                    String[] answer2 = null;
                    try {
                        answer2 = databaseHandler.database("usersettings", "select verified from users where id = '" + event.getMember().getId() + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        core.databaseHandler.database(event.getGuild().getId(), "update users set ticket = 0 where id = '" + event.getMember().getId() + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    boolean isVerifiedUser = false;
                    try {
                        assert answer2 != null;
                        if (answer2[0].toLowerCase().equals("true")) {
                            isVerifiedUser = true;
                        }
                    } catch (Exception ignored) {
                    }

                    String[] answer3 = null;
                    try {
                        answer3 = databaseHandler.database(event.getGuild().getId(), "select verifystatus from users where id = '" + event.getMember().getId() + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    boolean isVerifiedServer = false;
                    try {
                        assert answer3 != null;
                        if (answer3[0].toLowerCase().equals("true")) {
                            isVerifiedServer = true;
                        }
                    } catch (Exception ignored) {
                    }

                    if (isVerifiedUser && isVerifiedServer) {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("verified", true).get(0)).queue();
                        assert welcome1 != null;
                        welcome1.sendMessage("Mae govannen " + event.getMember().getAsMention() + "!").queue();
                    } else {
                        assert welcome1 != null;
                        welcome1.sendMessage(":flag_de: Mae govannen " + event.getMember().getAsMention() + "! Um auf den Server zugreifen zu k\u00f6nnen, musst du dich erst verifizieren. " +
                                "Klicke daf\u00fcr auf das :white_check_mark:-Emoji unter dieser Nachricht.\n\n" +
                                ":flag_gb: Mae govannen " + event.getMember().getAsMention() + "! In order to access the server, you have to verify yourself first. " +
                                "Therefore, you have to click the :white_check_mark: emoji below this message.").queueAfter(3, TimeUnit.SECONDS, msg -> msg.addReaction("\u2705").queue());
                    }

                }

        }
    }
}
