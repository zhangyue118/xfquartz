package com.netintech.xfquartz.cfgbeans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zhangyue
 * @date: 2019/1/9 13:44
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "project-params")
@Component
public class ProjectParamsConfig {

    private Integer admin;

    private Integer adminRole;

    private String saveFilePath;

    private String filePath;
}
