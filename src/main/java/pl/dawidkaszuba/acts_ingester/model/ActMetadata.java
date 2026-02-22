package pl.dawidkaszuba.acts_ingester.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(indexName = "acts-metadata")
@Setting(settingPath = "opensearch/settings.json")
public class ActMetadata {

    @Id
    private String address;
    @Field(type = FieldType.Keyword)
    private String publisher;
    @Field(type = FieldType.Integer)
    private Integer year;
    @Field(type = FieldType.Integer)
    private Integer volume;
    @Field(type = FieldType.Integer)
    private Integer pos;
    @MultiField(mainField = @Field(type = FieldType.Text, analyzer = "polish"),
            otherFields = {@InnerField(suffix = "keyword", type = FieldType.Keyword, normalizer = "lowercase_normalizer")})
    private String title;
    @Field(type = FieldType.Keyword)
    private String displayAddress;
    @Field(type = FieldType.Date)
    private LocalDate promulgation;
    @Field(type = FieldType.Date)
    private LocalDate announcementDate;
    @Field(type = FieldType.Boolean)
    private Boolean textPDF;
    @Field(type = FieldType.Boolean)
    private Boolean textHTML;
    @Field(type = FieldType.Date,
          pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime changeDate;
    @Field(type = FieldType.Keyword)
    private String eli;
    @Field(type = FieldType.Keyword)
    private String type;
    @Field(type = FieldType.Keyword)
    private String status;
}
