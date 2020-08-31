package com.dhcc.entity.hb;

import lombok.Data;

import java.io.Serializable;

/**
 * (FinishedData)实体类
 *
 * @author makejava
 * @since 2020-05-19 18:25:57
 */
@Data
public class FinishedData implements Serializable {
    private static final long serialVersionUID = -10739132853971353L;
    
    private Long id;
    
    private String year;
    
    private String cityName;
    
    private Float qdm;
    
    private Float ddm;
    
    private Float total;
    
    private String districtCode;

}