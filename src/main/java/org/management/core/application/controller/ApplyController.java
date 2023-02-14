package org.management.core.application.controller;


import org.management.core.application.common.annotation.CurrentUser;
import org.management.core.application.common.param.dto.ActiveDTO;
import org.management.core.application.common.param.dto.MaterialDTO;
import org.management.core.application.common.param.result.ResponseResult;
import org.management.core.application.common.param.vo.ActiveVO;
import org.management.core.application.common.param.vo.MaterialVO;
import org.management.core.domain.event.Const;
import org.management.core.domain.handler.ActiveHandler;
import org.management.core.domain.handler.MaterialHandler;
import org.management.core.domain.service.ApplyActiveService;
import org.management.core.domain.service.ApplyMaterialService;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.ApplyMaterial;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplyController extends BaseController{
    
    
    @Autowired
    ApplyActiveService applyActiveService;
    
    @Resource
    ApplyMaterialService applyMaterialService;
    
    @PostMapping(value = Const.API_URL+"/applyActive")
    public ResponseResult<ActiveVO> applyActive(@CurrentUser User user, @RequestBody @Valid List<ActiveDTO> activeDTOList){
        List<ApplyActive> serviceParam = new ArrayList<>(activeDTOList.size());
        activeDTOList.forEach(e-> serviceParam.add(ActiveHandler.convertDTO2pojo(e)));
        if (applyActiveService.addActives(user, serviceParam))
            return ResponseResult.success(ActiveVO.builder().success(true).build());
        else
            return ResponseResult.success(ActiveVO.builder().success(false).build());
    }
    
    @PostMapping(value = Const.API_URL + "/applyMaterial")
    public ResponseResult<MaterialVO> applyMaterial(@CurrentUser User user , @RequestBody @Valid List<MaterialDTO> materialDTOS){
        List<ApplyMaterial> serviceParam = new ArrayList<>(materialDTOS.size());
        materialDTOS.forEach(e -> serviceParam.add(MaterialHandler.convertDTO2pojo(e)));
        if (applyMaterialService.addMaterials(user, serviceParam))
            return ResponseResult.success(MaterialVO.builder().success(true).build());
        else
            return ResponseResult.success(MaterialVO.builder().success(true).build());
    }
    
    
    @GetMapping(value = Const.API_URL + "/getActives")
    public ResponseResult<List<ApplyActive>> getAllApplyActives(@CurrentUser User user){
        return ResponseResult.success(applyActiveService.getAll(user));
    }
    
    
    @GetMapping(value = Const.API_URL+"/getMaterials")
    public ResponseResult<List<ApplyMaterial>> getAllMaterials(@CurrentUser User user){
        return ResponseResult.success(applyMaterialService.getAll(user));
    }
    
    
}
