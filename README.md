# Getting Started

Code for intercom test 1. The application is written using spring boot, Gson, lombok etc.

### How To Run

`mvn spring-boot:run`

Please issue this command from terminal from project root folder.

### How To Test

`mvn test`

Please issue this command from terminal from project root folder.


### Output

```txt
2019-04-30 02:26:00.840  INFO 37424 --- [main] c.i.g.service.impl.CustomerServiceImpl   : Total fetched customers: 32
2019-04-30 02:26:00.842  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : Total customers matched in range of 100.0 km : 16
2019-04-30 02:26:00.844  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 4	Ian Kehoe	{"user_id":4,"latitude":53.2451022,"longitude":-6.238335,"name":"Ian Kehoe"}
2019-04-30 02:26:00.844  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 5	Nora Dempsey	{"user_id":5,"latitude":53.1302756,"longitude":-6.2397222,"name":"Nora Dempsey"}
2019-04-30 02:26:00.844  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 6	Theresa Enright	{"user_id":6,"latitude":53.1229599,"longitude":-6.2705202,"name":"Theresa Enright"}
2019-04-30 02:26:00.845  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 8	Eoin Ahearn	{"user_id":8,"latitude":54.0894797,"longitude":-6.18671,"name":"Eoin Ahearn"}
2019-04-30 02:26:00.845  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 11	Richard Finnegan	{"user_id":11,"latitude":53.008769,"longitude":-6.1056711,"name":"Richard Finnegan"}
2019-04-30 02:26:00.845  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 12	Christina McArdle	{"user_id":12,"latitude":52.986375,"longitude":-6.043701,"name":"Christina McArdle"}
2019-04-30 02:26:00.845  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 13	Olive Ahearn	{"user_id":13,"latitude":53.0,"longitude":-7.0,"name":"Olive Ahearn"}
2019-04-30 02:26:00.845  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 15	Michael Ahearn	{"user_id":15,"latitude":52.966,"longitude":-6.463,"name":"Michael Ahearn"}
2019-04-30 02:26:00.846  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 17	Patricia Cahill	{"user_id":17,"latitude":54.180238,"longitude":-5.920898,"name":"Patricia Cahill"}
2019-04-30 02:26:00.846  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 23	Eoin Gallagher	{"user_id":23,"latitude":54.080556,"longitude":-6.361944,"name":"Eoin Gallagher"}
2019-04-30 02:26:00.846  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 24	Rose Enright	{"user_id":24,"latitude":54.133333,"longitude":-6.433333,"name":"Rose Enright"}
2019-04-30 02:26:00.846  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 26	Stephen McArdle	{"user_id":26,"latitude":53.038056,"longitude":-7.653889,"name":"Stephen McArdle"}
2019-04-30 02:26:00.847  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 29	Oliver Ahearn	{"user_id":29,"latitude":53.74452,"longitude":-7.11167,"name":"Oliver Ahearn"}
2019-04-30 02:26:00.847  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 30	Nick Enright	{"user_id":30,"latitude":53.761389,"longitude":-7.2875,"name":"Nick Enright"}
2019-04-30 02:26:00.847  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 31	Alan Behan	{"user_id":31,"latitude":53.1489345,"longitude":-6.8422408,"name":"Alan Behan"}
2019-04-30 02:26:00.847  INFO 37424 --- [main] c.i.g.GeoCircleApplicationRunner         : 39	Lisa Ahearn	{"user_id":39,"latitude":53.0033946,"longitude":-6.3877505,"name":"Lisa Ahearn"}
```
Same output is stored in `logs/output.log` file also.

### Technology Stack

1. [Spring Boot](https://spring.io/projects/spring-boot) as bootstrap project.
2. [Gson](https://github.com/google/gson) for json serDe.
3. [Lombok](https://projectlombok.org/) for productivity. 

### Code Coverage
1. Class  - 87%
2. Method - 61%
3. Line   - 70%

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

