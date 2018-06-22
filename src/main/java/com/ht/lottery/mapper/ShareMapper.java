package com.ht.lottery.mapper;

import com.ht.lottery.entity.Share;

import java.util.List;

public interface ShareMapper {
    Integer deleteByPrimaryKey(Integer id);


    Integer insert(Share record);

    Share selectByPrimaryKey(Integer id);

    Integer update(Share record);

    List<Share> listShare(Share share);
}