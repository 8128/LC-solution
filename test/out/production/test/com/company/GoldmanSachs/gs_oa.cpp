//spiral order primes
#include <cstdlib>
#include <iostream>
#include <vector>
#include <string>
#include <math.h>
#include <unordered_map>
#include <sstream>
#include <queue>
#include <algorithm>
#include <iomanip>
using namespace std;

//Spiral Order

//bool isprime(int num){
//    if(num == 0 || num == 1){return false;}
//    else if(num == 2){return true;}
//    for(int i = 2; i <= (int)sqrt(num); i++){
//        if(num % i == 0){
//            return false;
//        }
//    }
//    return true;
//}
vector<int> primes(vector<vector<int>>& grids){
	int direction = 0;
	vector<int> result;
	if(grids.empty()){return result;}
	int left = 0, right = grids[0].size()-1;
	int top = 0, bottom = grids.size()-1;
	int max_range = 100000;
	vector<bool> prime(max_range, true);
	prime[0] = prime[1] = false;
	for(int i = 2; i <= max_range/2; i++){
		if(prime[i]){
			for(int j = i*2; j < max_range; j = j+i){
				prime[j] = false;
			}
		}
	}
	while(left <= right && top <= bottom){
		if(direction == 0){
			for(int i = left; i <= right; i++){
				if(prime[grids[top][i]]){
					result.push_back(grids[top][i]);
				}
			}
			top++;
		}
		else if(direction == 1){
			for(int i = top; i <= bottom; i++){
				if(prime[grids[i][right]]){
					result.push_back(grids[i][right]);
				}
			}
			right--;
		}
		else if(direction == 3){
			for(int i = bottom; i >= top; i--){
				if(prime[grids[i][left]]){
					result.push_back(grids[i][left]);
				}
			}
			left++;
		}
		else{
			for(int i = right; i >= left; i--){
				if(prime[grids[bottom][i]]){
					result.push_back(grids[bottom][i]);
				}
			}
			bottom--;

		}
		direction = (direction + 1) % 4;
	}
	return result;
}

//Pair of songs
int numPairsDivisibleBy60(vector<int>& time) {
    vector<int> counter(60, 0);
    int count = 0;
    for(auto& t : time){
        t %= 60;
        int pair = (60 - t) % 60; //avoid negative value;
        count += counter[pair];
        counter[t]++;
    }
    return count;
}

//Strange sort
bool compare(const pair<double, string>& p1, const pair<double, string>& p2){
    return p1.first < p2.first;
}
vector<string> strangeSort(vector<int> mapping, vector<string> nums){
    vector<int>location(10, 0);
    for(int i = 0; i < 10; i++){
        location[mapping[i]] = i;
    }
    vector<pair<int, string>> array;
    for(auto& s : nums){
        string copy_s = s;
        for(auto& letter : copy_s){
            letter = location[letter-'0'] + '0';
        }
        double value = stod(copy_s);
        array.push_back(make_pair(value, s));
    }
    stable_sort(array.begin(), array.end(), compare);
    vector<string> result;
    for(auto pair : array){
        result.push_back(pair.second);
    }
    return result;
}

//Share price
int shareprice(string invest){
    vector<int> count(3, 0);
    int number = 0;
    int start = 0, pointer = 0;
    while(pointer < invest.size()){
        int index = invest[pointer] - 'A';
        if(index < 3){
            count[index]++;
        }
        while(count[0] && count[1] && count[2]){
            int index = invest[start]-'A';
            if(index < 3){
                count[index]--;
            }
            number += invest.size()-pointer;
            start++;
        }
        pointer++;
    }
    return number;
}

//MaxCommon
int maxcommon(string s){
    vector<int> counter1(26, 0);
    vector<int> counter2(26, 0);
    int result = 0, curr = 0;
    for(auto& c : s){
        counter2[c-'a']++;
    }
    for(int i = 0; i < s.size(); i++){
        int number = s[i]-'a';
        if(counter2[number] > counter1[number] + 1){
            curr++;
        }
        else if(counter2[number] <= counter1[number]){
            curr--;
        }
        counter2[number]--;
        counter1[number]++;
        result = max(result, curr);
    }
    return result;
}

//Grid Game
vector<vector<int>> Gridgame(vector<vector<int>>& grid, int k, vector<string>& rules){
    if(k == 0){return grid;}
    if(grid.empty()){return grid;}
    int m = grid.size(), n = grid[0].size();
    vector<vector<int>> newgrid(m, vector<int>(n,0));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            int count = 0;
            for(int p = -1; p <=1; p++){
                for(int q = -1; q <= 1; q++){
                    int new_i = i + p, new_j = j + q;
                    if(new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || (p == 0 && q == 0)){
                        continue;
                    }
                    else if(grid[new_i][new_j]){
                        count++;
                    }
                }
            }
            if(rules[count] == "alive"){
                newgrid[i][j] = 1;
            }
        }
    }
    return Gridgame(newgrid, k-1, rules);
}

