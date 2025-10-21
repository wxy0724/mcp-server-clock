package com.chonglou.clock.config;

import com.chonglou.clock.service.TimeAndAgeService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chonglou
 * @date 2025/10/21 9:55
 */
@Configuration
public class McpServerConfig {

    /**
     * 将工具方法暴露给外部 mcp client 调用
     *
     * @param timeAndAgeService
     * @return
     */
    @Bean
    public ToolCallbackProvider weatherTools(TimeAndAgeService timeAndAgeService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(timeAndAgeService)
                .build();
    }

}
