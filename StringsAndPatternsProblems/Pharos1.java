package solutions.StringsAndPatternsProblems;

import java.util.LinkedList;
import java.util.List;

public class Pharos1 {
    /*
    We define a sentence to be a string of space-separated words that starts with a capital letter followed by lowercase letters and spaces, and ends with a period (i.e., it satisfies the regular expression ^[A-Z][a-z ]*\.$ ).
We want to rearrange the words in a sentence such that the following conditions are satisfied:
Each word is ordered by length, ascending.
Words of equal length must appear in the same order as in the original sentence.
The rearranged sentence must be formatted to satisfy the regular expression ^[A-Z][a-z]*\.$.
For example, consider the sentence "Cats and hats." First the words are ordered by length, maintaining original order for ties: [and, cats, hats].
Now reassemble the sentence and apply formatting, the output would be: "And cats hats."
Function Description:
Complete the function rearrange in the editor below. The function must return a properly formed sentence arranged as described.
rearrange has the following parameter(s):
sentence: a well formed sentence string


#	Original sentence	Expected Output
1	Cats and hats	    And cats hats.
2	I love coding with ror. 	I ror love with coding.
     */
    public String rearrange(String sentence){
        int maxN = 0;
        String[] words = sentence.split(" ");
        if(words.length == 0)return "";
        words[words.length-1] = words[words.length-1].substring(0,words[words.length-1].length()-1);
        char[] first = words[0].toCharArray();
        first[0] = Character.toLowerCase(first[0]);
        words[0] = new String(first);
        for(String word : words){
            maxN = Math.max(word.length(),maxN);
        }
        List<String>[] sortedWords = new List[maxN+1];
        for(String word : words){
            int n = word.length();
            if(sortedWords[n] == null)
                sortedWords[n] = new LinkedList<>();
            sortedWords[n].add(word);
        }
        StringBuilder sb = new StringBuilder();
        for(List<String> list: sortedWords){
            if(list != null){
                for(String word : list) {
                    if (sb.length() == 0) {
                        char[] chars = word.toCharArray();
                        chars[0] = Character.toUpperCase(chars[0]);
                        sb.append(new String(chars)).append(" ");
                    } else {
                        sb.append(word).append(" ");
                    }
                }
            }
        }
        return sb.substring(0,sb.length()-1)+".";

    }
    /*
    You will be given an array, each element consists of two characters that are in order. Two elements of the array can follow each other if the right character of the first element is equal to the left character of the second element. The elements of the array can be ordered together to form a country name, Each character is guranteed to appear only once in the word. You are required to find the country name that can be formed from each input
For example, the following input array ['GY', 'EG', 'YP', 'PT'] should return EGYPT
Function Description:
Complete the formACountryName function in your editor. It has one parameter: an array. The function must return the name of the country that can be formed.
formAcountryName has the following parameter(s):
input: an array consisiting of the list of ordered domino piece
Output should be a string representing the name of the country that can be formed
     */
    public String formACountryName(String[] input) {
        String prefix = "";
        String[] first = new String[26];
        String[] second = new String[26];
        for(String s : input){
            int c1 = s.charAt(0) - 'A';
            int c2 = s.charAt(1) - 'A';
            first[c1] = s;
            second[c2] = s;
        }
        for(int i=0; i<26; i++){
            if(first[i] != null && second[i] == null){
                prefix = first[i];
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        String w = prefix;
        sb.append(w);
        w = first[w.charAt(1)-'A'];
        while(w != null){

            sb.append(w.charAt(1));
            w = first[w.charAt(1)-'A'];
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Pharos1 p = new Pharos1();

        String[] input = {"RM", "ER", "GE", "AN", "NY", "MA"};

        System.out.println(p.formACountryName(input));
    }
}
/*
Q2
A company maintains information about its orders in table called orders. Write a query to find the day on which most of the orders has been placed and the orders total amount is higher than 100. If there is more than one day with the same number of orders, then print the nearest day. (Columns in orders tables are: id, date, status, total, customer_id)
Write your sql query in the editor and submit to check the results.
Output format:
The output of the query should be the day from the Orders table on which most of the orders has been placed nd the orders total amount is higher than 100. If there is more than one day with the same number of orders, then print the nearest day.
The query should start with a select statement, Any comments should be added at the end
-------------
SELECT o.date
FROM Orders as o
Where o.total in (Select max(total) FROM Orders) and o.total > 100
order by ABS( DATEDIFF( o.date, NOW() ) )
LIMIT 1
****************** Q4 **********************
A school stores the information of exams and subjects in two data tables: exams and subjects . Write a query to print the respective subject name and the count of exams per subject (even for subjects that do not have any exam solved). Sort the results by descending order count of exams; if two or more subjects have the same count then sort those subjects in descending order by subject name.
Database Structure
exams (id, name, subject_id)
subjects (id, name)
Write your sql query in the editor and submit to check the results.
Output format:
Each row must contain the following respective attributes for a subject:
The name of the subject.
The count of exams of each subject.
As following:

=== SUBJECTS.NAME COUNT_OF_EXAMS ===

Sort the results by descending order of the average grade; if two or more subjects have the same average then sort those subjects in descending order by subject name. .
The query should start with a select statement, Any comments should be added at the end
Example:

English 3
French 3
Maths
---------------------------
SELECT Subjects.name , count(e.id) as COUNT_OF_EXAMS
from subjects
LEFT JOIN exams as e on subjects.id = e.subject_id
group by subjects.id
order by COUNT_OF_EXAMS desc , subjects.name
 */