//Weekly Stock
string round(double number, int bit){
    stringstream ss;
    ss << fixed << setprecision(bit) << number;
    string s = ss.str();
    return s;
}
vector<string> weeklystock(vector<int> prices){
    int len = prices.size();
    vector<string> result;
    int start = 0, end = 6;
    double sum  = 0;
    for(int i = start; i <= end; i++){
        sum += prices[i];
    }
    result.push_back(round(sum / 7.0, 2));
    while(end < len-1){
        sum -= prices[start++];
        sum += prices[++end];
        result.push_back(round(sum / 7.0, 2));
    }
    return result;
}

//Find Rank
int findrank(vector<vector<int>> performance, int rank){
    if(performance.empty()){return 0;}
    int m = performance.size(), n = performance[0].size();
    vector<pair<int, int>> grades;
    for(int i = 0; i < m; i++){
        int sum = 0;
        for(int j = 0; j < n; j++){
            sum += performance[i][j];
        }
        grades.push_back(make_pair(sum, i));
    }
    stable_sort(grades.begin(), grades.end(), [](pair<int,int>p1, pair<int,int>p2){return p1.first < p2.first;});
    return grades[rank-1].second;
}

//Matrix Game
int matrixgame(vector<vector<int>> matrix){
    if(matrix.empty()){return 0;}
    int m = matrix.size(), n = matrix[0].size();
    priority_queue<int> pq;
    for(int c = 0; c < n; c++){
        int sum = 0;
        for(int r = 0; r < m; r++){
            sum += matrix[r][c];
        }
        pq.push(sum);
    }
    int sum1 = 0, sum2 = 0;
    int order = 0;
    while(!pq.empty()){
        int value = pq.top();
        pq.pop();
        if(order){
            sum2 += value;
        }
        else{
            sum1 += value;
        }
        order = 1 - order;
    }
    return sum1 - sum2;
}

//Rotate String
string rotatestring(string s, vector<int>dir, vector<int> amount){
    int start = 0;
    for(int i = 0; i < dir.size(); i++){
        int flag = -1;
        if(!dir[i]){
            flag = 1;
        }
        start += amount[i] * flag;
        start %= s.size();
    }
    string result;
    for(int i = 0; i < s.size(); i++){
        result += s[(start+i)%s.size()];
    }
    return result;
}

int main(){
//    vector<vector<int>> v = {{7,7,3,8,1},{13,5,4,5,2},{9,2,12,3,9},{6,12,1,11,41}};
//    vector<int> result = primes(v);
//    vector<int> v1 = {3,5,4,6,2,7,9,8,0,1};
//    vector<string> v2 = {"990","332","32"};
//    vector<int> v1 = {2,1,4,8,6,3,0,9,7,5};
//    vector<string> v2 = {"12","02","4","023","65","83","224","50"};
//    vector<int> v1 = {0,1,2,3,4,5,6,7,8,9};
//    vector<string> v2 = {"180","84","99","003","53","28","60","070","1"};
//    vector<string> result = strangeSort(v1, v2);
//    vector<int> v1 = {7,8,8,11,9,7,5,6};
//    vector<int> v2 = {5,5,5,5,5,5,5,6,6};
//    vector<double> result = weeklystock(v2);
//    for(auto& element : result){
//        cout << element << " ";
//    }
//    string s = "ABBCZBAC";
//    cout << shareprice(s) << endl;
//    string s = "abcdecdefg";
//    string s = "aaaaa";
//    cout << maxcommon(s) << endl;
//    vector<vector<int>> grid = {{0,1,1,0}, {1,1,0,0}};
//    vector<string> rules = {"dead","dead","dead","alive","dead","alive","dead","dead","dead"};
//    vector<vector<int>> result = Gridgame(grid, 2, rules);
//    for(auto& row : result){
//        for(auto& element : row) {
//            cout << element << " ";
//        }
//    }
//    vector<vector<int>> performance = {{79,89,15}, {85,89,92}, {71,96,88}};
//    cout << findrank(performance, 2) << endl;
//    vector<vector<int>> v1 = {{3,7,5,3,4,5}, {4,5,2,6,5,4}, {7,4,9,7,8,3}};
//    cout << matrixgame(v1) << endl;
    string s = "hurart";
    vector<int> direction = {0,1};
    vector<int> amount = {4, 1};
    cout << rotatestring(s, direction, amount) << endl;
    return 0;
}