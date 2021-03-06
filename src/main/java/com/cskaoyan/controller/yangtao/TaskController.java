package com.cskaoyan.controller.yangtao;

import com.cskaoyan.domain.yangtao.Task;
import com.cskaoyan.service.yangtao.TaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Auther: YangTao
 * @Date: 2018/12/6 0006
 */

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    /**
     * 显示显示列表
     * @param page
     * @param row
     * @param session
     * @return
     */
    @RequestMapping("task/find")
    public ModelAndView  theTashList(String page, String row, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("task_list");
        return modelAndView;

    }

    @ResponseBody
    @RequestMapping("task/list")
    public Map  ajaxFindList(String page, String rows){
        HashMap hashMap = new HashMap();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Task> allTasks = taskService.findAllTasks();
        int total=taskService.findTasksCount();
        hashMap.put("total",total);
        hashMap.put("rows",allTasks);
        return hashMap;

    }
    /**
     * 生产派管理数据 add
     */
    @ResponseBody
    @RequestMapping("task/add_judge")
    public Map  addJudge(String page, String row, HttpSession session){
        //这里貌似什么都没有做.增加页面判定?
        HashMap hashMap = new HashMap();
        return hashMap;

    }
    @RequestMapping("task/add")
    public ModelAndView  theTaskAdd(String page, String row, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("task_add");
        return modelAndView;

    }

    @ResponseBody//{"status":200,"msg":"OK","data":null}
    @RequestMapping("task/insert")
    public Map insertIntoTask(Task task){
        HashMap hashMap = new HashMap();
        int insert=taskService.insertIntoTask(task);
        if (insert==1){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);

        }
        //跳转页面显示
        return hashMap;
    }



    /**
     * 编辑 edit
     */
    @ResponseBody
    @RequestMapping("task/edit_judge")
    public Map  editJudge(String page, String row, HttpSession session){
        //这里貌似什么都没有做.增加页面判定?
        HashMap hashMap = new HashMap();
        return hashMap;

    }
    @RequestMapping("task/edit")
    public String taskEdit(){

        return "task_edit";
    }
    //task/update_all
    //{"status":200,"msg":"OK","data":null}
    @ResponseBody
    @RequestMapping("task/update_all")
    public Map updateAll(Task task){
        boolean b=taskService.updateTask(task);
        HashMap hashMap = new HashMap();
        if (b){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else{
            hashMap.put("status",100);
            hashMap.put("msg","error");
            hashMap.put("data",null);
        }

        return hashMap;
    }
    /**
     * 删除 delete
     */
    @ResponseBody
    @RequestMapping("task/delete_judge")
    public Map  deleteJudge(String page, String row, HttpSession session){
        //这里貌似什么都没有做.增加页面判定?
        HashMap hashMap = new HashMap();
        return hashMap;

    }
    //task/delete_batch
    @ResponseBody
    @RequestMapping("task/delete_batch")
    public Map deleteBatch(String[] ids){
       // System.out.println(Arrays.toString(ids));
        HashMap hashMap = new HashMap();
        boolean b =false;
        for (String id:
             ids) {
             b = taskService.deleteTaskById(id);
             if (b==false){
                 break;
             }
        }

        if (b){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);

        }else {
            hashMap.put("status",100);
            hashMap.put("msg","error");
            hashMap.put("data",null);

        }
        return hashMap;

    }
    /**
     * 条件查询框
     */
    //task/search_task_by_taskId
    //task/search_task_by_taskWorkId
    //task/search_task_by_taskManufactureSn
    @ResponseBody
    @RequestMapping("task/{searchId}")
    public Map searchTaskByID(@PathVariable String searchId, String searchValue, String Page, String rows){//这里的searchValue怎样分别
        HashMap hashMap = new HashMap();
        List<Task> taskList=new ArrayList();
        if (searchId.equals("search_task_by_taskId")){

            Task task =taskService.findTaskById(searchValue);
            taskList.add(task);

        }
        if (searchId.equals("search_task_by_taskWorkId")){
            taskList=taskService.findTaskByTaskWorkId(searchValue);
        }
        if (searchId.equals("search_task_by_taskManufactureSn")){
            taskList=taskService.findTaskBytaskManufactureSn(searchValue);

        }

        hashMap.put("total",taskList.size());
        hashMap.put("rows",taskList);
        return hashMap;
    }









}
