import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class NewApiTest {

    CloseableHttpResponse response=null;
    String entityStr = null;
    //登录url
    String url ="https://passport.jd.com/uc/loginService?uuid=fe49e023-209f-4988-82d1-1b7e9eccd834&ReturnUrl=https%3A%2F%2Fwww.jd.com%2F&r=0.9755361065343338&version=2015";

    @Test(invocationCount = 1, threadPoolSize = 0)
    public void JdLoginTest() throws IOException {

        // 获取连接客户端工具
        CloseableHttpClient httpClient=HttpClients.createDefault();
        // 创建POST请求对象
        HttpPost httpPost=new HttpPost(url);

        // httpPost.addHeader post请求 header
        httpPost.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.addHeader("User-Agent:","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");

        //参数封装对象
        List<NameValuePair> params=new ArrayList<NameValuePair>();

        try{
            params.add(new BasicNameValuePair("uuid","fe49e023-209f-4988-82d1-1b7e9eccd834"));
            params.add(new BasicNameValuePair("eid","JN4SUYVB7PERMMSXZ3FPGQUEJFOLZH3ZVORUPXZCCSSZOCC2ZEAVROBESK6VGB4NYBAKE577WNE3RJTL3WEMOQYYKA"));
            params.add(new BasicNameValuePair("fp","25faca8867ccd37b84242b091b1b1f78"));
            params.add(new BasicNameValuePair("loginType","c"));
            params.add(new BasicNameValuePair("loginname","15845116861"));
            params.add(new BasicNameValuePair("nloginpwd","XujDOj/9HC4QUReVT2v0eQ6wNc8Hco2EDb+uBcKH1IJp7wEkyyn2xU0MhajMcGAYbi8wCdoSBnl5MqevX4dWMky4Pig3aSS733s/B5NeHAKs7jgqRmvxluUM3Jpqb/2oZkFHYbISCvXiNaWc828Hkvc2VsGPLVL9oOcnCyGbV94="));
            params.add(new BasicNameValuePair("authcode","f38505896f0046c7a7556c4b6d88932c"));
            params.add(new BasicNameValuePair("pubKey","MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC7kw8r6tq43pwApYvkJ5laljaN9BZb21TAIfT/vexbobzH7Q8SUdP5uDPXEBKzOjx2L28y7Xs1d9v3tdPfKI2LR7PAzWBmDMn8riHrDDNpUpJnlAGUqJG9ooPn8j7YNpcxCa1iybOlc2kEhmJn5uwoanQq+CA6agNkqly2H4j6wIDAQAB"));
            params.add(new BasicNameValuePair("sa_token", "B68C442BE645754F33277E701208059080DD726A94A73F76DEC3053A838549C06EB7D3797CE1C5BBE7C2B2EF9CA7D467C3C76FF0A28885EE64B432120BA9B13D348C69B7D2A54084AD0AF9F604987E3FF4F05CFA833594DEAA638A1460132F8E4FC41F9984A0550F77FF3A51047D9FFA6937B2323ADE6CDB3A98776094AD46AFC0D104BE5A33FD4B2D219E65930F424CA62E9A76B0553DAFABE006ED3256B130266A76FAF5CCE3ADAB479A1B91EBE72C4561F5EEA0B8F47D42D83E5BDF9A9DD4F859D67E1B821EF79A484F070EE278321728B8636CF0C023585EE4049553FC059179356BFF79956D79513A800CB234A2520967D976F960CB0069EEC784576124FE835136C5DE493F1AB98C47EBFA2ADF27FE4A939D687F9B3341D634C0C3AEDAF6918CBB173CE84F2E1FCCF2BE51376A82DA9E358A9C3388F92968FD5A67E18CDC82F780A907C3A05CBD221D0620B4CAA12A0351EAD333641575BACD88D3F87593EEA390F49B3E5238AC8F43A0CA49C2AB3D5A8FDAFF7C86D683D17598D281A6BCA1E66CF2EA7586C3A0EDEFD22773E655E83D34D2E001C46596DB937A062271B112B62FCE688724CB808AEE61EC52B4EAD87CDCB47D31C4E0E515A00C81951A4E29571E2B5B407805816356428D66C2"));
            params.add(new BasicNameValuePair("seqSid","461422784671295190"));
            params.add(new BasicNameValuePair("useSlideAuthCode","1"));
            params.add(new BasicNameValuePair("_t","_t"));




            // 使用URL实体转换工具
            UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(params, "UTF-8");

            httpPost.setEntity(entityParam);
            // 执行请求
            response=httpClient.execute(httpPost);
            // 获得响应的实体对象
            HttpEntity entity=response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            int code =response.getStatusLine().getStatusCode();
            System.out.println("StatusCode: " + code);
            Assert.assertEquals(200,code);
            entityStr=EntityUtils.toString(entity,"UTF-8");
            System.out.println("接口返回结果是:="+entityStr);

        }catch(Exception e){
            e.printStackTrace();
        }finally {

            //释放资源
            if(httpClient!=null) {
                httpClient.close();
            }
            if (response!=null){
                response.close();
            }
        }


    }
}