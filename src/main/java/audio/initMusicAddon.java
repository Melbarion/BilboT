package audio;

import com.neovisionaries.ws.client.WebSocketFactory;
import commands.cmdBotinfo;
import core.commandHandler;
import listeners.commandsListener;
import listeners.readyListener;
import listeners.voiceListenerAddon;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

class initMusicAddon extends ListenerAdapter {
    private static JDABuilder builder;

    static void main(String token, String[] args, MessageReceivedEvent event, EmbedBuilder embed, VoiceChannel userVoiceChannel) throws InterruptedException {

        WebSocketFactory ws = new WebSocketFactory();
        ws.setVerifyHostname(false);

        builder = new JDABuilder(AccountType.BOT);
        builder.setWebsocketFactory(ws);
        builder.setToken(token);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.of(Activity.ActivityType.DEFAULT, " \u266A"));

        addListeners();
        addCommands();

        JDA jda = null;

        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        assert jda != null;
        jda.awaitReady();

        TextChannel textChannel = null;
        Member member = null;
        Message message = null;
        Guild guild = null;
        VoiceChannel voiceChannel = null;

        try {
            textChannel = jda.getTextChannelById(event.getTextChannel().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            member = jda.getGuildById(event.getGuild().getId()).getMember(jda.getUserById(event.getAuthor().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            message = jda.getGuildById(event.getGuild().getId()).getTextChannelById(event.getTextChannel().getId()).retrieveMessageById(event.getMessage().getId()).complete();
            jda.getTextChannelById(event.getTextChannel().getId()).retrieveMessageById(event.getMessageId()).complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            guild = jda.getGuildById(event.getGuild().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            voiceChannel = jda.getVoiceChannelById(userVoiceChannel.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        PlayerControl pc = new PlayerControl();
        pc.musicPlayer(textChannel, member, message, guild, args, embed, voiceChannel);
    }

    private static void addCommands() {
        commandHandler.commands.put("botinfo", new cmdBotinfo());
        commandHandler.commands.put("music", new PlayerControl());
    }

    private static void addListeners() {
        builder.addEventListeners(new readyListener());
        builder.addEventListeners(new voiceListenerAddon());
        builder.addEventListeners(new commandsListener());
    }
}
