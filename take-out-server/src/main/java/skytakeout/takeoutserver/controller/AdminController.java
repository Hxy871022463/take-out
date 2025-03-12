package skytakeout.takeoutserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skytakeout.Constant.JwtClaimsConstant;
import skytakeout.properties.JwtProperties;
import skytakeout.takeoutpojo.dto.*;
import skytakeout.takeoutpojo.vo.AdminLoginVO;
import skytakeout.takeoutserver.service.AdminService;
import skytakeout.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "管理员相关接口")
@RestController
@RequestMapping("/admin/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtProperties jwtProperties;

    @Operation(summary = "管理员登录")
    @PostMapping("/login")
    public Result<AdminLoginVO> Login(@RequestBody AdminLoginDTO adminLoginDTO) {
        Admin admin = adminService.login(adminLoginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, admin.getId());
        String token = JwtUtils.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);


        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .name(admin.getName())
                .token(token)
                .build();

        return Result.success(adminLoginVO);
    }

    @PostMapping("/logout")
    @Operation(summary = "员工登出")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping("/save")
    @Operation(summary = "新增员工")
    public Result save(@RequestBody AdminDTO adminDTO){
        adminService.save(adminDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @Operation(summary = "管理员分页查询")
    public Result<PageResult> page(AdminPageQueryDTO adminPageQueryDTO){
        PageResult pageResult = adminService.pageQuery(adminPageQueryDTO);
        return Result.success(pageResult);
    }


    @PostMapping("/status/{status}")
    @Operation(summary = "启用禁用管理员账号")
    public Result status(@PathVariable Integer status, Long id){
        adminService.startOrStop(status, id);
        return Result.success();
    }
}
