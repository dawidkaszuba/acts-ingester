package pl.dawidkaszuba.acts_ingester.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dawidkaszuba.acts_ingester.model.ActsInYear;
import pl.dawidkaszuba.acts_ingester.model.PublishingHouse;

import java.util.List;

@FeignClient(name = "sejmApiClient", url = "#{sejm.api.url")
public interface SejmApiClient {

    @GetMapping("/acts")
    List<PublishingHouse> getPublishingHouse();

    @GetMapping("/acts/{publisher}/{year}")
    ActsInYear getActsByPublisherAndYear(@PathVariable("publisher") String publisher,
                                               @PathVariable("year") Integer year);
}
