package com.cskaoyan.controller.Device;

import com.cskaoyan.domain.*;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 该控制器主要控制设备类型相关文件
 * @Author lyboy
 * @Date 2018/12/6 20:24
 **/
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    /**
     * @Author lyboy
     * @Description //TODO
     * @Date 21:01 2018/12/6
     * @Param []
     * @return java.lang.String
     *
     *返回设备类型列表
     */
    @RequestMapping("list")
    @ResponseBody
    public DeviceTypeListVO deviceTypeList(String page, String rows){
        DeviceTypeListVO deviceTypeListVO = deviceTypeService.deviceTypeList(page, rows);
        return deviceTypeListVO;
    }
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:44 2018/12/7
     * @Param []
     * @return 返回空的json字符猜测为权限控制
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public Status delete_judge(){
        return null;
    }
    /*
     * @Author lyboy
     * @Description 删除指定类型
     * @Date 14:46 2018/12/7
     * @Param [ids] 要删除的参数
     * @return 确认成功
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public Status delete_batch(String ids){
        System.out.println(ids);
        Status status = deviceTypeService.deleteByPrimaryKey(ids);
        return status;
    }
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:44 2018/12/7
     * @Param []
     * @return 返回空的json字符猜测为权限控制
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public Status add_judge(){
        return null;
    }
    @RequestMapping("add")
    public String add(){
        return "deviceType_add";
    }
    @RequestMapping("insert")
    public Status insert(DeviceType deviceType){
        return deviceTypeService.insert(deviceType);
    }
}