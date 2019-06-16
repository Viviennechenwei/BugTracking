package com.vivi.bugTracking.dao.mapper;

import com.vivi.bugTracking.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    Employee selectByLoginId(@Param("loginId") String loginId);

    List<Employee> selectAll();

    List<Employee> selectRange(@Param("nameFilter") String nameFilter, @Param("start") int startIndex,
                               @Param("size") int pageSize, @Param("sortOrder") String sortOrder);

    int count(@Param("nameFilter") String nameFilter);

    int createEmployee(@Param("employee") Employee employee);

    Employee selectById(@Param("id") int id);

    int updateEmployee(@Param("employee") Employee employee);

    int selectLoginIdCount(@Param("loginId") String loginId);
}
