/*
 * @Author: hujiayucc
 * @Date: 2022-08-16 03:11:03
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean("xlz")
    public Executor myTaskAsyncPool() {
        /**
         * corePoolSize：线程池维护线程的最少数量
         * keepAliveSeconds：允许的空闲时间
         * maxPoolSize：线程池维护线程的最大数量
         * queueCapacity：缓存队列
         * rejectedExecutionHandler：对拒绝task的处理策略
         */
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程池维护线程的最少数量
        executor.setCorePoolSize(30);
        // 线程池维护线程的最大数量
        executor.setMaxPoolSize(30);
        // 设置线程池中任务的等待时间
        executor.setAwaitTerminationSeconds(1);
        // 线程池所使用的缓冲队列
        executor.setQueueCapacity(10000);
        // 线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(5);
        // 线程池的前缀名称
        executor.setThreadNamePrefix("xlz-Thread-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
