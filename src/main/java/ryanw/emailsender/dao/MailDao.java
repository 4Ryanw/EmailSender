package ryanw.emailsender.dao;/**
 * Created by NARNEW on 2021/7/5
 */

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ryanw.emailsender.pojo.Staff;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName GetInfoDao
 * @Description TODO
 * @Author NARNEW
 * @Date 2021/7/5 0:12
 */
@Component
public class MailDao {


    /**
     * 查询今天过生日员工信息
     */
    public List<Staff> getTodayList(){

        List<Staff> staffList = new ArrayList<>();

        InputStreamReader in = null ;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();//获取当前时间

        try {
            //获取员工信息文件路径
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "email.txt");
            String s = "";
            String [] arr;
            in = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader buffer = new BufferedReader(in);
            buffer.readLine();//跳过头部一行
            while ((s=buffer.readLine())!=null){
                 arr = s.split("\\s+");
                try {
                    //解析员工生日日期
                    calendar.setTime(sdf.parse(arr[2]));
                    if (calendar.get(Calendar.DATE)==now.get(Calendar.DATE)){
                        if(calendar.get(Calendar.MONTH)==now.get(Calendar.MONTH)){
                            Staff staff = new Staff(arr[0],arr[1],arr[2],arr[3]);
                            staffList.add(staff);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(in);
        }
        return staffList;
    }





}
