/**
 * The logic is to preprocess the wordList in the form of *
 * Eg:WordList: ["hot","dot","dog","lot","log","cog"]
 * The Preprocessed output will have the following map. This is nothing but the adjacencyList for the graph.
 * {do*=[dot, dog], d*g=[dog], c*g=[cog], ho*=[hot], *og=[dog, log, cog], h*t=[hot],
 * lo*=[lot, log], l*t=[lot], l*g=[log],  *ot=[hot, dot, lot], d*t=[dot], co*=[cog]}
 **/
class Solution {
    public int ladderLength(String beginWord, String end, List<String> wordList) {
        Map<String, List<String>> map = preProcess(wordList);
        System.out.println(map);
        //BFS from beginWord.
        Set<String> visited = new HashSet<>();
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{beginWord, "0"});

        Integer res = null;
        while (q.size() != 0) {
            String[] node = q.poll();
            String cur = node[0];

            int level = Integer.parseInt(node[1]);

            if (cur.equals(end)) {
                res = level;
                break;
            }

            if (visited.contains(cur)) {
                continue;
            }

            visited.add(cur);

            for (int i = 0; i < cur.length(); i++) {
                String temp = cur.substring(0, i) + "*" + cur.substring(i + 1, cur.length());
                List<String> list = map.get(temp);
                // System.out.println(cur + ":" + temp +  ":" + list);
                if (list != null) {
                    for (String s : list) {
                        q.add(new String[]{s, (level + 1) + ""});
                    }
                }

            }

        }

        return res == null ? 0 : res + 1;
    }

    Map<String, List<String>> preProcess(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                String temp = w.substring(0, i) + "*" + w.substring(i + 1, w.length());
                List<String> list = map.getOrDefault(temp, new ArrayList<>());
                list.add(w);
                map.put(temp, list);
            }
        }
        return map;
    }

}