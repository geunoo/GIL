package com.example.hexagonalfeed.common.config;

import com.example.hexagonalfeed.common.annotation.ReadOnlyUseCase;
import com.example.hexagonalfeed.common.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.example.hexagonalfeed"},
        includeFilters = {
                @Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                UseCase.class,
                                ReadOnlyUseCase.class
                        }
                )
        }
)
public class AnnotationComponentConfig {
}
