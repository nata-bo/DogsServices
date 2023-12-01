package org.ait.dogservices.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
@Builder
public class AllClinicsDto {
    private List<ClinicDto> clinics;
}
