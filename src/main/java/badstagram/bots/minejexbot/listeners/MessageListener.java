package badstagram.bots.minejexbot.listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import badstagram.bots.minejexbot.Config.BotConfig;
import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        String content = event.getMessage().getContentRaw();
        String[] args = content.split("\\s+");

        if (content.equalsIgnoreCase(BotConfig.PREFIX + "ping")) {
            event.getChannel().sendMessage("Ping!").queue((message) -> {
                message.editMessageFormat("Pong! `%sms`", event.getJDA().getGatewayPing()).queue();
            });

        } else if (content.equalsIgnoreCase(BotConfig.PREFIX + "shutdown")) {

            if (event.getAuthor().getIdLong() == BotConfig.OWNERID) {
                    event.getJDA().shutdown();
                }

            } else {
                event.getChannel().sendMessageFormat("<@%s>, You do not have permission to run this command", event.getAuthor().getId()).queue((message) -> {
                  message.delete().queueAfter(1, TimeUnit.MINUTES);
                });
            }
        }
    }

