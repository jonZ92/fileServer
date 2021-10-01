package com.fileApp;

import com.fileApp.server.socket.ServerSocket;
import com.fileApp.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @author jon 2021:09:11
 */


public class ServerMain {

    private static final Logger log = LogManager.getLogger(ServerMain.class);

    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        path = path.replaceAll("\\\\", "/");
        path=path+"/dir_file/";
        Integer port = 7800;
        if (args.length < 1) {
            log.info("\n \n  \n      {}", StringUtil.ascii_name);
            log.info("文件默认存储路径: {}",path);
        }else{
            try {
                String str = args[0].substring(args[0].length() - 1, args[0].length());
                if (str.equals("/")) {
                    path = args[0];
                } else {
                    path = args[0] + "/";
                }
                port = Integer.parseInt(args[1]);

            } catch (Exception e) {

                log.error("error:{}", e.getMessage());

            }
        }
        File file=new  File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        ServerSocket socket = new ServerSocket(port, path);
        socket.bind();

    }


}
