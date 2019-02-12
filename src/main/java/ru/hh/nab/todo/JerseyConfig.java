package ru.hh.nab.todo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Resource.class)
public class JerseyConfig {
}
