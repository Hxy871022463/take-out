package skytakeout.takeoutserver.service;

import skytakeout.takeoutpojo.dto.Admin;
import skytakeout.takeoutpojo.dto.AdminDTO;
import skytakeout.takeoutpojo.dto.AdminLoginDTO;

public interface AdminService {


    Admin login(AdminLoginDTO adminLoginDTO);

    void save(AdminDTO adminDTO);
}
