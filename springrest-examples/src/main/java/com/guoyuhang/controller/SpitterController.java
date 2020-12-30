package com.guoyuhang.controller;

import com.guoyuhang.entity.Spitter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//自动在所有方法上添加ResponseBody注解
@RestController
@RequestMapping("/spitter")
public class SpitterController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Spitter> spitters(@RequestParam(value = "max", defaultValue = "100") long max, @RequestParam(value = "count", defaultValue = "20") int count) {
        List<Spitter> list = new ArrayList<Spitter>();
        Spitter spitter;
        int index = 0;
        while (index < count) {
            spitter = new Spitter(1, "user", "pass");
            list.add(spitter);
            index++;
        }
        return list;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = "application/json")
    public Spitter saveSpitter(@RequestBody Spitter spitter) {
        return spitter;
    }

    /**
     * 返回带状态码的，ResponseEntity还包含了responseBody语义
     * @param spitter
     * @param id
     * @return
     */
    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spitter> saveSpitter2(@RequestBody Spitter spitter, @PathVariable("id") int id) {
        HttpStatus status = spitter != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Spitter>(spitter, status);
    }

    /**
     * 返回带状态码的，ResponseEntity还包含了responseBody语义;携带错误信息返回
     * @param spitter
     * @param id
     * @return
     */
    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> saveSpitter3(@RequestBody Spitter spitter, @PathVariable("id") int id) {
        if (spitter == null) {
            Error error = new Error(4, "Spittle [" + id + "] not found");
            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Spitter>(spitter, HttpStatus.OK);
    }

    /**
     * 处理错误简化逻辑
     * @param e
     * @return
     */
    public ResponseEntity<Error> spitterNotFound(SpitterNotFoundException e) {
        long spitterId = e.getSpitterId();
        Error error = new Error(4, "not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
    /**
     * 返回带状态码的，ResponseEntity还包含了responseBody语义;调用SpitterNotFoundException返回错误信息
     * @param spitter
     * @param id
     * @return
     */
    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spitter> saveSpitter4(@RequestBody Spitter spitter, @PathVariable("id") int id) {
        if (spitter == null) {
            throw new SpitterNotFoundException(id);
        }
        return new ResponseEntity<Spitter>(spitter, HttpStatus.OK);
    }


    /**
     * @param spitter
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Spitter saveSpitter5(@RequestBody Spitter spitter, @PathVariable("id") int id) {
        if (spitter == null) {
            throw new SpitterNotFoundException(id);
        }
        return new Spitter();
    }

    /**
     * 返回带header头部信息的数据
     *
     * @param spitter
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spitter> saveSpitter6(@RequestBody Spitter spitter, UriComponentsBuilder ucb) {
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/spitter/").path(String.valueOf(spitter.getId())).build().toUri();
        headers.setLocation(locationUri);
        ResponseEntity<Spitter> responseEntity = new ResponseEntity<>(spitter, headers, HttpStatus.CREATED);
        return responseEntity;
    }
}
