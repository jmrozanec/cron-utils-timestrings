package com.cronutils.timestrings;

import org.joda.time.DateTime;
import org.junit.Test;

import static com.cronutils.timestrings.TimeStringBuilder.given;
import static org.junit.Assert.*;

public class TimeStringBuilderTest {

    @Test
    public void testBuildExpression() throws Exception {
        DateTime now = new DateTime(2016, 6, 22, 0, 0, 0);
        String sql =
                given("select * from tracks where ds>='YESTERDAY' and ds<'TODAY'")
                        .registerReplacement("YESTERDAY", "yyyy-MM-dd", date->date.minusDays(1))
                        .registerReplacement("TODAY", "yyyy-MM-dd", date->date)
                        .buildExpression(now);
        assertEquals("select * from tracks where ds>='2016-06-21' and ds<'2016-06-22'", sql);
    }
}