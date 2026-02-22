package pl.dawidkaszuba.acts_ingester.service.impl;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.dawidkaszuba.acts_ingester.api.SejmApiClient;
import pl.dawidkaszuba.acts_ingester.mapper.ActInYearMapper;
import pl.dawidkaszuba.acts_ingester.mapper.PublishingHouseMapper;
import pl.dawidkaszuba.acts_ingester.model.ActsInYear;
import pl.dawidkaszuba.acts_ingester.model.PublishingHouse;
import pl.dawidkaszuba.acts_ingester.model.dto.ActInYearDto;
import pl.dawidkaszuba.acts_ingester.model.dto.PublishingHouseDto;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class SejmClient {

    private final SejmApiClient sejmApiClient;
    private final PublishingHouseMapper publishingHouseMapper;
    private final ActInYearMapper actInYearMapper;

    public List<PublishingHouseDto> getPublishingHouses() {
        try {
            List<PublishingHouse> response = sejmApiClient.getPublishingHouse();

            if (response != null) {
                return response.stream()
                        .map(publishingHouseMapper::toDto)
                        .toList();
            }

        } catch (FeignException e) {
            log.error("Error while fetching publishing houses", e);
        }
        return Collections.emptyList();
    }

    public List<ActInYearDto> getActsInYear(String publisher, Integer year) {
        try {
            ActsInYear response = sejmApiClient.getActsByPublisherAndYear(publisher, year);

            if (response != null && response.getItems() != null) {
                return response.getItems().stream()
                        .map(actInYearMapper::toDto)
                        .toList();
            }

        } catch (FeignException e) {
            log.error("Error while fetching acts in {} in year {}", publisher, year, e);
        }
        return Collections.emptyList();
    }
}
