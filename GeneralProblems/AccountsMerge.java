package solutions.GeneralProblems;

import Datastructure.DSU;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> mailGroup = new HashMap<>();
        DSU dsu = new DSU(accounts.size());
        int j=0;
        for(List<String> account : accounts){
            int size = account.size();
            for(int i=1; i<size; i++){
                String mail = account.get(i);
                if(!mailGroup.containsKey(mail)){
                    mailGroup.put(mail,j);
                }else{
                    dsu.unionBySize(j,mailGroup.get(mail));
                }
            }
            j++;
        }
        Map<Integer, List<String>> components= new HashMap<>();
        for(String mail : mailGroup.keySet()){
            int group = mailGroup.get(mail);
            int groupRep = dsu.findRepresentative(group);
            components.putIfAbsent(groupRep,new LinkedList<>());
            components.get(groupRep).add(mail);
        }

        List<List<String>> sol = new LinkedList<>();
        for(Map.Entry<Integer,List<String>> entry : components.entrySet()){
            List<String> comp = entry.getValue();
            Integer group = entry.getKey();
            Collections.sort(comp);
            comp.add(0,accounts.get(group).get(0));
            sol.add(comp);
        }
        return sol;

    }

    public static void main(String[] args) {
        List<List<String>> accs = new LinkedList<>();
        String[] ac1 = {"John","johnsmith@mail.com","john_newyork@mail.com"};
        String[] ac2 =  {"John","johnsmith@mail.com","john00@mail.com"};
        String[] ac3 = {"Mary","mary@mail.com"};
        String[] ac4 = {"John","johnnybravo@mail.com"};
        accs.add(Arrays.asList(ac1));
        accs.add(Arrays.asList(ac2));
        accs.add(Arrays.asList(ac3));
        accs.add(Arrays.asList(ac4));
        AccountsMerge accountsMerge = new AccountsMerge();
        accountsMerge.accountsMerge(accs);

    }
}
