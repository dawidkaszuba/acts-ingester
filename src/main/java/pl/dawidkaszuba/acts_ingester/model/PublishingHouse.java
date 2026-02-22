package pl.dawidkaszuba.acts_ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublishingHouse {
    private String code;
    private String shortName;
    private String name;
    private Integer actsCount;
    private List<Integer> years;
}
