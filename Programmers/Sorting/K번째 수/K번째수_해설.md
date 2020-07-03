# K번째 수
## 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한사항
* array의 길이는 1 이상 100 이하입니다.
* array의 각 원소는 1 이상 100 이하입니다.
* commands의 길이는 1 이상 50 이하입니다.
* commands의 각 원소는 길이가 3입니다.

## 입출력 예
|array|commands|return|
|:--:|:--:|:--:|
|[1, 5, 2, 6, 3, 7, 4]|	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]|[5, 6, 3]|

## 입출력 예 설명
* [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

* [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

* [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

---
# 해설
## 기본사항
Language : **Java**

Tool : Visual Code

## 순서
1. 초기 설정
2. 주어진 배열의 i ~ j 인덱스 부분 생성
3. 잘린 배열을 정렬
> 여기서는 `삽입정렬(InsertSort)`을 이용
4. 정렬된 배열의 K번쨰 수를 answer[]에 차례대로 삽입

## 풀이
### 1. 초기 설정
처음에 배열 answer[]의 크기를 초기화 해줘야 하는데, **commands의 길이만큼 분할된 배열의 K번째 수가 도출**되기 때문에 `commands.length`로 설정한다. #2 에서 자세히 설명한다.

그리고 answer[]의 index에 접근하기 위해 `Integer` 형식의 `answerInit`를 선언해준다.
```java
int answerInit = 0;
int [] answer = new int[commands.length];
```
### 2. 주어진 배열의 i ~ j 인덱스 부분 생성
배열을 나누는 방법에는 두 가지가 있는데,
1. `for문`을 이용하여 범위의 배열값을 복사
2. Array의 method `copyOfRange()`를 이용

> 여기서는 library의 사용을 최소화하기 위해 **1번 방법(for문)** 을 사용한다.

commands 배열 안의 값을 이용하여 분할을 하기 위해서는 **각각의 값의 의미**를 알아야 한다.
|commands|[[2, 5, 3], [4, 4, 1], [1, 7, 3]]|
|:--:|:--:|

|값|설명|
|:--:|:--:|
|[[2, □, □], [4, □, □], [1, □, □]]|분할 시작 index|
|[[□, 5, □], [□, 4, □], [□, 7, □]]|분할 끝 index|
|[[□, □, 3], [□, □, 1], [□, □, 3]]|k|

3개의 내부 배열에 접근하기 위해 commands의 길이만큼(commands.length) 도는 for문을 설정한다.
```java
for(int i=0; i<commands.length; i++)
```

commands[index][0] ~ commands[index][1] 범위의 배열을 잘라내야 하므로,

분할한 배열을 return하는 메소드인 `getSubArray()`를 생성한다.
```java
public int [] getSubArray(int [] array, int [] subCommands)
```

나눈 배열을 임시 저장하는 temp[]을 선언하고, 크기를 위의 범위(commands[index][0] ~ commands[index][1])만큼 설정한다. 편의를 위해 `길이 변수 len`과 `분할 배열 index 접근 변수 init`를 생성하였다.
```java
int init = 0;
int len = subCommands[1] - subCommands[0] + 1;
int [] temp = new int[len];
```

지정한 범위의 array[] 값을 temp[]에 복사하고 배열을 return 한다.
```java
for(int k=subCommands[0]; k<=subCommands[1]; k++) {
            temp[init++] = array[k-1];  // 배열의 index는 0부터 시작하므로 1을 빼줌
}

return temp;
```

### 3. 잘린 배열을 정렬
분할된 배열을 `오름차순`으로 정렬한다. 배열의 크기가 작아 알고리즘에 따른 정렬 속도차가 크지 않으므로, `삽입정렬(insertSort)`을 이용한다. 


```java
public void insertSort(int [] subArray, int p, int r) {
        for(int i=p+1; i<r; i++) {
            int j;
            int subTmp = subArray[i];
            for(j=i; j>p && subArray[j-1] > subTmp; j--)
                subArray[j] = subArray[j-1];
            subArray[j] = subTmp;
        }
    }
}
```

### 4. 정렬된 배열의 K번쨰 수를 answer[]에 차례대로 삽입
insertSort()로 배열 정렬 후 commands[index][2](K번째 수)를 추출하여 answer에 저장한다.

배열은 0부터 시작하므로 commands[index][2] - 1을 해준다(1을 빼지 않으면 범위 초과 오류가 난다).
```java
insertSort(tmp, 0, tmp.length);
answer[answerInit++] = tmp[commands[i][2] - 1];
```

마지막으로 answer값을 return 해준다.
```java
return answer;
```
---
# 전체 코드
```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answerInit = 0;
        int [] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int [] tmp = getSubArray(array, commands[i]);
            insertSort(tmp, 0, tmp.length);
            answer[answerInit++] = tmp[commands[i][2] - 1];
        }

        return answer;
    }

    public int [] getSubArray(int [] array, int [] subCommands) {
        int init = 0;
        int len = subCommands[1] - subCommands[0] + 1;
        int [] temp = new int[len];

        for(int k=subCommands[0]; k<=subCommands[1]; k++) {
            temp[init++] = array[k-1];
        }

        return temp;
    }

    public void insertSort(int [] subArray, int p, int r) {
        for(int i=p+1; i<r; i++) {
            int j;
            int subTmp = subArray[i];
            for(j=i; j>p && subArray[j-1] > subTmp; j--)
                subArray[j] = subArray[j-1];
            subArray[j] = subTmp;
        }
    }
}
```