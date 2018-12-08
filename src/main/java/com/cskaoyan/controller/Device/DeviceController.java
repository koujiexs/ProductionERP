package com.cskaoyan.controller.Device;

import com.cskaoyan.domain.Device.Device;
import com.cskaoyan.domain.Device.DeviceListVO;
import com.cskaoyan.domain.Device.Status;
import com.cskaoyan.domain.Device.User;
import com.cskaoyan.service.Devicr.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/7 14:41
 **/
@SuppressWarnings("ALL")
@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:43 2018/12/7
     * @Param [session]
     * @return java.lang.String
     * 设备种类转发jsp组件的控制器
     * 黑洞
     */
    @RequestMapping("device/deviceType")
    public String deviceType(HttpSession session){
        User activeuser = (User) session.getAttribute("activeUser");
        if (activeuser.getLocked().equals("1")){
            List<String> sysPermissionList=new ArrayList<>();
            sysPermissionList.add("deviceType:add");
            sysPermissionList.add("deviceType:edit");
            sysPermissionList.add("deviceType:delete");
            session.setAttribute("sysPermissionList",sysPermissionList);
        }
        return "deviceType";
    }
    @RequestMapping("device/deviceList")
    public String deviceList(HttpSession session) {
        User activeuser = (User) session.getAttribute("activeUser");
        if (activeuser.getLocked().equals("1")) {
            List<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("device:add");
            sysPermissionList.add("device:edit");
            sysPermissionList.add("device:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
        }
        return "deviceList";
    }
    @RequestMapping("deviceList/list")
    @ResponseBody
    public DeviceListVO list(String page, String rows){
        DeviceListVO deviceListVO = deviceService.selectList(page, rows);
        return deviceListVO;
    }

    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public Status add_judge() {
        return null;
    }

    @RequestMapping("deviceList/add")
    public String add() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/insert")
    @ResponseBody
    public Status insert(Device device) {
        Status status = deviceService.insert(device);
        return status;
    }

    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public Status edit_judge() {
        return null;
    }

    @RequestMapping("deviceList/edit")
    public String edit() {
        return "deviceList_edit";
    }

    @RequestMapping("deviceList/update")
    @ResponseBody
    public Status update(Device device) {
        Status status = deviceService.update(device);
        return status;
    }

    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public Status delete_judge() {
        return null;
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public Status delete_batch(String ids) {
        Status status = deviceService.deleteByPrimaryKey(ids);
        return status;
    }

    @RequestMapping("deviceList/update_note")
    @ResponseBody
    public Status updateNote(String deviceId, String note) {
        Status status = deviceService.updateNote(deviceId, note);
        return status;
    }
}
