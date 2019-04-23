package net.japca.admin;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Jakub krhovják on 4/22/19.
 */

@Configuration
public class NotificationConfiguration {

//    @Autowired
//    private SlackNotifier notifier;
//
//    @Bean
//    public SlackNotifier slackNotifier() {
////        notifier.set
//
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        slackNotifier.setRestTemplate(new RestTemplate(requestFactory));
//        return slackNotifier;
////    }
//
//    @Primary
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public RemindingNotifier remindingNotifier() {
//        RemindingNotifier notifier = new RemindingNotifier(notifier, repository);
//        notifier.setReminderPeriod(Duration.ofMinutes(10));
//        notifier.setCheckReminderInverval(Duration.ofSeconds(10));
//        return notifier;
//    }

}
