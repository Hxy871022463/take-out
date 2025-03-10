package skytakeout.takeoutpojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户传递的数据")
public class AdminLoginDTO {


    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
