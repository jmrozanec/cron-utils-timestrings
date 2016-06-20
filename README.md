cron-utils-timestrings
===========
A Java library to provide human readable time strings and means to replace them with an actual date. The project follows the [Semantic Versioning Convention](http://semver.org/) and uses Apache 2.0 license.

[![Gitter Chat](http://img.shields.io/badge/chat-online-brightgreen.svg)](https://gitter.im/jmrozanec/cron-utils)
[![Build Status](https://travis-ci.org/jmrozanec/cron-utils-timestrings.png?branch=master)](https://travis-ci.org/jmrozanec/cron-utils-timestrings)
[![Coverage Status](https://coveralls.io/repos/jmrozanec/cron-utils-timestrings/badge.png)](https://coveralls.io/r/jmrozanec/cron-utils-timestrings)


**Download**

cron-utils-timestrings is available on [Maven central](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.cronutils%22) repository.

    <dependency>
        <groupId>com.cronutils</groupId>
        <artifactId>cron-utils</artifactId>
        <version>0.1.0-SNAPSHOT</version>
    </dependency>


**Features**

 * Define a human readable point in time and get accurate date replacement when required.

**Usage Examples**

    String sql = given("SELECT * FROM tracks WHERE ds>='YESTERDAY' AND ds<'TODAY'")
                    .registerReplacement("YESTERDAY", "yyyy-MM-dd", date->date.minusDays(1))
                    .registerReplacement("TODAY", "yyyy-MM-dd", date->date)
                    .buildExpression(DateTime.now());
    //should give us: SELECT * FROM tracks WHERE ds>='2016-06-16' AND ds<'2016-06-17'



**Contribute & Support!**

Contributions are welcome! You can contribute by
 * starring and/or Flattring this repo!
 * requesting or adding new features.
 * enhancing existing code
 * testing
 * enhancing documentation
 * bringing suggestions and reporting bugs
 * spreading the word / telling us how you use it!


Check [our page](http://cronutils.com)! For stats about the project, you can visit our [OpenHUB profile](https://www.openhub.net/p/cron-utils-timestrings).

Support us donating once or by subscription through Flattr!

[![Flattr this!](https://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=jmrozanec&url=https://github.com/jmrozanec/cron-utils-timestrings)

**Other cron-utils projects**

You are welcome to visit and use the following cron-utils projects:
 * [cron-utils](https://github.com/jmrozanec/cron-utils): A Java library to parse, validate, migrate crons as well as get human readable descriptions for them.
 * [cron-utils-spring](https://github.com/jmrozanec/cron-utils-spring): A Java library to describe cron expressions in human readable language at Spring framework, using cron-utils.
 * [sisyphus](https://github.com/jmrozanec/cron-utils-sisyphus): A cron-utils based scala scheduler. Supports any cron format and executes tasks all over again.
 * [htime](https://github.com/jmrozanec/htime): A Java library to make it easy for humans format a date. You no longer need to remember date time formatting chars: just write an example, and you will get the appropiate formatter.
