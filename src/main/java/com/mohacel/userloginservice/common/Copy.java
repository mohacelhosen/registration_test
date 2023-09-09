package com.mohacel.userloginservice.common;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class Copy {
    private static ModelMapper modelMapper= new ModelMapper();

    public static void copyNonNullProperties(Object source, Object target){
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(source,target);
    }
}
