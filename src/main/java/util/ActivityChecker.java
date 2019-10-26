package util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ActivityChecker {
    public void activity(JDA jda) throws SQLException {
        for (Guild guild : jda.getGuilds()) {

            Role role1 = null;
            Role role2 = null;
            Role role3 = null;
            Role role4 = null;
            Role role5 = null;
            Role role6 = null;
            Role role7 = null;
            Role role8 = null;

            try {
                role1 = guild.getRolesByName("Ilúvatar", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role2 = guild.getRolesByName("Vala", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role3 = guild.getRolesByName("Edhel Aglareb", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role4 = guild.getRolesByName("Maia", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role5 = guild.getRolesByName("Calaquende", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role6 = guild.getRolesByName("Moriquende", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role7 = guild.getRolesByName("Dunadan", true).get(0);
            } catch (Exception ignored) {
            }
            try {
                role8 = guild.getRolesByName("Adan", true).get(0);
            } catch (Exception ignored) {
            }

            for (Member member : guild.getMembers()) {
                if (!member.getUser().isBot() && !member.getRoles().contains(guild.getRolesByName("Vacation", true).get(0))) {
                    String[] arguments = {"users", "id = '" + member.getUser().getId() + "'", "1", "activity"};
                    String[] answer;
                    answer = core.databaseHandler.database(guild.getId(), "select", arguments);

                    long oldActivity = Long.parseLong(answer[0]);

                    List<Role> roles = member.getRoles();

                    if (!roles.contains(role1) && !roles.contains(role2)) {
                        if (roles.contains(role3)) {
                            if (oldActivity > 3600) {
                                oldActivity = 3600;
                            }
                        } else if (roles.contains(role4)) {
                            if (oldActivity > 1500) {
                                oldActivity = 1500;
                            }
                        } else if (roles.contains(role5)) {
                            if (oldActivity > 1100) {
                                oldActivity = 1100;
                            }
                        } else if (roles.contains(role6)) {
                            if (oldActivity > 720) {
                                oldActivity = 720;
                            }
                        } else if (roles.contains(role7)) {
                            if (oldActivity > 480) {
                                oldActivity = 480;
                            }
                        } else if (roles.contains(role8)) {
                            if (oldActivity > 240) {
                                oldActivity = 240;
                            }
                        }
                    }

                    long newActivity = oldActivity - 4;

                    String[] arguments2 = {"users", "id = '" + member.getUser().getId() + "'", "activity", String.valueOf(newActivity)};
                    core.databaseHandler.database(guild.getId(), "update", arguments2);

                    SET_CHANNEL set_channel = CHANNEL.getSetChannel("modlog", guild.getId());
                    TextChannel modlog = guild.getTextChannelById(set_channel.getChannel());

                    if (newActivity < 1) {
                        String url = null;
                        for (Invite inv : guild.retrieveInvites().complete()) {
                            if (!inv.isTemporary() && inv.getInviter().equals(guild.getOwner().getUser())) {
                                url = inv.getUrl();
                            }
                        }

                        if (url == null) {
                            url = guild.retrieveInvites().complete().get(0).getUrl();
                        }

                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setColor(Color.RED);
                        embed.setTitle("Kick!");
                        embed.setDescription("Du wurdest aufgrund von Inaktivit\u00e4t vom Server **" + guild.getName() + "** gekickt. Wenn du wieder joinen willst, findest du hier eine Einladung: " + url);
                        embed.setThumbnail(guild.getIconUrl());

                        EmbedBuilder embed1 = new EmbedBuilder();
                        embed1.setColor(Color.RED);
                        embed1.setTitle("Kick!");
                        embed1.setDescription(member.getAsMention() + " wurde aufgrund von Inaktivit\u00e4t gekickt.");
                        modlog.sendMessage(embed1.build()).queue();

                        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
                        channel.sendMessage(embed.build()).queue();
                        guild.kick(member, "Inaktivit\u00e4t").queue();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else if (newActivity < 30 && newActivity > 25) {

                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setColor(Color.RED);
                        embed.setTitle("Vorsicht!");
                        embed.setDescription("Aufgrund deiner Inaktivit\u00e4t k\u00f6nnte es zeitnah zum Kick vom Server **" + guild.getName() + "** kommen!");
                        embed.setThumbnail(guild.getIconUrl());

                        EmbedBuilder embed1 = new EmbedBuilder();
                        embed1.setColor(Color.RED);
                        embed1.setTitle("Verwarnung f\u00fcr Inaktivit\u00e4t");
                        embed1.setDescription(member.getUser().getAsTag() + " wurde aufgrund von Inaktivit\u00e4t verwarnt.");

                        modlog.sendMessage(embed1.build()).queue();

                        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
                        channel.sendMessage(embed.build()).queue();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}