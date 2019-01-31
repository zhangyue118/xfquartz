package com.netintech.xfquartz.controller;

import com.netintech.xfquartz.bean.*;
import com.netintech.xfquartz.cfgbeans.ProjectParamsConfig;
import com.netintech.xfquartz.dao.xf.*;
import com.netintech.xfquartz.dao.xf110.*;
import com.netintech.xfquartz.utils.Filebyte;
import com.netintech.xfquartz.utils.StaticConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: zhangyue
 * @date: 2019/1/9 13:51
 * @description:
 */
@Slf4j
@Controller
@RequestMapping("/quartz/*")
public class QuartzController {

    @Autowired
    private ProjectParamsConfig projectParamsConfig;

    @Autowired
    private Xf110WorkDao xf110WorkDao;

    @Autowired
    private XfWorkDao xfWorkDao;

    @Autowired
    private XfWorkSignDao xfWorkSignDao;

    @Autowired
    private Xf110WorkSignDao xf110WorkSignDao;

    @Autowired
    private XfWorkFinishDao xfWorkFinishDao;

    @Autowired
    private Xf110WorkFinishDao xf110WorkFinishDao;

    @Autowired
    private XfWorkRejectDao xfWorkRejectDao;

    @Autowired
    private Xf110WorkRejectDao xf110WorkRejectDao;

    @Autowired
    private XfSynAtachmentDao xfSynAtachmentDao;

    @Autowired
    private Xf110SynAtachmentDao xf110SynAtachmentDao;

    @Autowired
    private XfMattersDao xfMattersDao;

    @Autowired
    private MatterTagDao matterTagDao;

    @Autowired
    private WorkconfirmDao workconfirmDao;

    @Autowired
    private XfPressingDao xfPressingDao;

    @Autowired
    private Xf110PressingDao xf110PressingDao;

    @Autowired
    private XfAttachmentDao xfAttachmentDao;

    @Autowired
    private XfFormAtachmentDao xfFormAtachmentDao;

    @Autowired
    private Xf110FormAtachmentDao xf110FormAtachmentDao;

