package com.foureverhh.wiredbrain.friends;

import com.foureverhh.wiredbrain.friends.domain.Friend;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.UrlAssert;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

public class SystemTests {
    @Test
    public void testCreateReadDelete() throws MalformedURLException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/friend";
        //URL url = new URL(path);
        Friend friend = new Friend("Gordon","Moore");
/*
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON));
        String requestJson = "{"+
                                "\"first-name\"" + ":" + friend.getFirstName() + "," +
                                "\"last-name\"" + ":" + friend.getLastName() +
                "}";
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
*/

        ResponseEntity<Friend> entity = restTemplate.postForEntity(url,friend,Friend.class);
        Friend[] friends = restTemplate.getForObject(url,Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Gordon");

        restTemplate.delete(url+"/"+entity.getBody().getId());
        System.out.println(restTemplate.getForObject(url, Friend[].class).toString());
        Assertions.assertThat(restTemplate.getForObject(url, Friend[].class)).isEmpty();
    }
}
