package com.zeroone.star.basicdata.controller;


import com.zeroone.star.basicdata.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("prod-api/mes/md/client")
@RestController
public class VendorController {
    @Autowired
    VendorService vendorService;




}
