package ua.goit.vic.requestsClasses;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class PrintProjectPrices {
    private String id;
    private int price;
}
