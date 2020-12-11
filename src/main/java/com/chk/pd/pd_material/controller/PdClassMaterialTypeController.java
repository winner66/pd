package com.chk.pd.pd_material.controller;


import com.chk.pd.common.vo.Response;
import com.chk.pd.pd_material.Service.ClassMaterialTypeService;
import com.chk.pd.pd_material.Service.impl.ClassMaterialTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pd_material/V1/ClassMaterialType")
public class PdClassMaterialTypeController {
    @Autowired
    private ClassMaterialTypeServiceImpl materialTypeService;

    @GetMapping("/getMatrialtypeByclassId/{id}")
    public Response getMatrialtypeByclassIds(@PathVariable("id") Integer id){
        Integer res=materialTypeService.getMatrialtypeByclassId(id);
        return Response.ok(res);
    }
}
