package com.zeroone.star.customer.service.impl;

import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.MdClientExportQuery;
import org.springframework.stereotype.Service;

import java.io.File;

interface MsMRMdClientMapper{
    MdClient MdClientToMdClientDTO(MdClient mdClient);
}
/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author 快乐小新
 * @since 2024-05-21
 */
@Service
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Override
    public ResultDTO MdClientExport(MdClientExportQuery mdClientExportQuery) {
        return null;
    }



    @Override
    public ResultDTO CustomerImport(File file) {
        return null;
    }

    @Override
    public ResultDTO DownloadResult() {
        return null;
    }
}
