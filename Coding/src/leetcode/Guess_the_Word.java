/* over, n, n
 * 
 * 
 * This is an interactive problem.

You are given an array of unique strings wordlist where wordlist[i] is 6 letters long, and one word in this list is chosen as secret.

You may call Master.guess(word) to guess a word. The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word. Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have exactly 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or fewer calls to Master.guess and at least one of these guesses was secret, then you pass the test case.

 

Example 1:

Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
Output: You guessed the secret word correctly.
Explanation:
master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
Example 2:

Input: secret = "hamada", wordlist = ["hamada","khaled"], numguesses = 10
Output: You guessed the secret word correctly.
 

Constraints:

1 <= wordlist.length <= 100
wordlist[i].length == 6
wordlist[i] consist of lowercase English letters.
All the strings of wordlist are unique.
secret exists in wordlist.
numguesses == 10
 */


package leetcode;

public class Guess_the_Word {
	
	/*
	 * 
	 * 
	 * Foreword
Great! Finally we have an interactive problem on LeetCode platform.

The description emphasizes that,
the wordlist is generated randomly and it's does have a reason.

There is no solution that can guarantee to find a secret word in 10 tries.
If I make up a test case with wordlist like ["aaaaaa", "bbbbbb" ...., "zzzzzz"],
it needs 26 tries to find the secret.

So 10 tries is just a constrain to check a reasonable solution.
And instead of just finding right output from given input, it's more about a strategy.

So it doesn't make any sense to do any hand-made "extra challendge".



Intuition
Take a word from wordlist and guess it.
Get the matches of this word
Update our wordlist and keep only the same matches to our guess.

This process is straight forward.
However, the key point is, which word should we guess from all of the wordlist?



Prepare
For example we guess "aaaaaa" and get matches x = 3,
we keep the words with exactly 3 a .

Also we need to know the matches between two words,
so a helper function match as following will be useful.

C++:

    int match(string a, string b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a[i] == b[i])
                matches ++;
        return matches;
    }
Java:

    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches ++;
        return matches;
    }
Python

    def match(self, w1, w2):
        return sum(i == j for i, j in zip(w1, w2))



Solution 1: Always Guess the First One
First of all, we just guessed the first word in the wordlist.
Unfortunately, it didn't get a lucky pass.
This problem has only 5 test cases but they are good.

Time complexity O(N)
Space complexity O(N)



Solution 2.1: Shuffle the Wordlist
I didn't give up the previous idea, it's not that bad.
So I decided to try my luck by shuffling wordlist at the beginning.

Note that it may sound some unreliable,
but actully randomicity is very useful trick in both competition and reality problem.

This method can get accepted but not for sure.
After manualy testing locally,
on Leetcode's test cases set and random test cases set,
it has roughly 70% rate to get accepted.

However, C++ may set random seed in the OJ.
I keep submitting but doesn't fail.

Time complexity O(N)
Space complexity O(N)


C++

    void findSecretWord(vector<string>& wordlist, Master& master) {
        random_shuffle(wordlist.begin(), wordlist.end());
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            string guess = wordlist[0];
            x = master.guess(guess);
            vector<string> wordlist2;
            for (string w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.push_back(w);
            wordlist = wordlist2;
        }
    }
Python:

    def findSecretWord(self, wordlist, master):
        random.shuffle(wordlist)
        for i in range(10):
            guess = random.choice(wordlist)
            x = master.guess(guess)
            wordlist = [w for w in wordlist if sum(i == j for i, j in zip(guess, w)) == x]



Solution 2.2: Guess a Random Word
All words are generated randomly.
So why not we also guess a random word and let it be whatever will be.
This is actually the same as the previous solution.
Though we don't need one more O(N) operation to shuffle the wordlist at first.

Time complexity O(N)
Space complexity O(N)

C++:

    void findSecretWord(vector<string>& wordlist, Master& master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            string guess = wordlist[rand() % (wordlist.size())];
            x = master.guess(guess);
            vector<string> wordlist2;
            for (string w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.push_back(w);
            wordlist = wordlist2;
        }
    }
Java:

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
Python:

    def findSecretWord(self, wordlist, master):
        for i in range(10):
            guess = random.choice(wordlist)
            x = master.guess(guess)
            wordlist = [w for w in wordlist if sum(i == j for i, j in zip(guess, w)) == x]



Solution 3: Minimax
Now we want to try a better solution.
Generally, we will get 0 matches from the master.guess.
As a result, the size of wordlist reduces slowly.

Recall some math here, the possiblity that get 0 matched is:
(25/26) ^ 6 = 79.03%

That is to say, if we make a blind guess,
we have about 80% chance to get 0 matched with the secret word.

To simplify the model,
we're going to assume that,
we will always run into the worst case (get 0 matched).

In this case,
we have 80% chance to eliminate the candidate word
as well as its close words which have at least 1 match.

Additionally, in order to delete a max part of words,
we select a candidate who has a big "family",
(that is, the fewest 0 matched with other words.)
We want to guess a word that can minimum our worst outcome.

So we compare each two words and count their matches.
For each word, we note how many word of 0 matches it gets.
Then we guess the word with minimum words of 0 matches.

In this solution, we apply a minimax idea.
We minimize our worst case,
The worst case is max(the number of words with x matches),
and we assume it equal to "the number of words with 0 matches"

Time complexity O(N^2)
Space complexity O(N)

C++:

    void findSecretWord(vector<string>& wordlist, Master& master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            unordered_map<string, int> count;
            for (string w1 : wordlist)
                for (string w2 : wordlist)
                    if (match(w1, w2) == 0)
                        count[w1]++;
            pair<string, int> minimax = {wordlist[0], 1000};
            for (string w : wordlist)
                if (count[w] <= minimax.second)
                    minimax = make_pair(w, count[w]);
            x = master.guess(minimax.first);
            vector<string> wordlist2;
            for (string w : wordlist)
                if (match(minimax.first, w) == x)
                    wordlist2.push_back(w);
            wordlist = wordlist2;
        }
    }
Java:

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist)
                for (String w2 : wordlist)
                    if (match(w1, w2) == 0)
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
            String guess = "";
            int min0 = 100;
            for (String w : wordlist)
                if (count.getOrDefault(w, 0) < min0) {
                    guess = w;
                    min0 = count.getOrDefault(w, 0);
                }
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
Python:

    def findSecretWord(self, wordlist, master):
        x = 0
        while x < 6:
            count = collections.Counter(w1 for w1, w2 in itertools.permutations(wordlist, 2) if self.match(w1, w2) == 0)
            guess = min(wordlist, key=lambda w: count[w])
            x = master.guess(guess)
            wordlist = [w for w in wordlist if self.match(w, guess) == x]



Result Analyse
To be more convincing, I test each approach with 1000 test cases.
For the random approach, average 6.5 guess, worst case 14 guess.
For the minimax approach, average 5.5 guess, worst case 10 guess.
I draw this diagram to visualize the result:
image



Solution 4: Count the Occurrence of Characters
In the previous solution, we compaired each two words.
This make the complexity O(N^2) for each turn.

But actually we don't have to do that.
We just need to count the occurrence for each character on each position.

If we can guess the word that not in the wordlist,
we can guess the word based on the most frequent character on the position.

Here we have to guess a word from the list,
we still can calculate a score of similarity for each word,
and guess the word with highest score.

Time complexity O(N)
Space complexity O(N)


Java

    public void findSecretWord(String[] wordlist, Master master) {
        for (int t = 0, x = 0; t < 10 && x < 6; ++t) {
            int count[][] = new int[6][26], best = 0;
            for (String w : wordlist)
                for (int i = 0; i < 6; ++i)
                    count[i][w.charAt(i) - 'a']++;
            String guess = wordlist[0];
            for (String w: wordlist) {
                int score = 0;
                for (int i = 0; i < 6; ++i)
                    score += count[i][w.charAt(i) - 'a'];
                if (score > best) {
                    guess = w;
                    best = score;
                }
            }
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
C++

    void findSecretWord(vector<string>& wordlist, Master& master) {
        int count[6][26], x = 0, best;
        for (int t = 0; t < 10 && x < 6; ++t) {
            memset(count, 0, 156 * sizeof(int));
            for (string w : wordlist)
                for (int i = 0; i < 6; ++i)
                    count[i][w[i] - 'a']++;
            best = 0;
            string guess = wordlist[0];
            for (string w: wordlist) {
                int score = 0;
                for (int i = 0; i < 6; ++i)
                    score += count[i][w[i] - 'a'];
                if (score > best) {
                    guess = w;
                    best = score;
                }
            }
            x = master.guess(guess);
            vector<string> wordlist2;
            for (string w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.push_back(w);
            wordlist = wordlist2;
        }
    }
Python

    def findSecretWord(self, wordlist, master):
        def match(w1, w2):
            return sum(i == j for i, j in zip(w1, w2))

        n = 0
        while n < 6:
            count = [collections.Counter(w[i] for w in wordlist) for i in xrange(6)]
            guess = max(wordlist, key=lambda w: sum(count[i][c] for i, c in enumerate(w)))
            n = master.guess(guess)
            wordlist = [w for w in wordlist if match(w, guess) == n]
	 * 
	 */
	
	 public void findSecretWord(String[] wordlist, Master master) {
	        for (int t = 0, x = 0; t < 10 && x < 6; ++t) {
	            int count[][] = new int[6][26], best = 0;
	            for (String w : wordlist)
	                for (int i = 0; i < 6; ++i)
	                    count[i][w.charAt(i) - 'a']++;
	            String guess = wordlist[0];
	            for (String w: wordlist) {
	                int score = 0;
	                for (int i = 0; i < 6; ++i)
	                    score += count[i][w.charAt(i) - 'a'];
	                if (score > best) {
	                    guess = w;
	                    best = score;
	                }
	            }
	            x = master.guess(guess);
	            List<String> wordlist2 = new ArrayList<String>();
	            for (String w : wordlist)
	                if (match(guess, w) == x)
	                    wordlist2.add(w);
	            wordlist = wordlist2.toArray(new String[0]);
	        }
	    }
	    
	        public int match(String a, String b) {
	        int matches = 0;
	        for (int i = 0; i < a.length(); ++i)
	            if (a.charAt(i) == b.charAt(i))
	                matches ++;
	        return matches;
	    }

}
