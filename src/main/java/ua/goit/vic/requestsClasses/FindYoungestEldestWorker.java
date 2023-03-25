package ua.goit.vic.requestsClasses;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString

public class FindYoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate birthday;
}
