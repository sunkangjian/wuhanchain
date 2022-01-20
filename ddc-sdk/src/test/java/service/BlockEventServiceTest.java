package service;

import com.alibaba.fastjson.JSON;
import com.reddate.ddc.DDCSdkClient;
import com.reddate.ddc.listener.SignEventListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;


@Slf4j
class BlockEventServiceTest {

    // sign event listener
    SignEventListener signEventListener = event -> null;

    // ddcSdkClient instantiation
    DDCSdkClient ddcSdkClient = new DDCSdkClient().instance("src/main/resources/contractConfig.json", signEventListener);


    @Test
    void getBlockEvent() throws Exception {
        ArrayList<Object> result = new ArrayList<>();
        result.addAll(ddcSdkClient.blockEventService.getBlockEvent(new BigInteger("838940")));
        log.info(JSON.toJSONString(result));

        result.forEach(t -> {
            System.out.println(t.getClass());
        });
    }
}