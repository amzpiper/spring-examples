package com.guoyuhang.client;

import com.guoyuhang.entity.Spitter;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SpitterClient {

    //检索资源

    /**
     * ForObject
     *
     * @param id
     * @return
     */
    public Profile fetch(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://faceboot.com/{spitter}", Profile.class, id);
    }

    public Profile fetch2(String id) {
        Map<String, String> urlVariables = new HashMap<String, String>();
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://faceboot.com/{spitter}", Profile.class, urlVariables);
    }

    /**
     * ForEntity
     */
    public Spitter fetch(long id) throws Exception {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spitter> response = rest.getForEntity("http://****/{id}", Spitter.class, id);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new Exception();
        }
        return response.getBody();
    }

    //put
    public void update(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        String url = "http://www.com/spitter/" + spitter.getId();
        rest.put(URI.create(url), spitter);
    }

    public void update2(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        rest.put("http://www.com/spitter/{id}", spitter, spitter.getId());

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", spitter.getId());
        rest.put("http://www.com/spitter/{id}", spitter, params);
    }

    //delete
    public void delete(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        rest.delete("http://www/{id}", spitter.getId());
    }

    //post
    public Spitter post(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        rest.postForObject("", spitter, Spitter.class);

        ResponseEntity<Spitter> responseEntity = rest.postForEntity("", spitter, Spitter.class);
        responseEntity.getBody();
        responseEntity.getHeaders().getLocation();


        //仅仅要location
        rest.postForLocation("", spitter).toString();

        return responseEntity.getBody();
    }

    //get
    public void get(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spitter> response = rest.exchange("{spitter}", HttpMethod.GET, null, Spitter.class, spitter.getId());

        //发送带有头部信息的
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Spitter> response2 = rest.exchange("{spitter}", HttpMethod.GET, requestEntity, Spitter.class, spitter.getId());

        Spitter spitter1 = response2.getBody();
    }
}
