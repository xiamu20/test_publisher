package demo;

import com.xiamu.publisher.redis.redisson.MyRedissonConfig;
import lombok.Data;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Data
@Component
public class Test {


    public static void main(String[] args) {
        MyRedissonConfig myRedissonConfig = new MyRedissonConfig();

        if (false){

            return;
        }
       String lockKey ="lockKey";
        System.out.println("lockKey");
        RLock lock = myRedissonConfig.redisson().getLock(lockKey);
        lock.lock(10, TimeUnit.SECONDS);
        lock.unlock();


    }
}
