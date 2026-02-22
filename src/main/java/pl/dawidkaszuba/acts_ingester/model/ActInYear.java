package pl.dawidkaszuba.acts_ingester.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActInYear {
    private String address;
    private String publisher;
    private Integer year;
    private Integer volume;
    private Integer pos;
    private String title;
    private String displayAddress;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate promulgation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate announcementDate;
    private Boolean textPDF;
    private Boolean textHTML;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime changeDate;
    private String ELI;
    private String type;
    private String status;

}
