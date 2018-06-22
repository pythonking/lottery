package com.ht.lottery.util;

import com.ht.lottery.entity.TicketType;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽奖工具类
 */
public class RaffleUtil {
    public static TicketType getTicketType(List<TicketType> ticketTypeList) {
        int index = RaffleUtil.getPrizeIndex(ticketTypeList);
        TicketType ticketType = ticketTypeList.get(index);
        Integer todayNum = ticketType.getDaliyNum();
        //如果奖品还有,则返回该奖品.如果没有,则返回六等奖
        if (todayNum > 0) {
            return ticketType;
        } else {
            return ticketTypeList.get(ticketTypeList.size() - 1);
        }
    }

    /**
     * 获取奖券类型坐标:0-->1等奖   1-->2等奖 ... 5-->6等奖
     *
     * @param ticketTypeList
     * @return
     */
    public static int getPrizeIndex(List<TicketType> ticketTypeList) {
        int random = -1;
        try {
            //计算总权重
            double sumWeight = 0;
            for (TicketType ticketType : ticketTypeList) {
                sumWeight += ticketType.getProbability();
            }

            //产生随机数
            double randomNumber = Math.random();

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for (int i = 0; i < ticketTypeList.size(); i++) {
                d2 += Double.parseDouble(String.valueOf(ticketTypeList.get(i).getProbability())) / sumWeight;
                if (i == 0) {
                    d1 = 0;
                } else {
                    d1 += Double.parseDouble(String.valueOf(ticketTypeList.get(i - 1).getProbability())) / sumWeight;
                }
                if (randomNumber >= d1 && randomNumber <= d2) {
                    random = i;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("生成抽奖随机数出错，出错原因：" + e.getMessage());
        }
        return random;
    }

    public static void main(String[] args) {
        int i = 0;
        int[] result = new int[6];
        List<TicketType> prizes = new ArrayList<>();

        TicketType p1 = new TicketType();
        p1.setName("现金礼券100元");
        p1.setProbability(60);//奖品的权重设置成1
        prizes.add(p1);


        TicketType p2 = new TicketType();
        p2.setName("现金礼券500元");
        p2.setProbability(5);//奖品的权重设置成1
        prizes.add(p2);


        TicketType p3 = new TicketType();
        p3.setName("现金礼券1000元");
        p3.setProbability(10);//奖品的权重设置成1
        prizes.add(p3);


        TicketType p4 = new TicketType();
        p4.setName("擦银布");
        p4.setProbability(19);//奖品的权重设置成1
        prizes.add(p4);


        TicketType p5 = new TicketType();
        p5.setName("银质项链");
        p5.setProbability(5);//奖品的权重设置成1
        prizes.add(p5);


        TicketType p6 = new TicketType();
        p6.setName("免单大奖");
        p6.setProbability(1);//奖品的权重设置成1
        prizes.add(p6);


        System.out.println("抽奖开始");
        for (i = 0; i < 10000; i++)// 打印100个测试概率的准确性
        {
            int selected = RaffleUtil.getPrizeIndex(prizes);
            System.out.println("第" + i + "次抽中的奖品为" + (selected + 1) + "等奖：" + prizes.get(selected).getName());
            result[selected]++;
            System.out.println("--------------------------------");
        }
        System.out.println("抽奖结束");
        System.out.println("每种奖品抽到的数量为：");
        System.out.println("一等奖：" + result[0]);
        System.out.println("二等奖：" + result[1]);
        System.out.println("三等奖：" + result[2]);
        System.out.println("四等奖：" + result[3]);
        System.out.println("五等奖：" + result[4]);
        System.out.println("六等奖：" + result[5]);
    }
}
