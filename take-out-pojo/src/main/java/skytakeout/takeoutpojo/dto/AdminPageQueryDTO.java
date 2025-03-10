package skytakeout.takeoutpojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminPageQueryDTO implements Serializable {

    private String name;

    private int page;

    private int pageSize;
}
