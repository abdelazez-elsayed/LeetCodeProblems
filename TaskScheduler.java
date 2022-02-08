package solutions;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] char_map = new int[26];
        int max_val=0;
        //Map Task to its frequency
        for(char task :  tasks){
            int idx = task - 'A';
            char_map[idx]++;
            //Save max task to be done
            if ( char_map[idx] > max_val){
                max_val = char_map[idx];
            }
        }
        //worst Idle positions = (max task - 1 (last task to execute doesn't need idle slots)) * n;
        // if A is the max task with 3 and n = 2
        //Ex : A -> idle -> idle -> A -> idle -> idle -> A
        max_val--;
        int idle_slots = max_val * n;
        //for every remaining tasks try to fill idle slots with these tasks
        for(int i=0; i<26; i++){
            //in case if task freq == max task , there's no idle slots in the end (same as max task)
            idle_slots -= Math.min(char_map[i],max_val);
        }
        //we counted max task twice (over counting) so add its interval again
        idle_slots += max_val;
        //if no idle slots --> execute all tasks sequentially , otherwise add these idle slots to the tasks
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
