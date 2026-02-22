package pl.dawidkaszuba.acts_ingester.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.acts_ingester.model.ActMetadataEvent;
import pl.dawidkaszuba.acts_ingester.service.NotificationService;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaNotificationService implements NotificationService {

    private static final String TOPIC = "act-metadata";

    private final KafkaTemplate<String, ActMetadataEvent> kafkaTemplate;

    @Override
    public void notifyActMetadataReceived(ActMetadataEvent event) {

        try {
            kafkaTemplate.send(TOPIC, event.address(), event);
            log.debug("Act metadata sent to Kafka: {}", event.address());
        } catch (Exception e) {
            log.error("Failed to send act metadata to Kafka", e);
        }
    }

}
