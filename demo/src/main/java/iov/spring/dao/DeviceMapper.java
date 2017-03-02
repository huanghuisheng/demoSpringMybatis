package iov.spring.dao;

import org.apache.ibatis.annotations.Param;


import iov.spring.entity.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    
  //  int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);
    
//    第三种方案
//    Dao层的函数方法
//
//    Public User selectUser(@param(“userName”)Stringname,@param(“userArea”)String area);
//
//    对应的Mapper.xml
//
//    <select id=" selectUser" resultMap="BaseResultMap">
//       select  *  from user_user_t   where user_name = #{userName，jdbcType=VARCHAR} and user_area=#{userArea,jdbcType=VARCHAR}
//    </select> 
    
    
    
    
}