package io.nk.unittestingwithjunitmockito.Business;

import io.nk.unittestingwithjunitmockito.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
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
