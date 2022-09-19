/**
 * Time complexity: O(n * l) : Where N is number of input strings. l is the average length of each string
 * Space complexity: O(n * l) : Where N is number of input strings. l is the average length of each string
 * <p>
 *
 * Explanation:
 * <p>
 * 1. We use a hashmap to strore content vs List of final result paths.
 * 2. Iterate each input string and parse the file path by breaking into individual tokens
 * 3. Split each token into individual file path, actual content.
 * 4. Store the tokens in the map with content as key and value as the constructed final path
 * 5. If List<String> paths has size > 1 it means it has duplicate paths.
 * 6. So return that path in the result.
 **/


class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] tokens = path.split(" ");
            String dir = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                int index = tokens[i].indexOf("(");
                String file = tokens[i].substring(0, index);
                String content = tokens[i].substring(index + 1);

                String fpath = dir + "/" + file;

                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(fpath);
                map.put(content, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> l : map.values()) {
            if (l.size() > 1) {
                res.add(new ArrayList<>(l));
            }
        }

        return res;

    }
}