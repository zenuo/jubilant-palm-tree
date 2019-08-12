package demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class ExcelPropertyIndexModel extends BaseRowModel {

    @ExcelProperty(value = "", index = 0)
    private Integer row;

    @ExcelProperty(value = "身份证号码", index = 1)
    private String id;

    @ExcelProperty(value = "姓名", index = 2)
    private String name;

    @ExcelProperty(value = "缴费人员类别", index = 3)
    private String type;

    @ExcelProperty(value = "社区编号", index = 4)
    private String communityId;

    @ExcelProperty(value = "社区名称", index = 5)
    private String communityName;

    @ExcelProperty(value = "序号", index = 6)
    private String serial;
}
