class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = weights[0];
        int maxWeight = 0;

        for (int weight : weights) {
            if (weight > minWeight) {
                minWeight = weight;
            }
            maxWeight += weight;
        }

        int left = minWeight;
        int right = maxWeight;

        int result = right;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            int minDay = 1;
            int sum = 0;
            for (int weight : weights) {
                if (weight + sum <= middle) {
                    sum += weight;
                } else {
                    minDay++;
                    if (minDay > days) {
                        break;
                    }
                    sum = weight;
                }
            }

            if(minDay <= days){
                result = middle;
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        return result;
    }
}

// use binary search to find min result
// start with middle of min and max weight
// if middle pass, then move max to middle and start again