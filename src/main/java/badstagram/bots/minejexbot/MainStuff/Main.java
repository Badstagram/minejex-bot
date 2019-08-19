package badstagram.bots.minejexbot.MainStuff;

import badstagram.bots.minejexbot.Config.BotConfig;
import badstagram.bots.minejexbot.Config.secrets;
import badstagram.bots.minejexbot.listeners.MessageFilter;
import badstagram.bots.minejexbot.listeners.MessageListener;
import badstagram.bots.minejexbot.listeners.readyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Attempting to log in!");
        try {
            JDA api = new JDABuilder(secrets.DISCORD)
                    .setActivity(Activity.playing(BotConfig.VERSION))
                    .addEventListeners(new readyListener())
                    .addEventListeners(new MessageListener())
                    .addEventListeners(new MessageFilter())
                    .build().awaitReady();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } catch (LoginException e) {
            logger.error(e.getMessage());
        }
    }
}
