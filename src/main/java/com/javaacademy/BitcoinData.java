package com.javaacademy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinData {
    private String disclaimer;
    private String chartName;
    private Bpi bpi;
}
