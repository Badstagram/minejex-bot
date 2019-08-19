package badstagram.bots.minejexbot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Nonnull;

public class readyListener extends ListenerAdapter {
    static Logger logger = LoggerFactory.getLogger(readyListener.class);
    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        User selfUser  = event.getJDA().getSelfUser();

        logger.info(String.format("Logged in as %s#%s (ID: %s)", selfUser.getName(), selfUser.getDiscriminator(),
                                 selfUser.getId()));

    }
}
