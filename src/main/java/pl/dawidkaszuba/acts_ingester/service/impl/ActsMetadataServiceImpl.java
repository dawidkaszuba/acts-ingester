package pl.dawidkaszuba.acts_ingester.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.acts_ingester.mapper.ActInYearMapper;
import pl.dawidkaszuba.acts_ingester.model.dto.ActInYearDto;
import pl.dawidkaszuba.acts_ingester.model.dto.PublishingHouseDto;
import pl.dawidkaszuba.acts_ingester.service.ActsMetadataService;
import pl.dawidkaszuba.acts_ingester.service.NotificationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActsMetadataServiceImpl implements ActsMetadataService {

    private final SejmClient sejmClient;
    private final NotificationService notificationService;
    private final ActInYearMapper actInYearMapper;

    @Override
    public void fetchAllActsMetadata() {
        List<PublishingHouseDto> publisherHouses = sejmClient.getPublishingHouses();

        publisherHouses.forEach(house -> {

            String houseCode = house.getCode();
            List<Integer> years = house.getYears();

            years.forEach(year -> {
                List<ActInYearDto> actInYears = sejmClient.getActsInYear(houseCode, year);
                actInYears.forEach(act -> {
                    //load metadata to OpenSearch
                    notificationService.notifyActMetadataReceived(actInYearMapper.toEvent(act));
                });
            });

        });
    }
}
