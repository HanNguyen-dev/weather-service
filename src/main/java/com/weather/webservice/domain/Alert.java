package com.weather.webservice.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    public String sender_name;
    public String event;
    public Integer start;
    public Integer end;
    public String description;
    public List<String> tags;
}
