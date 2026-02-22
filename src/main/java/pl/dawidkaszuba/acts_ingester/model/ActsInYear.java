package pl.dawidkaszuba.acts_ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActsInYear {
    private List<ActInYear> items;
}
