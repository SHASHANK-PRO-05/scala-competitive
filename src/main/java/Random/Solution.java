package Random;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class Temp implements Comparable<Temp> {
    public String s;
    public int key;
    @Override
    public int compareTo(Temp o) {
        if(this.key>o.key) return 1;
        else if(this.key<o.key) return -1;
        return 0;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return s+" "+key+"\n";
    }

}
class Solution {
    public static ArrayList<ArrayList<String>> arrangeList(ArrayList<ArrayList<String>> input) {

        Map<String,Integer> priority = new HashMap<>();
        Set<String> elements= new HashSet<String>();
        ArrayList<ArrayList<String>> output  = new ArrayList<ArrayList<String>>();
        int i=0;
        int priorityPast = -1;
        boolean contains = false;
        for(ArrayList<String> x: input) {
            contains = false;
            i=0;
            for(String y: x) {
                if(i == 0) {
                    if(elements.contains(y)) {
                        contains = true;
                        priorityPast = priority.get(y);

                    } else {
                        priority.put(y, 0);

                    }
                    i++;
                } else {
                    if(contains == true) {
                        if(elements.contains(y)) {
                            priority.replace(y,priorityPast+1);

                        }
                        else {
                            priority.put(y, priorityPast);
                        }
                    }
                    else {
                        priority.put(y, 1);
                    }
                }
            }
        }

        Iterator iter= priority.entrySet().iterator();
        ArrayList<Temp> list=new ArrayList<>();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            Temp temp=new Temp();
            temp.s=(String)pair.getKey();
            temp.key=(int) pair.getValue();
            list.add(temp);
        }
        Collections.sort(list);
        ArrayList<ArrayList<String>> out=new ArrayList<>();
        ArrayList<String> var=new ArrayList<>();
        var.add(list.get(0).s);
        int prevPri=list.get(0).key;
        for(int it=1;it<list.size();it++) {
            if(list.get(it).key>prevPri) {
                out.add(var);
                var=new ArrayList<>();
                var.add(list.get(it).s);
                prevPri=list.get(it).key;
            }else
                var.add(list.get(it).s);
        }
        out.add(var);
        //System.out.println(list);
        return out;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<ArrayList<String>> temp = new ArrayList<>();
        strings.add("boil");
        strings.add("serve");
        temp.add(strings);
        strings = new ArrayList<String>();
        strings.add("chop");
        strings.add("boil");
        temp.add(strings);
        strings = new ArrayList<String>();
        strings.add("stir");
        strings.add("boil");
        temp.add(strings);
        strings = new ArrayList<String>();
        strings.add("set table");
        strings.add("serve");
        temp.add(strings);
        strings = new ArrayList<String>();
        for (ArrayList<String> retun : arrangeList(temp)) {
            System.out.println(retun);
        }
    }

}




