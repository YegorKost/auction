package com.yegor.service.config;

import com.yegor.dal.config.DataAccessLayerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by YegorKost on 02.05.2017.
 */
@Configuration
@ComponentScan(value = "com.yegor.service.serviceImpl")
@Import(DataAccessLayerConfiguration.class)
public class BusinessLayerConfiguration {
}
