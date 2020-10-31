package com.shit.code.cloud.infrastructure.security.service;

import com.shit.code.cloud.infrastructure.security.dao.entity.ShiroConceptEntity;

/**
 * shiro实体的操作service
 *
 * @author Anthony
 * @date 10/31/20
 **/
public interface ShiroConceptService {
    /**
     * 插入一条数据
     *
     * @param shiroConceptEntity
     * @return
     */
    ShiroConceptEntity save(ShiroConceptEntity shiroConceptEntity);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    ShiroConceptEntity deleteById(final int id);

    ShiroConceptEntity findById(final int id);

    ShiroConceptEntity updateById(ShiroConceptEntity shiroConceptEntity);
}
