package test;

import main.TimerMaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


class TimerMasterTest {
    TimerMaster timer = new TimerMaster();
    @Test
    void getPeriodStartSave() {
        Assertions.assertEquals(timer.getPeriodStartSave(LocalDateTime.now()),0);
    }

    @Test
    void testGetPeriodStartSave() {
        LocalDateTime localdate = LocalDateTime.now();
        Assertions.assertEquals(timer.getPeriodStartSave(localdate,localdate),0);
    }

    @Test
    void getDate() {
        Assertions.assertEquals(LocalDateTime.now(), timer.getDate());
    }
}