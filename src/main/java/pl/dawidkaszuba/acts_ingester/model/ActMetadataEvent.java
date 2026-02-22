package pl.dawidkaszuba.acts_ingester.model;

public record ActMetadataEvent(String address,
                               Integer year,
                               Boolean textPDF,
                               Boolean textHTML,
                               String changeDate) {}
