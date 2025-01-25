package com.tharuntech.Demo_MicroServ1.entity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorantBundleInfo {

    //parsed ValorantAPIResponse is stored here
    private String uuid;
    private String displayName;
    private String displayIcon;
    private String verticalPromoImage;
    @JsonIgnore
    private String displayNameSubText;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String extraDescription;
    @JsonIgnore
    private String promoDescription;
    @JsonIgnore
    private String useAdditionalContext;
    @JsonIgnore
    private String displayIcon2;
    @JsonIgnore
    private String logoIcon;
    @JsonIgnore
    private String assetPath;
}
