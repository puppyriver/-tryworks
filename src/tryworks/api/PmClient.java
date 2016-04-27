package tryworks.api;


import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tryworks.util.SysProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2016/3/24
 * Time: 11:04
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class PmClient {
    private static PmClient ourInstance = new PmClient();
    private Log logger = LogFactory.getLog(getClass());

    public static PmClient getInstance() {
        return ourInstance;
    }

    JsonRpcHttpClient client = null;
    public PmClient() {
        if (client == null) {
            try {
                client = new JsonRpcHttpClient(
                        new URL(SysProperty.getString("jsonrpc.url","http://citronriver.com/web/ajax/server.json")));
            } catch (MalformedURLException e) {
                logger.error(e, e);
            }
        }
    }

    public PmClient(String jsonRpcUrl) {
        if (client == null) {
            try {
                client = new JsonRpcHttpClient(
                        new URL(jsonRpcUrl));
            } catch (MalformedURLException e) {
                logger.error(e, e);
            }
        }
    }

    public String sendMail(String toAddress,String title,String body) throws Throwable {
        HashMap map =  client.invoke("sendMail",new Object[]{toAddress,title,body},HashMap.class);
        return (String)map.get("result");
    }

    public static void main(String[] args) throws Throwable {
        PmClient.getInstance().sendMail(null,"abc","testabc");
    }
}
