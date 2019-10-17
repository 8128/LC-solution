package com.company.viagogo;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-16 15:43
 */
public class Tickets {

    class Event {

        int eventId;
        int x;
        int y;
        PriorityQueue<Integer> price;

        public Event (int eventId, int x, int y) {
            this.eventId = eventId;
            this.x = x;
            this.y = y;
            price = new PriorityQueue<>();
        }

    }

    public void purchaseTicket (int worldSize, int eventNum, String[] eventInfo,int buyerNum, String[] buyers) {
        HashMap<Integer, Event> events = new HashMap<>();
        for (int i = 0; i < eventNum; i++) {
            String singleEvent = eventInfo[i];
            String[] split = singleEvent.split(" ");
            int eventId = Integer.valueOf(split[0]);
            if (events.containsKey(eventId)) {
                for (int j = 3; j < split.length; j++) {
                    events.get(eventId).price.add(Integer.valueOf(split[j]));
                }
            } else {
                Event event = new Event(eventId, Integer.valueOf(split[1]), Integer.valueOf(split[2]));
                for (int j = 3; j < split.length; j++) {
                    event.price.add(Integer.valueOf(split[j]));
                }
                if (event.price.size() == 0) {
                    continue;
                }
                events.put(eventId, event);
            }
        }
        for (int i = 0; i < buyerNum; i++) {
            List<Integer> eventId = new ArrayList<>(events.keySet());
            if (eventId.size() == 0) {
                System.out.println("Error");
                continue;
            }
            String singleBuyer = buyers[i];
            String[] split = singleBuyer.split(" ");
            int tempX = Integer.valueOf(split[0]);
            int tempY = Integer.valueOf(split[1]);
            eventId.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    Event event1 = events.get(o1);
                    Event event2 = events.get(o2);
                    int dis1 = Math.abs(event1.x - tempX) + Math.abs(event1.y - tempY);
                    int dis2 = Math.abs(event2.x - tempX) + Math.abs(event2.y - tempY);
                    return Integer.compare(dis1, dis2);
                }
            });
            Event toBuy = events.get(eventId.get(0));
            int price = toBuy.price.poll();
            if (toBuy.price.size() == 0) {
                events.remove(toBuy.eventId);
            }
            System.out.println(toBuy.eventId + " " + price);
        }

    }

    public static void main(String[] args) {
        
    }
}
