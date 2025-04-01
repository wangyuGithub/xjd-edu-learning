package com.xjd.edu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum AdminStatus implements TypeEnum<Integer> {
    /**失效 */
    DISABLE(1,"失效"),
    /**启用 */
    ENABLE(0,"启用");

    private Integer type;
    private String msg;
    @Override
    public TypeEnum <Integer> parse (Integer type)
    {
        for(AdminStatus e :  AdminStatus.values()){
            if(Objects.equals(e.getType(),type)){
                return e;
            }
        }
        return null;
    }
}
