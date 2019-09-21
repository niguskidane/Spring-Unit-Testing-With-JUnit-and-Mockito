package io.nk.unittestingwithjunitmockito.Business;

import io.nk.unittestingwithjunitmockito.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSum1(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingSomeDataService() {
        int sum = 0;
        int [] data=someDataService.retriveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
