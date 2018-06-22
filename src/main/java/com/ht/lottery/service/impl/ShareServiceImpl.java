package com.ht.lottery.service.impl;

import com.ht.lottery.entity.Share;
import com.ht.lottery.mapper.ShareMapper;
import com.ht.lottery.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return shareMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(Share share) {
        return shareMapper.insert(share);
    }

    @Override
    public Share selectByPrimaryKey(Integer id) {
        return shareMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(Share share) {
        return shareMapper.update(share);
    }

    @Override
    public List<Share> listShare(Share share) {
        return shareMapper.listShare(share);
    }
}
