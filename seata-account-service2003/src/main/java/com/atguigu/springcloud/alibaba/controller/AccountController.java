package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money")BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200,"账户余额扣减成功，哈哈哈");
    }
}
