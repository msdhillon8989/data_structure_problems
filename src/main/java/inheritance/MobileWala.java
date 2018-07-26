package inheritance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pokkt.lang.DurationConstants;

import java.util.Timer;

/**
 * Created by maninder on 10/8/17.
 */
public class MobileWala extends QueueData {

    @Override
    protected JsonNode getBatchData(ArrayNode events) {
        ObjectNode nodes = JsonNodeFactory.instance.objectNode();
        nodes.put("mobileWala",events);

        return nodes;
    }



    MobileWala()
    {
        Timer timer = new Timer("LoggingServiceTimer", true);
        timer.scheduleAtFixedRate(timerTask, DurationConstants.MilliSeconds.ONE_SECOND*3, 3 * DurationConstants.MilliSeconds.ONE_SECOND);

    }


}
