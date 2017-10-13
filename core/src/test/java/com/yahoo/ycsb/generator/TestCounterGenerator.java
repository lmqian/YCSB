package com.yahoo.ycsb.generator;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author liaomq
 * @createtime 2017/9/20 17:56
 * @description 一句话描述这个类
 **/
public class TestCounterGenerator {

  @Test
  public void testCounterGenerator(){
    NumberGenerator keysequence = new CounterGenerator(0);
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(keysequence.nextValue().intValue());
    System.out.println(String.format("XM%018d", new Random().nextInt(2000)));
  }



}
