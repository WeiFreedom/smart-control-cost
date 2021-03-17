package com.wei.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResultVo implements Serializable {
    private static final long serialVersionUID = -7008634900170421880L;
    private String code;
    private String message;
    private Object value;
}
