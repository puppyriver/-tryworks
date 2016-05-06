package tryworks.util;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;

/**
 * Author: Ronnie.Chen
 * Date: 2016/4/27
 * Time: 15:09
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class JarReducer {
   // private Log logger = LogFactory.getLog(getClass());

    public static void load(String filePath,String libPrefix,String outDir) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;
        HashSet<String> urlStrs = new HashSet<String>();
        while ((line = br.readLine()) != null) {
            if (line.contains("from ")) {
                String urlStr = line.substring(line.indexOf("from ") + 5, line.lastIndexOf("]"));
                if (urlStr.contains(libPrefix))
                    urlStrs.add(urlStr);
            }
        }
        File out = new File(outDir);
        if (!out.exists()) out.mkdir();
        for (String urlStr : urlStrs) {
            URI url = new URI(urlStr);
            File file = new File(url);
            FileUtils.copyFile(file,new File(outDir,file.getName()));
            System.out.println("copy "+file.getName());
        }
    }
    public static void main(String[] args) throws Exception {
        load("c:\\cls.txt","WEB-INF/lib","outlib");
    }
}
