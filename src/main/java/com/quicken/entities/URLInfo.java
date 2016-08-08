package com.quicken.entities;

import com.quicken.common.core.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by bbose on 8/1/16.
 */
@Entity
@Data
public class URLInfo extends BaseEntity {

    private String urlname;
    private String urllink;
    private String platform;
}
