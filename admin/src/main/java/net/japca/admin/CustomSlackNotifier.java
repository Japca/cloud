package net.japca.admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceDeregisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.SlackNotifier;

/**
 * Created by Jakub krhovják on 4/23/19.
 */
public class CustomSlackNotifier extends SlackNotifier {

    public CustomSlackNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected boolean shouldNotify(InstanceEvent event, Instance instance) {
        boolean shouldNotify = super.shouldNotify(event, instance);
        if (event instanceof InstanceDeregisteredEvent) {
            return true;
        }
        return shouldNotify;
    }

//    @Override
//    protected String getText(InstanceEvent event, Instance instance) {
//        Map<String, Object> root = new HashMap<>();
//        root.put("event", event);
//        root.put("instance", instance);
//        root.put("lastStatus", getLastStatus(event.getInstance()));
//        StandardEvaluationContext context = new StandardEvaluationContext(root);
//        context.addPropertyAccessor(new MapAccessor());
//        return message.getValue(context, String.class);
//    }
}
