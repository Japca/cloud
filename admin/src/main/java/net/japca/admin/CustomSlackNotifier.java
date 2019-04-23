package net.japca.admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceDeregisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.SlackNotifier;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jakub krhovják on 4/23/19.
 */
public class CustomSlackNotifier extends SlackNotifier {

    private static final String DEFAULT_MESSAGE = "*#{instance.registration.name}* (#{instance.id}) is *#{event.statusInfo.status}*";

    private static final String DEREGISTER_MESSAGE = "*#{instance.registration.name}* (#{instance.id}) is *OFFLINE*";

    private ExpressionParser parser  = new SpelExpressionParser();

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

    @Override
    protected String getText(InstanceEvent event, Instance instance) {
        Map<String, Object> root = new HashMap<>();
        root.put("event", event);
        root.put("instance", instance);
        root.put("lastStatus", getLastStatus(event.getInstance()));
        StandardEvaluationContext context = new StandardEvaluationContext(root);
        context.addPropertyAccessor(new MapAccessor());
        if (event instanceof InstanceStatusChangedEvent) {
            return parser.parseExpression(DEFAULT_MESSAGE, ParserContext.TEMPLATE_EXPRESSION).getValue(context, String.class);
        }
        return parser.parseExpression(DEREGISTER_MESSAGE, ParserContext.TEMPLATE_EXPRESSION).getValue(context, String.class);
    }
}
