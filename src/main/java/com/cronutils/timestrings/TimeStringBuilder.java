/*
 * Copyright 2016 jmrozanec
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cronutils.timestrings;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TimeStringBuilder {
    private Map<String, DateTimeFormatter> formats;
    private Map<String, Function<DateTime, DateTime>> timeFunctions;
    private String expression;

    private TimeStringBuilder(String expression){
        this.expression = expression;
        this.formats = new HashMap<>();
        this.timeFunctions = new HashMap<>();
    }

    public static TimeStringBuilder given(String expression){
        return new TimeStringBuilder(expression);
    }

    public TimeStringBuilder registerReplacement(String expression, String format, Function<DateTime, DateTime> fromNow){
        this.formats.put(expression, DateTimeFormat.forPattern(format));
        this.timeFunctions.put(expression, fromNow);
        return this;
    }

    public String buildExpression(DateTime now){
        String expression = this.expression;
        for(Map.Entry<String, DateTimeFormatter> entry : formats.entrySet()){
            expression =
                    expression.replaceAll(
                            entry.getKey(),
                            entry.getValue().print(timeFunctions.get(entry.getKey()).apply(now))
                    );
        }
        return expression;
    }

    public String buildExpression(){
        return buildExpression(DateTime.now());
    }
}
