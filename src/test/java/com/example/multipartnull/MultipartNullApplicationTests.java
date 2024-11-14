package com.example.multipartnull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MultipartNullApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void test() throws Exception {
        byte[] bytes = resourceLoader.getResource("classpath:application.properties").getContentAsByteArray();
        MockMultipartFile file = new MockMultipartFile("file", "application.properties", MediaType.TEXT_PLAIN_VALUE,
                bytes);
        mvc.perform(multipart("/").file(file))
                .andExpect(status().isOk());
    }

}
