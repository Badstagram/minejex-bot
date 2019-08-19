package badstagram.bots.minejexbot.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

public class MessageFilter extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        Message message = event.getMessage();
        String content = message.getContentRaw();
        Member member = event.getMember();
        TextChannel channel = event.getChannel();

        if (content.equalsIgnoreCase("creeper")){
            message.delete().queue();
            channel.sendMessageFormat("<@%s>, The creeper meme is not allowed here", member.getUser().getId()).queue((message1) -> {
                message1.delete().queueAfter(1, TimeUnit.MINUTES);
            });
        }

        if (content.matches("/^((?:https?:)?\\/\\/)?((?:www|m)\\.)? ((?:discord\\.gg|discordapp\\.com))/g")) {
            message.delete().queue();
            channel.sendMessageFormat("<@%s>, Do not advertise other servers!").queue();
        }
    }
}
