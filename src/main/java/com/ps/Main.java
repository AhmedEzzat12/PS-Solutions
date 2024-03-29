package com.ps;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableImpl());
        t1.start();
    }

    private static class RunnableImpl implements Runnable {
        public void run() {
            recu("", 0, 0);
        }

//        int n = 2;
//
//        void recu(String s, int sum, int sum2) {
//            if (s.length() == 2 * n) {
//                if (sum == sum2) {
//                    System.out.println(s);
//                }
//                return;
//            }
//
//            recu(s + "0", sum, sum2);
//            if (s.length() < n) {
//                recu(s + "1", sum + 1, sum2);
//            } else {
//                recu(s + "1", sum, sum2 + 1);
//            }
//        }
//        Stack<Character> stack = new Stack<>();
//        List<String> res = new ArrayList<>();
//
//        public List<String> generateParenthesis(int n) {
//            backtrack(res, "", 0, 0, n);
//            return res;
//        }
//
//        private void backtrack(List<String> res, String s, int openN, int closedN, int n) {
//            if (s.length() == (n * 2)) {
//                res.add(s);
//                return;
//            }
//
//            if (openN < n) {
//                backtrack(res, s + "(", openN + 1, closedN, n);
//            }
//
//            if (closedN < openN) {
//                backtrack(res, s + ")", openN, closedN + 1, n);
//            }
//        }
        /*public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            Set<String> operators = Set.of("+", "/", "*", "-");
            for (String token : tokens) {

                if (!operators.contains(token)) {
                    stack.push(parseInt(token));
                } else {
                    switch (token) {
                        case "+" -> {
                            int first = stack.pop();
                            int second = stack.pop();
                            stack.push(first + second);
                        }
                        case "-" -> {
                            int first = stack.pop();
                            int second = stack.pop();
                            stack.push(second - first);
                        }
                        case "*" -> {
                            int first = stack.pop();
                            int second = stack.pop();
                            stack.push(first * second);
                        }
                        case "/" -> {
                            int first = stack.pop();
                            int second = stack.pop();
                            stack.push(second / first);
                        }
                        default -> throw new IllegalArgumentException();
                    }
                }
            }
            return stack.pop();
        }*/

//        public boolean isMatchingPair(char top, char current) {
//            return (current == ')' && top == '(') ||
//                    (current == '}' && top == '{') ||
//                    (current == ']' && top == '[');
//        }
/*

        public boolean isValid(String s) {
            List<Parentheses> parentheses = List.of(new Parentheses('(', ')'), new Parentheses('{', '}'), new Parentheses('[', ']'));
            Deque<Parentheses> characters = new ArrayDeque<>();
            Function<Character, Optional<Parentheses>> isStart = a -> parentheses.stream().filter(parentheses1 -> parentheses1.start == a).findFirst();

            for (char c : s.toCharArray()) {
                Optional<Parentheses> parentheses1 = isStart.apply(c);
                if (parentheses1.isPresent()) {
                    characters.push(parentheses1.get());
                } else {
                    if (characters.isEmpty()) return false;
                    Parentheses peek = characters.pop();
                    if (peek.end != c) {
                        return false;
                    }
                }
            }
            return characters.isEmpty();
        }

        class Parentheses {
            char start;
            char end;

            public Parentheses(char start, char end) {
                this.start = start;
                this.end = end;
            }
        }
*/


       /* class NestedIterator {
            Deque<NestedInteger> stack = new ArrayDeque<>();

            // NestedIterator constructor inializes the stack using the
            // given nestedList list
            public NestedIterator(List<NestedInteger> nestedList) {
                // Write your code here
                for (int i = nestedList.size() - 1; i >= 0; --i) {
                    stack.push(nestedList.get(i));
                }
            }

            // hasNext() will return True if there are still some integers in the
            // stack (that has nested_list elements) and, otherwise, will return False.
            public boolean hasNext() {
                while (!stack.isEmpty()) {
                    NestedInteger peek = stack.peek();
                    if (peek.isFile()) {
                        return true;
                    }
                    if (!peek.getList().isEmpty()) {
                        List<NestedInteger> list = stack.pop().getList();
                        for (int i = list.size() - 1; i >= 0; --i) {
                            stack.push(list.get(i));
                        }
                    }
                }
                return false;
            }

            // Check if there is still an integer in the stack
            public int next() {
                // Write your code here
                return stack.pop().getFile();
            }

            // ------ Please don't change the following function ----------
            // flatten_list function is used for testing porpuses.
            // Your code will be tested using this function
            public static List<Integer> flattenList(NestedIterator obj) {
                List<Integer> result = new ArrayList<Integer>();
                while (obj.hasNext()) {
                    result.add(obj.next());
                }
                return result;
            }
        }

        public class NestedInteger {
            List<NestedInteger> list;
            int file;

            // Constructor initializes an empty nested list.
            public NestedInteger() {
                this.list = new ArrayList<NestedInteger>();
            }

            // Constructor initializes a single file.
            public NestedInteger(int value) {
                this.file = value;
            }

            // @return true if this NestedDirectories holds a single file, rather than a nested list.
            public boolean isFile() {
                if (this.file != 0)
                    return true;
                return false;
            }

            // @return the single file that this NestedDirectories holds, if it holds a single file
            // Return null if this NestedDirectories holds a nested list
            public int getFile() {
                return this.file;
            }

            // Set this NestedDirectories to hold a single file.
            public void setFile(int value) {
                this.list = null;
                this.file = value;
            }

            // Set this NestedDirectories to hold a nested list and adds a nested file to it.
            public void add(NestedInteger ni) {
                if (this.file != 0) {
                    this.list = new ArrayList<NestedInteger>();
                    this.list.add(new NestedInteger(this.file));
                    this.file = 0;
                }
                this.list.add(ni);
            }

            // @return the nested list that this NestedDirectories holds, if it holds a nested list
            // Return null if this NestedDirectories holds a single file
            public List<NestedInteger> getList() {
                return this.list;
            }
        }*/

/*        public static List<Integer> exclusiveTime(int n, List<String> events) {
            List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
            Stack<Event> stack = new Stack<>();
            for (String s : events) {
                Event event = new Event(s);
                if (event.getIsStart()) {
                    stack.push(event);
                } else {
                    Event pop = stack.pop();
                    int executionTime = event.getTime() - pop.getTime() + 1;
                    result.set(pop.getId(), result.get(pop.getId()) + executionTime);
                    if (!stack.isEmpty()) {
                        Event peek = stack.peek();
                        result.set(peek.getId(), result.get(peek.getId()) - executionTime);
                    }
                }
            }
            return result;
        }

        public static class Event {
            private int id;
            private boolean isStart;
            private int time;

            public Event(String content) {
                String[] strs = content.split(":");
                this.id = Integer.valueOf(strs[0]);
                this.isStart = strs[1].equals("start");
                this.time = Integer.valueOf(strs[2]);
            }

            public int getId() {
                return this.id;
            }

            public boolean getIsStart() {
                return this.isStart;
            }

            public int getTime() {
                return this.time;
            }
        }*/

/*        public String minRemoveParentheses(String s) {
            Stack<StackElement> parentheses = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    parentheses.push(new StackElement(c, i));
                } else if (c == ')') {
                    if (parentheses.size() > 0 && parentheses.peek().c == '(') {
                        parentheses.pop();
                    } else {
                        parentheses.push(new StackElement(c, i));
                    }
                }
            }
            if (parentheses.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (parentheses.size() != 0 && i == parentheses.firstElement().index) {
                        parentheses.removeElement(parentheses.firstElement());
                        continue;
                    }
                    stringBuilder.append(s.charAt(i));
                }
                return stringBuilder.toString();
            }
            return s;
        }

        class StackElement {
            char c;
            int index;

            public StackElement(char c, int index) {
                this.c = c;
                this.index = index;
            }
        }*/


/*        public static String removeDuplicates(String s) {
            if (s.length() == 0) return "";
            if (s.length() == 1) return s;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.size() > 0 && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stackToString(stack);
        }

        public static String stackToString(Stack<Character> stack) {
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            return sb.toString();
        }*/

/*
        public int calculator(String expression) {

            Stack<Integer> integers = new Stack<>();
            // Write your code here
            Integer number = 0;
            Integer sign = 1;
            Integer result = 0;

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == ' ') continue;
                if (Character.isDigit(c)) {
                    number = (number * 10) + Character.digit(c, 10);
                } else if (c == '(') {
                    integers.push(result);
                    integers.push(sign);
                    result = 0;
                    sign = 1;
                } else if (c == '+' || c == '-') {
                    result += (number * sign);
                    if (c == '+') {
                        sign = 1;
                    } else {
                        sign = -1;
                    }
                    number = 0;
                } else if (c == ')') {
                    number = number * sign;
                    result = result + number;
                    result *= integers.pop();
                    Integer result2 = integers.pop();
                    result += result2;
                    number = 0;
                }
            }
            result = result + (number * sign);
            return result;
        }
*/

    /*    public int longestConsecutive(int[] nums) {
            Set<Integer> integers = new LinkedHashSet<>(IntStream.of(nums).boxed().toList());
            List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
            if (collect.size() == 1) return 1;
            Map<Integer, Integer> results = new LinkedHashMap<>();
            int group = 1;
            for (int i = 0; i < collect.size() - 1; i++) {
                if (collect.get(i + 1) - collect.get(i) == 1) {
                    results.put(group, results.getOrDefault(group, 1) + 1);
                } else {
                    ++group;
                }
            }
            if (results.values().size() == 0) {
                if (nums.length > integers.size()) {
                    return 1;
                }
                return 0;
            }
            return Collections.max(results.values(), Integer::compareTo);
        }*/


        /*        *//*
         * @param strs: a list of strings
         * @return: encodes a list of strings to a single string.
         *//*
        public String encode(List<String> strs) {
            // write your code here
            return String.join("", strs.stream().map(s -> s.length() + ":" + s).toList());
        }

        *//*
         * @param str: A string
         * @return: dcodes a single string to a list of strings
         *//*
        public List<String> decode(String str) {
            List<String> result = new ArrayList<>();
            String tempStr = str;
            while (tempStr.length() > 0) {
                WordLength wordLength = getWordLength(tempStr);
                int jump = wordLength.numberLength + wordLength.wordLength;
                String substring = tempStr.substring(wordLength.numberLength, jump);
                result.add(substring);
                tempStr = tempStr.substring(jump);
            }
            return result;
        }

        public WordLength getWordLength(String str) {
            int index = 0;
            StringBuilder number = new StringBuilder();
            while (str.charAt(index) != ':') {
                number.append(str.charAt(index));
                ++index;
            }
            return new WordLength(Integer.parseInt(number.toString()), index + 1);
        }

        public class WordLength {
            int wordLength;
            int numberLength;

            public WordLength(int wordLength, int numberLength) {
                this.wordLength = wordLength;
                this.numberLength = numberLength;
            }
        }*/
        /*public boolean isValidSudoku(char[][] board) {
            Map<Integer, List<Character>> integerListMap = new LinkedHashMap<>();
            Set<Character> set = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            int counter = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (set.contains(board[i][j])) {
                            return false;
                        } else {
                            set.add(board[i][j]);
                        }
                    }

                    if (board[j][i] != '.') {
                        if (set2.contains(board[j][i])) {
                            return false;
                        } else {
                            set2.add(board[j][i]);
                        }
                    }

                    if (j % 3 == 0) {
                        ++counter;
                    }
                    if (board[i][j] != '.') {
                        List<Character> list = integerListMap.getOrDefault(counter, new LinkedList<>());
                        list.add(board[i][j]);
                        integerListMap.put(counter, list);
                    }
                }
                if ((i + 1) % 3 == 0) {
                    for (List<Character> list : integerListMap.values()) {
                        if (list.size() != new HashSet<>(list).size()) {
                            return false;
                        }
                    }
                    integerListMap.clear();
                }
                if (i == 0 || i == 1) {
                    counter = 0;
                } else if (i == 2 || i == 3 || i == 4) {
                    counter = 3;
                } else {
                    counter = 6;
                }
            }
            return true;
        }*/


//        public int[] productExceptSelf(int[] nums) {
//            int[] result = new int[nums.length];
//            int x = 1;
//            result[0] = x;
//            for (int i = 1; i < nums.length; i++) {
//                x = x * nums[i - 1];
//                result[i] = x;
//            }
//            x = 1;
//            for (int i = nums.length - 2; i >= 0; i--) {
//                x = x * nums[i + 1];
//                result[i] = result[i] * x;
//            }
//            return result;
//        }


//        public int[] topKFrequent(int[] nums, int k) {
//            Map<Integer, Integer> integerIntegerMap = new HashMap<>();
//            int[] result = new int[k];
//            for (int x : nums) {
//                int i = integerIntegerMap.getOrDefault(x, 0) + 1;
//                integerIntegerMap.put(x, i);
//            }
//
//            Map<Integer, Integer> collect = integerIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//            int index = 0;
//            for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
//                result[index] = entry.getKey();
//                if (index == (k - 1)) {
//                    break;
//                }
//                ++index;
//            }
//            return result;
//        }

//        public List<List<String>> groupAnagrams(String[] strs) {
//            if (strs.length == 1) {
//                List<List<String>> a = new ArrayList<>();
//                a.add(Collections.singletonList(strs[0]));
//                return a;
//            }
//            Map<String, LinkedList<String>> stringLinkedListMap = new HashMap<>();
//            for (String str : strs) {
//                char[] charArray = str.toCharArray();
//                Arrays.sort(charArray);
//                String sorted = new String(charArray);
//                if (stringLinkedListMap.containsKey(sorted)) {
//                    stringLinkedListMap.get(sorted).add(str);
//                } else {
//                    LinkedList<String> strings = new LinkedList<>();
//                    strings.add(str);
//                    stringLinkedListMap.put(sorted, strings);
//                }
//            }
//            return new ArrayList<>(stringLinkedListMap.values());
//        }

//        public static class Value {
//            int index;
//            String sorted;
//
//            public Value(int index, String sorted) {
//                this.index = index;
//                this.sorted = sorted;
//            }
//        }

        /*public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> integerIntegerMap = new TreeMap<>();
            int[] indices = new int[2];
            for (int i = 0; i < nums.length; i++) {
                integerIntegerMap.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int i1 = target - nums[i];
                if (integerIntegerMap.containsKey(i1) && (integerIntegerMap.get(i1) != i)) {
                    indices[0] = i;
                    indices[1] = integerIntegerMap.get(i1);
                    break;
                }
            }
            return indices;
        }*/

        /*public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            char[] charArray = s.toCharArray();
            char[] charArray1 = t.toCharArray();
            Arrays.sort(charArray);
            Arrays.sort(charArray1);
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                char c1 = charArray1[i];
                if (c != c1) return false;
            }
            return true;
        }*/
//        /**
//         * @param arr
//         * @return
//         */
//        public int findLength(String str) {
//            int[] arr = new int[4];
//            arrs = Arrays.stream(arr).sorted().toArray();
//            Integer[] b = Arrays.stream(arr).boxed().sorted().toArray(Integer[]::new);
//            Integer[] a = IntStream.of(arr).boxed().toArray(Integer[]::new);
//            Arrays.setAll(arr, i -> arr[i]);
//            List<Integer> integers = new ArrayList<>(Arrays.stream(arr).boxed().toList());
//            integers.sort(Collections.reverseOrder());
//        }


    }
}