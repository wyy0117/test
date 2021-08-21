package com.wyy.test;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/8/12
 * @Author: wyy
 */
public class RestTemplateTest {

    @Test
    public void testGet() {
        String url = "http://localhost:8080/get?a=abab";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            System.out.println(responseEntity.getBody());
        }

        String result = restTemplate.getForObject(url, String.class);
        System.out.println("result = " + result);
    }

    @Test
    public void testPost() {
        String url = "http://localhost:8080/post";

        Map<String, Object> body = new HashMap<>();
        body.put("name", "1");
        body.put("id", System.currentTimeMillis());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //RestTemplate带参传的时候要用HttpEntity<?>对象传递
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println("response = " + response);
    }

//    @Test
//    public void testFile() throws FileNotFoundException {
//      String url = "http://localhost:8000/file" ;
//        RestTemplate restTemplate = new RestTemplate();
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        File file = new File("/Users/wyy/temp/11.log");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        new FileSystemResource()
//        body.put("file",fileInputStream)
//        restTemplate.postForObject(url,)
//    }

    @Test
    public void testTimeOut() {

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectionRequestTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
    }

    @Test
    public void testInterceptor() {

        String url = "http://localhost:8080/get?a=abab";

        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                //login
                request.getHeaders().add("token", "tttt");
                ClientHttpResponse clientHttpResponse = execution.execute(request, body);
                return clientHttpResponse;
            }
        });
        restTemplate.setInterceptors(interceptors);
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("result = " + result);
    }


}
