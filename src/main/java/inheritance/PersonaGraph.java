package inheritance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.util.Timer;

/**
 * Created by maninder on 10/8/17.
 */
public class PersonaGraph extends QueueData {

    @Override
    protected JsonNode getBatchData(ArrayNode events) {
        ObjectNode nodes = JsonNodeFactory.instance.objectNode();
        nodes.put("personagraph",events);
        return nodes;
    }

    PersonaGraph()
    {
        Timer timer = new Timer("LoggingServiceTimerpersona", true);
        timer.scheduleAtFixedRate(timerTask, 1000*3, 3 * 1000);
    }


}
