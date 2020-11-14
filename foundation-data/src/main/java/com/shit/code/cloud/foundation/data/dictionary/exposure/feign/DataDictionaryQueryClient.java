package com.shit.code.cloud.foundation.data.dictionary.exposure.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Anthony
 * @date 11/14/20
 **/
@FeignClient(name = "foundation-data", path = "/dictionary")
public interface DataDictionaryQueryClient {

    @GetMapping("test/{time}")
    Integer test(@PathVariable Integer time);

    @GetMapping("test2")
    String test2();
}
