package com.cskaoyan.mapper;

import com.cskaoyan.domain.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    int deleteByPrimaryKey(String customId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    int insert(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    int insertSelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    Custom selectByPrimaryKey(String customId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    int updateByPrimaryKeySelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Sat Dec 08 11:03:32 CST 2018
     */
    int updateByPrimaryKey(Custom record);

    List<Custom> findAllCustomFromDB();

    Custom findCustomByNameFromDB(@Param("searchValue") String searchValue);
}