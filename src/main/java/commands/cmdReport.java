package commands;

import core.messageActions;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import util.CHANNEL;
import util.SET_CHANNEL;

import java.awt.*;
import java.sql.SQLException;

public class cmdReport implements Command {
    @Override
    public boolean called() {
        return false;
    }

    @Override
    public void action(String[] args, GuildMessageReceivedEvent event) throws SQLException {

            SET_CHANNEL set_channel = CHANNEL.getSetChannel("modlog", event.getGuild().getId());
            if (set_channel.getMsg()) {
                messageActions.neededChannel(event);
            } else {
                TextChannel modlog = event.getGuild().getTextChannelById(set_channel.getChannel());

                StringBuilder sb = new StringBuilder();
                int lenght = args.length;
                int i = 1;
                if (lenght >= 2) {
                    while (i < lenght) {
                        sb.append(args[i]);
                        sb.append(" ");
                        i++;
                    }
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setColor(Color.RED);
                    embed.setTitle(messageActions.getLocalizedString("report_title", "server", event.getGuild().getId()));
                    embed.setDescription(messageActions.getLocalizedString("report_msg", "server", event.getGuild().getId())
                            .replace("[USER]", event.getAuthor().getAsMention()).replace("[REPORTED_USER]", args[0])
                            .replace("[REASON]", sb.toString()));
                    assert modlog != null;
                    modlog.sendMessage(embed.build()).queue();
                } else {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.red);
                    error.setTitle(messageActions.getLocalizedString("report_syntax", "user", event.getAuthor().getId()));
                    error.setDescription(messageActions.getLocalizedString("report_help", "user", event.getAuthor().getId()));
                    event.getChannel().sendMessage(error.build()).queue();
                }
            }



    }


}
