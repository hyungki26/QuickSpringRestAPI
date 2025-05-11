package com.helloworld.quickstart.controller;


import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "{}";
    }


    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo
    , @RequestParam("year") int year) {
        log.info("empNo = {}", empNo);
        log.info("year = {}", year);

        return "OK";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable String id) {
        log.info("id = {}", id);

        return "OK";
    }

    @PostMapping("/item")
    public ResponseDto regsterItem(@RequestBody ItemDto item) {
        log.info("item = {}", item);

        boolean b = quickService.regsterItem(item);

        if(b == true){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("success");

            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");

        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        log.info("id = {}", id);

        ItemDto res = quickService.getItemById(id);

        return res;
    }
}
