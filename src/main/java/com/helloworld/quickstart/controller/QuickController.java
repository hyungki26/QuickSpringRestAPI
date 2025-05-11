package com.helloworld.quickstart.controller;


import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

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

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("success");

        return responseDto;

    }
}
