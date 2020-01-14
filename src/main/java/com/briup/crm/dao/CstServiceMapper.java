package com.briup.crm.dao;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.CstServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CstServiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    long countByExample(CstServiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int deleteByExample(CstServiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int deleteByPrimaryKey(Long svrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int insert(CstService record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int insertSelective(CstService record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    List<CstService> selectByExample(CstServiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    CstService selectByPrimaryKey(Long svrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int updateByExampleSelective(@Param("record") CstService record, @Param("example") CstServiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int updateByExample(@Param("record") CstService record, @Param("example") CstServiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int updateByPrimaryKeySelective(CstService record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_service
     *
     * @mbg.generated Tue Dec 31 17:03:22 CST 2019
     */
    int updateByPrimaryKey(CstService record);
}