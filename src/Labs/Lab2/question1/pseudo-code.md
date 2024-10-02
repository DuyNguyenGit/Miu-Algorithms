Algorithm findThirdMaxUsingAlgorithm1(A)            #Operations                                             
    int length = A.length;                              2
    if (length < 2) {                                   1
        return -1;                                      1
    }
    int firstMaxIndex = 0;                              1
    for (int i = 1; i < length; i++) {                  (1+n) + 2(n-1)
        if (arr[i] > arr[firstMaxIndex]) {              3(n-1)
            firstMaxIndex = i;                          (n-1)
        }
    }
    int secondMaxIndex = 0;                             1
    for (int i = 1; i < length; i++) {                  (1+n) + 2(n-1)
        if (arr[i] > arr[secondMaxIndex]                4(n-1)
            && firstMaxIndex != i) {                    
            secondMaxIndex = i;                         (n-1)
        }
    }
    int thirdMaxIndex = 0;                              1
    for (int i = 1; i < length; i++) {                  (1+n) + 2(n-1)
        if (arr[i] > arr[thirdMaxIndex]                 5(n-1)
            && secondMaxIndex != i 
            && firstMaxIndex != i) {
            thirdMaxIndex = i;                          (n-1)
        }
    }
    return arr[thirdMaxIndex];                          2
                                            Total       24n - 9     

Algorithm findThirdMaxUsingAlgorithm2(A)            #Operations                                             
    int length = A.length;                              2
    if (length < 2) {                                   1
        return -1;                                      1
    }
    int firstMax = arr[0];                              2
    int secondMax = arr[0];                             2
    thirdMax = arr[0];                                  2
    for (int i = 1; i < length; i++) {                  1+n + 2(n-1)
        if (arr[i] > arr[firstMax]) {                   3(n-1)
            firstMax = arr[i];                          2(n-1)
        } else if (arr[i] > arr[secondMax]) {           3(n-1)
            secondMax = arr[i];                         2(n-1)
        } else if (arr[i] > arr[thirdMax]) {            3(n-1)
            thirdMax = arr[i];                          2(n-1)
        }
    }
    return thirdMax;                                    1
                                            Total       18n - 6

Algorithm findThirdMaxUsingAlgorithm3(A)                                #Operations                                             
    TreeMap<Integer, Integer> orderedDict = new TreeMap<>();    

    for (int num : A) {                                                     n
        orderedDict.put(num, orderedDict.getOrDefault(num, 0) + 1);         5
    }

    int count = 3;                                                          1

    for (int key : orderedDict.descendingKeySet()) {                        n+1
        int value = orderedDict.get(key);                                   2n
        if(value >= count) {                                                n
            return key;                                                     1
        } else {
            count -= value;                                                 n        
        }
    }

    return -1;                                                              1
                                                                Total       6n + 9