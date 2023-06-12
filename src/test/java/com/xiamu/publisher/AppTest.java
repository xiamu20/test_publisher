package com.xiamu.publisher;

import com.xiamu.publisher.bean.Sum;
import com.xiamu.publisher.service.MySqlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
    @Autowired
    MySqlServiceImpl mySqlService;
   ;

    @Test
   public void contestLoads(){
        System.out.println(mySqlService);
    }

}
