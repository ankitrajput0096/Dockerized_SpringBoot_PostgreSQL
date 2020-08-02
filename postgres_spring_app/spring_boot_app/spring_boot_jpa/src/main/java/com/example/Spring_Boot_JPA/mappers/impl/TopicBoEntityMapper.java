package com.example.Spring_Boot_JPA.mappers.impl;

import com.example.Spring_Boot_JPA.entity.Topic;
import com.example.Spring_Boot_JPA.mappers.BoEntityMapperIface;
import org.springframework.stereotype.Service;

@Service
public class TopicBoEntityMapper implements BoEntityMapperIface<com.example.Spring_Boot_JPA.bo.TopicBo, Topic> {

    @Override
    public com.example.Spring_Boot_JPA.bo.TopicBo toBo(Topic topic) {
        return com.example.Spring_Boot_JPA.bo.TopicBo.builder()
                .id(topic.getId())
                .name(topic.getName())
                .description(topic.getDescription())
                .build();
    }

    @Override
    public Topic toEntity(com.example.Spring_Boot_JPA.bo.TopicBo topicBo) {
        return new Topic(topicBo.getId(), topicBo.getName(), topicBo.getDescription());
    }

}
