package fr.epita.assistants.loggingbasics;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Trombinoscope {
    private final Logger LOGGER;
    private final HashMap<String, Long> map;

    public Trombinoscope() {
        LOGGER = (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        LOGGER.setLevel(Level.TRACE);
        // FIXME: Instantiate logger with level TRACE

        // FIXME: Add logging here
        LOGGER.trace("Instantiating new Trombinoscope");
        map = new HashMap<>();

    }

    public Long putPerson(String name, long photoId) {
        // FIXME: Add logging here

        LOGGER.setLevel(Level.DEBUG);
        LOGGER.debug("Putting person (\"" + name + "\", " + photoId + ")");
        if (map.containsKey("Bob"))
        {
            LOGGER.setLevel(Level.TRACE);
            LOGGER.trace("Updated entry for person \"" + name + "\"");
        }
        else
        {
            LOGGER.setLevel(Level.TRACE);
            LOGGER.trace("Added entry for person \"" + name + "\"");
        }
        Long oldPhotoId = map.put(name,
                                  photoId);
        // FIXME: Add logging here

        return oldPhotoId;
    }
}
