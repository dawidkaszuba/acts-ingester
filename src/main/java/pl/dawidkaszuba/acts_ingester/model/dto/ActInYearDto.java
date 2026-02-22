package pl.dawidkaszuba.acts_ingester.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActInYearDto {
    private String address;
    private String publisher;
    private Integer year;
    private Integer volume;
    private Integer pos;
    private String title;
    private String displayAddress;
    private LocalDate promulgation;
    private LocalDate announcementDate;
    private Boolean textPDF;
    private Boolean textHTML;
    private LocalDateTime changeDate;
    private String ELI;
    private String type;
    private String status;
}
