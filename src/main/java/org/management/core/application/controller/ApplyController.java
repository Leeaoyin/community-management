package org.management.core.application.controller;


import org.management.core.application.common.annotation.CurrentUser;
import org.management.core.application.common.enums.HttpCodeEnum;
import org.management.core.application.common.param.dto.ActiveDTO;
import org.management.core.application.common.param.dto.MaterialDTO;
import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.application.common.param.dto.VerifyDTO;
import org.management.core.application.common.param.result.ResponseResult;
import org.management.core.application.common.param.vo.ActiveVO;
import org.management.core.application.common.param.vo.MaterialVO;
import org.management.core.application.common.param.vo.VerifyVO;
import org.management.core.domain.event.Const;
import org.management.core.domain.handler.ActiveHandler;
import org.management.core.domain.handler.MaterialHandler;
import org.management.core.domain.service.ApplyActiveService;
import org.management.core.domain.service.ApplyMaterialService;
import org.management.core.domain.service.VaccineOrderService;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.ApplyMaterial;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.VaccineOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);
    
    @Resource
    ApplyActiveService applyActiveService;
    
    @Resource
    ApplyMaterialService applyMaterialService;
    
    @Resource
    VaccineOrderService vaccineOrderService;
    
    @PostMapping(value = Const.API_URL+"/applyActive")
    public ResponseResult<ActiveVO> applyActive(@CurrentUser User user, @RequestBody @Valid List<ActiveDTO> activeDTOList){
        List<ApplyActive> serviceParam = new ArrayList<>(activeDTOList.size());
        activeDTOList.forEach(e-> serviceParam.add(ActiveHandler.convertDTO2pojo(e)));
        if (applyActiveService.addActives(user, serviceParam)){
            logger.info("active has already applyed, wait for verifying");
            return ResponseResult.success(ActiveVO.builder().success(true).build());
        }
        else{
            logger.error("active apply failed");
            return ResponseResult.success(ActiveVO.builder().success(false).build());
        }
            
    }
    
    @PostMapping(value = Const.API_URL + "/applyMaterial")
    public ResponseResult<MaterialVO> applyMaterial(@CurrentUser User user , @RequestBody @Valid List<MaterialDTO> materialDTOS){
        List<ApplyMaterial> serviceParam = new ArrayList<>(materialDTOS.size());
        materialDTOS.forEach(e -> serviceParam.add(MaterialHandler.convertDTO2pojo(e)));
        if (applyMaterialService.addMaterials(user, serviceParam)){
            logger.info("active has already applyed,wait for verifying");
            return ResponseResult.success(MaterialVO.builder().success(true).build());
        }
        else{
            logger.error("Material apply failed");
            return ResponseResult.success(MaterialVO.builder().success(false).build());
        }
    }
    
    
    @GetMapping(value = Const.API_URL + "/getActives")
    public ResponseResult<List<ApplyActive>> getAllApplyActives(@CurrentUser User user){
        return ResponseResult.success(applyActiveService.getAll(user));
    }
    
    
    @GetMapping(value = Const.API_URL+"/getMaterials")
    public ResponseResult<List<ApplyMaterial>> getAllMaterials(@CurrentUser User user){
        return ResponseResult.success(applyMaterialService.getAll(user));
    }
    
    @PostMapping(value = Const.API_URL + "/verifyActives")
    public ResponseResult<VerifyVO> verifyActive(@CurrentUser User user, @RequestBody List<VerifyDTO> ids){
        if (exitAdministrator(user))
            return ResponseResult.error(HttpCodeEnum.FORBIDDEN);
        Boolean result = applyActiveService.verifyActive(ids);
        if (result) {
            logger.info("verify those actives[{}] success", ids.toString());
        }
            return ResponseResult.success(VerifyVO.builder().success(result).build());
    }
    
    @PostMapping(Const.API_URL + "/orderVaccine")
    public ResponseResult<VerifyVO> orderVaccine(@CurrentUser User user, @RequestBody @Valid VaccineDTO vaccineDTO){
        Boolean result = vaccineOrderService.order(user, vaccineDTO);
        if (result) {
            logger.info("order {} for {} successfully ",vaccineDTO.getVaccinename(), user.getUserName());
        }
            return ResponseResult.success(VerifyVO.builder().success(result).build());
    }
    
    @GetMapping(value = Const.API_URL + "/getOrderedVaccine")
    public ResponseResult<List<VaccineOrder>> getAllOrderVaccine(@CurrentUser User user){
        return ResponseResult.success(vaccineOrderService.getAll(user));
    }
    
    
}
