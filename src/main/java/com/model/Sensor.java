package com.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Sensor {
    public String time;
    public int id;
    public int dataUBP;
    public int dataLBP;
    public int dataPulls;
    public int dataSugar;
}
