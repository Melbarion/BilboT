package commands;


import core.messageActions;
import core.modulesChecker;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class cmdMap implements Command {

    @Override
    public boolean called() {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws SQLException {
        String status;
        status = modulesChecker.moduleStatus("maps", event.getGuild().getId());
        if (status.equals("activated")) {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.ORANGE);
            embed.addField(messageActions.getLocalizedString("map_title", "user", event.getAuthor().getId()), "", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_arda", "user", event.getAuthor().getId()),
                    "```/map     <arda/ad0>                   \n" +
                            "/map     <arda_1/arda_zeit-vor-der-zeit/ad1>                \n" +
                            "/map     <arda_2/arda_nach-zerst\u00F6rung-der-leuchten/ad2>\n" +
                            "/map     <arda_3/arda_zeitalter-1/ad3>                   \n" +
                            "/map     <arda_4/arda_zeitalter-2/ad4>                   \n" +
                            "/map     <arda_5/arda_zeitalter-3/ad5>                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_beleriand", "user", event.getAuthor().getId()),
                    "```/map     <beleriand/b>                        ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_battle_of_beleriand", "user", event.getAuthor().getId()),
                    "```/map     <schlacht-von-beleriand_1/battle-of-beleriand_1/bb1>\n" +
                            "/map     <schlacht-von-beleriand_2/battle-of-beleriand_2/bb2>\n" +
                            "/map     <schlacht-von-beleriand_3/battle-of-beleriand_3/bb3>\n" +
                            "/map     <schlacht-von-beleriand_4/battle-of-beleriand_4/bb4>\n" +
                            "/map     <schlacht-von-beleriand_5/battle-of-beleriand_5/bb5>```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_middleearth", "user", event.getAuthor().getId()),
                    "```/map     <middle-earth/mittelerde/me>          ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_gondolin", "user", event.getAuthor().getId()),
                    "```/map     <gondolin/gd>                                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_menegroth", "user", event.getAuthor().getId()),
                    "```/map     <menegroth/mg>                                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_nargothrond", "user", event.getAuthor().getId()),
                    "```/map     <nargothrond/ng>                                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_valinor", "user", event.getAuthor().getId()),
                    "```/map     <valinor/vl>                                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_numenor", "user", event.getAuthor().getId()),
                    "```/map     <numenor/nm>                                   ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_thangorodrim", "user", event.getAuthor().getId()),
                    "```/map     <thangorodrim/thg>                              ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_arnor", "user", event.getAuthor().getId()),
                    "```/map     <arnor/ar>                                     ```", true);
            embed.addBlankField(true);
            embed.addField(messageActions.getLocalizedString("map_arnor&gondor", "user", event.getAuthor().getId()),
                    "```/map     <arnor_gondor/arg>                              ```", true);
            embed.addBlankField(true);
            EmbedBuilder embed1 = new EmbedBuilder();
            embed1.setColor(Color.ORANGE);
            embed1.addField(messageActions.getLocalizedString("map_arrival_of_the_humans", "user", event.getAuthor().getId()),
                    "```/map     <ankunft-der-menschen/arrival-of-the-humans/ah>```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_beren_and_luthien", "user", event.getAuthor().getId()),
                    "```/map     <beren_luthien/bl>                               ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_great_journey", "user", event.getAuthor().getId()),
                    "```/map     <die-gro\u00DFe-wanderung/gj>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_turin_and_nienor", "user", event.getAuthor().getId()),
                    "```/map     <turin_nienor/tn>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_battle_of_the_last_alliance", "user", event.getAuthor().getId()),
                    "```/map     <battle-of-the-last-alliance/schlacht-des-letzten-b\u00FCndnis/bla>```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_kingdom_of_human", "user", event.getAuthor().getId()),
                    "```/map     <menschenreiche-zeitalter-2/hk>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_kingdom_of_elves", "user", event.getAuthor().getId()),
                    "```/map     <elbenreiche-zeitalter-1/ek>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_war_of_wrath", "user", event.getAuthor().getId()),
                    "```/map     <krieg-des-zorns/ww>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_journey_of_noldor", "user", event.getAuthor().getId()),
                    "```/map     <reise-der-noldor/jn>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_journey_of_numenors", "user", event.getAuthor().getId()),
                    "```/map     <fahrten-der-numenorer/jnu>                    ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_immigrants_second_age", "user", event.getAuthor().getId()),
                    "```/map     <neusiedlung-fl\u00FCchtlinge-zeitalter-2/im> ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_saurons_kingdom", "user", event.getAuthor().getId()),
                    "```/map     <saurons-reich-h\u00F6hepunkt/sk>          ```", true);
            embed1.addBlankField(true);
            embed1.addField(messageActions.getLocalizedString("map_tolkien_original_map", "user", event.getAuthor().getId()),
                    "```/map     <tolkien-originalkarte/tom>                    ```", true);
            embed1.addBlankField(true);
            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setColor(Color.ORANGE);
            embed2.addField(messageActions.getLocalizedString("map_tolkien_first_map", "user", event.getAuthor().getId()),
                    "```/map     <tolkien-first-map/tolkien-erste-karte/tfm>```", true);
            embed2.addBlankField(true);
            embed2.addField(messageActions.getLocalizedString("map_time_bar", "user", event.getAuthor().getId()),
                    "```/map     <zeitstrahl/timeline/t1>                               ```\n" +
                            "```/map     <zeitstrahl2/timeline2/t2>                               ```", true);
            embed2.addBlankField(true);
            embed2.addField("WELTKARTEN",
                    "```/map     <weltkarte0/worldmap0/w0>                               ```\n" +
                            "```/map     <weltkarte1/worldmap1/w1>                               ```\n" +
                            "```/map     <weltkarte2/worldmap2/w2>                               ```\n" +
                            "```/map     <weltkarte3/worldmap3/w3>                               ```\n" +
                            "```/map     <weltkarte4/worldmap4/w4>                               ```\n" +
                            "```/map     <weltkarte5/worldmap5/w5>                               ```", true);
            embed2.addBlankField(true);
            embed2.addField("KANONKREIS",
                    "```/map     <kanonkreis/canoncircle/cc>                               ```", true);
            embed2.addBlankField(true);
            embed2.addField(messageActions.getLocalizedString("map_random", "user", event.getAuthor().getId()),
                    "```/map     <random/r>                                        ```", true);

            String map = null;

            try {
                map = args[0].toLowerCase();
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }

            assert map != null;
            if (map.equals("random") || map.equals("r")) {
                String[] search = {"arda", "beleriand", "middle-earth", "ankunft-der-menschen", "beren_luthien",
                        "die-gro\u00DFe-wanderung", "schlacht-von-beleriand_1", "schlacht-von-beleriand_2",
                        "schlacht-von-beleriand_3", "schlacht-von-beleriand_4", "schlacht-von-beleriand_5",
                        "gondolin", "menegroth", "nargothrond", "valinor", "numenor", "thangorodrim",
                        "turin_nienor", "battle-of-the-last-alliance", "arda_1", "arda_2", "arda_3", "arda_4", "arda_5",
                        "menschenreiche-zeitalter-2", "tolkien-erste-karte", "elbenreiche-zeitalter-1",
                        "krieg-des-zorns", "flucht-der-noldor", "fahrten-der-numenorer", "tolkien-originalkarte",
                        "neusiedlung-fl\u00FCchtlinge-zeitalter-2", "saurons-reich-h\u00F6hepunkt", "zeitstrahl",
                        "arnor", "arnor_gondor", "t2", "w0", "w1", "w2", "w3", "w4", "w5", "cc"};
                int random = ThreadLocalRandom.current().nextInt(0, search.length);
                map = search[random];
            }

            if (map == null) {
                if (!event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed1.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed2.build()).queue());
                }
            } else if (map.equals("arda") || map.equals("ad0")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/arda_map.gif")).queue();
            } else if (map.equals("beleriand") || map.equals("b")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/beleriand_map.jpg")).queue();
            } else if (map.equals("middle-earth") || map.equals("mittelerde") || map.equals("me")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/middle-earth_map.png")).queue();
            } else if (map.equals("ankunft-der-menschen") || map.equals("arrival-of-the-humans") || map.equals("ah")) {
                event.getTextChannel().sendFile(new File("Bilder/Wanderungen/Ankunft_der_Menschen.jpg")).queue();
            } else if (map.equals("beren_luthien") || map.equals("bl")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Beren_und_Luthien.jpg")).queue();
            } else if (map.equals("die-gro\u00DFe-wanderung") || map.equals("gj")) {
                event.getTextChannel().sendFile(new File("Bilder/Wanderungen/Die_gro\u00DFe_Wanderung.jpg")).queue();
            } else if (map.equals("schlacht-von-beleriand_1") || map.equals("battle-of-beleriand_1") || map.equals("bb1")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/Erste_Schlacht_von_Beleriand.jpg")).queue();
            } else if (map.equals("schlacht-von-beleriand_2") || map.equals("battle-of-beleriand_2") || map.equals("bb2")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/Zweite_Schlacht_von_Beleriand.jpg")).queue();
            } else if (map.equals("schlacht-von-beleriand_3") || map.equals("battle-of-beleriand_3") || map.equals("bb3")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/Dritte_Schlacht_von_Beleriand.jpg")).queue();
            } else if (map.equals("schlacht-von-beleriand_4") || map.equals("battle-of-beleriand_4") || map.equals("bb4")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/Vierte_Schlacht_von_Beleriand.jpg")).queue();
            } else if (map.equals("schlacht-von-beleriand_5") || map.equals("battle-of-beleriand_5") || map.equals("bb5")) {
                event.getTextChannel().sendFile(new File("Bilder/Beleriand/F\u00FCnfte_Schlacht_von_Beleriand.jpg")).queue();
            } else if (map.equals("gondolin") || map.equals("gd")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Gondolin.jpg")).queue();
            } else if (map.equals("menegroth") || map.equals("mg")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Menegroth.jpg")).queue();
            } else if (map.equals("nargothrond") || map.equals("ng")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Nargothrond.jpg")).queue();
            } else if (map.equals("valinor") || map.equals("vl")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Valinor.jpg")).queue();
            } else if (map.equals("numenor") || map.equals("nm")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Numenor.JPG")).queue();
            } else if (map.equals("thangorodrim") || map.equals("thg")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Thangorodrim.jpg")).queue();
            } else if (map.equals("turin_nienor") || map.equals("tn")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Turin_und_Nienor.jpg")).queue();
            } else if (map.equals("battle-of-the-last-alliance") || map.equals("schlacht-des-letzten-b\u00FCndnis") || map.equals("bla")) {
                event.getTextChannel().sendFile(new File("Bilder/Schlachten/Schlacht_des_letzten_B\u00FCndnis.jpg")).queue();
            } else if (map.equals("arda_1") || map.equals("arda_zeit-vor-der-zeit") || map.equals("ad1")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/Arda1.jpg")).queue();
            } else if (map.equals("arda_2") || map.equals("arda_nach-zerst\u00F6rung-der-leuchten") || map.equals("ad2")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/Arda2.jpg")).queue();
            } else if (map.equals("arda_3") || map.equals("arda_zeitalter-1") || map.equals("ad3")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/Arda3.jpg")).queue();
            } else if (map.equals("arda_4") || map.equals("arda_zeitalter-2") || map.equals("ad4")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/Arda4.jpg")).queue();
            } else if (map.equals("arda_5") || map.equals("arda_zeitalter-3") || map.equals("ad5")) {
                event.getTextChannel().sendFile(new File("Bilder/Arda/Arda5.jpg")).queue();
            } else if (map.equals("menschenreiche-zeitalter-2") || map.equals("hk")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Menschenreiche.jpg")).queue();
            } else if (map.equals("tolkien-erste-karte") || map.equals("tolkien-first-map") || map.equals("tfm")) {
                event.getTextChannel().sendFile(new File("Bilder/Tolkien/TolkienersteKarte.jpg")).queue();
            } else if (map.equals("elbenreiche-zeitalter-1") || map.equals("ek")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/Elbenreiche.jpg")).queue();
            } else if (map.equals("krieg-des-zorns") || map.equals("ww")) {
                event.getTextChannel().sendFile(new File("Bilder/Schlachten/Krieg_des_Zorns.jpg")).queue();
            } else if (map.equals("reise-der-noldor") || map.equals("jn")) {
                event.getTextChannel().sendFile(new File("Bilder/Wanderungen/Flucht_der_Noldor.jpg")).queue();
            } else if (map.equals("fahrten-der-numenorer") || map.equals("jnu")) {
                event.getTextChannel().sendFile(new File("Bilder/Wanderungen/Fahrten_der_Numenorer.jpg")).queue();
            } else if (map.equals("tolkien-originalkarte") || map.equals("tom")) {
                event.getTextChannel().sendFile(new File("Bilder/Tolkien/Tolkien_Originalkarte.jpg")).queue();
            } else if (map.equals("neusiedlung-fl\u00FCchtlinge-zeitalter-2") || map.equals("im")) {
                event.getTextChannel().sendFile(new File("Bilder/Wanderungen/Neusiedlung_der_Fluchtlinge_Beginn_Zweites_Zeitalter.jpg")).queue();
            } else if (map.equals("saurons-reich-h\u00F6hepunkt") || map.equals("sk")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Saurons_Hohepunkt_der_Macht.jpg")).queue();
            } else if (map.equals("zeitstrahl") || map.equals("timeline") || map.equals("t1")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/zeitstrahl.png")).queue();
            } else if (map.equals("arnor") || map.equals("ar")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/arnor.png")).queue();
            } else if (map.equals("arnor_gondor") || map.equals("arg")) {
                event.getTextChannel().sendFile(new File("Bilder/Reiche/arnor_gongor.jpg")).queue();
            } else if (map.equals("zeitstrahl2") || map.equals("timeline2") || map.equals("t2")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Zeitleiste2.jpg")).queue();
            } else if (map.equals("weltkarte0") || map.equals("worldmap0") || map.equals("w0")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte0.jpg")).queue();
            } else if (map.equals("weltkarte1") || map.equals("worldmap1") || map.equals("w1")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte1.jpg")).queue();
            } else if (map.equals("weltkarte2") || map.equals("worldmap2") || map.equals("w2")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte2.jpg")).queue();
            } else if (map.equals("weltkarte3") || map.equals("worldmap3") || map.equals("w3")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte3.jpg")).queue();
            } else if (map.equals("weltkarte4") || map.equals("worldmap4") || map.equals("w4")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte4.jpg")).queue();
            } else if (map.equals("weltkarte5") || map.equals("worldmap5") || map.equals("w5")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Weltkarte5.png")).queue();
            } else if (map.equals("kanonkreis") || map.equals("canoncircle") || map.equals("cc")) {
                event.getTextChannel().sendFile(new File("Bilder/Sonstiges/Kanonkreis.png")).queue();
            } else if (map.equals("") || map.equals(" ")) {
                if (!event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed1.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed2.build()).queue());
                }
            } else {
                if (!event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed1.build()).queue());
                    event.getAuthor().openPrivateChannel().queue((channel) ->
                            channel.sendMessage(embed2.build()).queue());
                }
            }

        } else {
            messageActions.moduleIsDeactivated(event, "maps");
        }
    }


}
