package com.ht.lottery.service;

import com.ht.lottery.entity.Share;

import java.util.List;

/**
 * @author king
 */
public interface ShareService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Share share);


    Share selectByPrimaryKey(Integer id);

    Integer update(Share share);

    List<Share> listShare(Share share);
}