    /**
     * fixedDelay = 15000 以一个固定延迟时间15秒钟调用一次执行 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，15s后再次执行
     */
    @RequestMapping("xf110")
    //@Scheduled(fixedDelay = 15000)
    public void sysLogs(){
        try {
            log.info("定时任务执行开始...");
            fetchMS110();
            synchronizationMS110();
            log.info("定时任务执行结束...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 本地同步处理结果到中间数据库
     */
    private void synchronizationMS110(){
        Map<String, Object> map=new HashMap<String, Object>();
        List<XfWorkFinish> ltXfWorkFinish=xfWorkFinishDao.getXfWorkFinishList(map);
        if(ltXfWorkFinish.size()>0){
            //xfWorkFinishService.insertBatch2(ltXfWorkFinish);
            XfWorkFinish xfWorkFinish2=new XfWorkFinish();
            for(XfWorkFinish x:ltXfWorkFinish){
                xfWorkFinish2.setId(x.getId());
                try {
                    xf110WorkFinishDao.insert2(x);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    continue;
                }
                try {
                    xfWorkFinish2.setIsHandle(1);
                    xfWorkFinishDao.updateById(xfWorkFinish2);
                    log.info(x.getFormId()+"--已办结");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        List<XfWorkSign> ltXfWorkSign=xfWorkSignDao.getXfWorkSignList(map);
        //List<XfWorkSign> ltXfWorkSign2=xfWorkSignDao.getXfWorkSignList(map);
        XfWorkSign sign=new XfWorkSign();
        for(XfWorkSign x:ltXfWorkSign){
            x.setIsHandle(0);
            sign.setId(x.getId());
            try {
                xf110WorkSignDao.insert2(x);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
            try {
                sign.setIsHandle(1);
                xfWorkSignDao.updateById(sign);
                log.info(x.getFormId()+"--已签收");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        List<XfWorkReject> ltXfWorkReject=xfWorkRejectDao.getXfWorkRejectList(map);
        //List<XfWorkReject> ltXfWorkReject2=xfWorkRejectDao.getXfWorkRejectList(map);
        XfWorkReject reject=new XfWorkReject();
        for(XfWorkReject x:ltXfWorkReject){
            x.setIsHandle(0);
            reject.setId(x.getId());
            try {
                xf110WorkRejectDao.insert2(x);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
            try {
                reject.setIsHandle(1);
                xfWorkRejectDao.updateById(reject);
                log.info(x.getFormId()+"--已驳回");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        List<XfSynAtachment> ltXfSynAtachment=xfSynAtachmentDao.getXfSynAtachmentList(map);
        //List<XfSynAtachment> ltXfSynAtachment2=xfSynAtachmentDao.getXfSynAtachmentList(map);
        //xfSynAtachmentService.insertBatch2(ltXfSynAtachment);
        XfSynAtachment atachment=new XfSynAtachment();
        for(XfSynAtachment x:ltXfSynAtachment){
            atachment.setId(x.getId());
            try {
                xf110SynAtachmentDao.insert2(x);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
            try {
                atachment.setIsHandle(1);
                xfSynAtachmentDao.updateById(atachment);
                log.info(x.getFormId()+"--"+x.getMatterId()+"--"+x.getFilename()+"--附件已回复");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 从中间数据库抽取民生110信访事项
     */
    private void fetchMS110() {
        //flag=true;
        // TODO Auto-generated method stub
        Map<String, Object> map=new HashMap<String, Object>();
        List<XfWork> ltXfWork=xf110WorkDao.getXfWorkList2(map);
        List<XfMatters> ltXfMatters=new ArrayList<XfMatters>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(XfWork x:ltXfWork){
            List<XfMatters> lxfMatters= xfMattersDao.getByWorkid(x.getBusiNumber());
            if(lxfMatters.size()>0){
                continue;
            }
            XfMatters xfMatters=new XfMatters();
            xfMatters.setAddress(x.getBusiAddress());
            xfMatters.setWork_id(x.getBusiNumber());
            xfMatters.setCreateTime(new Date());
            try {
                xfMatters.setMs110concludeDeadline(formatter.parse(x.getPlanTime()));
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            xfMatters.setXfName(x.getCusName());
            if("0".equals(x.getCusSex())){
                xfMatters.setSex("女");
            }else if("1".equals(x.getCusSex())){
                xfMatters.setSex("男");
            }else {
                xfMatters.setSex("保密");
            }
            xfMatters.setContact(x.getCusPhone());
            xfMatters.setAddress(x.getBusiAddress());
            xfMatters.setXfAppeal(x.getContentText());
            Map<String, Object> map1=new HashMap<String, Object>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd hh:mm:ss");
            Date date = new Date();
            Date time2=null;
            Date time1=null;
            String time=sdf1.format(date);
            Integer maxOrder=null;
            try {
                time=sdf1.format(date);
                time2=sdf1.parse("12-20 23:59:59");
                time1=sdf1.parse(time);
                //12月20即为一年的最后一天
                if(time1.getTime()>time2.getTime()){
                    map1.put("year", Integer.valueOf(sdf.format(date))+1+"");
                    xfMatters.setXfYear(Integer.valueOf(sdf.format(date))+1);
                }else {
                    map1.put("year", sdf.format(date));
                    xfMatters.setXfYear(Integer.valueOf(sdf.format(date)));
                }
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                map1.put("year", sdf.format(date));
                xfMatters.setXfYear(Integer.valueOf(sdf.format(date)));
            }
            maxOrder=xfMattersDao.getByMaxOrder(map1);
            if(maxOrder==null){
                maxOrder=1;
            }
            //最大文号
            xfMatters.setOrder(maxOrder);

            try {
                xfMatters.setXfDate(formatter.parse(x.getCreateTime()));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                xfMatters.setXfDate(new Date());
            }
            xfMatters.setXfSource(StaticConfigUtil.MS110);
            xfMatters.setXfType("18");
            xfMatters.setCreater(projectParamsConfig.getAdmin());
            xfMatters.setState("0");
            xfMatters.setIssueTime(new Date());
            xfMatters.setInputTime(new Date());
            xfMatters.setIsDelete(0);
            xfMatters.setIsSfsu(0);
            xfMatters.setRemark(x.getComments());
            xfMatters.setIszczb(0);
            xfMatters.setTransactManner(StaticConfigUtil.CXBL);
            xfMatters.setXfDestination("0");
            xfMatters.setComplaintStage("1");
            xfMatters.setIs110qianshou(0);
            xfMatters.setMinsheng110source(x.getFormOriginName());
            xfMatters.setHisadv(x.getHisadv());
            if("苏州寒山闻钟".equals(x.getCusName())){
                xfMatters.setMinsheng110source("寒山闻钟");
            }
            xfMatters.setIsexport(0);
            ltXfMatters.add(xfMatters);
            try {
                xfMattersDao.insert(xfMatters);
                x.setIsFetch(1);
                xf110WorkDao.updateById2(x);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                x.setMatterId(xfMatters.getId());
                xfWorkDao.insert(x);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //信访标签插入标签表
            try {
                //XfMatters xfMatters2=xfMattersService.getById(xfMatters.getId());
                Tag tag=new Tag();
                tag.setCreater(projectParamsConfig.getAdmin());
                tag.setCreateTime(new Date());
                tag.setMatterId(xfMatters.getId());
                tag.setTag(xfMatters.getComplaintType());
                matterTagDao.savaTag(tag);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                //生成工单办结记录
                Workconfirm workconfirm=new Workconfirm();
                workconfirm.setXfMattersId(xfMatters.getId());
                workconfirm.setCreater(19);
                workconfirm.setCreateTime(new Date());
                workconfirmDao.insert(workconfirm);
            } catch (Exception e) {
                e.printStackTrace();
            }

            log.info(xfMatters.getWork_id()+"--已新增");
        }

        //催办或补充
        map.clear();
        List<XfPressing> ltXfPressing=xf110PressingDao.getXfPressingList2(map);
        XfMatters xfMatters=new XfMatters();
        String ms110addcontent="";
        for(XfPressing p:ltXfPressing){
            Integer pId=p.getId();
            map.put("work_id", p.getBusiNumber());
            try {
                List<XfMatters> ltxfMatters =xfMattersDao.getByEntityAndPressing(map);
                if(ltxfMatters.size()>0){
                    xfMatters=ltxfMatters.get(0);
                    map.clear();
                    map.put("matterId",xfMatters.getId());
                    XfWork xfWork=xfWorkDao.getByMap(map);
                    ms110addcontent=xfWork.getAddcontent();
                    if(StringUtils.isEmpty(ms110addcontent)){
                        ms110addcontent="";
                    }
                    if(1==p.getFlag()){
                        ms110addcontent=ms110addcontent+"补充:\n";
                    }else{
                        ms110addcontent=ms110addcontent+"催办:\n";
                    }
                    ms110addcontent=ms110addcontent+p.getAddContent()+"\n";
//                    xfMatters.setMs110addcontent(ms110addcontent);
//                    xfMattersDao.updateById(xfMatters);
                    xfWork.setAddcontent(ms110addcontent);
                    xfWorkDao.updateById(xfWork);
                    p.setMatterId(xfMatters.getId());
                    p.setId(null);
                    xfPressingDao.insert(p);
                }
                p.setIsFetch(1);
                p.setId(pId);
                xf110PressingDao.updateById2(p);
                log.info(p.getBusiNumber()+"--有新的补充或催办");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //民生110附件
        List<XfFormAtachment> ltXfFormAtachment=xf110FormAtachmentDao.getXfFormAtachmentList2();
        ltXfMatters=null;
        List<XfAttachment> ltXfAttachment=new ArrayList<XfAttachment>();
        for(XfFormAtachment x:ltXfFormAtachment){
            ltXfMatters=xfMattersDao.getByWorkid2(x.getBusinessNumber());
            boolean flag=true;
            for(XfMatters m:ltXfMatters){
                XfAttachment xfAttachment=new XfAttachment();
                xfAttachment.setCreater(projectParamsConfig.getAdmin());
                xfAttachment.setProcessId(-1);
                xfAttachment.setMatterId(m.getId());
                xfAttachment.setType("X");
                xfAttachment.setName("民生110-"+x.getFilename());
                xfAttachment.setCreateTime(new Date());


                String oldName = x.getFilename();
                String prefix=oldName.substring(oldName.lastIndexOf(".")+1);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
                String newName = "X"+sdf.format(new Date()) +""+"."+prefix;
                // 转存文件
                byte[] buffer = x.getFiles();
                Filebyte.getFile(buffer, projectParamsConfig.getSaveFilePath(), newName);
                xfAttachment.setFile("/xfUpload/"+newName);
                xfAttachment.setExtension(prefix);
                xfAttachment.setFileSize(String.valueOf(buffer.length));

                ltXfAttachment.add(xfAttachment);
                try {
                    xfAttachmentDao.insert(xfAttachment);
                    flag=false;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    flag=true;
                }
            }
            try {
                if(!flag){
                    x.setIsFetch(1L);
                    xf110FormAtachmentDao.updateById2(x);
                    log.info(x.getBusinessNumber()+"--附件已接收");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
