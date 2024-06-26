package com.cristianbyte.hire_hub_jpa_dto.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyToVacantResponse {
    private String id;
    private String name;
    private String location;
    private String contact;
}
