package inheritance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.util.TimerTask;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by maninder on 10/8/17.
 *
 */
abstract class QueueData {

    private static final int FLUSH_LIMIT = 3;
    final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            sendQueueAsync();
        }
    };

    private final LinkedTransferQueue<JsonNode> queue = new LinkedTransferQueue<>();

    void pushData(JsonNode node)
    {
        System.out.println("Pushing "+node.toString());
        queue.put(node);
    }

    protected abstract JsonNode getBatchData(ArrayNode events);

    private void sendQueueAsync() {
        if (!queue.isEmpty()) {
            ArrayNode events = JsonNodeFactory.instance.arrayNode();

            JsonNode node = queue.poll();
            int i = 0;
            while (node != null) {
                i++;
                events.add(node);
                if (i == FLUSH_LIMIT) {

                    JsonNode finalNode = getBatchData(events);
                    System.out.println(finalNode.toString());
                    i = 0;
                    events.removeAll();
                }
                node =  queue.poll();
            }
            if (events.size() > 0) {
                JsonNode finalNode = getBatchData(events);
                System.out.println(finalNode.toString());
            }
        }
        else {
            System.out.println("Queue is empty "+this.getClass().getSimpleName());
        }
    }



}


