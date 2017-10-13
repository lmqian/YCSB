package com.yahoo.ycsb.workloads;

import com.yahoo.ycsb.ByteIterator;
import com.yahoo.ycsb.NumericByteIterator;
import com.yahoo.ycsb.RandomByteIterator;
import com.yahoo.ycsb.StringByteIterator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author liaomq@chinawyny.com
 * @copyright www.chinawyny.com
 * @date 2017/9/24 17:21
 */
public class YMWorkLoad extends CoreWorkload {
  private static Random random = new Random();
  private Date now = new Date();
  private DateFormat format = new SimpleDateFormat("yyyyMMddHH");

  @Override
  protected String buildKeyName(long keynum) {

    String projectId = String.format("XM%04d", random.nextInt());
    String deviceIdValueType = String.format("XM%018d", random.nextInt(2000));
    String dateHour = calDate(now, keynum);

    return projectId + deviceIdValueType + dateHour;
  }

  private String calDate(Date date, long keyNum){
    long milTime = date.getTime() - keyNum * 1000 * 3600;
    return format.format(new Date(milTime));
  }

  @Override
  protected HashMap<String, ByteIterator> buildValues(String key) {
    HashMap<String, ByteIterator> values = new HashMap<>();

    for (String fieldkey : fieldnames) {
      ByteIterator data = new NumericByteIterator(random.nextDouble());
      values.put(fieldkey, data);
    }
    return values;
  }

}
