package com.ruoyi.project.system.user.service;

import com.ruoyi.project.system.user.domain.AttachFileNumber;
import com.ruoyi.project.system.user.mapper.IMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements IMainService {

    @Autowired
    private IMainMapper mainMapper;

    /**
     * @return
     */
    @Override
    public AttachFileNumber selectAttachFileNumber() {
        return mainMapper.selectAttachFileNumber();
    }
}
