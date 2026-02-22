package pl.dawidkaszuba.acts_ingester.service;

import pl.dawidkaszuba.acts_ingester.model.ActMetadataEvent;

public interface NotificationService {

    void notifyActMetadataReceived(ActMetadataEvent event);
}
