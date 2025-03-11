package skytakeout.takeoutserver.service;

import skytakeout.takeoutpojo.dto.*;

public interface AdminService {


    Admin login(AdminLoginDTO adminLoginDTO);

    void save(AdminDTO adminDTO);

    PageResult pageQuery(AdminPageQueryDTO adminPageQueryDTO);

    void startOrStop(Integer status, Long id);
}
