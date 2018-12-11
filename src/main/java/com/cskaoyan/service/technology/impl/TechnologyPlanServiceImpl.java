package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.customize.CustomResult;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyPlan;
import com.cskaoyan.domain.technology.TechnologyPlanExample;
import com.cskaoyan.mapper.technology.TechnologyMapper;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import com.cskaoyan.service.technology.TechnologyPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

	@Autowired
    TechnologyMapper technologyMapper;
	
	@Autowired
    TechnologyPlanMapper technologyPlanMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyPlan> list = technologyPlanMapper.find(technologyPlan);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TechnologyPlan get(String string) throws Exception{
		return technologyPlanMapper.selectByPrimaryKey(string);
	}
	
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = technologyPlanMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(TechnologyPlan technologyPlan) throws Exception{
		int i = technologyPlanMapper.insert(technologyPlan);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工艺计划信息失败");
		}
	}

	@Override
	public CustomResult updateAll(TechnologyPlan technologyPlan) throws Exception{
		int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺计划信息失败");
		}
	}

	@Override
	public List<TechnologyPlan> find() throws Exception{
		TechnologyPlanExample example = new TechnologyPlanExample();
		return technologyPlanMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchTechnologyPlanByTechnologyPlanId(
			Integer page, Integer rows, String technologyPlanId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyPlan> list = technologyPlanMapper
				.searchTechnologyPlanByTechnologyPlanId(technologyPlanId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page,
                                                                 Integer rows, String technologyName) throws Exception{
		//分页处理
				PageHelper.startPage(page, rows);
				List<TechnologyPlan> list = technologyPlanMapper
						.searchTechnologyPlanByTechnologyName(technologyName);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
}
