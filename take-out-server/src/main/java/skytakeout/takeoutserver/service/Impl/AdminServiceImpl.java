package skytakeout.takeoutserver.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import skytakeout.Constant.MessageConstant;
import skytakeout.Constant.PasswordConstant;
import skytakeout.Constant.StatusConstant;
import skytakeout.exception.AccountNotFoundException;
import skytakeout.exception.PasswordErrorException;
import skytakeout.takeoutpojo.dto.*;
import skytakeout.takeoutserver.mapper.AdminMapper;
import skytakeout.takeoutserver.service.AdminService;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Admin admin = adminMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (admin == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }


        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        return admin;
    }


    public void save(AdminDTO adminDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        admin.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
        admin.setStatus(StatusConstant.STATUS_OK);
        adminMapper.insert(admin);
    }


    public PageResult pageQuery(AdminPageQueryDTO adminPageQueryDTO) {
        PageHelper.startPage(adminPageQueryDTO.getPage(), adminPageQueryDTO.getPageSize());

        Page<Admin> page = adminMapper.pageQuery(adminPageQueryDTO);

        long total = page.getTotal();
        List<Admin> record = page.getResult();
        return new PageResult(total, record);
    }

    public void startOrStop(Integer status, Long id) {
        Admin admin = Admin.builder()
                .status(status)
                .id(id)
                .build();
        adminMapper.update(admin);
    }

}
