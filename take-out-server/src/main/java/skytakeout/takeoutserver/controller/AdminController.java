package skytakeout.takeoutserver.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skytakeout.takeoutpojo.dto.Admin;
import skytakeout.takeoutpojo.dto.AdminDTO;
import skytakeout.takeoutpojo.dto.AdminLoginDTO;
import skytakeout.takeoutpojo.dto.Result;
import skytakeout.takeoutpojo.vo.AdminLoginVO;
import skytakeout.takeoutserver.service.AdminService;

@Tag(name = "管理员相关接口")
@RestController
@RequestMapping("/admin/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Operation(summary = "管理员登录")
    @PostMapping("/login")
    public Result<AdminLoginVO> Login(@RequestBody AdminLoginDTO adminLoginDTO) {
        Admin admin = adminService.login(adminLoginDTO);

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .name(admin.getName())
                .build();
        return Result.success(adminLoginVO);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "员工登出")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增员工")
    public Result save(@RequestBody AdminDTO adminDTO){
        adminService.save(adminDTO);
        return Result.success();
    }
}
