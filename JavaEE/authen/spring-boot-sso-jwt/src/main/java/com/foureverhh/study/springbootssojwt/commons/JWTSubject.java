package com.foureverhh.study.springbootssojwt.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 作为Subject数据使用，也就是payload中保存的public claims
* 其中不包含任何敏感数据
* 开发中建议使用实体类型，或BO，DTO数据类型
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTSubject {
    private String username;
}
