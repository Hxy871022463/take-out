package skytakeout.takeoutpojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class person {

    @ApiModelProperty("编号")
    private int id;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("年龄")
    private int age;
}
