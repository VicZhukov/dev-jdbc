package ua.goit.vic.requestsClasses;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class FindMaxProjectsClient {
    private String name;
    private int count;
}
