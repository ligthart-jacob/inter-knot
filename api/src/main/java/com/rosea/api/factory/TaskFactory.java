package com.rosea.api.factory;

import com.rosea.api.model.DailyTask;
import com.rosea.api.model.RegularTask;

public class TaskFactory {
    public RegularTask createRegularTask() {
        return new RegularTask();
    }

    public DailyTask createDailyTask() {
        return new DailyTask();
    }
}
