package com.netintech.xfquartz.controller;

import com.netintech.xfquartz.bean.XfFormAtachment;
import com.netintech.xfquartz.bean.XfSynAtachment;
import com.netintech.xfquartz.dao.xf.XfSynAtachmentDao;
import com.netintech.xfquartz.dao.xf110.Xf110FormAtachmentDao;
import com.netintech.xfquartz.utils.Filebyte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.Date;

/**
 * @author: zhangyue
 * @date: 2019/1/16 15:37
 * @description:
 */
@Slf4j
@RestController
public class testController {

    @Autowired
    private XfSynAtachmentDao xfSynAtachmentDao;

    @Autowired
    private Xf110FormAtachmentDao xf110FormAtachmentDao;

    @GetMapping("/testFile")
    public Object getPhotoQueryTaskList4(){
        byte[] Buffer = Filebyte.getBytes("D:\\111.mp3");
        XfSynAtachment xfSynAtachment=new XfSynAtachment( "3", 3, "111", Buffer, new Date(), 0);
        xfSynAtachmentDao.insert(xfSynAtachment);
        XfFormAtachment xfFormAtachment=new XfFormAtachment();
        xfFormAtachment.setFiles(Buffer);
        xfFormAtachment.setId(39L);
        xf110FormAtachmentDao.updateById2(xfFormAtachment);
        return "上传测试文件成功";
    }

    @GetMapping("/testtest")
    public Object getPhotoQueryTaskList5(HttpServletRequest request){
        log.info(request.getRequestURL().toString());
        return "成功";
    }
}
