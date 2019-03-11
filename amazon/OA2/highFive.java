/**
 * Author: tty8128
 * Time: 2019.Mar.11
 */


// there are two types of this question
// they changed the data structure of the input on the second one
// just remember change the Record to ProductReviewScore
// change the id to productId
// also, the priorityqueue need to be changed to a-b>0 return 1; a-b<0 return -1;a-b==0 return 0
// because the input score is double in the second case


/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution{
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
     
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        HashMap<Integer, PriorityQueue<Record>> map = new HashMap<Integer, PriorityQueue<Record>>();
        
        int k = 5;
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                PriorityQueue<Record> pq = new PriorityQueue<Record>(k, new Comparator<Record>() {
                   public int compare(Record a, Record b) {
                       return a.score - b.score; // min-heap
                   } 
                });
                map.put(r.id, pq);
            }
            
            map.get(r.id).add(r);
            if (map.get(r.id).size() > k) {
                map.get(r.id).poll();
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            result.put(id, average);
        }
        
        return result;
    }
}