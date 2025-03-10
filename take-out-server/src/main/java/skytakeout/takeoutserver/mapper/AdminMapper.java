package skytakeout.takeoutserver.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import skytakeout.takeoutpojo.dto.Admin;
import skytakeout.takeoutpojo.dto.AdminPageQueryDTO;

@Mapper
public interface AdminMapper {

    @Select("select * from employee where username = #{username}")
    Admin getByUsername(String username);

    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status) " +
            "values " +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
    void insert(Admin admin);

    Page<Admin> pageQuery(AdminPageQueryDTO adminPageQueryDTO);
}
